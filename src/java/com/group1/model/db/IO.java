package com.group1.model.db;

import com.group1.controller.ServerInit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 *
 * @author Anh Vu Nguyen {@literal <nganhvu>}
 */
public class IO {
    public static BufferedReader getReader(String basePath, String pathToFile) {
        Path path = Paths.get(basePath, pathToFile);
        try {
            Files.createDirectories(path.getParent());
            if (Files.exists(path)) return new BufferedReader(new FileReader(path.toString()));
            else Files.createFile(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static BufferedReader getReader(String pathToFile) {
        return getReader(ServerInit.dataPath, pathToFile);
    }
    
    public static BufferedWriter getWriter(String pathToFile, boolean append) {
        Path path = Paths.get(ServerInit.dataPath, pathToFile);
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
    
    public static List<String> getFilesName(String basePath, String subPath) {
        List<String> res = new ArrayList<>();
        try (Stream<Path> paths = Files.list(Paths.get(basePath, subPath))) {
            paths.filter(Files::isRegularFile).forEach(path -> res.add(path.getFileName().toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    
   public static boolean delete(String basePath, String subPath, String fileName) {
        try {
            return Files.deleteIfExists(Paths.get(basePath, subPath, fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
