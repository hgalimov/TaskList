package ru.uennar.birem.config;

import java.text.DateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import ru.uennar.birem.beans.Client;


@Configuration
@PropertySource("classpath:client.properties")
public class AppConfig {

    @Autowired
    private Environment environment;

    @Bean
    public Date newDate() {
        return new Date();
    }

    @Bean
    public DateFormat dateFormat() {
        return DateFormat.getDateTimeInstance();
    }

    @Bean
    public Client client() {
        Client client = new Client();
        client.setId(Long.parseLong(environment.getRequiredProperty("id")));
        client.setName(environment.getRequiredProperty("name"));
        client.setCity(environment.getProperty("greeting"));
        return client;
    }

}
