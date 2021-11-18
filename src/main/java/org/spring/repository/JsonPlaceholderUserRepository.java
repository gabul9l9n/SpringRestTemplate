package org.spring.repository;

import org.spring.model.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JsonPlaceholderUserRepository extends JpaRepository<User, Integer> {
}