/**
 * 
 */
package entity;

/**
 * @author THEGIOILAP.VN
 *
 */
public class Employee extends User{
private int projectId;
private String proSkill;
/**
 * @param id
 * @param fullName
 * @param email
 * @param password
 * @param project
 * @param proSkill
 */
public Employee(int id, String fullName, String email, String password, int projectId, String proSkill) {
	super(id, fullName, email, password);
	this.projectId = projectId;
	this.proSkill = proSkill;
}

/**
 * @return the projectId
 */
public int getProjectId() {
	return projectId;
}

/**
 * @param projectId the projectId to set
 */
public void setProjectId(int projectId) {
	this.projectId = projectId;
}

/**
 * @return the proSkill
 */
public String getProSkill() {
	return proSkill;
}
/**
 * @param proSkill the proSkill to set
 */
public void setProSkill(String proSkill) {
	this.proSkill = proSkill;
}
@Override
public String toString() {
	return "Employee [project ID=" + projectId + ", proSkill=" + proSkill + ", getId()=" + getId() + ", getFullName()="
			+ getFullName() + ", getEmail()=" + getEmail() + ", getPassword()=" + getPassword() + "]";
}
}
