package service.Impl;

import factories.BasketServiceFactory;
import model.OrderDetails;
import model.User;
import org.apache.log4j.Logger;
import service.BasketService;
import service.MailService;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Properties;

public class MailServiceImpl implements MailService {
    private static final BasketService basketService = BasketServiceFactory.getInstance();
    private static final String userNmae = "testu0513@gmail.com";
    private static final String password = "490401Neko";
    private static final Logger logger = Logger.getLogger(MailServiceImpl.class);

    private Properties getProperties() {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        return properties;
    }

    private Session getSession() {
        return Session.getInstance(getProperties(),
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(userNmae, password);
                    }
                });
    }

    @Override
    public void sendCode(User user) {
        Session session = getSession();

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(userNmae));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(user.getEmail())
            );
            message.setSubject("Code for confirmation order");
            message.setText(user.getCode());
            Transport.send(message);
        } catch (MessagingException e) {
            logger.error("Send Code ERROR!!!");
        }
    }

    @Override
    public void sendOrder(User user, OrderDetails order) {
        Session session = getSession();

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(userNmae));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(user.getEmail())
            );
            message.setSubject("Your order " + order.getId());
            message.setText(basketService.getUserBasket(user).get().toString() +
                    "\n" + order.toString());
            Transport.send(message);
        } catch (MessagingException e) {

        }
    }
}
