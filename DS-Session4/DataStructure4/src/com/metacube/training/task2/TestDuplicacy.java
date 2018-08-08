package com.metacube.training.task2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestDuplicacy {

	@Test
	public void test() {
		CharacterCount obj = new CharacterCount();
		assertEquals(3,obj.getCountOfCharacterInString("aabc"));
		assertEquals(4,obj.getCountOfCharacterInString("abcabcd"));

	}

}
