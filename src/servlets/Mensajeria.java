package servlets;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class Mensajeria {
	
	
	public String enviarMensaje(String correo,String mensaje){
		
		//String correoUsuario="carlosmamani1993@gmail.com";
		//String password="263627fb";
		
		
		String correoUsuario="cinepapaya9@gmail.com";
		String password="Papaya123";
		
		try{
			
			Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", correoUsuario);
            props.setProperty("mail.smtp.auth", "true");

            // Preparamos la sesion
            Session session = Session.getDefaultInstance(props);

            // Construimos el mensaje
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(correo));
            message.addRecipient(
            Message.RecipientType.TO,new InternetAddress(correo));
           
            message.setSubject("Entradas");
            message.setText(mensaje);
            // Lo enviamos.
            Transport t = session.getTransport("smtp");
            t.connect(correoUsuario,password);
            t.sendMessage(message, message.getAllRecipients());
            // Cierre.
            t.close();
            
            return "exito";
            
		}catch (Exception e) {
			e.printStackTrace();
			return "fracaso";

		}
		
		
	}
	

}
