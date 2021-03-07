package backend.bussiness_layer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import entity.User;

public interface IUserService {
	List<User> getListUsersByProjectId(int id) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException;
	List<User> getListManager() throws SQLException, ClassNotFoundException, FileNotFoundException, IOException;
	User login(String email, String password) throws Exception;
}
