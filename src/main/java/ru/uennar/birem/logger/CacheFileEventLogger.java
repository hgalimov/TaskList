package ru.uennar.birem.logger;

import ru.uennar.birem.beans.Event;

import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {
    private int cacheSize;
    private List<Event> cache;

    public CacheFileEventLogger(){

    }
    public CacheFileEventLogger(int cacheSize, List<Event> cache) {
        this.cacheSize = cacheSize;
        this.cache = cache;
    }

    public void logEvent(Event event) {
        cache.add(event);
        if (cache.size() == cacheSize) {
            writeEventsFromCache();
            cache.clear();
        }
    }

    public void destroy() {
        if (!cache.isEmpty()) {
            writeEventsFromCache();
        }
    }
}
