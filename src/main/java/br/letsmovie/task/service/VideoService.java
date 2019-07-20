package br.letsmovie.task.service;

import java.util.List;

public interface VideoService<T> {
	
	List<T> getVideos(String trailerKey);

}
