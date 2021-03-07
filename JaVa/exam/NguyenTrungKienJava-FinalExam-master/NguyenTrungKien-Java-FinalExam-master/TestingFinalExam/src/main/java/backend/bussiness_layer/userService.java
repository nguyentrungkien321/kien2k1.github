package backend.bussiness_layer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import backend.data_layer.IUserRepository;
import backend.data_layer.userRepository;
import entity.User;

public class userService implements IUserService{
IUserRepository userRepository;
public userService() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
	userRepository = new userRepository();
}
public List<User> getListUsersByProjectId(int id)
		throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
	
	return userRepository.getListUsersByProjectId(id);
}

public List<User> getListManager() throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
	List<User> managers = 
			userRepository.getListManager();
	return managers;
}

public User login(String email, String password) throws Exception {
	return userRepository.login(email, password);
}

}
