package com.deveignatik.MessageBroker.LibKernel.entities;

/**
 * 5:12 PM.
 */
public class Topic {
    private long id;
    private String name;

    public Topic(int id, String name){
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
