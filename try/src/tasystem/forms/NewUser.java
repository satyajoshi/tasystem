package tasystem.forms;

import org.springframework.stereotype.Component;

@Component
public class NewUser {
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String role;
	private String companyName;
	private String status;	
	
	public NewUser() {}

	public NewUser(String firstName, String lastName, String password,
			String email, String companyName, String status, String role) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.companyName = companyName;
		this.status = status;
		this.role = role;
	}

	

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getStatus() {
		return status;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setStatus(String status) {
		this.status = status;
	}	

}
