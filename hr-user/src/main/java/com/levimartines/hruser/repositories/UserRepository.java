package com.levimartines.hruser.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.levimartines.hruser.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);
}
