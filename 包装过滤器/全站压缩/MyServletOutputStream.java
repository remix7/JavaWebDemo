package cc.cynara.filter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;

public class MyServletOutputStream extends ServletOutputStream {
	private ByteArrayOutputStream baos;
	public MyServletOutputStream(ByteArrayOutputStream baos){
		this.baos = baos;
	}
	
	@Override
	public void write(int b) throws IOException {
		baos.write(b);
	}

}
