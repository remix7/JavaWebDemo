package cc.cynara.buffered;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
//对代码加行号输出
public class BufferedReaderDemo {
	public static void main(String[] args) throws Exception {
		Reader in = new FileReader("src/cc/cynara/buffered/BufferedReaderDemo.java");
		BufferedReader br = new BufferedReader(in);
		MyBufferedReader mbr = new MyBufferedReader(br);
		String str = null;
		while((str = mbr.readLine())!=null){
			System.out.println(str);
		}
		mbr.close();
	}
}
