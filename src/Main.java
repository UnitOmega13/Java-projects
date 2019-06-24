import controller.ConsoleHandler;
import controller.PlayerConsoleHandler;
import dao.BetDao;
import dao.BetDaoImpl;
import dao.PlayerDao;
import dao.PlayerDaoImpl;
import javafx.util.Pair;
import lib.Injector;

import java.io.*;
import java.util.*;
import java.util.List;

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
