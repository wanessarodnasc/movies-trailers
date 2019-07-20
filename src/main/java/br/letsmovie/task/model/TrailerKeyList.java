package br.letsmovie.task.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 
 * @author Wanessa Nascimento
 * 
 */
@JsonInclude(Include.NON_NULL) 
public class TrailerKeyList implements Serializable{ 

	private static final long serialVersionUID = 1L;
	
	private List<TrailerKey> results;
	
	public TrailerKeyList() {
	}

	public TrailerKeyList(List<TrailerKey> results) {
		this.results = results;
	}

	public List<TrailerKey> getResults() {
		return results;
	}
}
