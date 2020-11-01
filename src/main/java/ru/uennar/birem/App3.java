package ru.uennar.birem;

import org.aspectj.lang.JoinPoint;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.uennar.birem.aspect.LoggingAspect;
import ru.uennar.birem.beans.*;
import ru.uennar.birem.logger.CombinedEventLogger;

import java.text.DateFormat;
import java.util.Map;

public class App3 {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spr.xml");
        Entity entity = ctx.getBean("entity", Entity.class);
        System.out.println(entity.getNum() +
                " " + entity.getUser() +
                " " + entity.getUser1());
        for (int i: entity.getNums()
             ) {
            System.out.println(i);
        }
        LoggingAspect loggingAspect = ctx.getBean("loggingAspect", LoggingAspect.class);
        loggingAspect.logBefore();
        ctx.close();
    }
}
