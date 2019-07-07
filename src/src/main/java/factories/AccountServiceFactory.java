package factories;

import service.AccountService;

public class AccountServiceFactory {

    private static AccountService instance;

    private AccountServiceFactory() {
    }

    public static AccountService getInstance() {
        if (instance == null) {
            instance = new AccountService();
        }
        return instance;
    }
}
