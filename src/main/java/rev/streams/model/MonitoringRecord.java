package rev.streams.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;

@Data
public class MonitoringRecord {
  private LocalDate date;
  private String state;
  private String area;
  private List<String> pollutants;
  private int aqiValue;
  private String aqiStatus;

  public MonitoringRecord(String[] csvRow) {
    this.date = LocalDate.parse(csvRow[0], DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    this.state = csvRow[1];
    this.area = csvRow[2];
    this.pollutants =
        Arrays.stream(csvRow[4].replaceAll("\"", "").split(","))
            .map(String::trim)
            .collect(Collectors.toList());
    this.aqiValue = Integer.parseInt(csvRow[5]);
    this.aqiStatus = csvRow[6];
  }
}
