package br.letsmovie.task.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 
 * @author Wanessa Nascimento
 *
 */
@JsonInclude(Include.NON_NULL) 
public class Movie implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private String title;

	private String overview;

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getOverview() {
		return overview;
	}
}
