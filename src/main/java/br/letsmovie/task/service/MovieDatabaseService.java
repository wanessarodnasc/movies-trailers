package br.letsmovie.task.service;

import java.util.List;

import br.letsmovie.task.controller.dto.VideoDto;
import br.letsmovie.task.exception.BusinessException;
import br.letsmovie.task.model.MovieList;
/**
* 
*
* @author Wanessa Nascimento
*/
public interface MovieDatabaseService {

	MovieList searchMovie(String searchParam, int page, String language) throws BusinessException;

	List<VideoDto> searchTrailer(long idMovie) throws BusinessException; 
	
}
