package br.letsmovie.task.exception;

public class ExceptionFormDto {
	
	private String field;
	private String error;
	
	public ExceptionFormDto(String field, String error) {
		this.field = field;
		this.error = error;
	}

	public String getField() {
		return field;
	}

	public String getError() {
		return error;
	}
}
