/**
 * 
 */
package entity;

/**
 * @author THEGIOILAP.VN
 *
 */
public class Manager extends User{
 private int expInYear;
 private int projectId;
/**
 * 
 */
public Manager(int id, String fullName, String email, String password, int expInYear, int projectId) {
	super(id, fullName, email, password);
	this.expInYear = expInYear;
	this.projectId = projectId;
}

/**
 * @param id
 * @param fullName
 * @param email
 * @param password
 */
public Manager(int id, String fullName, String email, String password, int expInYear) {
	super(id, fullName, email, password);
	this.expInYear = expInYear;
}

public int getExpInYear() {
	return expInYear;
}

public void setExpInYear(int expInYear) {
	this.expInYear = expInYear;
}

@Override
public String toString() {
	return "Manager | " + "ManagerID: " + getId() + ", FullName: " + getFullName()
			+ ", Email" + getEmail() + ", Password: " + getPassword() + "expInYear: " + getExpInYear() +  "|";
}

public int getProjectId() {
	return projectId;
}

public void setProjectId(int projectId) {
	this.projectId = projectId;
}

}
