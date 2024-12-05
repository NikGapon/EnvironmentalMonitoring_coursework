package ru.ulstu.NikGapon.Environmental_monitoring.model;

import jakarta.persistence.*;
import ru.ulstu.NikGapon.Environmental_monitoring.dto.WeatherReportDto;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class WeatherReportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String reportId;

    @Column(nullable = false)
    private Timestamp timestamp;

    @Column(nullable = false)
    private String region;

    private Double avgTemperature;

    @ElementCollection
    @CollectionTable(name = "high_risk_areas", joinColumns = @JoinColumn(name = "report_id"))
    @Column(name = "area")
    private List<String> highRiskAreas;

    @OneToMany(mappedBy = "weatherReport", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WeatherDataEntity> weatherData;


    public WeatherReportEntity() {
    }

    public WeatherReportEntity(Long id, String reportId, Timestamp timestamp, String region, Double avgTemperature, List<String> highRiskAreas, List<WeatherDataEntity> weatherData) {
        this(reportId, timestamp, region, avgTemperature, highRiskAreas, weatherData);
        this.id = id;
    }

    public WeatherReportEntity(String reportId, Timestamp timestamp, String region, Double avgTemperature, List<String> highRiskAreas, List<WeatherDataEntity> weatherData) {
        this.reportId = reportId;
        this.timestamp = timestamp;
        this.region = region;
        this.avgTemperature = avgTemperature;
        this.highRiskAreas = highRiskAreas;
        this.weatherData = weatherData;
    }

    public WeatherReportEntity(WeatherReportDto weatherReportDto) {
        this(weatherReportDto.getReportId(), weatherReportDto.getTimestampTimestamp(), weatherReportDto.getRegion(),
                weatherReportDto.getSummary().getAvgTemperature(), weatherReportDto.getSummary().getHighRiskAreas(),
                weatherReportDto.getWeatherData());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Double getAvgTemperature() {
        return avgTemperature;
    }

    public void setAvgTemperature(Double avgTemperature) {
        this.avgTemperature = avgTemperature;
    }

    public List<String> getHighRiskAreas() {
        return highRiskAreas;
    }

    public void setHighRiskAreas(List<String> highRiskAreas) {
        this.highRiskAreas = highRiskAreas;
    }

    public List<WeatherDataEntity> getWeatherData() {
        return weatherData;
    }

    public void setWeatherData(List<WeatherDataEntity> weatherData) {
        this.weatherData = weatherData;
    }
}
