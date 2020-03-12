package ca.sheridancollege.repositories;

import org.springframework.data.repository.CrudRepository;

import ca.sheridancollege.beans.User;

public interface UserRepository extends CrudRepository<User, Long>{
	
	public User findByUsername(String userName);

}
