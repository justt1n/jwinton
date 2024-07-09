package com.jwinton.auth.infrastructure.repositories;

import com.jwinton.auth.infrastructure.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
