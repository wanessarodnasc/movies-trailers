package br.letsmovie.task.form;

import javax.validation.constraints.NotBlank;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 * 
 * @author Wanessa Nascimento
 *
 */
public class LoginForm {

	private String name;
	
	@NotBlank(message = "Email is mandatory")
	private String email;
	
	@NotBlank(message = "Password is mandatory")
	private String password;
	
	private String profile = "USER";

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getProfile() {
		return profile;
	}

	public UsernamePasswordAuthenticationToken converter() {
		return new UsernamePasswordAuthenticationToken(email, password);
	}
}
