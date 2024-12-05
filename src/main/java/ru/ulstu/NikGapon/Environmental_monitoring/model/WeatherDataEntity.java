package ru.ulstu.NikGapon.Environmental_monitoring.model;

import jakarta.persistence.*;
import ru.ulstu.NikGapon.Environmental_monitoring.dto.WeatherDataDto;

@Entity
public class WeatherDataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "report_id", nullable = false)
    private WeatherReportEntity weatherReport;

    private String location;
    private Double temperature;
    private Integer humidity;
    private Double precipitation;
    private Double windSpeed;
    private String windDirection;

    public WeatherDataEntity() {
    }

    public WeatherDataEntity(String location, Double temperature, Integer humidity, Double precipitation, Double windSpeed, String windDirection) {
        this.location = location;
        this.temperature = temperature;
        this.humidity = humidity;
        this.precipitation = precipitation;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
    }

    public WeatherDataEntity(WeatherReportEntity weatherReport, String location, Double temperature, Integer humidity, Double precipitation, Double windSpeed, String windDirection) {
        this(location, temperature, humidity, precipitation, windSpeed, windDirection);
        this.weatherReport = weatherReport;
    }

    public WeatherDataEntity(Long id, WeatherReportEntity weatherReport, String location, Double temperature, Integer humidity, Double precipitation, Double windSpeed, String windDirection) {
        this(weatherReport, location, temperature, humidity, precipitation, windSpeed, windDirection);
        this.id = id;
    }

    public WeatherDataEntity(WeatherDataDto weatherDataDto) {
        this(weatherDataDto.getLocation(), weatherDataDto.getTemperature(), weatherDataDto.getHumidity(), weatherDataDto.getPrecipitation(), weatherDataDto.getWindSpeed(), weatherDataDto.getWindDirection());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public WeatherReportEntity getWeatherReport() {
        return weatherReport;
    }

    public void setWeatherReport(WeatherReportEntity weatherReport) {
        this.weatherReport = weatherReport;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Double getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(Double precipitation) {
        this.precipitation = precipitation;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }
}
