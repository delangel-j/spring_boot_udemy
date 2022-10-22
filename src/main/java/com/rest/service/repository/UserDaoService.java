package com.rest.service.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.rest.service.model.User;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();
	
	private static int user_count = 0;
	
	static {
		users.add(new User(++user_count, "Jesus", LocalDate.now().minusYears(29)));
		users.add(new User(++user_count, "Eve", LocalDate.now().minusYears(25)));
		users.add(new User(++user_count, "Jim", LocalDate.now().minusYears(20)));
	}
	
	public List<User> find_all(){
		return users;
	}

	public User findOne(int id) {
		Predicate<? super User> predicate = user -> user.getId() == id; 
		return users.stream().filter(predicate).findFirst().orElse(null);
	}
	
	public User save(User user) {
		user.setId(++user_count);
		users.add(user);
		return user;
	}
	
	public void detele_by_id(int id) {
		Predicate<? super User> predicate = user -> user.getId() == id; 
		users.removeIf(predicate);
	}
	
	
	
}
