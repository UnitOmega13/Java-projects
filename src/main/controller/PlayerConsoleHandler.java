package controller;

import dao.PlayerDao;
import dao.PlayerDaoImpl;
import lib.Inject;
import model.Player;

import java.util.Scanner;

public class PlayerConsoleHandler {

	@Inject
	private static PlayerDao playerDao;

	static public void playerHandle() {
		try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
				String command = scanner.nextLine();
				if (command.equals("0")) {
					return;
				}
				String[] data = command.split(" ");
				String name = data[0];
				String surName = data[1];
				Player player = new Player(name, surName);
				playerDao.add(player);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Данные введены некорректно");
		}
	}
}
