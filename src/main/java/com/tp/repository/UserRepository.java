package com.tp.repository;

import org.springframework.data.repository.CrudRepository;
import com.tp.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	 User findByLogin(String login);

}
