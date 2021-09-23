package com.group1.model.db;

import com.group1.controller.ServerInit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Anh Vu Nguyen {@literal <nganhvu>}
 */
public class IO {
    public static BufferedReader getReader(String pathToFile) {
        Path path = Paths.get(ServerInit.dataPath.toString(), pathToFile);
        try {
            Files.createDirectories(path.getParent());
            if (Files.exists(path)) return new BufferedReader(new FileReader(path.toString()));
            else Files.createFile(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static BufferedWriter getWriter(String pathToFile, boolean append) {
        Path path = Paths.get(ServerInit.dataPath.toString(), pathToFile);
        try {
            Files.createDirectories(path.getParent());
            return new BufferedWriter(new FileWriter(path.toString(), append));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static Path getPathToFile(String basePath, String subPath, String fileName) {
        try {
            Path path = Paths.get(basePath, subPath);
            Files.createDirectories(path);
            return Paths.get(path.toString(), fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static boolean exists(String basePath, String subPath, String fileName) {
        return Files.exists(Paths.get(basePath, subPath, fileName));
    }
}
