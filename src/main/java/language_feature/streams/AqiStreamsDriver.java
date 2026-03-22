package language_feature.streams;

import static language_feature.helper.FileIoHelper.getFromFile;

import java.nio.file.Path;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import language_feature.streams.model.MonitoringRecord;

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
      // log.info("records: {}", records);

      // ----------------------------------------------
      // Q4: List all pollutant types present in
      // the dataset
      // ----------------------------------------------
      var allPollutants =
          records.stream()
              .map(MonitoringRecord::getPollutants)
              .flatMap(List::stream)
              .distinct()
              .toList();
      log.info("allPollutants: {}", allPollutants);
    }
  }
}
