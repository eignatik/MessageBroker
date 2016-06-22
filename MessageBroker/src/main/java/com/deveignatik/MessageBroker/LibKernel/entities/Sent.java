package com.deveignatik.MessageBroker.LibKernel.entities;

public class Sent {
    private Long id;
    private Long idClient;
    private Long idMessage;

    public Sent() {
    }

    public Sent(Long id, Long idClient, Long idMessage) {
        this.id = id;
        this.idClient = idClient;
        this.idMessage = idMessage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public Long getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Long idMessage) {
        this.idMessage = idMessage;
    }

    @Override
    public String toString() {
        return "Sent{" +
                "id=" + id +
                ", idClient=" + idClient +
                ", idMessage=" + idMessage +
                '}';
    }
}
