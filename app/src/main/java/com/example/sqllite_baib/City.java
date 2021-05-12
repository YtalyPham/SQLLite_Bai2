package com.example.sqllite_baib;

public class City {
    private int id;
    private String name;

    public int getId() {
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

    public City(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public City() {
    }

    public City(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  id +" " + name ;
    }
}
