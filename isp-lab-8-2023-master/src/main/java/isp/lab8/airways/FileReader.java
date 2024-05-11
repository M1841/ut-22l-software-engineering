package isp.lab8.airways;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

public class FileReader {
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
}