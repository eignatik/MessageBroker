package com.deveignatik.MessageBroker.LibKernel.entities;

/**
 * 5:12 PM.
 */
public class Topic {
    private long id;
    private String title;

    public Topic() {
    }

    public Topic(int id, String title){
        this.id = id;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
