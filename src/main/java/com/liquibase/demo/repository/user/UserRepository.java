package com.liquibase.demo.repository.user;

import com.liquibase.demo.model.user.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("SELECT name FROM User u WHERE u.name LIKE %:name")
    String findByName(String name);
}
