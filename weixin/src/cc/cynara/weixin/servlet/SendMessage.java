package cc.cynara.weixin.servlet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import cc.cynara.weixin.tuling.TuLingMessgae;



public class SendMessage {
	public static final String KEY = "30f1786d28abc487c901f9352999820c";
	public static List<String> messages = new ArrayList<String>();
	
	public static String realTextMessgae(Map<String, String> xmls){
		List<String> messages = TuLingMessgae.res(xmls.get("Content"), xmls.get("FromUserName"));
		System.out.println(messages.get(0));
		if(messages.size() == 1){
			String xml = "<xml><ToUserName><![CDATA["+xmls.get("FromUserName")+"]]></ToUserName><FromUserName><![CDATA["+xmls.get("ToUserName")+"]]></FromUserName><CreateTime>"+new Date().getTime()+""+"</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA["+messages.get(0)+"]]></Content></xml>";
			messages.clear();
			System.out.println(xml);
			return xml;
		}else{
			String xml = "<xml><ToUserName><![CDATA["+xmls.get("FromUserName")+"]]></ToUserName><FromUserName><![CDATA["+xmls.get("ToUserName")+"]]></FromUserName><CreateTime>"+new Date().getTime()+""+"</CreateTime><MsgType><![CDATA[news]]></MsgType><ArticleCount>1</ArticleCount><Articles><item><Title><![CDATA["+messages.get(0)+"]]></Title><Description><![CDATA["+messages.get(0)+"]]></Description><Url><![CDATA["+messages.get(1)+"]]></Url></item></Articles></xml>";
			messages.clear();
			System.out.println(xml);
			return xml;
		}
	}
}
