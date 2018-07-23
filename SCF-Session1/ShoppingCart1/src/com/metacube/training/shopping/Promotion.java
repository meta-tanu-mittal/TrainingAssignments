package com.metacube.training.shopping;

public interface Promotion {

	public double getMinimumPrice();

	public void setMinimumPrice(double price);

	public double getFixedDiscount();

	public void setFixedDiscount(double discount);

	public boolean isPromotionApplicable(String promocode);

}
