package ru.uennar.birem.beans;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

public class Event {
    private int id = new Random().nextInt(100);
    private String msg;
    private Date date;
    private DateFormat df;

    public Event() {
    }

    public Event(Date date) {
        this.date = date;
    }
    public Event(Date date, DateFormat df) {
        this.date = date;
        this.df = df;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + df.format(date) +
                '}';
    }
}
