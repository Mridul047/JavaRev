package rev.datetime;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public class LocalDateExample {
  public static void main(String[] args) {
    // Logger log = LoggerFactory.getLogger(LocalDateExample.class);

    LocalDate today = LocalDate.now(); // Current date
    LocalDate birthDate = LocalDate.of(1990, 5, 15); // Specific date
    LocalDate nextMonth = today.plusMonths(1); // Add 1 month

    //    log.info("Today: {}", today);
    //    log.info("Birth Date: {}", birthDate);
    //    log.info("Next Month: {}", nextMonth);
  }
}
