package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {
	private int id;
	private String username;
	private String password;
	private String email;
	private String firstname;
	private String lastname;
	private String gender;
	private String interest;

	public User(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;

	}

	public User(String username, String password, String email, String firstname, String lastname, String gender,
			String interest) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.interest = interest;
	}

}