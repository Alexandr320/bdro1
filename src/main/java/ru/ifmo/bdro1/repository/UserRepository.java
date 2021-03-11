package ru.ifmo.bdro1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ifmo.bdro1.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);


}
