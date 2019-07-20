package br.letsmovie.task.model;

import java.io.Serializable;

/**
 * 
 * @author Wanessa Nascimento
 * 
 */
public class YoutubePlayer implements Serializable { 

	private static final long serialVersionUID = 1L;
	
	private String embedHtml;
	
	public YoutubePlayer() {
	}

	public YoutubePlayer(String embedHtml) {
		this.embedHtml = embedHtml;
	}

	public String getEmbedHtml() {
		return embedHtml;
	}
}
