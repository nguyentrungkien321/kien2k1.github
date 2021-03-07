/**
 * 
 */
package entity;

/**
 * @author THEGIOILAP.VN
 *
 */
public class Project {
private int projectId;
private int teamSize;
private int managerId;
private int[] employeesId;


public Project(int projectId, int teamSize, int managerId, int[] employeesId) {
	super();
	this.projectId = projectId;
	this.teamSize = teamSize;
	this.managerId = managerId;
	this.employeesId = employeesId;
}
public int getProjectId() {
	return projectId;
}
public void setProjectId(int projectId) {
	this.projectId = projectId;
}
public int getTeamSize() {
	return teamSize;
}
public void setTeamSize(int teamSize) {
	this.teamSize = teamSize;
}
public int getManagerId() {
	return managerId;
}
public void setManagerId(int managerId) {
	this.managerId = managerId;
}
public int[] getEmployeesId() {
	return employeesId;
}
public void setEmployeesId(int[] employeesId) {
	this.employeesId = employeesId;
}

}
