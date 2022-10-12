package ru.home_task.weather.dictionaries.weather_stack.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalTimeDeserializer extends StdDeserializer<LocalTime> {

  protected LocalTimeDeserializer() {
    this(null);
  }

  protected LocalTimeDeserializer(Class<LocalTime> t) {
    super(t);
  }

  @Override
  public LocalTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
    return LocalTime.parse(jsonParser.getText(), DateTimeFormatter.ofPattern("hh:mm a"));
  }
}
