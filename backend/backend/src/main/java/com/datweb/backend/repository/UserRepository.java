package com.datweb.backend.repository;

import com.datweb.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "select * from User u where u.username = :username",
            nativeQuery = true)
    User findUserByUsername(String username);

    @Query(
            value = "select * from User u where u.username like %:username%",
            nativeQuery = true
    )
    List<User> findUserByKeyUsername(String username);
}
