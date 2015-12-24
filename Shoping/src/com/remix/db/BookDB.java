package com.remix.db;

import java.util.LinkedHashMap;
import java.util.Map;

import com.remix.domain.Book;

public class BookDB {
	private static Map<String, Book> books = new LinkedHashMap<String, Book>();
	static{
		books.put("001", new Book("001", "ISBN001", "你是猪吗", "刘涛", 12.0f, "真的很好看！"));
		books.put("002", new Book("002", "ISBN002", "你是牛吗", "华华", 13.0f, "不信你看下！"));
		books.put("003", new Book("003", "ISBN003", "你是马吗", "涛涛", 16.0f, "这个好便宜啊！"));
		books.put("004", new Book("004", "ISBN004", "你是奥特曼吗", "宝安", 17.0f, "全部都想要！"));
		books.put("005", new Book("005", "ISBN005", "你是西泽吗", "上海", 14.0f, "不要白不要啊！"));
	}
	public static Map<String, Book> findAllBooks(){
		return books;
		
	}
	public static Book findBookById(String bookId){
		return books.get(bookId);
	}
}
