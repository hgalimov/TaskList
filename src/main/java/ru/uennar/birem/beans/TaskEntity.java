package ru.uennar.birem.beans;

public abstract class TaskEntity {
    private Long id;
    public String name;
    {
        name = "TestTask";
    }

    public abstract Long getId();

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TaskEntity{" +
                "id=" + id +
                '}';
    }
}
