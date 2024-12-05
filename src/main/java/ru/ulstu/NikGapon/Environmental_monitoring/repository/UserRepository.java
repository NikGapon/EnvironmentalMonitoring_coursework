package ru.ulstu.NikGapon.Environmental_monitoring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ulstu.NikGapon.Environmental_monitoring.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}