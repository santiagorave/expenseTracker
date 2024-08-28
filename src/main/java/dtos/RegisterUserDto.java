package dtos;

public class RegisterUserDto {
	private String email;

	private String password;

	private String name;

	public String getName() {
		return this.name;
	}

	public String getEmail() {
		return this.email;
	}
	public String getPassword() {
		return this.password;
	}

}
