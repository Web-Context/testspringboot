package hello.entities;

import javax.persistence.Entity;

/**
 * This class is a User model.
 * 
 * @author Frédéric Delorme
 *
 */
@Entity
public class User extends SuperEntity {

	private String username;

	private String password;

	private String email;

	private String firstName;
	private String lastName;

	public User() {
	}

	/**
	 * @param username
	 * @param password
	 * @param email
	 * @param firstName
	 * @param lastName
	 */
	public User(String username, String password, String email,
			String firstName, String lastName) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}