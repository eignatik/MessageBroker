package com.deveignatik.MessageBroker.LibKernel.entities;

/**
 * 5:12 PM.
 */
public class Message {
    private long id;
    private String message;
    private boolean sended;
    private long idtopic;

    public Message(long id, String message, boolean sended, long idtopic) {
        this.id = id;
        this.message = message;
        this.sended = sended;
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

    public boolean isSended() {
        return sended;
    }

    public void setSended(boolean sended) {
        this.sended = sended;
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
                ", message='" + message + '\'' +
                ", sended=" + sended +
                ", idtopic=" + idtopic +
                '}';
    }
}
