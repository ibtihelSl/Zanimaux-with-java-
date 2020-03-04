package pidev.Zanimaux.entities;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class EmailController {

    String reciever;
    String subj;
    String con;
    final String username;
    final String password;
    String from;
    String host;
    String put_auth;
    String put_ttls;
    String put_host;
    String put_port;

   

    public EmailController(String reciever, String subj, String con) {
       username = "zanimaux.pi@gmail.com";
        password = "zanimaux123456";
        from = "zanimaux.pi@gmail.com";
        host = "smtp.gmail.com";
        put_auth = "mail.smtp.auth";
        put_ttls = "mail.smtp.starttls.enable";
        put_host = "mail.smtp.host";
        put_port = "mail.smtp.port";
        this.reciever = reciever;
        this.subj = subj;
        this.con = con;
    }

    public void send() {

        Properties props = new Properties();
        props.put(put_auth, "true");
        props.put(put_ttls, "true");
        props.put(put_host, host);
        props.put(put_port, "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(reciever));
            message.setSubject(subj);
            message.setText(con);
            System.out.println(message);
            Transport.send(message);
//            JOptionPane.showMessageDialog(null, "Done, check mailbox !");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
