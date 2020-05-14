//Example of sending email in Java through SMTP server provided by the host provider***********

//Staging  Area
//local repo changes
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailBySite {

	public static void main(String[] args) {
		String to="maateldhiya@gmail.com";
		String host="mail.javatpoint.com";  
		  final String user="sonoojaiswal@javatpoint.com";//change accordingly  
		  final String password="xxxxx";//change accordingly  
		
		//Get the session object  
		   Properties props = new Properties();  
		   props.put("mail.smtp.host",host);  
		   props.put("mail.smtp.auth", "true");  
		  Session session = Session.getDefaultInstance(props,  
				    new javax.mail.Authenticator() {  
				      protected PasswordAuthentication getPasswordAuthentication() {  
				    return new PasswordAuthentication(user,password);  
				      }  
				    });  
		
		
		//compose the message
		try {
			MimeMessage message = new MimeMessage(session);  
		     message.setFrom(new InternetAddress(user));  
		     message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
		     message.setSubject("javatpoint");  
		     message.setText("This is simple program of sending email using JavaMail API"); 
			
			//Send Message
			Transport.send(message);
			
			System.out.println("Message sent sucessfully");
		}
		catch(MessagingException mex)
		{
			mex.printStackTrace();
		}

	}

}
