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

import br.letsmovie.task.model.YoutubeVideo;
import br.letsmovie.task.model.YoutubeVideoList;
import br.letsmovie.task.service.client.VideoClientService;

/**
* 
* This class make the communication with Youtube API to get the video of a trailer.
*
* @author Wanessa Nascimento
*/

@Service
public class YoutubeClientServiceImp implements VideoClientService<YoutubeVideo> {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TMDBClientServiceImp.class);

	@Autowired
	private RestTemplate restTemplate;

	@Value("${ur.api.google.youtube.videos}")
	private String address;

	@Value("${api.google.youtube.videos.param.key}")
	private String apiKeyParam;

	@Value("${api.google.youtube.videos.value.key}")
	private String apiKeyValue;
	
	@Value("${api.google.youtube.videos.param.part}")
	private String partParam = "part";

	@Value("${api.google.youtube.videos.param.player}")
	private String partValue;
	
	@Value("${ur.api.google.youtube.videos.param.id}")
	private String idParam;
	

	@Override
	public List<YoutubeVideo> getVideo(String id) {
		UriComponents uri = UriComponentsBuilder.fromUriString(address)
				.queryParam(apiKeyParam, apiKeyValue)
				.queryParam(partParam, partValue)
				.queryParam(idParam, id).build();
		LOGGER.info(MessageFormat.format("Calling web service Youtube: {0}", uri));
		return restTemplate.getForObject(uri.toUriString(), YoutubeVideoList.class).getItems();
	}
}
