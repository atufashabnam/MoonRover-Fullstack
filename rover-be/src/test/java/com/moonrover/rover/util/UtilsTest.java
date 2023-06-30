package com.moonrover.rover.util;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.moonrover.rover.model.Coordinates;
import com.moonrover.rover.model.Direction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UtilsTest {
    @Autowired
    MoonRoverHelper helper;

    @Test
    public void shouldReturnTrueForValidCoordinates(){
        Coordinates coordinates = new Coordinates(2, 3, Direction.EAST);
        assertTrue(helper.validateCoordinates(coordinates));
    }

    @Test
    public void shouldReturnFalseForInValidXCoordinates(){
        Coordinates coordinates = new Coordinates(21, 3, Direction.EAST);
        assertFalse(helper.validateCoordinates(coordinates));
    }

    @Test
    public void shouldReturnFalseForInValidYCoordinates(){
        Coordinates coordinates = new Coordinates(1, 13, Direction.EAST);
        assertFalse(helper.validateCoordinates(coordinates));
    }
}