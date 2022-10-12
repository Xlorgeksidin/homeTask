package ru.home_task.weather.dictionaries.weather_stack.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.TimeZone;

public class ZonedDateTimeEpochDeserializer extends StdDeserializer<ZonedDateTime> {
  protected ZonedDateTimeEpochDeserializer() {
    this(null);
  }
  
  protected ZonedDateTimeEpochDeserializer(Class<ZonedDateTime> t) {
    super(t);
  }

  @Override
  public ZonedDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
    String value = jsonParser.getText();
    long milli = Long.parseLong(value);
    return ZonedDateTime.ofInstant(Instant.ofEpochMilli(milli), TimeZone.getDefault().toZoneId());
  }
}
