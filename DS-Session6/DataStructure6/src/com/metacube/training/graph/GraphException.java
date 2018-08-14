package com.metacube.training.graph;

/**
 * custom exception
 * @author Tanu Mittal
 *
 */
@SuppressWarnings("serial")
public class GraphException extends Exception{

	String exception;
	public GraphException(String exception)
	{
		this.exception = exception;
	}
	
	public String getMessage() {
		return exception;
	}
}
