package ru.uennar.birem.beans;

public class Client {
    private long id;
    private String name;
    private String city;

    public Client(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Client() {

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

    public void setCity(String city){
        this.city = city;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name +
                ", city='" + city +'\'' +
                '}';
    }
}
