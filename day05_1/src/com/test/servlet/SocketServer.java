package com.test.servlet;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
	/**
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(8888);
		Socket socket = server.accept();
		
		OutputStream out = socket.getOutputStream();
		InputStream in = new FileInputStream("D:\\a.html");
		
		int flag = -1;
		byte[] b = new byte[1024];
		while((flag = in.read(b))!=-1){
			out.write(b, 0, flag);
		}
		socket.close();
		out.close();
	}
}
