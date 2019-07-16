package io.github.mlniang.zabbix.client.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * @author Mamadou Lamine NIANG
 **/
public final class CustomJsonSerializer {

    private CustomJsonSerializer() {}

    public static class BooleanNumericSerializer extends JsonSerializer<Boolean> {

        @Override
        public void serialize(Boolean aBoolean, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeNumber(Boolean.TRUE == aBoolean ? 1 : 0);
        }
    }

    public static class BooleanNumericDeserializer extends JsonDeserializer<Boolean> {

        @Override
        public Boolean deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            return !"0".equals(jsonParser.getText());
        }
    }
}
