package ru.ulstu.NikGapon.Environmental_monitoring.model;

import jakarta.persistence.*;

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
}
