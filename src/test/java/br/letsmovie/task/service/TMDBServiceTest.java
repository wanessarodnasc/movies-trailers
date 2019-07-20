package br.letsmovie.task.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.letsmovie.task.controller.dto.VideoDto;
import br.letsmovie.task.exception.BusinessException;
import br.letsmovie.task.model.Movie;
import br.letsmovie.task.service.imp.TMDBServiceImp;

/**
* 
* @author Wanessa Nascimento
*
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TMDBServiceTest {
	
	private final static String MOVIE_NAME = "Shaz";
	private final static int PAGE = 1;
	private final static String LANGUAGE_PORTUGUESE = "pt-BR";
	private final static long MOVIE_CODE = 550;
	
	@Autowired
	private TMDBServiceImp service;
	
	@Test
	public void searchMovie() throws BusinessException {
		List<Movie> searchMovie = service.searchMovie(MOVIE_NAME, PAGE, LANGUAGE_PORTUGUESE).getResults();
		assertEquals(true, movieExist(searchMovie));
	}

	@Test
	public void searchTrailer() throws BusinessException {
		List<VideoDto> video = service.searchTrailer(MOVIE_CODE);
		assertEquals(true, trailerExist(video));
	}

	private boolean trailerExist(List<VideoDto> videos) {
		for(VideoDto video : videos) {
			if(video.getVideoData().contains("www.youtube.com/embed/BdJKm16Co6M")) {
				return true;
			}
		}
		return false;
	}

	private boolean movieExist(List<Movie> searchMovie) {
		for(Movie movie : searchMovie) {
			if(movie.getTitle().toLowerCase().contains("shazam")) {
				return true;
			}
		}
		return false;
	}
}
