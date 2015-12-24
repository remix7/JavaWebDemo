package com.remix.util;

import java.io.FileOutputStream;
import java.net.URL;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Dom4jUtils {
	private static String dbFilePath="";
	static{
		ClassLoader cl = Dom4jUtils.class.getClassLoader();
		URL url = cl.getResource("users.xml");
		dbFilePath = url.getPath();
	}
	public static Document getDocument() throws DocumentException{
		SAXReader reader = new SAXReader();
		return reader.read(dbFilePath);
	}
	public static void writer2xml(Document document) throws Exception{
		XMLWriter writer = new XMLWriter(new FileOutputStream(dbFilePath), OutputFormat.createCompactFormat());
		writer.write(document);
		writer.close();
	}
}
