package com.jwinton.auth.infrastructure.repositories;

import com.jwinton.auth.infrastructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    Boolean existsByUsername(String username);
}
