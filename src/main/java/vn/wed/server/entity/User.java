package vn.wed.server.entity;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	private int id;
	private String email;
	private String password;
	private String passwordSalt;
	private String firstName;
	private String lastName;
	private String role;
	private String gender;
	private String phone;
	private String address;
	private List<Wedding> weddings = new ArrayList<Wedding>();

	public User() {
	}

	// use for login
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public User(String email, String password, String firstName, String lastName) {
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	// use for feeding data
	public User(int id, String email, String password, String passwordSalt, String firstName, String lastName,
			String role, String gender, String phone, String address, List<Wedding> weddings) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.passwordSalt = passwordSalt;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.gender = gender;
		this.phone = phone;
		this.address = address;
		this.weddings = weddings;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordSalt() {
		return passwordSalt;
	}

	public void setPasswordSalt(String passwordSalt) {
		this.passwordSalt = passwordSalt;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Wedding> getWeddings() {
		return weddings;
	}

	public void setWeddings(List<Wedding> weddings) {
		this.weddings = weddings;
	}

}
