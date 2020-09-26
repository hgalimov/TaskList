package ru.uennar.birem.logger;

import ru.uennar.birem.logger.EventLogger;

public class ConsoleEventLogger implements EventLogger {

    public void logEvent(String msg){
        System.out.println(msg);
    }
}
