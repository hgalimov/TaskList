package ru.uennar.birem.beans;

public class Task extends TaskEntity {

    private String name;

    public Long getId(){
        return 234L;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id2=" + this.getId() +
                "name='" + name + '\'' + super.name + "" +
                '}';
    }
}
