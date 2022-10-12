package ru.home_task.weather.services;

import lombok.Data;

@Data
public class ServiceData {
  private String host;
  private String port;
  private String accessKey;
}
