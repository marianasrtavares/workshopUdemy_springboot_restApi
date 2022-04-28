package com.marianatavares.workshopspring.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marianatavares.workshopspring.domain.Post;
import com.marianatavares.workshopspring.repository.PostRepository;
import com.marianatavares.workshopspring.resources.exceptions.ObjectNotFoundException;

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
	
	public List<Post> findByTitle (String text){
		return postRepo.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date startDate, Date finalDate){
		finalDate= new Date(finalDate.getTime()+24*60*60*1000);
		return postRepo.fullSearch(text, startDate, finalDate);
	}

}
