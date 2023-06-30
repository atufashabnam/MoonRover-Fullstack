package com.moonrover.rover.service;

import com.moonrover.rover.model.Coordinates;
import com.moonrover.rover.model.Direction;
import com.moonrover.rover.util.Constants;
import com.moonrover.rover.util.MoonRoverHelper;
import com.moonrover.rover.util.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class MoonRoverOperations implements Operations {

    Logger logger = LoggerFactory.getLogger(MoonRoverOperations.class);

    private Coordinates coordinates;

    @Autowired
    private MoonRoverHelper moonRoverHelper;

    @Value("${xaxis.of.board.dimension}")
    private int xaxisDimension;
    @Value("${yaxis.of.board.dimension}")
    private int yaxisDimension;

    @Override
    public Response place(Coordinates coordinates) {

        if (moonRoverHelper.validateCoordinates(coordinates)) {
            this.coordinates = coordinates;
            logger.info(Constants.API_ROVER_PLACE_REQUEST_SUCCESS);
            return new Response(200, 100, Constants.APPLICATION_REQUEST_SUCCESS,
                    Constants.API_ROVER_PLACE_REQUEST_SUCCESS);

        } else {
            logger.error(Constants.API_ROVER_PLACE_REQUEST_FAILURE);
            return new Response(200, 100, Constants.APPLICATION_REQUEST_FAILURE,
                    Constants.API_ROVER_PLACE_REQUEST_FAILURE);

        }
    }

    @Override
    public Response move() {
        Response response;
        if (coordinates != null) {
            System.out.println(coordinates.getxAxis() + ":" + coordinates.getyAxis() + ":" + coordinates.getDirection());
            switch (coordinates.getDirection()) {
                case NORTH -> {
                    if (coordinates.getyAxis() + 1 <= yaxisDimension) {
                        coordinates.setyAxis(coordinates.getyAxis() + 1);
                        response = new Response(200, 220, Constants.APPLICATION_REQUEST_SUCCESS, Constants.API_ROVER_MOVE_REQUEST_SUCCESS);
                    } else {
                        response = new Response(400, 420, Constants.APPLICATION_REQUEST_FAILURE, Constants.API_ROVER_MOVE_REQUEST_FAILURE);
                    }
                }
                case SOUTH -> {
                    if (coordinates.getyAxis() - 1 >= 0) {
                        coordinates.setyAxis(coordinates.getyAxis() - 1);
                        response = new Response(200, 220, Constants.APPLICATION_REQUEST_SUCCESS, Constants.API_ROVER_MOVE_REQUEST_SUCCESS);
                    } else {
                        response = new Response(400, 420, Constants.APPLICATION_REQUEST_FAILURE, Constants.API_ROVER_MOVE_REQUEST_FAILURE);
                    }
                }
                case EAST -> {
                    if (coordinates.getxAxis() + 1 <= xaxisDimension) {
                        coordinates.setxAxis(coordinates.getxAxis() + 1);
                        response = new Response(200, 220, Constants.APPLICATION_REQUEST_SUCCESS, Constants.API_ROVER_MOVE_REQUEST_SUCCESS);
                    } else {
                        response = new Response(400, 420, Constants.APPLICATION_REQUEST_FAILURE, Constants.API_ROVER_MOVE_REQUEST_FAILURE);
                    }
                }
                case WEST -> {
                    if (coordinates.getxAxis() - 1 >= 0) {
                        coordinates.setxAxis(coordinates.getxAxis() - 1);
                        response = new Response(200, 220, Constants.APPLICATION_REQUEST_SUCCESS, Constants.API_ROVER_MOVE_REQUEST_SUCCESS);
                    } else {
                        response = new Response(400, 420, Constants.APPLICATION_REQUEST_FAILURE, Constants.API_ROVER_MOVE_REQUEST_FAILURE);
                    }
                }
                default ->
                        response = new Response(400, 420, Constants.APPLICATION_REQUEST_FAILURE, Constants.API_ROVER_MOVE_REQUEST_FAILURE);
            }
        } else {
            response = new Response(400, 420, Constants.APPLICATION_REQUEST_FAILURE, Constants.API_ROVER_MOVE_REQUEST_ROVER_NOT_PLACED);
        }
        return response;
    }

    @Override
    public Response turn(String direction) {
        Response response;
        if (coordinates != null) {
            switch (coordinates.getDirection()) {
                case NORTH ->
                        coordinates.setDirection(direction.toUpperCase().equals(Constants.API_ROVER_TURN_COMMAND_LEFT) ? Direction.WEST : Direction.EAST);
                case SOUTH ->
                        coordinates.setDirection(direction.toUpperCase().equals(Constants.API_ROVER_TURN_COMMAND_LEFT) ? Direction.EAST : Direction.WEST);
                case EAST ->
                        coordinates.setDirection(direction.toUpperCase().equals(Constants.API_ROVER_TURN_COMMAND_LEFT) ? Direction.NORTH : Direction.SOUTH);
                case WEST ->
                        coordinates.setDirection(direction.toUpperCase().equals(Constants.API_ROVER_TURN_COMMAND_LEFT) ? Direction.SOUTH : Direction.NORTH);
                default ->
                        response = new Response(400, 420, Constants.APPLICATION_REQUEST_FAILURE, Constants.API_ROVER_TURN_REQUEST_FAILURE);
            }
            response = new Response(200, 220, Constants.APPLICATION_REQUEST_SUCCESS, Constants.API_ROVER_TURN_REQUEST_SUCCESS);
        } else {
            response = new Response(400, 420, Constants.APPLICATION_REQUEST_FAILURE, Constants.API_ROVER_TURN_REQUEST_ROVER_NOT_PLACED);
        }
        return response;
    }

    @Override
    public Response report() {
        Response response;
        if (coordinates != null) {
            response = new Response(200, 220, Constants.APPLICATION_REQUEST_SUCCESS, Constants.API_ROVER_GENERATE_REQUEST_SUCCESS);
            response.setCoordinates(coordinates);
        } else {
            response = new Response(400, 420, Constants.APPLICATION_REQUEST_FAILURE, Constants.API_ROVER_GENERATE_REQUEST_ROVER_NOT_PLACED);
        }

        return response;
    }


    public void resetCoordinates() {
        coordinates = null;
    }

}