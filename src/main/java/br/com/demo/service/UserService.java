package br.com.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.demo.model.User;

@Service
public interface UserService {

	User getUserFindOne(Long id);
	
	List<User> listAll();
	
	User save(User usuario);
	
	User update(User usuario);
	
	void delete(Long id);
	
}
