package com.metacube.training.shopping;

public enum PromotionEnum {

	PROMO1("code1", 16, 30), PROMO2("code2", 1, 15);

	private String code;
	private int startDate;
	private int endDate;

	PromotionEnum(String code, int startDate, int endDate) {
		this.code = code;
		this.startDate = startDate;
		this.endDate = endDate;

	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getStartDate() {
		return startDate;
	}

	public void setStartDate(int startDate) {
		this.startDate = startDate;
	}

	public int getEndDate() {
		return endDate;
	}

	public void setEndDate(int endDate) {
		this.endDate = endDate;
	}

}
