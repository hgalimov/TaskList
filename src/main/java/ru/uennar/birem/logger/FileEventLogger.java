package ru.uennar.birem.logger;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger {
    private File file;
    private String fileName;

    private String text;

    public FileEventLogger() {
    }

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    public void init() throws IOException {
        this.file = new File(fileName);
    }
    public void setText(String text) {
        this.text = text;
    }
    public void writeEventsFromCache() {
        try {
            FileUtils.write(file, text, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
