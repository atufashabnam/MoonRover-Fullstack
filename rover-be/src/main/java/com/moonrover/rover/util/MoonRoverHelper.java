package com.moonrover.rover.util;


import com.moonrover.rover.model.Coordinates;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class MoonRoverHelper {

    @Value("${xaxis.of.board.dimension}")
    private int xaxisDimension;
    @Value("${yaxis.of.board.dimension}")
    private int yaxisDimension;

    public boolean validateCoordinates(Coordinates coordinates) {
        return coordinates.getxAxis() >= 0 && coordinates.getxAxis() <= xaxisDimension
                && coordinates.getyAxis() >= 0 && coordinates.getyAxis() <= yaxisDimension;
    }
}
