package ru.home_task.weather.models.weather_stack.current;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import ru.home_task.weather.dictionaries.weather_stack.deserializers.LocalDateTimeDeserializer;
import ru.home_task.weather.dictionaries.weather_stack.deserializers.ZonedDateTimeEpochDeserializer;
import ru.home_task.weather.dictionaries.weather_stack.serializers.LocalDateTimeSerializer;
import ru.home_task.weather.dictionaries.weather_stack.serializers.ZonedDateTimeEpochSerializer;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@ToString
@EqualsAndHashCode
public class Location{

	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonProperty("localtime")
	private LocalDateTime localtime;

	@JsonProperty("utc_offset")
	private String utcOffset;

	@JsonProperty("country")
	private String country;

	@JsonSerialize(using = ZonedDateTimeEpochSerializer.class)
	@JsonDeserialize(using = ZonedDateTimeEpochDeserializer.class)
	@JsonProperty("localtime_epoch")
	private ZonedDateTime localtimeEpoch;

	@JsonProperty("name")
	private String name;

	@JsonProperty("timezone_id")
	private String timezoneId;

	@JsonProperty("lon")
	private String lon;

	@JsonProperty("region")
	private String region;

	@JsonProperty("lat")
	private String lat;
}