package br.letsmovie.task.service.imp;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.letsmovie.task.exception.BusinessException;
import br.letsmovie.task.form.UserForm;
import br.letsmovie.task.model.Email;
import br.letsmovie.task.model.Profile;
import br.letsmovie.task.model.User;
import br.letsmovie.task.repository.ProfileRepository;
import br.letsmovie.task.repository.UserRepository;
import br.letsmovie.task.util.EmailUtil;

/**
* 
* @author Wanessa Nascimento
*
*/
@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private ProfileRepository profileRepository;
	
	@Autowired
	private EmailUtil emailUtil;
	
	@Value("${service.user.invalid.email}")
	private String invalidEmail;
	
	@Value("${service.user.email.exist}")
	private String emailExist;
	
	private String subject = "Access Token Lets Movie API";

	public User registerNewUser(UserForm loginForm) throws BusinessException {
		Optional<User> userExistent = repository.findByEmail(loginForm.getEmail());
		if(!userExistent.isPresent()) {
			return validateNewUser(loginForm);
		}
		throw new BusinessException(emailExist);
	}

	private User validateNewUser(UserForm loginForm) throws BusinessException {
		String passwordGenerated = generateRadomicPassword();
		User user = new User(loginForm, new BCryptPasswordEncoder().encode(passwordGenerated));
		String msg = gerEmailMsg(passwordGenerated, user);
		if(emailUtil.sendMail(new Email(user.getEmail(), subject, msg))) {
			saveProfile(user.getProfile());
			return repository.save(user);
		}
		throw new BusinessException(invalidEmail);
	}

	private void saveProfile(List<Profile> profiles) {
		for(Profile profile : profiles) {
			profileRepository.save(profile);
		}
	}

	private String gerEmailMsg(String passwordGenerated, User user) {
		return "Congratilations, " + user.getName() + " now do you have access to our amazing API. "
						+ " Find your creditials : "
						+ " Username :" + user.getEmail() + " Password :" + passwordGenerated;
	}
	
	private String generateRadomicPassword() {
		return UUID.randomUUID().toString().split("-")[0];
	}
}
