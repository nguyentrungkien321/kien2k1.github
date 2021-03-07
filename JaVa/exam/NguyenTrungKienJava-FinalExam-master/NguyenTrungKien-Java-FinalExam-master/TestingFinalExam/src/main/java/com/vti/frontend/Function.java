package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import backend.presentation_layer.userController;
import entity.Employee;
import entity.Manager;
import entity.User;
import utils.ScannerUtils;
public class Function {
	private userController userController;

	public Function() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		userController = new userController();
	}
	public void getListUsersByProjectId() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
			System.out.print("Mời bạn nhập vào project id: ");
			int id = ScannerUtils.inputPositiveInt("Bạn phải nhập vào số nguyên dương! Mời nhập lại");
			List<User> employees = userController.getListUsersByProjectId(id);
			System.out.println("List: ");
			System.out.printf("%-15s %-25s %-25s %-25s %-25s %-25s\n", "ID", "Email", "Fullname", "Password", "ProjectID", "ProSkill");
			for (User e : employees) {
				System.out.printf("%-15s %-25s %-25s %-25s %-25s %-25s\n", e.getId(), e.getEmail(), e.getFullName(),
						e.getPassword(), ((Employee) e).getProjectId(), ((Employee) e).getProSkill());
			}
	}
	public void getListManager() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		List<User> managers = userController.getListManager();
		System.out.println("List Manager: ");
		System.out.printf("%-15s %-25s %-25s %-25s %-25s %-25s\n", "ID", "Email", "Fullname", "Password", "ExpInYear", "ProjectID");
		for (User m : managers) {
			System.out.printf("%-15s %-25s %-25s %-25s %-25s %-25s\n", m.getId(), m.getEmail(), m.getFullName(),
					m.getPassword(), ((Manager) m).getExpInYear(), ((Manager) m).getProjectId());
		}
	}

	public void login() throws ClassNotFoundException, SQLException {
		boolean done = false;
		while (done != true) {
			System.out.print("Mời bạn nhập vào Email: ");
			String email = ScannerUtils.inputEmail("Email chưa đúng định dạng.");
			System.out.print("Mời bạn nhập password: ");
			String password = ScannerUtils
					.inputPassword("Password phai dai tu 6--> 12 ki tu va co it nhat 1 chu viet hoa!");
			try {
				User user = userController.login(email, password);
				done = true;
				System.out.println(user);
			} catch (Exception e) {
				System.err.println(e.getMessage() + "\n");
			}
		}
	}
}
