package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import ru.home_task.weather.models.weather_stack.current.CurrentWeatherResponse;
import ru.home_task.weather.steps.WeatherSteps;

import java.io.IOException;
import java.util.List;

import static ru.home_task.weather.context.RunContext.RUN_CONTEXT;

public class PositiveCurrentWeatherSteps {
  
  @When("^Выполняем запрос погоды и выполняем парсинг результатов для городов:$")
  public void weatherRequest(List<String> cities) {
    List<CurrentWeatherResponse> responsesList = WeatherSteps.getCurrentWeather(cities);
    RUN_CONTEXT.put("responsesList", responsesList);
  }
  
  @Then("^Сравниваем полученные результаты с ожидаемыми значениями из тестового набора$")
  public void compareResponseAndExpectedResult() throws IOException {
    List<CurrentWeatherResponse> expectedResultsList = WeatherSteps.getExpectedCurrentWeatherResponse();
    List<CurrentWeatherResponse> responsesList = (List<CurrentWeatherResponse>) RUN_CONTEXT.get("responsesList");
      Assertions.assertThat(responsesList)
      .usingRecursiveComparison()
      .isEqualTo(expectedResultsList);
  }
}
