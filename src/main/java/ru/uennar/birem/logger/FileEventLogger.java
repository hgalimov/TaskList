package ru.uennar.birem.logger;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger {
    private File file;
    private String fileName;

    public FileEventLogger() {
    }

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    public void init() throws IOException {
        this.file = new File(fileName);
    }

    public void writeEventsFromCache() {
        //FileUtils.writeStringToFile;
    }
}
