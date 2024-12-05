package ru.ulstu.NikGapon.Environmental_monitoring.controler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ulstu.NikGapon.Environmental_monitoring.dto.WeatherReportDto;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    private final ObjectMapper objectMapper;

    public WeatherController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        System.out.println("ObjectMapper: " + objectMapper);
    }

    @PostMapping
    public ResponseEntity<String> receiveWeatherData(@RequestBody WeatherReportDto report) {
        System.out.println("Получен бюллетень: " + report);
        return ResponseEntity.ok("Данные успешно получены");
    }
}