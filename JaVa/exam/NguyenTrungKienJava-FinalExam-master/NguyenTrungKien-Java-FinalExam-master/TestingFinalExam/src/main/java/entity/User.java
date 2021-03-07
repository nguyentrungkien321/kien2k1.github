/**
 * 
 */
package entity;

/**
 * @author THEGIOILAP.VN
 *
 */
public class User {
private int id;
private String fullName;
private String email;
private String password;


/**
 * 
 */
public User() {
	super();
}

/**
 * @param id
 * @param fullName
 * @param email
 * @param password
 */
public User(int id, String fullName, String email, String password) {
	super();
	this.id = id;
	this.fullName = fullName;
	this.email = email;
	this.password = password;
}

/**
 * @return the id
 */
public int getId() {
	return id;
}
/**
 * @param id the id to set
 */
public void setId(int id) {
	this.id = id;
}
/**
 * @return the fullName
 */
public String getFullName() {
	return fullName;
}
/**
 * @param fullName the fullName to set
 */
public void setFullName(String fullName) {
	this.fullName = fullName;
}
/**
 * @return the email
 */
public String getEmail() {
	return email;
}
/**
 * @param email the email to set
 */
public void setEmail(String email) {
	this.email = email;
}
/**
 * @return the password
 */
public String getPassword() {
	return password;
}
/**
 * @param password the password to set
 */
public void setPassword(String password) {
	this.password = password;
}

@Override
public String toString() {
	return "User | ID = " + id + " , FullName = " + fullName + " , Email = " + email + " , Password = " + password + " | ";
}
}
