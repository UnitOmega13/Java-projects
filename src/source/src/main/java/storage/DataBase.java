package storage;

import model.Basket;
import model.OrderDetails;
import model.Product;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class DataBase {

    public static List<Product> products = new ArrayList<>();
    public static List<User> users = new ArrayList<>();
    public static List<Basket> baskets = new ArrayList<>();
    public static List<OrderDetails> orders = new ArrayList<>();
}
