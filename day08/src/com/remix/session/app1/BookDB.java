package com.remix.session.app1;

import java.util.LinkedHashMap;
import java.util.Map;

public class BookDB {
	//key�������id  value����id��Ӧ��s��Ķ���
	private static Map<String, Book> books = new LinkedHashMap<String, Book>();
	static{
		books.put("1", new Book("1", "����һֻ�ʺ�", "����", 10.1f, "�ۣ�����˧��"));
		books.put("2", new Book("2", "Ū����ı���", "����", 111.1f, "���������"));
		books.put("3", new Book("3", "��������", "����", 10.1f, "���������"));
		books.put("4", new Book("4", "����ţ��", "ѧϰ��", 80.1f, "���̫���ˣ�"));
	}
	public static Book findBookById(String bookId){
		return books.get(bookId);
	}
	public static Map<String, Book> findAllBooks(){
		return books;

	}
}
