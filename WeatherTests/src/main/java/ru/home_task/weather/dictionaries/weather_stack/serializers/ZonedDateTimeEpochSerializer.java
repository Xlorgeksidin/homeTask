package ru.home_task.weather.dictionaries.weather_stack.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.ZonedDateTime;

public class ZonedDateTimeEpochSerializer extends StdSerializer<ZonedDateTime> {
  protected ZonedDateTimeEpochSerializer() {
    this(null);
  }

  protected ZonedDateTimeEpochSerializer(Class<ZonedDateTime> t) {
    super(t);
  }

  @Override
  public void serialize(ZonedDateTime zonedDateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
    jsonGenerator.writeNumber(zonedDateTime.toInstant().toEpochMilli());
  }
}
