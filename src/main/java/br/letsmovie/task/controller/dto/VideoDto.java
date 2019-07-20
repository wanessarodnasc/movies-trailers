package br.letsmovie.task.controller.dto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import br.letsmovie.task.model.YoutubeVideo;

/**
* This class is the object that need send such a response to a web service call.
*
* @author Wanessa Nascimento
*/
public class VideoDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String videoData;
		
	public VideoDto() {
	}

	public VideoDto(String videoData) {
		this.videoData = videoData;
	}
	
	public VideoDto(YoutubeVideo youtubeVideo) {
		this.videoData = youtubeVideo.getPlayerValue();
	}

	public String getVideoData() {
		return videoData;
	}

	public static List<VideoDto> convert(List<YoutubeVideo> videos) {
		return videos.stream().map(VideoDto::new).collect(Collectors.toList());
	}
}
