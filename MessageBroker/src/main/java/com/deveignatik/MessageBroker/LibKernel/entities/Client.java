package com.deveignatik.MessageBroker.LibKernel.entities;

/**
 * 6:40 PM.
 */
public class Client {
    private long id;
    private String name;
    private int lastmessageid;

    public Client(long id, String name, int lastmessageid) {
        this.id = id;
        this.name = name;
        this.lastmessageid = lastmessageid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLastmessageid() {
        return lastmessageid;
    }

    public void setLastmessageid(int lastmessageid) {
        this.lastmessageid = lastmessageid;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastmessageid=" + lastmessageid +
                '}';
    }
}
