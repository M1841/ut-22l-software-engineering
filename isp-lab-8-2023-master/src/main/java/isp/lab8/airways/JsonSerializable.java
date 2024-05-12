package isp.lab8.airways;

import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.Collectors;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class JsonSerializable<T> {
  public static <T> T fromJson(String directory, String name, Class<T> type) throws IOException {
    String jsonContent = FileSystem
        .readAllLines(FileSystem.getPath(directory, name, true))
        .stream()
        .collect(Collectors.joining("\n"));

    ObjectMapper objectMapper = new ObjectMapper();

    return objectMapper.readValue(jsonContent, type);
  }

  public void toJson(String directory, String name) throws IOException {
    FileWriter fileWriter = new FileWriter(FileSystem.getPath(directory, name, true));
    ObjectMapper objectMapper = new ObjectMapper();

    objectMapper.writeValue(fileWriter, this);
  }
}