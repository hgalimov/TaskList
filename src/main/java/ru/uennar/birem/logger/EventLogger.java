package ru.uennar.birem.logger;

import ru.uennar.birem.beans.Event;

public interface EventLogger {
    void logEvent(Event event);
}
