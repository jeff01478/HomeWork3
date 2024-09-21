package com.systex.model;

import java.util.LinkedList;

public class GuessGame {
	private final LinkedList<Integer> recordNumber = new LinkedList<>();
	private int remains;
	private int luckyNumber;
	
	public GuessGame(int range, int remains) {
		this.remains = remains;
		luckyNumber = (int)(Math.random()*range + 1);
	}
	
	public int getRemains() {
		return remains;
	}
	
	public int getLuckyNumber() {
		return luckyNumber;
	}
	
	public LinkedList<Integer> getRecordNumber() {
		return recordNumber;
	}
	
	public boolean guess(int number) {
		remains--;
		recordNumber.add(number);
		if (number == luckyNumber) {
			return true;
		} else {
			return false;
		}
	}
}
