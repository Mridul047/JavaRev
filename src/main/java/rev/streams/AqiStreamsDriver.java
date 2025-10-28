package rev.streams;

import static rev.helper.FileIoHelper.getFromFile;

import java.nio.file.Path;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import rev.streams.model.MonitoringRecord;

@Slf4j
public class AqiStreamsDriver {
  private static final String BASE_PATH = "src/main/resources/";

  private static final String AQI_CSV_FILE = "India_AQI.csv";

  static void main() {
    Path csvFilePath = Path.of(BASE_PATH + AQI_CSV_FILE);
    List<MonitoringRecord> records;

    if (getFromFile(csvFilePath).isPresent()) {
      records =
          getFromFile(csvFilePath).get().stream()
              .skip(1)
              .map(line -> line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1))
              .map(MonitoringRecord::new)
              .toList();

      var allPollutants = getAllPollutants(records);
      log.info("All pollutants: {}", allPollutants);

      var recordsWithModerateAqi =
          records.stream().filter(record -> "Moderate".equals(record.getAqiStatus())).toList();
      log.info("Records with Moderate aqi status: {}", recordsWithModerateAqi);

      var recordsGroupedByState =
          records.stream().collect(Collectors.groupingBy(MonitoringRecord::getState));
      log.info("Grouped by state: {}", recordsGroupedByState);

      var areasByStatus =
          records.stream()
              .collect(
                  Collectors.groupingBy(
                      MonitoringRecord::getAqiStatus,
                      Collectors.mapping(MonitoringRecord::getArea, Collectors.toSet())));

      log.info("Areas by status: {}", areasByStatus);
    }
  }

  @NotNull
  private static Set<String> getAllPollutants(List<MonitoringRecord> records) {
    return records.stream().flatMap(r -> r.getPollutants().stream()).collect(Collectors.toSet());
  }
}
