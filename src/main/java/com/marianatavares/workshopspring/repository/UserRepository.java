package com.marianatavares.workshopspring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.marianatavares.workshopspring.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	

}
