package com.practiceprojects;

import java.util.Scanner;

public class ArithmaticCalculator {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		double Ans;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the two numbers");
		int firstnum=sc.nextInt();
		int secnum= sc.nextInt();
		System.out.println("Enter the operator ");
		char op=sc.next().charAt(0);
		double Ans=0;

		switch(op){
		case '+': Ans=firstnum+secnum;
		break;
		case '-':Ans=firstnum-secnum;
		break;
		case '*': Ans=firstnum*secnum;
		break;
		case '/':Ans=firstnum/secnum;
		break;
		}
		System.out.println("the answer is " +Ans);
	}
}

