package rev.helper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileIoHelper {
  public static void readFromFile(Path filePath) {
    try {
      List<String> fileLines = Files.readAllLines(filePath);
      fileLines.forEach(log::info);
    } catch (IOException e) {
      log.error(e.getMessage(), e.getCause());
    }
  }

  public static void writeToFile(Path filePath, List<String> dataToWrite) {
    try {
      // Write lines to the file (overwrites if file exists)
      Files.write(filePath, dataToWrite);
    } catch (IOException e) {
      log.error(e.getMessage());
    }
  }
}
