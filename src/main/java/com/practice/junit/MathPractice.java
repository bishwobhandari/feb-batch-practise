package com.practice.junit;

public class MathPractice {
	
	public int addition(int a,int b ) {
		return a+b;
	}
	
	public int substraction(int a ,int b ) {
		return a-b;
	}
	
	public double division(int a,int b) {
		if (b == 0) {
			   throw new IllegalArgumentException("Division by zero is not supported");
			  }

		return a/b;
	}
	
	public int multiplication(int a,int b) {
		return a*b;
	}

}
