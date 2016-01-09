package cc.cynara.mail;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailDeom1 {

	public static void main(String[] args) throws Exception {
		Properties props = new Properties();//设置环境 发送时才需要
//		InputStream in = MailDeom1.class.getClassLoader().getResourceAsStream("mail.properties");
//		props.load(in);
		Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);
		
		message.setFrom(new InternetAddress("发送方地址"));//发件人
		message.setRecipients(Message.RecipientType.TO, "接收方地址");//收件人  
		message.setSubject("javaMail发送的邮件");//主题
		
		message.setText("你是猪吗sdkfjasdlkfajdsflajdlkjsdl");//内容
		
		
		//把邮件存在磁盘上
		message.writeTo(new FileOutputStream("f:/one.mel"));
	}

}
