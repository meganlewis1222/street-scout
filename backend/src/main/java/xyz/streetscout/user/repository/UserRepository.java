package xyz.streetscout.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.streetscout.user.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
}
