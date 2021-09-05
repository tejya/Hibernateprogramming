package com.hibernate.manytomany;

public class Demo1 extends Demo{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s="test";
		String s3=new String("test1");
		
		
		
		String s1="test";
		System.out.println(s.equals(s1));
		System.out.println(s==s1);
		
		s.concat("hello");//o/p:
		System.out.println("First Test:"+s);
		System.out.println(s.concat("hello"));
		String s2=s.concat("hello"); 
		System.out.println(s);
		
	}

	@Override
	public void method() {
		// TODO Auto-generated method stub
		
	}

}
