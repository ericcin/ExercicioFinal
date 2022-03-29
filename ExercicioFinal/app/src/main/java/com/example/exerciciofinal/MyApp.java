package com.example.exerciciofinal;

public class MyApp {
    private int id;
    private String name;

    public MyApp() {
        super();
    }

    public MyApp(int id, String name){
        this.id = id;
        this.name = name;
    }

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
}
