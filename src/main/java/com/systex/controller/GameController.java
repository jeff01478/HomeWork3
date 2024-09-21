package com.systex.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.util.LinkedList;

import com.systex.model.GuessGame;

public class GameController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher view;
	

    public GameController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int range = 10;
		int remains = 5;
		GuessGame guessGame = new GuessGame(range, remains);
		HttpSession session = request.getSession();
		session.setAttribute("guessGame", guessGame);
		session.setAttribute("range", range);
		session.setAttribute("answer", false);
		view = request.getRequestDispatcher("guess.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LinkedList<String> errorMsgs = new LinkedList<>();
		HttpSession session = request.getSession();
		String number = request.getParameter("number");
		request.setAttribute("errorMsgs", errorMsgs);
		if(number.isEmpty()) {
			errorMsgs.add("請輸入要猜的數字");
		}
		if (!errorMsgs.isEmpty()) {
			view = request.getRequestDispatcher("guess.jsp");
			view.forward(request, response);
			return;
		}
		if(number.equals("GOOD")) {
			session.setAttribute("answer", true);
			view = request.getRequestDispatcher("guess.jsp");
			view.forward(request, response);
			return;
		}
		
		GuessGame guessGame = (GuessGame)session.getAttribute("guessGame");
		
		try {
			if(guessGame.guess(Integer.parseInt(number))) {
				view = request.getRequestDispatcher("youWin.jsp");
				view.forward(request, response);
			} else if (guessGame.getRemains() > 0) {
				view = request.getRequestDispatcher("guess.jsp");
				view.forward(request, response);
			} else {
				view = request.getRequestDispatcher("youLose.jsp");
				view.forward(request, response);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			errorMsgs.add("請輸入整數");
			view = request.getRequestDispatcher("guess.jsp");
			view.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			errorMsgs.add(e.getMessage());
			view = request.getRequestDispatcher("guess.jsp");
			view.forward(request, response);
		}
	}

}
