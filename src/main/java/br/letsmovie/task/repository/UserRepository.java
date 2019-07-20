package br.letsmovie.task.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.letsmovie.task.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByEmail(String email);

}
