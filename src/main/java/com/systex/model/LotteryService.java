package com.systex.model;

import java.util.ArrayList;
import java.util.LinkedList;

public class LotteryService {
	public ArrayList[] getNumbers(int groups, LinkedList excludes) {
		ArrayList[] resultArray = new ArrayList[groups];
		for (int i = 0; i<groups; i++) {
			ArrayList<Integer> resultArrayList = new ArrayList<>();
			while(resultArrayList.size() != 6) {
				int num = (int)(Math.random()*49 + 1);
				if (excludes.contains(num)) {
					continue;
				}
				resultArrayList.add(num);
			}
			resultArray[i] = resultArrayList;
		}
		
		return resultArray;
	}
}
