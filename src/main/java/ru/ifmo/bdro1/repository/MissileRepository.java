package ru.ifmo.bdro1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ifmo.bdro1.entity.Missile;

import java.util.Optional;

public interface MissileRepository extends JpaRepository<Missile, Long> {

    Optional<Missile> findByMissileName(String missileName);
    Optional<Missile> findByMissileCode(String missileCode);

}
