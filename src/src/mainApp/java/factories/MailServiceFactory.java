package factories;

import service.Impl.MailServiceImpl;
import service.MailService;

public class MailServiceFactory {
    private static MailService instance;

    public MailServiceFactory() {
    }

    public static synchronized MailService getInstance() {
        if (instance == null) {
            instance = new MailServiceImpl();
        }
        return instance;
    }
}
