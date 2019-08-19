import controller.PlayerConsoleHandler;
import dao.PlayerDao;
import dao.PlayerDaoImpl;
import lib.Injector;

public class Main {

    static {
        try {
            Injector.injectDependency();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Please input player name and surname:");
        PlayerConsoleHandler.playerHandle();
        PlayerDao playerDao = new PlayerDaoImpl();
        System.out.println(playerDao.getAll());
    }
}
