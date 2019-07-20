package br.letsmovie.task.controller;

import java.net.URI;
import java.text.MessageFormat;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.letsmovie.task.exception.BusinessException;
import br.letsmovie.task.form.UserForm;
import br.letsmovie.task.model.User;
import br.letsmovie.task.service.imp.UserService;

/**
* This class is a controller to create a access password. 
*
* @author Wanessa Nascimento
*/

@RestController
public class UserController {
	
private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);
	
	@Autowired
	private UserService service;
	
    /**
     * Adding a new user to receive a password.
     *
     * @param UserForma name, email is a required parameter can be a movie name, actor name or any parameter related with the a movie
     * @return A MovieDto with the video information
     * @throws BusinessException 
     */
    @PostMapping("users")
    @Transactional
    public ResponseEntity<Long> registerUser(@RequestBody @Valid UserForm form, 
    		UriComponentsBuilder uriBuilder) throws BusinessException {
    	User user = service.registerNewUser(form);
    	URI uri = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
    	LOGGER.info(MessageFormat.format("New user created : ",form.getEmail()));
    	return ResponseEntity.created(uri).body(user.getId());
    }
}
