package steps;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import ru.home_task.weather.ConfigQA;
import ru.home_task.weather.helpers.ApiHelper;
import ru.home_task.weather.models.weather_stack.errors.ErrorResponse;
import ru.home_task.weather.services.ServiceData;
import ru.home_task.weather.services.ServiceEnum;
import ru.home_task.weather.steps.WeatherSteps;

import static ru.home_task.weather.context.RunContext.RUN_CONTEXT;

public class ErrorSteps {
  private static final ServiceData serviceData = ConfigQA.getInstance().getServiceData().get(ServiceEnum.WEATHER_STACK);
  
  @Когда("выполняем запрос к сервису weatherstack, методу {string} с параметрами {string} c валидным access_key")
  public void getCurrentWeather(String methodName, String params) {
    String path = String.format("%s/%s?access_key=%s%s",
      serviceData.getHost(), methodName, serviceData.getAccessKey(), params);
    RUN_CONTEXT.put("errorResponse", ApiHelper.get(path).as(ErrorResponse.class)); 
  }

  @Когда("выполняем запрос к сервису weatherstack, методу {string} без access_key")
  public void getCurrentWeatherWithoutKey(String methodName) {
    String path = String.format("%s/%s",
      serviceData.getHost(), methodName);
    RUN_CONTEXT.put("errorResponse", ApiHelper.get(path).as(ErrorResponse.class));
  }

  @Тогда("получаем ошибку c типом {string} и кодом {int}")
  public void checkError(String arg0, int arg1) {
    WeatherSteps.checkErrorResponse(RUN_CONTEXT.get("errorResponse", ErrorResponse.class), arg0, arg1);
  }
}
