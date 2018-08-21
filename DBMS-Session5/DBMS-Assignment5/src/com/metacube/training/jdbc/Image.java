package com.metacube.training.jdbc;

/**
 * Class for Product image
 * 
 * @author Tanu Mittal
 *
 */
public class Image {
	private String name;
	private String url;
	private int productId;

	/**
	 * constructor
	 * 
	 * @param name
	 *            is title for image
	 * @param url
	 *            is image url
	 * @param productId
	 *            is id of product
	 */
	public Image(String name, String url, int productId) {
		this.name = name;
		this.url = url;
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

}
