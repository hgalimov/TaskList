package ru.uennar.birem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.uennar.birem.beans.Task;
import ru.uennar.birem.logger.ConsoleEventLogger;
import ru.uennar.birem.logger.EventLogger;

public class App {
    public static void main(String[] args){
        /*Task task = new Task();
        task.setId(1L);*/
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        Task task = (Task) ctx.getBean("task");
        System.out.println(task.toString());
        logEvent("ObjectCreated");
    }
    public static void logEvent(String msg){
        EventLogger logger = new ConsoleEventLogger();
        logger.logEvent(msg);
    }
}
