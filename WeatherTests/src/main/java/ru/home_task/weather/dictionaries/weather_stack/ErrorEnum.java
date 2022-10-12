package ru.home_task.weather.dictionaries.weather_stack;

import lombok.Getter;

public enum ErrorEnum {
  BULK_QUERIES_NOT_SUPPORTED_ON_PLAN(604),
  REQUEST_FAILED(615),
  MISSING_ACCESS_KEY(101),
  INVALID_API_FUNCTION(103),
  MISSING_QUERY(601);

  @Getter
  private final int errorCode;  
  
  ErrorEnum(int errorCode) {
    this.errorCode = errorCode;
  }
}
