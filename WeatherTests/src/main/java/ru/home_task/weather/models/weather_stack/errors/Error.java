package ru.home_task.weather.models.weather_stack.errors;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Error {

	@JsonProperty("code")
	private Integer code;

	@JsonProperty("type")
	private String type;

	@JsonProperty("info")
	private String info;
}