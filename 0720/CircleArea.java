package com.java.first;

public class CircleArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double r = 5;    
	      System.out.println("반지름이 5Cm인 원의 넓이는 " + Area(r, Math.PI) + "Cm2입니다.");
	   }
	   
	   static double Area(double r, double pi)
	   {
	      return r*r*pi;
	   }

}