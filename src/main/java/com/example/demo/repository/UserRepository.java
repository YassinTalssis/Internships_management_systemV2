package com.example.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.User;
 //yassinTalssis
public interface UserRepository extends CrudRepository<User, Long> {
 
    @Query("SELECT u FROM User u WHERE u.email = :email")
    //public User getUserByUsername(@Param("username") String username);
	public User getUserByEmail(@Param("email")String username);
}
//yassinTalssis