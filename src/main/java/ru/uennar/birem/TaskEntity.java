package ru.uennar.birem;

public class TaskEntity {
    private Long id;
    public String name;
    {
        name = "dfgk";
    }

    public Long getId() {
        return id;
    }

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
