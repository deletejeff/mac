package com.mac.baidu.bean;

import java.util.Random;

public class NumGameBean {
	private String roundnum = "";
	private int count =1;
	private String result = "";
	public NumGameBean(){
		int i=0;
		Random rand = new Random(System.currentTimeMillis());
		while(true){
			String s = rand.nextInt(10)+"";
			if(!roundnum.contains(s)){
				roundnum += s;
				i++;
			}
			if(i==4)break;
		}
	}
	
	public String getRoundnum() {
		return roundnum;
	}

	public void setRoundnum(String roundnum) {
		this.roundnum = roundnum;
	}

	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
}
