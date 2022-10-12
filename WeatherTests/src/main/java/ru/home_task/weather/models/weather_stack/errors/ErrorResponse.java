package ru.home_task.weather.models.weather_stack.errors;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {

	@JsonProperty("success")
	private Boolean success;

	@JsonProperty("error")
	private Error error;
}