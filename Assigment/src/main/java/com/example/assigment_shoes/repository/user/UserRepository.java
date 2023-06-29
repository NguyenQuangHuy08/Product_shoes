package com.example.assigment_shoes.repository.user;

import com.example.assigment_shoes.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Integer> {

    Users findByUsernameAndPassword(String username, String password);

}
