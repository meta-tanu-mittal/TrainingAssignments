package com.metacube.training.shopping;
import java.util.Calendar;
import java.util.Scanner;

public class FixedProductPromotion implements Promotion {
	private double minimumPrice;
	private double discount;
	Scanner sc1 = new Scanner(System.in);
	// Item itemObj=new Item();

	@Override
	public double getMinimumPrice() {
		// TODO Auto-generated method stub
		return minimumPrice;
	}

	@Override
	public void setMinimumPrice(double price) {
		minimumPrice = price;

	}

	@Override
	public double getFixedDiscount() {
		// TODO Auto-generated method stub
		return discount;
	}

	@Override
	public void setFixedDiscount(double discount) {
		this.discount = discount;

	}

	@Override
	public boolean isPromotionApplicable(String promocode) {
		boolean validity = false;
		// Date date = new Date(); // your date
		Calendar cal = Calendar.getInstance();
		int day = cal.get(Calendar.DAY_OF_MONTH);
		for (PromotionEnum en : PromotionEnum.values()) {
			if (promocode.equals(en.getCode()) && (day >= en.getStartDate() && day <= en.getEndDate())) {
				validity = true;
				break;

			}
		}
		return validity;
	}

}
