package com.metacube.training.jdbc;

import java.util.Date;

/**
 * class for storing order details
 * @author Tanu Mittal
 *
 */
public class OrderDetail {
	private int orderId;
	private Date orderDate;
	private float price;

	/**
	 * constructor
	 * @param orderId is id of order
	 * @param orderDate is date of order
	 * @param price is price of that order
	 */
	public OrderDetail(int orderId, Date orderDate, float price) {
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.price = price;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}
