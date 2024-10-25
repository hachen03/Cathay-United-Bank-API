package com.cathay.bank.api.dto;

import java.util.List;

public class CoinDeskResponseDTO {
	
	private String updatedTime;
    private List<CurrencyInfo> currencyInfo;
	
    public static class CurrencyInfo {
    	
	private String code;
    private String name;
    private String rate;
    
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
    
}

	public String getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(String updatedTime) {
		this.updatedTime = updatedTime;
	}

	public List<CurrencyInfo> getCurrencyInfo() {
		return currencyInfo;
	}

	public void setCurrencyInfo(List<CurrencyInfo> currencyInfo) {
		this.currencyInfo = currencyInfo;
	}
    

}
