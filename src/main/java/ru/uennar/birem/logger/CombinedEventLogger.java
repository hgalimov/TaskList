package ru.uennar.birem.logger;

import ru.uennar.birem.beans.Event;

import java.util.Collection;

public class CombinedEventLogger implements EventLogger{
    private Collection<EventLogger> loggers;

    public CombinedEventLogger(){}
    public CombinedEventLogger(Collection<EventLogger> eventLoggers){
        loggers = eventLoggers;
    }

    @Override
    public void logEvent(Event event) {
        for (EventLogger logger: loggers){
            logger.logEvent(event);
        }
    }
}
