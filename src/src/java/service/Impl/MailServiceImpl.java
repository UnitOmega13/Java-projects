package service.Impl;

import factories.BasketServiceFactory;
import model.OrderDetails;
import model.User;
import service.BasketService;
import service.MailService;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Properties;

public class MailServiceImpl implements MailService {
    private static final BasketService basketService = BasketServiceFactory.getInstance();
    private static final String userNmae = "testu0513@gmail.com";
    private static final String password = "490401Neko";

    private Properties getProperties() {
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        return prop;
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
            e.printStackTrace();
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
            e.printStackTrace();
        }
    }
}
