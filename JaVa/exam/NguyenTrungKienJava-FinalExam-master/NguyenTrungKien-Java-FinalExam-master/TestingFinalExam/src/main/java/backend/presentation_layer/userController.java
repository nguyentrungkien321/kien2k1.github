package backend.presentation_layer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import backend.bussiness_layer.IUserService;
import backend.bussiness_layer.userService;
import entity.User;
public class userController implements IUserController{
	private IUserService userService;
	public userController() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		userService = new userService();
	}
	public List<User> getListUsersByProjectId(int id)
			throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		return userService.getListUsersByProjectId(id);
	}

	public List<User> getListManager() throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		List<User> managers = 
				userService.getListManager();
		return managers;
	}

	public User login(String email, String password) throws Exception {
		return userService.login(email, password);
	}

}
