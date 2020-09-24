package ru.uennar.birem;

public class Task extends TaskEntity{
    private String name;

    public Long getId(){
        return 234l;
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
                "id1=" + super.getId() +
                "id2=" + this.getId() +
                "name='" + name + '\'' + super.name +
                '}';
    }
}
