package com.metacube.training.task1;

import static org.junit.Assert.*;

import org.junit.Test;

public class PostfixEvaluationTest {

	@Test
	public void test() {
		PostfixEvaluation obj=new PostfixEvaluation();
		assertEquals(12,obj.evaluationOfPostfix("3 4 *"),0.001);
	}

	
	@Test
	public void test1() {
		PostfixEvaluation obj=new PostfixEvaluation();
		assertEquals(11,obj.evaluationOfPostfix("2 3 * 5 +"),0.001);
	}
	
	@Test
	public void test2() {
		PostfixEvaluation obj=new PostfixEvaluation();
		assertEquals(48,obj.evaluationOfPostfix("5 3 + 8 2 - *"),0.001);
	}


}
