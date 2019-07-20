package br.letsmovie.task.client;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.letsmovie.task.model.YoutubeVideo;
import br.letsmovie.task.service.client.VideoClientService;

/**
* 
* @author Wanessa Nascimento
*
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class YoutubeClientServiceTest {
	
	@Autowired
	private VideoClientService<YoutubeVideo> service;

	private final String codeVideoByTMDB = "BdJKm16Co6M";

	@Test
	public void getVideo() {
		List<YoutubeVideo> detail = service.getVideo(codeVideoByTMDB);
		Assert.assertNotNull(detail);
	}
}
