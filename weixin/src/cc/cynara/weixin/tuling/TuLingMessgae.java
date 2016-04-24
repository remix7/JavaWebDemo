package cc.cynara.weixin.tuling;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

public class TuLingMessgae {
	public static final String KEY = "30f1786d28abc487c901f9352999820c";
	public static List<String> messages = new ArrayList<String>();
	public static List<String> res(String info,String userid){
		try {
			URL url = new URL("http://www.tuling123.com/openapi/api?key="+KEY+"&info="+info+"&userid="+userid);
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			connection.connect();
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line = in.readLine();
			System.out.println(line);
			JSONObject jo = JSONObject.fromObject(line);
			messages.add(jo.getString("text"));
			messages.add(jo.getString("url"));
			in.close();
			connection.disconnect();
		} catch (Exception e) {
		}
		return messages;
	}
}
