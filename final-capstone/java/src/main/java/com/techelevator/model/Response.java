package com.virginessee.TETicketingSystem.models;

public class Response {
    private Long id;
    private Long ticketId;
    private Long responseTypeId;

    private String message;
    private String responseType;

    public Response() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public Long getResponseTypeId() {
        return responseTypeId;
    }

    public void setResponseTypeId(Long responseTypeId) {
        this.responseTypeId = responseTypeId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }
}
