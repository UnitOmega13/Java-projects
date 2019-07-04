package java.dbService;

import java.dbService.dataSets.User;
import java.util.Optional;

public class AccountService {

    private static DataBaseService dbService;

    static {
        dbService = new DataBaseService();
        System.out.println("AccountService loaded");
    }

    private AccountService() {
    }


    public static boolean signUp(String login, String password) {

        boolean result = false;
        Optional<User> user = Optional.empty();
        try {
            user = Optional.ofNullable(dbService.getUserByLogin(login));
        } catch (DataBaseException e) {
            e.printStackTrace();
        }
        if (user.isPresent()) {
            result = false;
        } else {
            try {
                dbService.addUser(login, password);
            } catch (DataBaseException e) {
                e.printStackTrace();
            }
            result = true;
        }

        return result;

    }

    public static boolean signIn(String login, String password) {

        return checkRegister(login) && checkPassword(login, password);
    }


    private static boolean checkRegister(String login) {
        boolean isRegistered = false;
        try {
            isRegistered = dbService.getUserByLogin(login) != null;
        } catch (DataBaseException e) {
            e.printStackTrace();
        }

        return isRegistered;
    }

    private static boolean checkPassword(String login, String password) {
        boolean matched = false;
        try {
            matched = password.equals(dbService.getUsersPassword(login));
        } catch (DataBaseException e) {
            e.printStackTrace();
        }

        return matched;
    }
}
