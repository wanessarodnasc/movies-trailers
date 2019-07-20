package br.letsmovie.task.service.client.imp;

import java.text.MessageFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import br.letsmovie.task.model.MovieList;
import br.letsmovie.task.model.TrailerKey;
import br.letsmovie.task.model.TrailerKeyList;
import br.letsmovie.task.service.client.MovieDatabaseClientService;

/**
* This class make the communication with the TMDB services to get movie details by title or actor name
* and get the trailer id in webSites such Youtube.
*
* @author Wanessa Nascimento
*/

@Service
public class TMDBClientServiceImp implements MovieDatabaseClientService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TMDBClientServiceImp.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${url.api.the.movie.search.movie}")
	private String urlTMDBSearchMovie;
	
	@Value("${url.api.the.movie.search.trailers}")
	private String urlTMDBSearchTrailers;
	
	@Value("${api.the.movie.param.api.key}")
	private String apiKeyVariable;
	
	@Value("${api.the.movie.value.api.key}")
	private String apiKeyValue;
	
	@Value("${api.the.movie.param.query}")
	private String queryVariable;
	
	@Value("${api.the.movie.param.page}")
	private String pageVariable;
	
	@Value("${api.the.movie.param.language}")
	private String languageVariable;
	
	@Override
	public  MovieList serachMovie(String searchParameter, int page, String language) {
		UriComponents uri = UriComponentsBuilder.fromUriString(urlTMDBSearchMovie)
				.queryParam(apiKeyVariable, apiKeyValue)
				.queryParam(queryVariable, searchParameter)
				.queryParam(pageVariable, page)
				.queryParam(languageVariable, language).build();
		
		LOGGER.info(MessageFormat.format("Calling web service TMDB: {0}", uri));
		
		return restTemplate.getForObject(uri.toUriString(), MovieList.class);
	}

	@Override
	public List<TrailerKey> getCodeTrailerMovie(long idMovie) {
		UriComponents uri = UriComponentsBuilder.fromUriString(urlTMDBSearchTrailers + idMovie + "/videos")
				.queryParam(apiKeyVariable, apiKeyValue).build();
		
		LOGGER.info(MessageFormat.format("Calling web service TMDB: {0}", uri));
		
		return restTemplate.getForObject(uri.toUriString(), TrailerKeyList.class).getResults();
	}
}
