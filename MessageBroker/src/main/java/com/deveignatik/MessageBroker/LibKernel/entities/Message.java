package com.deveignatik.MessageBroker.LibKernel.entities;

/**
 * 5:12 PM.
 */
public class Message {
    private long id;
    private String message;
    private long idtopic;

    public Message() {
    }

    public Message(long id, String message, long idtopic) {
        this.id = id;
        this.message = message;
        this.idtopic = idtopic;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getIdtopic() {
        return idtopic;
    }

    public void setIdtopic(long idtopic) {
        this.idtopic = idtopic;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", message='" + message + '\''+
                ", idtopic=" + idtopic +
                '}';
    }
}
