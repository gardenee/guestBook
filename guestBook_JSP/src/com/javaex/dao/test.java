package com.javaex.dao;

public class test {

	public static void main(String[] args) {
		GuestBookDao gbDao = new GuestBookDao();
		String pw = gbDao.findPW(9);
		System.out.println(pw);

	}

}
