package ru.home_task.weather.models.weather_stack.current;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class Request{

	@JsonProperty("unit")
	private String unit;

	@JsonProperty("query")
	private String query;

	@JsonProperty("language")
	private String language;

	@JsonProperty("type")
	private String type;
}