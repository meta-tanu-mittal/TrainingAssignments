package com.metacube.training.task2;

public interface QueueInterface<T> {
	public void addItem(T value);

	public T removeItem();

	boolean isEmpty();

	boolean isFull();
}
