package ru.ulstu.NikGapon.Environmental_monitoring.dto;

import ru.ulstu.NikGapon.Environmental_monitoring.model.WeatherDataEntity;

public class WeatherDataDto {
    private String location;
    private double temperature;
    private int humidity;
    private double precipitation;
    private double windSpeed;
    private String windDirection;

    public WeatherDataDto(String location, double temperature, int humidity, double precipitation, double windSpeed, String windDirection) {
        this.location = location;
        this.temperature = temperature;
        this.humidity = humidity;
        this.precipitation = precipitation;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
    }

    public WeatherDataDto(WeatherDataEntity entity) {
        this(entity.getLocation(), entity.getTemperature(), entity.getHumidity(),
                entity.getPrecipitation(), entity.getWindSpeed(), entity.getWindDirection());
    }

    public WeatherDataDto() {
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(double precipitation) {
        this.precipitation = precipitation;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }
}
