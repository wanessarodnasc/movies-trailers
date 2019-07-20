package br.letsmovie.task.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Wanessa Nascimento
 * 
 */
@JsonInclude(Include.NON_NULL) 
public class MovieList implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int page;
	
	@JsonProperty("total_results")
    private long totalResults;
    
	@JsonProperty("total_pages")
    private long totalPages; 

	private List<Movie> results;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public long getTotalResults() {
		return totalResults;
	}

	public long getTotalPages() {
		return totalPages;
	}

	public List<Movie> getResults() {
		return results;
	}
}
