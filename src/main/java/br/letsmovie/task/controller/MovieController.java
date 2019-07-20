package br.letsmovie.task.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.letsmovie.task.controller.dto.VideoDto;
import br.letsmovie.task.exception.BusinessException;
import br.letsmovie.task.model.MovieList;
import br.letsmovie.task.service.MovieDatabaseService;
import springfox.documentation.annotations.Cacheable;

/**
* This class is a controller to provide a rest webservice. 
*
* @author Wanessa Nascimento
*
*/
@RestController
public class MovieController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);
	
	@Autowired
	private MovieDatabaseService service;

    /**
     * Search a movie by parameter.
     *
     * @param searchParam is a required parameter search by title
     * @return A MovieDto with the video information
     * @throws BusinessException 
     */
    @GetMapping("movies")
    public ResponseEntity<MovieList> searchMovie(@Valid @RequestParam String searchParam, @RequestParam int page, String language,
    		UriComponentsBuilder uriBuilder) throws BusinessException {
    	LOGGER.info("Call searchMovie");
    	MovieList movies = service.searchMovie(searchParam, page, language);
    	return ResponseEntity.ok().body(movies);
    }
    
    /**
     * Search a trailer by movie id.
     *
     * @param idMovie
     * @return A VideoDto with the video information
     * @throws BusinessException 
     */
    @GetMapping("trailers")
    @Cacheable(value = "trailerList")
    public ResponseEntity<List<VideoDto>> searchTrailer(@RequestParam long idMovie) throws BusinessException {
    	LOGGER.info("Call searchTrailer");
    	List<VideoDto> videos = service.searchTrailer(idMovie);
    	return ResponseEntity.ok().body(videos);
    }
}
