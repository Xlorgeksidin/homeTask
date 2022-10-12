package ru.home_task.weather.dictionaries.weather_stack.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalTimeSerializer extends StdSerializer<LocalTime> {
  private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("hh:mm a");
  protected LocalTimeSerializer(){
    this(null);
  }

  protected LocalTimeSerializer(Class<LocalTime> t) {
    super(t);
  }

  @Override
  public void serialize(LocalTime localDateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
    jsonGenerator.writeString(localDateTime.format(DateTimeFormatter.ofPattern(SIMPLE_DATE_FORMAT.toPattern())));
  }
}
