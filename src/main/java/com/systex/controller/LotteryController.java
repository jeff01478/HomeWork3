package com.systex.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;

import com.systex.model.LotteryService;

public class LotteryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LotteryController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view;
		LinkedList<String> errorMsgs = new LinkedList<>();
		request.setAttribute("errors", errorMsgs);
		
		String groups = request.getParameter("groups");
		String filterNumString = request.getParameter("filterNum");
		
		if(groups.isEmpty()) {
			errorMsgs.add("請輸入需要數組的數量");
		}
		
		if(!errorMsgs.isEmpty()) {
			view = request.getRequestDispatcher("lottery.jsp");
			view.forward(request, response);
			return;
		}
		
		try {
			LinkedList<Integer> excludes = new LinkedList<>();
			if(filterNumString != null) {
				String[] filterNumArray = filterNumString.split(" ");
				for(String filterNum : filterNumArray) {
					if(filterNum.equals("")) {
						continue;
					}
					excludes.add(Integer.parseInt(filterNum));
				}
			}
			LotteryService lotteryService = new LotteryService();
			ArrayList[] lotteryNumbers =  lotteryService.getNumbers(Integer.parseInt(groups.trim()), excludes);
			request.setAttribute("lotteryNumbers", lotteryNumbers);
			view = request.getRequestDispatcher("result.jsp");
			view.forward(request, response);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			errorMsgs.add("請輸入整數");
			view = request.getRequestDispatcher("lottery.jsp");
			view.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			errorMsgs.add(e.getMessage());
			view = request.getRequestDispatcher("lottery.jsp");
			view.forward(request, response);
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
