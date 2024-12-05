package ru.ulstu.NikGapon.Environmental_monitoring.dto;

import java.util.List;

public class SummaryDto {
    private double avgTemperature;
    private List<String> highRiskAreas;

    public SummaryDto(double avgTemperature, List<String> highRiskAreas) {
        this.avgTemperature = avgTemperature;
        this.highRiskAreas = highRiskAreas;
    }

    public SummaryDto() {

    }

    public double getAvgTemperature() {
        return avgTemperature;
    }

    public void setAvgTemperature(double avgTemperature) {
        this.avgTemperature = avgTemperature;
    }

    public List<String> getHighRiskAreas() {
        return highRiskAreas;
    }

    public void setHighRiskAreas(List<String> highRiskAreas) {
        this.highRiskAreas = highRiskAreas;
    }
}