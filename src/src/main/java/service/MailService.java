package service;

import model.OrderDetails;
import model.User;

public interface MailService {
    void sendCode(User user);
    void sendOrder(User user, OrderDetails order);
}
