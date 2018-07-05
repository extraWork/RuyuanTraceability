package com.spring.domain;

public class Book {
	private long bookId;// 图书ID

    private String name;// 图书名称
    
    private int num;	

    
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
