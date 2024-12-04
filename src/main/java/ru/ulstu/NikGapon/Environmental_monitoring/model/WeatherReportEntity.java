package ru.ulstu.NikGapon.Environmental_monitoring.model;

import jakarta.persistence.*;

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
    private LocalDateTime timestamp;

    @Column(nullable = false)
    private String region;

    private Double avgTemperature;

    @ElementCollection
    @CollectionTable(name = "high_risk_areas", joinColumns = @JoinColumn(name = "report_id"))
    @Column(name = "area")
    private List<String> highRiskAreas;

    @OneToMany(mappedBy = "weatherReport", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WeatherDataEntity> weatherData;

    // Getters and setters
}
