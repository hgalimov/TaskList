package ru.uennar.birem;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.uennar.birem.beans.Client;
import ru.uennar.birem.config.AppConfig;

public class App2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.scan("ru.uennar.birem");
        ctx.refresh();
        Client client = ctx.getBean(Client.class);
        System.out.println(client.toString());
    }
}
