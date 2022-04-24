package com.marianatavares.workshopspring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marianatavares.workshopspring.domain.User;
import com.marianatavares.workshopspring.repository.UserRepository;
import com.marianatavares.workshopspring.service.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user= repo.findById(id);
		if(user.isEmpty()) {
			throw new ObjectNotFoundException("Object not found");
		}
		return user.get();
	}

}
