package factories;

import service.Impl.UserServiceInpl;
import service.UserService;

public class UserServiceFactory {

    private static UserService instance;

    private UserServiceFactory() {
    }

    public static synchronized UserService getInstance() {
        if (instance == null) {
            instance = new UserServiceInpl();
        }
        return instance;
    }
}
