package com.practice.junitTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.practice.junit.MathPractice;

public class MathPracticeTest {

	MathPractice mp = new MathPractice();

	@Test // org.junit
	public void test_addition() {

		int addResult = mp.addition(2, 5);
		assertEquals(7, addResult);
		System.out.println(addResult);
	}

	@Test
	public void test_substraction() {

		int subResult = mp.substraction(7, 5);
		assertEquals(2, subResult);
		System.out.println(subResult);
	}

	@Test
	public void test_division() {
		try {
			mp.division(10, 0);
			fail("Expected an IllegalArgumentException to be thrown");
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Division by zero is not supported");
		}

		catch (Throwable t) {
			fail("Expected an IllegalArgumentException to be thrown");
		}
	}

	@Test
	public void test_division1() {
		double x = mp.division(10, 5);
		assertEquals(2, x, x);
	}

	@Test
	public void test_multiplication() {
		int x = mp.multiplication(5, 2);
		assertEquals(10, x);
	}

}
