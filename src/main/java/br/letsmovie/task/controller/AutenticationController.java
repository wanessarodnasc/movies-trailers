package br.letsmovie.task.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.letsmovie.task.config.security.TokenService;
import br.letsmovie.task.controller.dto.TokenDto;
import br.letsmovie.task.form.LoginForm;

/**
* 
* @author Wanessa Nascimento
*
*/
@RestController
public class AutenticationController {

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private TokenService tokenService;

	/**
	 * Generate Token by authentication user.
	 *
	 * @param LoginForm is a required parameter
	 * @return A TokenDto with a valid token
	 * @throws Exception
	 */
	@PostMapping("generate-token")
	public ResponseEntity<TokenDto> authenticate(@RequestBody @Valid LoginForm form) {
		UsernamePasswordAuthenticationToken loginData = form.converter();
		Authentication authentication = authManager.authenticate(loginData);
		return ResponseEntity.ok(new TokenDto(tokenService.gerarToken(authentication)));
	}
}
