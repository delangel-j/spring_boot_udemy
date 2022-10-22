package com.rest.service.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.rest.service.model.User;
import com.rest.service.repository.UserDaoService;
import com.rest.service.utils.UserNotFoundException;

@RestController
public class UserController {

	// Los componentes pueden ser llamados con autowired
	private UserDaoService service;

	public UserController(UserDaoService service) {
		this.service = service;
	}

	@GetMapping("/users")
	public List<User> get_all_users() {
		return service.find_all();
	}

	@GetMapping("/users/{id}")
	public User get_all_users_id(@PathVariable int id) {
		User user = service.findOne(id);
		if(user==null)
			throw new UserNotFoundException("Id: " + id);
		return user;
	}

	@PostMapping("/users")
	public ResponseEntity<User> create_user( @Valid @RequestBody User user) {
		User saved_user = service.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saved_user.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void delete_user(@PathVariable int id) {
		service.detele_by_id(id);
	}

}
