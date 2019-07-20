package br.letsmovie.task.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Wanessa Nascimento
 * 
 */
@JsonInclude(Include.NON_NULL) 
public class YoutubeVideo implements Serializable{ 

	private static final long serialVersionUID = 1L;

	private String kind;
	private String etag;
	
	@JsonProperty("player")
	private YoutubePlayer player;
	
	public YoutubeVideo() {
	}

	public YoutubeVideo(String kind, String etag, YoutubePlayer player) {
		this.kind = kind;
		this.etag = etag;
		this.player = player;
	}

	public String getKind() {
		return kind;
	}

	public String getEtag() {
		return etag;
	}

	public YoutubePlayer getYouTubePlayer() {
		return player;
	}
	
	public String getPlayerValue() {
		return player.getEmbedHtml();
	}
}
