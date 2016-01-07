package cc.cynara.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//提供文件的下载
public class DownServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		OutputStream out = response.getOutputStream();
		
		String fileName = request.getParameter("filename");
		fileName = new String(fileName.getBytes("ISO-8859-1"),"UTF-8");//get中中文编码的问题
		//得到存储路径
		String storePath = getServletContext().getRealPath("/WEB-INF/files");
		//得到文件的全部路径
		String filePath = makeFilePath(storePath,fileName)+"\\"+fileName;
		
		File file = new File(filePath);
		if(!file.exists()){
			out.write("文件不存在".getBytes("UTF-8"));
			return;
		}
		InputStream in = new FileInputStream(file);
		//客户端以下载的方式打开
		response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(fileName.substring(fileName.indexOf("_")+1), "UTF-8"));
		
		byte[] b = new byte[1024];
		int len = -1;
		while((len = in.read(b))!=-1){
			out.write(b, 0, len);
		}
		in.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
	private String makeFilePath(String sPath, String fileName) {
		int hashCode = fileName.hashCode();
		int dri1 = hashCode & 0xf;
		int dri2 = (hashCode & 0xf0) >> 4;
		String path = sPath + "\\" + dri1 + "\\" + dri2;
		File file = new File(path);
		if (!file.exists()) {
			file.mkdirs();
		}
		return path;
	}
}
