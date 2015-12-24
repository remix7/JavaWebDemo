package com.remix.response;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//��������֤��ͼƬ
public class ResponseDemo3 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		֪ͨ�������Ҫ����
		response.setHeader("Expires", "-1");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		CreateImage(response);
		
	}

	private void CreateImage(HttpServletResponse response) throws IOException {
		int width = 120;
		int height = 25;
		//����һ���ڴ�ͼ��BufferedImage
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		//�õ����ڸ�ͼ��Ļ���Graphics
		Graphics g = image.getGraphics();
		//���߿�
		g.setColor(Color.BLUE);
		g.drawRect(0, 0, width, height);
		//��䱳��ɫ
		g.setColor(Color.YELLOW);
		g.fillRect(1, 1, width-2, height-2);
		//��������
		g.setColor(Color.GRAY);
		Random r = new Random();
		for(int i = 0;i < 10;i ++){
			g.drawLine(r.nextInt(width), r.nextInt(height), r.nextInt(width), r.nextInt(height));
		}
		//�������
		g.setColor(Color.RED);
		g.setFont(new Font("����",Font.BOLD|Font.ITALIC , 20));
		int x = 23;
		for(int i = 0;i < 4;i++){
			g.drawString(r.nextInt(10)+"", x, 20);
			x+=21;
		}
		//������������
		ImageIO.write(image, "jpg", response.getOutputStream());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
