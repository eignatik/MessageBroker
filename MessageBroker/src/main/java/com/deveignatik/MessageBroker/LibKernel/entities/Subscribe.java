package com.deveignatik.MessageBroker.LibKernel.entities;

/**
 * 6:40 PM.
 */
public class Subscribe {
    private long id;
    private String name;
    private int lastmesid;

    public Subscribe(long id, String name, int lastmesid) {
        this.id = id;
        this.name = name;
        this.lastmesid = lastmesid;
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

    public int getLastmesid() {
        return lastmesid;
    }

    public void setLastmesid(int lastmesid) {
        this.lastmesid = lastmesid;
    }

    @Override
    public String toString() {
        return "Subscribe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastmesid=" + lastmesid +
                '}';
    }
}
