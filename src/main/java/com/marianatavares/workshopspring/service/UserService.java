package com.marianatavares.workshopspring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marianatavares.workshopspring.config.dto.UserDTO;
import com.marianatavares.workshopspring.domain.User;
import com.marianatavares.workshopspring.repository.UserRepository;
import com.marianatavares.workshopspring.service.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		Optional<User> user = repo.findById(id);
		if (user.isEmpty()) {
			throw new ObjectNotFoundException("Object not found");
		}
		return user.get();
	}

	public User insert(User obj) {
		return repo.save(obj);
	}

	public User fromDTO(UserDTO userDto) {
		User user = new User(userDto.getId(), userDto.getName(), userDto.getEmail());
		return user;
	}

	public void deleteById(String id) {
		findById(id);
		repo.deleteById(id);
	}

	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);

	}

	private void updateData(User newObj, User obj) {
		newObj.setId(obj.getId());
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());

	}

}
