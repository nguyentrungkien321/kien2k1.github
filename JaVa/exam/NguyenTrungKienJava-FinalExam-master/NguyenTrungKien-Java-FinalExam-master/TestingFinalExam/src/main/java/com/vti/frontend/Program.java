package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import utils.ScannerUtils;


public class Program {
	public static void Menu() {
		System.out.println("--------------");
		System.out.println("Menu: ");
		System.out.println("1. Get User By Project ID");
		System.out.println("2. Get Managers From All Projects ");
		System.out.println("3. Login");
		System.out.println("4. Exit");
		System.out.println("---------------");
	}
public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		Function function = new Function();
		while (true) {
			Menu();
			System.out.println("Moi ban nhap chuc nang: ");
			int choose = ScannerUtils.inputFunction(1, 4, "Ban chi duoc chon tu 1 --> 4. Mời nhập lại!");

			switch (choose) {
			case 1:
				function.getListUsersByProjectId();
				break;
			case 2:
				function.getListManager();
				break;
			case 3:
				function.login();;
				break;
			case 4:
				System.out.println("Bạn đã thoát khỏi chương trình!");
				System.exit(0);
			}
}
}
}
