package com.marianatavares.workshopspring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marianatavares.workshopspring.domain.Post;
import com.marianatavares.workshopspring.repository.PostRepository;
import com.marianatavares.workshopspring.service.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepo;
	
	public Post findById(String id) {
		Optional<Post> post= postRepo.findById(id);
		 
		if(post.isEmpty()) {
			throw new ObjectNotFoundException("Post not found");
		}else {
			return post.get();
		}
	}

}
