package ru.ulstu.NikGapon.Environmental_monitoring.eventGenerators;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherDataSender {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String url = "http://localhost:8080/api/weather";

    @Scheduled(fixedRate = 60000)
    public void sendWeatherData() {
        try {
            String weatherReportJson = WeatherDataGenerator.generateWeatherReport();
            restTemplate.postForObject(url, weatherReportJson, String.class);
            System.out.println("Отправлен бюллетень: " + weatherReportJson);
        } catch (Exception e) {
            System.err.println("Ошибка при отправке данных: " + e.getMessage());
        }
    }
}