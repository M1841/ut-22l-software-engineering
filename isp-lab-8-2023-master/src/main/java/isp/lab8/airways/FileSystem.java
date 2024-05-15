package isp.lab8.airways;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

public class FileSystem {
  public static List<String> readAllLines(String pathString) throws IOException {
    List<String> lines = new ArrayList<>();
    Path path = Paths.get(pathString);

    try (BufferedReader bufferedReader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        lines.add(line);
      }
    }
    return lines;
  }

  public static List<String> getFilesInDirectory(String directoryName) {
    File directory = new File(directoryName);
    return Arrays.asList(directory.list());
  }

  public static String getDirectory(String path) {
    File directory = new File(path);

    if (!directory.isDirectory()) {
      directory.mkdir();
    }

    return path;
  }

  public static String getPath(String directory, String file, boolean isJson) {
    return String.format(
        "%s\\%s%s",
        directory, file, isJson ? ".json" : "");
  }
}
