package br.letsmovie.task.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import br.letsmovie.task.controller.dto.VideoDto;
import br.letsmovie.task.exception.BusinessException;
import br.letsmovie.task.model.MovieList;
import br.letsmovie.task.model.TrailerKey;
import br.letsmovie.task.model.YoutubeVideo;
import br.letsmovie.task.service.MovieDatabaseService;
import br.letsmovie.task.service.VideoService;
import br.letsmovie.task.service.client.MovieDatabaseClientService;
/**
* 
*
* @author Wanessa Nascimento
*/
@Service
public class TMDBServiceImp implements MovieDatabaseService {
	
	@Autowired
	private MovieDatabaseClientService tmdbService;
	
	@Autowired
	private VideoService<YoutubeVideo> youTubeVideoService;
	
	@Value("${service.database.youtube}")
	private String serviceDatabase;
	
	@Override
	@Cacheable(cacheNames = "movies", unless = "#result==null")
	public MovieList searchMovie(String searchParam, int page, String language) throws BusinessException {
		MovieList movieList = tmdbService.serachMovie(searchParam, page, language);
		
		if(movieList == null || movieList.getResults().isEmpty()) {
			throw new BusinessException("No movies found.");
		}
		return movieList;
	}

	@Override
	@Cacheable(cacheNames = "videos", unless = "#result==null")
	public List<VideoDto> searchTrailer(long idMovie) throws BusinessException {
		List<VideoDto> videos = getVideos(tmdbService.getCodeTrailerMovie(idMovie));
		
		if(videos.isEmpty()) {
			throw new BusinessException("No trailer found.");
		}
		return videos;
	}

	private List<VideoDto> getVideos(List<TrailerKey> keys) {
		List<YoutubeVideo> youtubeVideos = new ArrayList<>();
		for(TrailerKey trailerKey : keys) {
			if(trailerKey.getTrailerWebSite().toLowerCase().contains(serviceDatabase)) {
				youtubeVideos.addAll(youTubeVideoService.getVideos(trailerKey.getTrailerKeyValue()));
			}
		}
		return VideoDto.convert(youtubeVideos);
	}
}
