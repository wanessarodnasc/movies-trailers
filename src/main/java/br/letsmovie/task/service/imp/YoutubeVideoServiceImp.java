package br.letsmovie.task.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.letsmovie.task.model.YoutubeVideo;
import br.letsmovie.task.service.VideoService;
import br.letsmovie.task.service.client.imp.YoutubeClientServiceImp;

@Service
public class YoutubeVideoServiceImp implements VideoService<YoutubeVideo> {
	
	@Autowired
	private YoutubeClientServiceImp youtubeService;

	@Override
	public List<YoutubeVideo> getVideos(String trailerKey) {
		return youtubeService.getVideo(trailerKey);
	}
}
