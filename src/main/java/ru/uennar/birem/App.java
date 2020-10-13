package ru.uennar.birem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.uennar.birem.beans.Event;
import ru.uennar.birem.beans.Person;
import ru.uennar.birem.beans.Task;
import ru.uennar.birem.logger.CacheFileEventLogger;
import ru.uennar.birem.logger.ConsoleEventLogger;
import ru.uennar.birem.logger.EventLogger;
import ru.uennar.birem.logger.FileEventLogger;

import java.text.DateFormat;
import java.util.Date;

public class App {
    public static void main(String[] args) {
        /*Task task = new Task();
        task.setId(1L);*/
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        Task task = (Task) ctx.getBean("task");
        System.out.println(task.toString());

        DateFormat df = (DateFormat) ctx.getBean("dateFormat");
        logEvent("ObjectCreated", df);

        Person person = (Person) ctx.getBean("person");
        Event event = (Event) ctx.getBean("event");

        if (person != null) {
            logEvent(event);
            logEventFile(event);
        }
    }

    public static void logEvent(String msg, DateFormat df) {
        EventLogger logger = new ConsoleEventLogger();
        Event event = new Event(new Date(), df);
        event.setMsg(msg);
        logger.logEvent(event);
    }

    public static void logEvent(Event event) {
        EventLogger logger = new ConsoleEventLogger();
        event.setMsg("Person exist");
        logger.logEvent(event);
    }
    public static void logEventFile(Event event) {
        CacheFileEventLogger logger = new CacheFileEventLogger();
        event.setMsg("Person exist");
        logger.logEvent(event);
    }
}
