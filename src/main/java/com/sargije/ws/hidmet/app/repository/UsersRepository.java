package com.sargije.ws.hidmet.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sargije.ws.hidmet.app.model.Users;

@Repository
public interface UsersRepository extends CrudRepository<Users, String>{
//	Users findByUsername(String username);
}
