package com.remix.session.app1;

import java.util.LinkedHashMap;
import java.util.Map;

public class BookDB {
	//key就是书的id  value就是id对应的s书的对象
	private static Map<String, Book> books = new LinkedHashMap<String, Book>();
	static{
		books.put("1", new Book("1", "我是一只肥猴", "刘涛", 10.1f, "哇，他好帅！"));
		books.put("2", new Book("2", "弄堂里的被子", "华华", 111.1f, "这是真的吗"));
		books.put("3", new Book("3", "你是猪吗", "涛涛", 10.1f, "华华在哪里！"));
		books.put("4", new Book("4", "你是牛吗", "学习饿", 80.1f, "这个太贵了！"));
	}
	public static Book findBookById(String bookId){
		return books.get(bookId);
	}
	public static Map<String, Book> findAllBooks(){
		return books;

	}
}
