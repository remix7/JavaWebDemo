package cc.cynara.upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class uploadFileServlet4 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();

		request.setCharacterEncoding("UTF-8");
		try {
			// 得到存放上传文件的真实路径
			String sPath = getServletContext().getRealPath("/WEB-INF/files");
			// 文件上传的工厂
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//设置临时文件目录
			factory.setRepository(new File(getServletContext().getRealPath("/temp")));
			
			
			// 判断form的enctype属性是不是 multipart/form-data 类型的
			boolean b = ServletFileUpload.isMultipartContent(request);
			if (!b) {
				return;
			}
			// 文件上传核心类
			ServletFileUpload upload = new ServletFileUpload(factory);
//			upload.setFileSizeMax(4 * 1024 * 1024);// 设置最大单个上传文件大小
//			upload.setSizeMax(6 * 1024 * 1024);// 设置总上传大小的最大值

			List<FileItem> itmes = upload.parseRequest(request);
			for (FileItem item : itmes) {
				// 判断是不是普通字段
				if (item.isFormField()) {
					String name = item.getFieldName();
					String value = item.getString("UTF-8");
					System.out.println(name + value);
				} else {// 是上传字段
					// 获得输入流
					// String mimeType = item.getContentType();
					// System.out.println(mimeType);
					// if(mimeType.startsWith("image")){
					InputStream in = item.getInputStream();
					String fileName = item.getName();
					if(fileName==null||"".equals(fileName.trim())){
						continue;//没有上传的文件是  直接跳出此次循环
					}
					fileName = fileName.substring(fileName.indexOf("\\") + 1);// 获得文件的名字
					fileName = UUID.randomUUID().toString() + "_" + fileName;
					// 构建输出流
					String newStoreFile = makeFilePath(sPath, fileName);
					String storeFile = newStoreFile + "\\" + fileName;
					OutputStream out = new FileOutputStream(storeFile);
					byte[] bb = new byte[1024];
					int len = -1;
					while ((len = in.read(bb)) != -1) {
						out.write(bb, 0, len);
					}
					out.close();
					in.close();
					item.delete();
				}
			}
			// }
		} catch (org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException e) {
			pw.write("单个文件大小超过4M");
		} catch (org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException e) {
			pw.write("一共上传的文件大小不能超过6M");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据文件名的hashCode值 计算出新的目录
	 * 
	 * @param sPath
	 * @param fileName
	 * @return
	 */
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

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
