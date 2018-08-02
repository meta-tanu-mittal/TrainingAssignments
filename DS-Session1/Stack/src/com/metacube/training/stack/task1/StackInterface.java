package com.metacube.training.stack.task1;

public interface StackInterface<GenericType> {
	void push(GenericType value);

	GenericType pop();

	boolean isEmpty();

}
