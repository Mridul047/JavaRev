package rev.collections;

import static rev.helper.FileIoHelper.readFromFile;
import static rev.helper.FileIoHelper.writeToFile;

import java.nio.file.Path;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ListDriver {
  private static final String BASE_PATH = "src/main/resources/";

  public static void main(String[] args) {
    Path readFilePath = Path.of(BASE_PATH + "ReadFile.txt");
    Path writeFilePath = Path.of(BASE_PATH + "WriteFile.txt");

    readFromFile(readFilePath);
    writeToFile(writeFilePath, List.of("Hello, world!", "This is modern Java."));
  }
}
