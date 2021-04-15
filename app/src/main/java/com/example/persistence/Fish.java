package com.example.persistence;

public class Fish {
    private long id;
    private String name;
    private int width;
    private String location;

    public Fish(long id, String name, int width, String location){
        this.id = id;
        this.name = name;
        this.width = width;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", width=" + width + '\'' +
                ", location=" + location +
                '}';
    }
}
