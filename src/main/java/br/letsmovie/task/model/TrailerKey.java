package br.letsmovie.task.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 
 * @author Wanessa Nascimento
 * 
 */
@JsonInclude(Include.NON_NULL) 
public class TrailerKey implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	private String trailerKeyId;
	
	@JsonProperty("key")
	private String trailerKeyValue;
	
	@JsonProperty("site")
	private String trailerWebSite;
	
	@JsonProperty("name")
	private String trailerName;

	public TrailerKey() {
	}

	public TrailerKey(TrailerKey trailerKey) {
		this.trailerKeyId = trailerKey.getTrailerKeyId();
		this.trailerKeyValue = trailerKey.getTrailerKeyValue();
		this.trailerWebSite = trailerKey.getTrailerWebSite();
		this.trailerName = trailerKey.getTrailerName();
	}

	public String getTrailerKeyId() {
		return trailerKeyId;
	}

	public String getTrailerKeyValue() {
		return trailerKeyValue;
	}

	public String getTrailerWebSite() {
		return trailerWebSite;
	}

	public String getTrailerName() {
		return trailerName;
	}
}
