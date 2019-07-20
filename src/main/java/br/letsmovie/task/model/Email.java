package br.letsmovie.task.model;

/**
* 
* @author Wanessa Nascimento
*
*/
public class Email {

	private String emailAddress;
	private String subject;
	private String msg;

	public Email() {
	}

	public Email(String email, String subject, String msg) {
		this.emailAddress = email;
		this.subject = subject;
		this.msg = msg;
	}

	public String getEmail() {
		return emailAddress;
	}

	public String getSubject() {
		return subject;
	}

	public String getMsg() {
		return msg;
	}

}
