package com.moonrover.rover.util;


import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.moonrover.rover.model.Direction;

import java.io.IOException;


public class DirectionDeserializer extends StdDeserializer {

    public DirectionDeserializer() {
        super(Direction.class);
    }

    @Override
    public Direction deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
        String value = jsonParser.getValueAsString();
        if (value != null) {
            try {
                return Direction.valueOf(value.toUpperCase());
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid Direction " + value);
            }
        }
        return null;
    }

}
