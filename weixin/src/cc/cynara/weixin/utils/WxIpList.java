package cc.cynara.weixin.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

public class WxIpList {
	private static List<String> ipList = new  ArrayList<String>();
	public static List<String> listIp(String access_token){
		try {
			URL url = new URL("https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token="+access_token);
			URLConnection connection = url.openConnection();
			connection.connect();
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line = in.readLine();
			JSONObject jo = new JSONObject(line);
			String ips = jo.get("ip_list").toString().substring(1, jo.get("ip_list").toString().length()-1);
			String ipst[] = ips.split(",");
			for (int i = 0; i < ipst.length; i++) {
				ipList.add(ipst[i].substring(1,ipst[i].length()-1) );
			}
		} catch (Exception e) {
			System.out.println("获取ip地址失败");
		}
		return ipList;
	}
}
