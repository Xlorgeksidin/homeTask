package ru.home_task.weather.services;

import ru.home_task.weather.services.weatherstack.WeatherStackPath;

public enum ServiceEnum {
    WEATHER_STACK;

    public IPathEnum[] getPathEnumList(){
        switch (this){
            case WEATHER_STACK: return WeatherStackPath.values();
            default: throw new IllegalArgumentException();
        }
    }
}
