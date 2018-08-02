package com.metacube.training.task2;

public interface QueueInterface<GenericType> {
	public void addItem(GenericType value);

	public GenericType removeItem();

	boolean isEmpty();

	boolean isFull();
}
