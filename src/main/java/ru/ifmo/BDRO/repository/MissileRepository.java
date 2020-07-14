package ru.ifmo.BDRO.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ifmo.BDRO.entity.Missile;

import java.util.Optional;

public interface MissileRepository extends JpaRepository<Missile, Long> {

    Optional<Missile> findByMissileName(String missileName);
    Optional<Missile> findByMissileCode(String missileCode);

}
