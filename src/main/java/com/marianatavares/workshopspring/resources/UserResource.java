package com.marianatavares.workshopspring.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.marianatavares.workshopspring.config.dto.UserDTO;
import com.marianatavares.workshopspring.domain.Post;
import com.marianatavares.workshopspring.domain.User;
import com.marianatavares.workshopspring.service.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User>list= service.findAll();
		List<UserDTO> listDto= list.stream().map(x-> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
		
	}
	
	@RequestMapping(value= "/{id}",method=RequestMethod.GET)
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		UserDTO user = new UserDTO(service.findById(id));
	 return ResponseEntity.ok().body(user);
	}
	
	@RequestMapping(method= RequestMethod.POST)
	public ResponseEntity<Void> insert (@RequestBody UserDTO obj) {
		User user= service.insert(service.fromDTO(obj));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).build();
				
		
	}
	
	@RequestMapping(value="/{id}" ,method= RequestMethod.DELETE)
	public ResponseEntity<Void>	deleteById (@PathVariable String id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}" ,method= RequestMethod.PUT)
	public ResponseEntity<Void>update(@RequestBody UserDTO obj, @PathVariable String id){
		User user= service.fromDTO(obj);
		user.setId(id);
		user= service.update(user);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value= "/{id}/posts",method=RequestMethod.GET)
	public ResponseEntity<List<Post>> findPost(@PathVariable String id){
		User user = service.findById(id);
		List<Post>posts= user.getPosts();
		return ResponseEntity.ok().body(posts);
		
	}
	
}
