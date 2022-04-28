package com.marianatavares.workshopspring.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marianatavares.workshopspring.domain.Post;
import com.marianatavares.workshopspring.resource.util.URL;
import com.marianatavares.workshopspring.service.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResource {

	@Autowired
	private PostService postService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post post= postService.findById(id);
		return ResponseEntity.ok().body(post);
	}
	
	@RequestMapping(value="/titlesearch", method= RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTilte(@RequestParam(value="text",defaultValue="") String text){
		List <Post> list=postService.findByTitle(URL.decodeParam(text));
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="fullsearch", method= RequestMethod.GET)
	public ResponseEntity<List<Post>> fullSearch(
			@RequestParam(value="text", defaultValue="") String text, 
			@RequestParam(value="inicialDate", defaultValue="")String inicialDate, 
			@RequestParam(value="finalDate", defaultValue="")String finalDate){
		List<Post> list= postService.fullSearch(URL.decodeParam(text), URL.decodeDateParam(inicialDate, new Date(0L)), URL.decodeDateParam(finalDate, new Date()));
		return ResponseEntity.ok().body(list);
	}
}
