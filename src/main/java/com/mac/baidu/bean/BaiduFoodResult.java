package com.mac.baidu.bean;

import java.util.List;

public class BaiduFoodResult {
	private String status;
	private String message;
	private String total;
	private List<BaiduFoodShopInfo> results;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public List<BaiduFoodShopInfo> getResults() {
		return results;
	}
	public void setResults(List<BaiduFoodShopInfo> results) {
		this.results = results;
	}
}
