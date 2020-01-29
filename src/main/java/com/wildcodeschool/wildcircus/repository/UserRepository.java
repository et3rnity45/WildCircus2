package com.wildcodeschool.wildcircus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wildcodeschool.wildcircus.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
