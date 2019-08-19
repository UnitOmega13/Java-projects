package lib;

import controller.ConsoleHandler;
import controller.PlayerConsoleHandler;
import dao.BetDao;
import dao.BetDaoImpl;
import dao.PlayerDao;
import dao.PlayerDaoImpl;
import factory.BetDaoFactory;
import factory.PlayerDaoFactory;

import java.lang.reflect.Field;

public class Injector {

    public static void injectDependency() throws IllegalAccessException {
        Class<ConsoleHandler> consoleHandlerClass = ConsoleHandler.class;
        Class<BetDao> betDaoClass = BetDao.class;
        Class<BetDaoImpl> betDaoImplClass = BetDaoImpl.class;
        Class<PlayerDao> playerDaoClass = PlayerDao.class;
        Class<PlayerConsoleHandler> playerConsoleHandlerClass = PlayerConsoleHandler.class;
        Class<PlayerDaoImpl> playerDaoImpClass = PlayerDaoImpl.class;

        Field[] consoleHandlerFields = consoleHandlerClass.getDeclaredFields();
        for (Field field : consoleHandlerFields) {
            if (field.getDeclaredAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                field.set(null, BetDaoFactory.getBetDao());
            }
        }

        Field[] playerConsoleHandler = playerConsoleHandlerClass.getDeclaredFields();
        for (Field field : playerConsoleHandler) {
            if (field.getDeclaredAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getType().equals(playerDaoClass) && playerDaoImpClass.getAnnotation(Dao.class) != null) {
                    field.set(null, PlayerDaoFactory.getPlayerDao());
                }
            }
        }
    }
}
