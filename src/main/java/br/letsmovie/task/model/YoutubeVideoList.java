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
public class YoutubeVideoList implements Serializable{ 

	private static final long serialVersionUID = 1L;
	
	private int page;
	
    private long totalResults;
    
    private long totalPages; 
	
	private List<YoutubeVideo> items;

	public YoutubeVideoList() {
	}

	/**
	 * @param page
	 * @param totalResults
	 * @param totalPages
	 * @param items
	 */
	public YoutubeVideoList(int page, long totalResults, long totalPages, List<YoutubeVideo> items) {
		this.page = page;
		this.totalResults = totalResults;
		this.totalPages = totalPages;
		this.items = items;
	}

	public int getPage() {
		return page;
	}

	public long getTotalResults() {
		return totalResults;
	}

	public long getTotalPages() {
		return totalPages;
	}

	public List<YoutubeVideo> getItems() {
		return items;
	}
}
