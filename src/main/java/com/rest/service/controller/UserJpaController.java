package com.rest.service.controller;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rest.service.model.Post;
import com.rest.service.model.User;
import com.rest.service.repository.UserDaoService;
import com.rest.service.repository.UserRepository;
import com.rest.service.utils.UserNotFoundException;

@RestController
public class UserJpaController {

	// Los componentes pueden ser llamados con autowired
	@Autowired
	private UserRepository repository;


	@GetMapping("/jpa/users")
	public List<User> get_all_users() {
		return repository.findAll();
	}

	//hateoas example 
	@GetMapping("/jpa/users/{id}")
	public EntityModel<User>get_all_users_id(@PathVariable int id) {
		Optional<User> user = repository.findById(id);
		if(user.isEmpty())
			throw new UserNotFoundException("Id: " + id);
		//Allow add links
		EntityModel<User> entity_model = EntityModel.of(user.get());
		
		//Get actual class and link the get all method
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).get_all_users());
		entity_model.add(link.withRel("all-users"));
		return entity_model;
	}

	@PostMapping("/jpa/users")
	public ResponseEntity<User> create_user( @Valid @RequestBody User user) {
		User saved_user = repository.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saved_user.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/jpa/users/{id}")
	public void delete_user(@PathVariable int id) {
		repository.deleteById(id);
	}
	
	@GetMapping("/jpa/users/{id}/post")
	public List<Post> retrieve_post_for_user(@PathVariable int id) {
		Optional<User> user = repository.findById(id);
		if(user.isEmpty())
			throw new UserNotFoundException("Id: " + id);
		return user.get().getPosts();
	}

}
