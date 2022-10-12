package ru.home_task.weather.steps;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.home_task.weather.ConfigQA;
import ru.home_task.weather.helpers.ApiHelper;
import ru.home_task.weather.models.weather_stack.current.CurrentWeatherResponse;
import ru.home_task.weather.models.weather_stack.errors.ErrorResponse;
import ru.home_task.weather.services.IPathEnum;
import ru.home_task.weather.services.ServiceData;
import ru.home_task.weather.services.ServiceEnum;
import ru.home_task.weather.services.weatherstack.WeatherStackPath;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class WeatherSteps {
  private static final Map<IPathEnum, String> servicePath = ConfigQA.getInstance().getServiceMethodPath();
  private static final Map<ServiceEnum, ServiceData> serviceData = ConfigQA.getInstance().getServiceData();

  public static CurrentWeatherResponse getCurrentWeather(String city) {
    String path = String.format("%s?access_key=%s&query=%s",
      servicePath.get(WeatherStackPath.CURRENT), 
      serviceData.get(ServiceEnum.WEATHER_STACK).getAccessKey(),
      city);
    return ApiHelper.get(path).as(CurrentWeatherResponse.class);
  }
  
  public static List<CurrentWeatherResponse> getCurrentWeather(List<String> cities) {
    List<CurrentWeatherResponse> list = new ArrayList<>(cities.size());
    for (String s : cities) {
      list.add(getCurrentWeather(s));
    }
    return list;
  }
  
  public static List<CurrentWeatherResponse> getExpectedCurrentWeatherResponse() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(new File("src/test/resources/CorrectCurrentWeatherJson.json"),
      new TypeReference<List<CurrentWeatherResponse>>(){});
  }
  
  public static void checkErrorResponse(ErrorResponse errorResponse, String expectedErrorType, int expectedErrorCode) {
    assertThat(errorResponse.getSuccess()).isFalse();
    assertThat(errorResponse.getError().getCode()).isEqualTo(expectedErrorCode);
    assertThat(errorResponse.getError().getType()).isEqualTo(expectedErrorType);
  }
}
