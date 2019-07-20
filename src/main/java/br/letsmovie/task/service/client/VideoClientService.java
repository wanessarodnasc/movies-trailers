package br.letsmovie.task.service.client;

import java.util.List;

/**
* 
* This interface provide a contract to consult video service. Is possible implement to more than one video service provider
*
* @author Wanessa Nascimento
* @param <T>
*
*/

public interface VideoClientService<T> {
	
	List<T> getVideo(String codeVideo);

}
