package com.moonrover.rover.service;


import com.moonrover.rover.model.Coordinates;
import com.moonrover.rover.util.Response;

public interface Operations {
    Response place(Coordinates coordinates);

    Response move();

    Response turn(String direction);

    Response report();

}
