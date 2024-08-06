package xyz.streetscout.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.streetscout.auth.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
}
