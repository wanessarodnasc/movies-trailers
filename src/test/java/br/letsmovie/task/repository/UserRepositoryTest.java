package br.letsmovie.task.repository;

import static org.junit.Assert.assertNotNull;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.letsmovie.task.model.Profile;
import br.letsmovie.task.model.User;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository repository;

	@Test
	public void saveUser() throws Exception {
		repository.save(new User());
	}
	
	@Test
    public void findAll() {
		User user = new User("name", "name@gmail.com", "password", Arrays.asList(new Profile("USER")));
        repository.save(user);
        assertNotNull(repository.findAll());
    }
}
