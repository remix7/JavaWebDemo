package cc.cynara.mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailDemo2 {
	public static void main(String[] args) throws Exception {
		Properties props = new Properties();//设置环境 发送时才需要
		props.setProperty("mail.transport.protocol", "smtp");//发送使用的协议
		props.setProperty("mail.host", "smtp.qq.com");//发送服务器的主机地址
		props.setProperty("mail.smtp.auth", "true");//请求身份认证
		props.setProperty("mail.debug", "true");//调试模式
		//匿名内部类实现设置用户名和密码
		Session session = Session.getDefaultInstance(props,new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("用户名", "密码");
			}
		});
		MimeMessage message = new MimeMessage(session);
		
		message.setFrom(new InternetAddress("发送方邮件地址"));//发件人
		message.setRecipients(Message.RecipientType.TO, "接收方邮件地址");//收件人  
		message.setSubject("javaMail发送的邮件");//主题
		
		message.setText("你是猪吗sdkfjasdlkfajdsflajdlkjsdl");//内容
		message.saveChanges();
		
		
		//第二种方式
		Transport.send(message);
	}
}
