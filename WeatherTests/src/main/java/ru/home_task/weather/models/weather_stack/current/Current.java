package ru.home_task.weather.models.weather_stack.current;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import ru.home_task.weather.dictionaries.weather_stack.deserializers.LocalTimeDeserializer;
import ru.home_task.weather.dictionaries.weather_stack.serializers.LocalTimeSerializer;

import java.time.LocalTime;
import java.util.List;

@ToString
@EqualsAndHashCode
public class Current{

	@JsonProperty("weather_descriptions")
	private List<String> weatherDescriptions;

	@JsonSerialize(using = LocalTimeSerializer.class)
	@JsonDeserialize(using = LocalTimeDeserializer.class)
	@JsonProperty("observation_time")
	private LocalTime observationTime;

	@JsonProperty("wind_degree")
	private Integer windDegree;

	@JsonProperty("visibility")
	private Integer visibility;

	@JsonProperty("weather_icons")
	private List<String> weatherIcons;

	@JsonProperty("feelslike")
	private Integer feelslike;

	@JsonProperty("is_day")
	private String isDay;

	@JsonProperty("wind_dir")
	private String windDir;

	@JsonProperty("pressure")
	private Integer pressure;

	@JsonProperty("cloudcover")
	private Integer cloudcover;

	@JsonProperty("precip")
	private Integer precip;

	@JsonProperty("uv_index")
	private Integer uvIndex;

	@JsonProperty("temperature")
	private Integer temperature;

	@JsonProperty("humidity")
	private Integer humidity;

	@JsonProperty("wind_speed")
	private Integer windSpeed;

	@JsonProperty("weather_code")
	private Integer weatherCode;
}