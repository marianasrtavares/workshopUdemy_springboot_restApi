package com.marianatavares.workshopspring.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.marianatavares.workshopspring.config.dto.AuthorDTO;
import com.marianatavares.workshopspring.config.dto.CommentDTO;
import com.marianatavares.workshopspring.domain.Post;
import com.marianatavares.workshopspring.domain.User;
import com.marianatavares.workshopspring.repository.PostRepository;
import com.marianatavares.workshopspring.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
     
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PostRepository postRepo;
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		userRepo.deleteAll();
		postRepo.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");	
	  
	    userRepo.saveAll(Arrays.asList(maria,alex,bob));
	    
	    Post post1 = new Post (null, sdf.parse("2018-03-21"), "Partiu viagem","Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
	    Post post2 = new Post (null, sdf.parse("2018-03-23"), "Bom dia","Acordei feliz hoje!",new AuthorDTO(maria));

	    CommentDTO comment1 = new CommentDTO("Boa viagem mano!",sdf.parse("2018-03-21"), new AuthorDTO(alex));
	    CommentDTO comment2 = new CommentDTO("Aproveite!",sdf.parse("2018-03-22"), new AuthorDTO(bob));
	    CommentDTO comment3 = new CommentDTO("Boa viagem mano!",sdf.parse("2018-03-21"), new AuthorDTO(alex));

	    post1.setComments(Arrays.asList(comment1,comment3));
	    post2.setComments(Arrays.asList(comment2));
	    
	    postRepo.saveAll(Arrays.asList(post1,post2));
	    
	    maria.getPosts().addAll(Arrays.asList(post1,post2));  
	    
	    userRepo.save(maria);
	    
	    
	}

}
