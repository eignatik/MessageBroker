package com.deveignatik.MessageBroker.LibKernel.entities;

/**
 * 6:40 PM.
 */
public class Subscribe {
    private long id;
    private long idTopic;
    private long idClient;

    public Subscribe() {
    }

    public Subscribe(long id, long idTopic, long idClient) {
        this.id = id;
        this.idTopic = idTopic;
        this.idClient = idClient;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(long idTopic) {
        this.idTopic = idTopic;
    }

    public long getIdClient() {
        return idClient;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }

    @Override
    public String toString() {
        return "Subscribe{" +
                "id=" + id +
                ", idTopic=" + idTopic +
                ", idClient=" + idClient +
                '}';
    }
}
