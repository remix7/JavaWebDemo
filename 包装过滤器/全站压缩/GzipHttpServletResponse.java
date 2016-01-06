package cc.cynara.filter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
/**
 * 全站压缩得到data
 * @author REMIX-7
 *
 */
public class GzipHttpServletResponse extends HttpServletResponseWrapper {
	private ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private PrintWriter pw;

	public GzipHttpServletResponse(HttpServletResponse response) {
		super(response);
	}
	
	@Override//字符流 把原始数据封装到一个缓冲流中
	public PrintWriter getWriter() throws IOException {
		pw = new PrintWriter(new OutputStreamWriter(baos, super.getCharacterEncoding()));
		return pw;
	}
	//把原始数据封装到一个缓冲流中
	public ServletOutputStream getOutputStream() throws IOException {
		return new MyServletOutputStream(baos);
	}
	//返回baos中的原始数据
	public byte[] getOldBytes(){
		try {
			if(pw!=null){
				pw.close();
			}
			baos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return baos.toByteArray();
	}
}
