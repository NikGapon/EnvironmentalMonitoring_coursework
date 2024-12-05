package ru.ulstu.NikGapon.Environmental_monitoring.eventGenerators;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import ru.ulstu.NikGapon.Environmental_monitoring.dto.SummaryDto;
import ru.ulstu.NikGapon.Environmental_monitoring.dto.WeatherDataDto;
import ru.ulstu.NikGapon.Environmental_monitoring.dto.WeatherReportDto;
import ru.ulstu.NikGapon.Environmental_monitoring.model.WeatherDataEntity;
import ru.ulstu.NikGapon.Environmental_monitoring.model.WeatherReportEntity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherDataGenerator {

    private static final Random RANDOM = new Random();

    public static String generateWeatherReport() throws Exception {
        WeatherReportDto report = new WeatherReportDto();
        report.setReportId("REPORT-" + System.currentTimeMillis());
        report.setTimestamp(LocalDateTime.now());
        report.setRegion("Ulyanovsk Region");

        List<WeatherDataDto> weatherDataList = new ArrayList<>();
        weatherDataList.add(generateWeatherData("Ulyanovsk"));
        weatherDataList.add(generateWeatherData("Dimitrovgrad"));

        report.setWeatherData(weatherDataList);
        report.setSummary(generateSummary(weatherDataList));
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper.writeValueAsString(report);
    }

    private static WeatherDataDto generateWeatherData(String location) {
        WeatherDataDto data = new WeatherDataDto();
        data.setLocation(location);
        data.setTemperature(RANDOM.nextDouble() * 30 - 10);
        data.setHumidity(RANDOM.nextInt(100));
        data.setPrecipitation(RANDOM.nextDouble() * 10);
        data.setWindSpeed(RANDOM.nextDouble() * 15);
        data.setWindDirection(generateWindDirection());
        return data;
    }

    private static String generateWindDirection() {
        String[] directions = {"N", "NE", "E", "SE", "S", "SW", "W", "NW"};
        return directions[RANDOM.nextInt(directions.length)];
    }

    private static SummaryDto generateSummary(List<WeatherDataDto> weatherDataList) {
        SummaryDto summary = new SummaryDto();
        summary.setAvgTemperature(weatherDataList.stream()
                .mapToDouble(WeatherDataDto::getTemperature)
                .average()
                .orElse(0.0));
        summary.setHighRiskAreas(List.of("Dimitrovgrad"));
        return summary;
    }
}