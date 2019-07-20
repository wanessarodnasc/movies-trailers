package br.letsmovie.task.client;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.letsmovie.task.model.MovieList;
import br.letsmovie.task.model.TrailerKey;
import br.letsmovie.task.service.client.MovieDatabaseClientService;
/**
* 
* @author Wanessa Nascimento
*
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MovieClientServiceTest {
	
	@Autowired
	private MovieDatabaseClientService service;
	
	private final static String MOVIE_NAME = "Shaz";
	private final static int PAGE = 1;
	private final static String LANGUAGE_PORTUGUESE = "pt-BR";
	private final static long MOVIE_CODE = 550;

	@Test
	public void getMovieDetailByTitle() {
		MovieList detail = service.serachMovie(MOVIE_NAME, PAGE, LANGUAGE_PORTUGUESE);
		assertNotNull(detail.getResults());
	}

	@Test
	public void getIdTrailerMovie() {
		List<TrailerKey> trailers = service.getCodeTrailerMovie(MOVIE_CODE);
		assertNotNull(trailers);
	}
}
