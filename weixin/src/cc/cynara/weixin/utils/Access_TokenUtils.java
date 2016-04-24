package cc.cynara.weixin.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONObject;

import com.sun.swing.internal.plaf.metal.resources.metal;

public class Access_TokenUtils {
	public static String accessToken = "";
	public static String findAccessToken(){
		try {
			String grant_type = "client_credential";
			String appid = "";
			String secret = "";
			URL url = new URL("https://api.weixin.qq.com/cgi-bin/token?grant_type="+grant_type+"&appid="+appid+"&secret="+secret);
			//打开连接
			URLConnection connection = url.openConnection();
			//建立实际连接
	        connection.connect();
	        //构建输出流
	        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        String line = in.readLine();
	        //转为json
	        JSONObject jo = new JSONObject(line);
	        accessToken = jo.get("access_token").toString();
           in.close();
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
		}
		return accessToken;
	}
	public static void main(String[] args) {
		System.out.println(findAccessToken());
	}
}
