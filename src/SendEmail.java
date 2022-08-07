import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.time.LocalDate;
import java.util.Properties;

public class SendEmail {

    public static void send(Email mail) {
        String email = mail.getTo();
        String subject = mail.getSubject();
        String content = mail.getContent();

        final String username = "rashadCS1040@gmail.com";
        final String password = "dqbibgvvqmezpjii";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("from@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email)
            );
            message.setSubject(subject);
            message.setText(content);

            Transport.send(message);
            mail.setDate(LocalDate.now());
            // TODO: Serialize the mail object

            System.out.println("Message sent!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}