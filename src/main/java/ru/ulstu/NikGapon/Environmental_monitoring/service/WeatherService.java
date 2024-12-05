package ru.ulstu.NikGapon.Environmental_monitoring.service;


import org.springframework.stereotype.Service;
import ru.ulstu.NikGapon.Environmental_monitoring.dto.WeatherReportDto;
import ru.ulstu.NikGapon.Environmental_monitoring.model.WeatherReportEntity;
import ru.ulstu.NikGapon.Environmental_monitoring.repository.WeatherReportRepository;

@Service
public class WeatherService {

    private final WeatherReportRepository weatherReportRepository;

    public WeatherService(WeatherReportRepository weatherReportRepository) {
        this.weatherReportRepository = weatherReportRepository;
    }

    public void saveReport(WeatherReportDto report) {
        System.out.println(1);
        weatherReportRepository.save(new WeatherReportEntity(report));
    }
}
