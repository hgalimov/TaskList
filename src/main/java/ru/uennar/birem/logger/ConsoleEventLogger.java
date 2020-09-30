package ru.uennar.birem.logger;

import ru.uennar.birem.beans.Event;
import ru.uennar.birem.logger.EventLogger;

public class ConsoleEventLogger implements EventLogger {

    public void logEvent(Event event){
        System.out.println(event.toString());
    }
}
