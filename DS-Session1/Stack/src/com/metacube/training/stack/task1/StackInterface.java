package com.metacube.training.stack.task1;

public interface StackInterface<T> {
	void push(T value);

	T pop();

	boolean isEmpty();

}
