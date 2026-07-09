
package com.developer.platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.developer.platform.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);
}