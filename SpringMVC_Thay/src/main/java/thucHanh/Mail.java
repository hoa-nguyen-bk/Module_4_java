package thucHanh;
import java.util.Properties;

import org.springframework.mail.javamail.JavaMailSenderImpl;

public class Mail {
	public static void main(String[] args) {
		//nó yêu cầu mình khai báo trong này để khi khởi động thì nó tự tạo ra
		JavaMailSenderImpl jms = new JavaMailSenderImpl();
		jms.setHost("smtp.gmail.com");
		jms.setPort(465);
		jms.setUsername("nva@gmail.com");
		jms.setPassword("123456");
		Properties pros = System.getProperties();
		//cái thuộc tính đòi đối tượng trong system.getProperties
		pros.setProperty("mail.smtp.auth", "true");
		//tập hợp các thuộc tính
		jms.setJavaMailProperties(pros);
		
	}
	
}
