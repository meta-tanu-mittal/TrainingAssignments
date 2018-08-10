package com.metacube.training.stack;

public interface StackInterface<GenericType> {
	void push(GenericType value);

	GenericType pop();

	boolean isEmpty();

}
