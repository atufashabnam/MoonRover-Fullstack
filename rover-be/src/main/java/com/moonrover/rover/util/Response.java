package com.moonrover.rover.util;


import com.moonrover.rover.model.Coordinates;

public class Response {

    private int responseCode;
    private int reasonCode;
    private String status;
    private String message;
    private Coordinates coordinates;

    public Response() {
    }

    public Response(int responseCode, int reasonCode, String status, String message) {
        this.responseCode = responseCode;
        this.reasonCode = reasonCode;
        this.status = status;
        this.message = message;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public int getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(int reasonCode) {
        this.reasonCode = reasonCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }


}
