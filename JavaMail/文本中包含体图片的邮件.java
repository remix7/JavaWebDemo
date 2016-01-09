package cc.cynara.mail;

import java.io.FileOutputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
//创建一个带有文本 图片 附件的邮件
public class MailDemo3 {

	public static void main(String[] args) throws Exception {
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props);
		
		MimeMessage message = new MimeMessage(session);
		
		message.setFrom(new InternetAddress("发送方地址"));
		message.setRecipients(Message.RecipientType.TO, "接收方地址");
		message.setSubject("这是一个有内嵌图片的邮件");
		
		//文本部分
		MimeBodyPart textPart = new MimeBodyPart();
		textPart.setContent("你好c<img src='cid:mmee'/>aaa","text/html;charset=UTF-8");//这里解决正文中中文问题
		//图片部分
		MimeBodyPart imagePart = new MimeBodyPart();
		DataHandler dh = new DataHandler(new FileDataSource("f:/a.jpg"));
		imagePart.setDataHandler(dh);
		imagePart.setContentID("mmee");
		//合并转型
		MimeMultipart mmpart = new MimeMultipart();
		mmpart.addBodyPart(textPart);
		mmpart.addBodyPart(imagePart);
		mmpart.setSubType("related");
		
		MimeBodyPart textimagePart = new MimeBodyPart();
		textimagePart.setContent(mmpart);
		
		//附件部分
		MimeBodyPart zipPart = new MimeBodyPart();
		dh = new DataHandler(new FileDataSource("f:\\a.zip"));
		String fileName = dh.getName();
		System.out.println(fileName);
		zipPart.setDataHandler(dh);
		//设置文件名
		zipPart.setFileName(MimeUtility.encodeText(fileName));//这里是解决中文文件名问题
		
		//全部组合
		MimeMultipart mmzpart = new MimeMultipart();
		mmzpart.addBodyPart(textimagePart);
		mmzpart.addBodyPart(zipPart);
		mmzpart.setSubType("mixed");
		
		//放入message中
		message.setContent(mmzpart);
		message.saveChanges();
		message.writeTo(new FileOutputStream("f:/t*.mel"));
	}

}
