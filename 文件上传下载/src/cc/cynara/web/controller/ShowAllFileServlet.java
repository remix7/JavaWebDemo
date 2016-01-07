package cc.cynara.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//得到所有上传的文件  交给jsp显示
public class ShowAllFileServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, String> map = new HashMap<String, String>();//UUID_name, name
		//得到文件存储的目录
		String storePath = getServletContext().getRealPath("WEB-INF/files");
		//递归遍历文件
		File file = new File(storePath);
		treeWalk(file,map);
		//交给jsp显示  
		request.setAttribute("map", map);
		request.getRequestDispatcher("/listAllFile.jsp").forward(request, response);
	}

	private void treeWalk(File file, Map<String, String> map) {
		if(file.isFile()){//说明得到的是文件
			String u_name = file.getName();
			String o_name = u_name.substring(u_name.indexOf("_")+1);
			map.put(u_name, o_name);
		}else{
			File[] fs = file.listFiles();
			for(File f:fs){
				treeWalk(f,map);
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
