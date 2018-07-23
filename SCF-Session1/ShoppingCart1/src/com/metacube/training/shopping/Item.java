package com.metacube.training.shopping;

import java.util.Scanner;

class Item {
	final static int max = 5;
	private int id[] = new int[] { 1, 2, 3, 4, 5 };
	private double[] price = new double[] { 100, 200, 300, 400, 500 };
	private String name[] = new String[] { "item1", "item2", "item3", "item4", "item5" };
	private int userItemId[] = new int[max];
	private int userItemQuantity[] = new int[max];
	private double userItemPrice[] = new double[max];
	private String userItemName[] = new String[max];
	private static int noOfItems = 0;

	private String promoCode;
	Scanner sc1 = new Scanner(System.in);

	FixedOrderPromotion fixedOrder = new FixedOrderPromotion();
	FixedProductPromotion fixedProduct = new FixedProductPromotion();

	/**
	 * Add elements in cart
	 */
	void insert() {
		int found = 0;
		int foundItemInUserList = 0;
		if (noOfItems == max)
			System.out.println("no more item can be inserted #max limit");
		else {
			System.out.print("enter id of element you want to purchase:");
			int id1 = sc1.nextInt();
			for (int i = 0; i < max; i++) {
				if (id1 == id[i]) {
					for (int j = 0; j < noOfItems; j++) {
						if (id1 == userItemId[j]) {
							System.out.println("item already in list !! ");
							foundItemInUserList = 1;
							break;
						}
					}
					if (foundItemInUserList == 1) {
						break;
					}
					System.out.print("enter quantity:");
					userItemQuantity[noOfItems] = sc1.nextInt();
					userItemId[noOfItems] = id[i];
					userItemName[noOfItems] = name[i];
					userItemPrice[noOfItems] = price[i];
					noOfItems++;
					found = 1;

				}
			}

		}
		if (found == 0 && foundItemInUserList == 0) {
			System.out.println("item not exist");
		}

	}

	/**
	 * update quantity of items in cart
	 */
	void update() {
		System.out.print("enter the id of element you want to update:");
		int id1 = sc1.nextInt();
		int find = 0;
		for (int i = 0; i < noOfItems; i++) {
			if (id1 == userItemId[i]) {
				System.out.print("enter quantity");
				userItemQuantity[i] = sc1.nextInt();
				find = 1;
				break;

			}
		}
		if (find == 0) {
			System.out.println("item not found");
		} else {
			System.out.println("item updated successfully");
		}

	}

	/**
	 * remove item from cart
	 * 
	 * @param id
	 *            is id of item to be removed
	 */
	void remove(int id) {
		int flag = 0;

		for (int i = 0; i < noOfItems; i++) {
			if (userItemId[i] == id) {
				if (i < noOfItems - 1) {
					userItemId[i] = userItemId[i + 1];
					userItemName[i] = userItemName[i + 1];
					userItemPrice[i] = userItemPrice[i + 1];
					userItemQuantity[i] = userItemQuantity[i + 1];
				}
				noOfItems--;
				flag = 1;
				break;
			}
		}
		if (flag == 0) {
			System.out.println("item not exist");
		} else {
			System.out.println("item removed successfully!!");
		}
	}

	/**
	 * display list of all available items
	 */
	void displayAllItems() {
		System.out.println("select from following items");
		System.out.println("id\tname\tprice");
		for (int i = 0; i < max; i++)
			System.out.println(id[i] + "\t" + name[i] + "\t" + price[i]);
	}

	/**
	 * display list of items present in user cart
	 */
	void display() {
		System.out.println("elements of cart are:");
		System.out.println("id\t\t name\t quantity\t price");
		for (int i = 0; i < noOfItems; i++)
			System.out.println(
					userItemId[i] + "\t\t" + userItemName[i] + "\t" + userItemQuantity[i] + "\t" + userItemPrice[i]);
	}

	/**
	 * find total amount of items in cart without any discount
	 * 
	 * @return total amount
	 */
	double totalAmount() {
		double bill = 0;
		for (int i = 0; i < noOfItems; i++)
			bill = bill + (userItemPrice[i] * userItemQuantity[i]);
		return bill;
	}

	/**
	 * set promocode
	 * 
	 * @param promoCode
	 *            is code entered by user
	 */
	void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	/**
	 * get promocode
	 * 
	 * @return promocode
	 */
	String getPromocode() {
		return promoCode;
	}

	/**
	 * Check which type of discount will be applied
	 * 
	 * @return discount
	 */
	double applyTypeOfDiscount() {
		Double d = 0.0;
		if ((PromotionEnum.PROMO1.getCode()).equals(getPromocode())) {
			d = applyOrderDiscount();
		}
		if ((PromotionEnum.PROMO2.getCode()).equals(getPromocode())) {
			d = applyProductDiscount();
		}

		return d;
	}

	/**
	 * find discount applied on total order
	 * 
	 * @return discount on order
	 */
	double applyOrderDiscount() {
		double orderDiscount = 0.0;
		fixedOrder.setMinimumPrice(1000);
		fixedOrder.setFixedDiscount(10);
		System.out.println(fixedOrder.isPromotionApplicable(promoCode));
		if (fixedOrder.isPromotionApplicable(promoCode) && totalAmount() >= fixedOrder.getMinimumPrice()) {
			orderDiscount = (totalAmount() * fixedOrder.getFixedDiscount()) / 100;
		}

		return orderDiscount;
	}

	/**
	 * find discount on any product
	 * 
	 * @return discount on product
	 */
	double applyProductDiscount() {
		double productDiscount = 0.0;

		fixedProduct.setFixedDiscount(5);

		if (fixedProduct.isPromotionApplicable(promoCode)) {
			for (int i = 0; i < noOfItems; i++) {
				// we assume discount is applied on item5 if purchased by user
				if (id[4] == userItemId[i]) {
					productDiscount = (userItemPrice[i] * userItemQuantity[i] * fixedProduct.getFixedDiscount()) / 100;
				}
			}
		}

		return productDiscount;
	}

}