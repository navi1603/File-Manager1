package com.ukrainec.java.file.manager;

import sun.util.resources.LocaleData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileInfo {
    public enum FileType {
        FILE("F"), DIRECTORY("D");

        private String name;

        public String getName() {
            return name;
        }

        FileType(String name) {
            this.name = name;
        }
    }

    private  String fileName;
    private FileInfo type;
    private long size;
    private LocaleData lastModified;

    public void setLastModified(LocaleData lastModified) {
        this.lastModified = lastModified;
    }

    public FileInfo (Path path) {
        try {
            this.fileName = path.getFileName().toString();
            this.size = Files.size(path);
        } catch (IOException e) {
            throw new RuntimeException("Unable to create file info from path");
        }
    }
}
