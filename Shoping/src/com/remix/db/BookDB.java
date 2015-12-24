package com.remix.db;

import java.util.LinkedHashMap;
import java.util.Map;

import com.remix.domain.Book;

public class BookDB {
	private static Map<String, Book> books = new LinkedHashMap<String, Book>();
	static{
		books.put("001", new Book("001", "ISBN001", "��������", "����", 12.0f, "��ĺܺÿ���"));
		books.put("002", new Book("002", "ISBN002", "����ţ��", "����", 13.0f, "�����㿴�£�"));
		books.put("003", new Book("003", "ISBN003", "��������", "����", 16.0f, "����ñ��˰���"));
		books.put("004", new Book("004", "ISBN004", "���ǰ�������", "����", 17.0f, "ȫ������Ҫ��"));
		books.put("005", new Book("005", "ISBN005", "����������", "�Ϻ�", 14.0f, "��Ҫ�ײ�Ҫ����"));
	}
	public static Map<String, Book> findAllBooks(){
		return books;
		
	}
	public static Book findBookById(String bookId){
		return books.get(bookId);
	}
}
