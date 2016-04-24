package cc.cynara.weixin.botton;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


import cc.cynara.weixin.utils.Access_TokenUtils;

public class Button {
	public static void main(String[] args) {
		System.out.println(Access_TokenUtils.findAccessToken());
		String menu = "{\"button\":[ {\"type\":\"view\",\"name\":\"微商城\",\"url\":\"https://wap.koudaitong.com/v2/showcase/feature?alias=wu6rzshd\"},{\"name\": \"测试功能\",\"sub_button\": [{\"type\": \"pic_sysphoto\",  \"name\": \"系统拍照发图\", \"key\": \"rselfmenu_1_0\", \"sub_button\": [ ]},{\"type\": \"pic_photo_or_album\",\"name\": \"拍照或者相册发图\", \"key\": \"rselfmenu_1_1\",\"sub_button\": [ ]},{\"type\": \"pic_weixin\",\"name\": \"微信相册发图\",\"key\": \"rselfmenu_1_2\",\"sub_button\": [ ]},{\"name\": \"发送位置\",\"type\": \"location_select\",\"key\": \"rselfmenu_2_0\"}]}]}";
		try {
			URL url = new URL("https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+Access_TokenUtils.findAccessToken());
			HttpURLConnection http = (HttpURLConnection)url.openConnection();
			
			 http.setRequestMethod("POST");       
	         http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");   
	         http.setDoOutput(true);       
	         http.setDoInput(true);
	         System.setProperty("sun.net.client.defaultConnectTimeout", "30000");//连接超时30秒
	         System.setProperty("sun.net.client.defaultReadTimeout", "30000"); //读取超时30秒
			http.connect();
			OutputStream os = http.getOutputStream();
			os.write(menu.getBytes());
			os.flush();
			os.close();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(http.getInputStream()));
			System.out.println(in.readLine());
			in.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
