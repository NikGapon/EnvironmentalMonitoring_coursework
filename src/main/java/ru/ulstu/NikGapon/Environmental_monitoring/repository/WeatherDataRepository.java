package ru.ulstu.NikGapon.Environmental_monitoring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ulstu.NikGapon.Environmental_monitoring.model.WeatherDataEntity;

public interface WeatherDataRepository extends JpaRepository<WeatherDataEntity, Long> {
}