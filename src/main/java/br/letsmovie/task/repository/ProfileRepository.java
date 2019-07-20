package br.letsmovie.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.letsmovie.task.model.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
