package ru.ulstu.NikGapon.Environmental_monitoring.dto;

import ru.ulstu.NikGapon.Environmental_monitoring.model.WeatherDataEntity;
import ru.ulstu.NikGapon.Environmental_monitoring.model.WeatherReportEntity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class WeatherReportDto {
    private String reportId;
    private LocalDateTime timestamp;
    private String region;
    private List<WeatherDataDto> weatherDatumDtos;
    private SummaryDto summaryDto;

    public WeatherReportDto() {
    }

    public WeatherReportDto(String reportId, LocalDateTime timestamp, String region,
                            List<WeatherDataDto> weatherDatumDtos, SummaryDto summaryDto) {
        this(reportId, timestamp, region );
        this.weatherDatumDtos = weatherDatumDtos;
        this.summaryDto = summaryDto;
    }

    public WeatherReportDto(WeatherReportEntity entity) {
        this(entity.getReportId(), entity.getTimestamp(), entity.getRegion());
    }

    public WeatherReportDto(String reportId, String region) {
        this.reportId = reportId;
        this.region = region;
    }

    public WeatherReportDto(String reportId, Timestamp timestamp, String region) {
        this(reportId, region);
        this.timestamp = timestamp.toLocalDateTime();

    }
    public WeatherReportDto(String reportId, LocalDateTime timestamp, String region) {
        this(reportId, region);
        this.timestamp = timestamp;
    }


    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Timestamp getTimestampTimestamp() {
        return Timestamp.valueOf(timestamp);
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp.toLocalDateTime();
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public List<WeatherDataDto> getWeatherDataDto() {
        return weatherDatumDtos;
    }

    public List<WeatherDataEntity> getWeatherData() {
        return weatherDatumDtos.stream().map(WeatherDataEntity::new).collect(Collectors.toList());
    }

    public void setWeatherData(List<WeatherDataDto> weatherDatumDtos) {
        this.weatherDatumDtos = weatherDatumDtos;
    }


    public SummaryDto getSummary() {
        return summaryDto;
    }

    public void setSummary(SummaryDto summaryDto) {
        this.summaryDto = summaryDto;
    }
}
