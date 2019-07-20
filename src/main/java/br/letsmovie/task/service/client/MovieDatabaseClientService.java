package br.letsmovie.task.service.client;

import java.util.List;

import br.letsmovie.task.model.MovieList;
import br.letsmovie.task.model.TrailerKey;

/**
 *
 * This interface provide a contract to consult movie database. Is possible
 * implement to more than one movie database provider.
 *
 * @author Wanessa Nascimento
 * 
 */

public interface MovieDatabaseClientService {

	MovieList serachMovie(String searchParameter, int page, String language);

	List<TrailerKey> getCodeTrailerMovie(long movieCode);

}
