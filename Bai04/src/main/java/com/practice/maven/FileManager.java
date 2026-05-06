package com.practice.maven;

import java.nio.file.Paths;

public class FileManager {
    public String createFilePath(String folder, String fileName) {
        return Paths.get(folder, fileName).toString();
    }
}