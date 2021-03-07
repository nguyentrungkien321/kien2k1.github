package backend.data_layer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Employee;
import entity.Manager;
import entity.User;
import utils.JdbcUtils;

public class userRepository implements IUserRepository{	
	private JdbcUtils jdbcUtils;
	private Connection connection;

	public userRepository() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		jdbcUtils = new JdbcUtils();
	}
	
	public List<User> getListUsersByProjectId(int id) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		List<User> employees = new ArrayList<User>();
		try {
			// get connect
			connection = jdbcUtils.connect();

			// Step 3: Create a statment object
			String listEmployees = "SELECT * FROM testing_final_exam.employee WHERE ProjectID = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(listEmployees);
			// Step 4: set parameter
			preparedStatement.setInt(1, id);
			//Step 5: Execute SQL query			
			ResultSet resultSet = preparedStatement.executeQuery();
			// Step 6: Handling result set
			while (resultSet.next()) {
				int employeeId = resultSet.getInt("EmployeeID");
				String email = resultSet.getString("Email");
				String fullName = resultSet.getString("FullName");				
				String password = resultSet.getString("Password");
				int projectId = resultSet.getInt("ProjectID");
				String proSkill = resultSet.getString("ProSkill");
				User employee = new Employee(employeeId, fullName, email, password, projectId , proSkill);
				employees.add(employee);
			}
			return employees;
		} finally {
			// Step 7: Close connection
			connection.close();
		}
	}

	public List<User> getListManager() throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		List<User> managers = new ArrayList<User>();
		try {
			// get connect
			connection = jdbcUtils.connect();

			// Step 3: Create a statment object
			Statement statement = connection.createStatement();

			// Step 4: Execute query
			String listManager = "SELECT M.*, P.ProjectID FROM testing_final_exam.manager M JOIN testing_final_exam.project P ON P.ManagerID = M.ManagerID";
			ResultSet resultSet = statement.executeQuery(listManager);
			
			// Step 5: Handling result set
			while (resultSet.next()) {
				int managerId = resultSet.getInt("ManagerID");
				String fullName = resultSet.getString("FullName");
				String email = resultSet.getString("Email");
				String password = resultSet.getString("Password");
				int exp = resultSet.getInt("ExpInYear");
				int projectId = resultSet.getInt("ProjectID");
				User manager = new Manager(managerId, fullName, email, password, exp, projectId);
				managers.add(manager);
			}
			return managers;
		} finally {
			// Step 6: Close connection
			connection.close();
		}

	}

	public User login(String email, String password) throws Exception {
		try {

			// step 2: get connect
			connection = jdbcUtils.connect();

			// Step 3: Create a statement object

			String sql = "SELECT EmployeeID, Email, FullName, Password FROM testing_final_exam.employee "
					+ "UNION "
					+ "SELECT ManagerID, Email, FullName, Password FROM testing_final_exam.manager" + " WHERE Email = ? AND Password = ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			// set parameter
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);

			// Step 4: Execute Query

			ResultSet resultSet = preparedStatement.executeQuery();

			// Step 5: Handling result
			if (resultSet.next()) {
				int userId = resultSet.getInt("EmployeeID");
				String fullName = resultSet.getString("FullName");
				User user = new User(userId, fullName, email, password);  
				return user;
			} else {
				throw new Exception("Tai khoan hoac mat khau sai!");
			}

		} finally {
			connection.close();
		}
	}

}
