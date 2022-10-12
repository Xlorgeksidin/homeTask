package ru.home_task.weather.models.weather_stack.current;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class CurrentWeatherResponse{

	@JsonProperty("request")
	private Request request;

	@JsonProperty("current")
	private Current current;

	@JsonProperty("location")
	private Location location;
}