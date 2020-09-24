package ru.uennar.birem;

public class Task extends TaskEntity{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + super.getId() +
                "name='" + name + '\'' +
                '}';
    }
}
