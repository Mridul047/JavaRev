package rev.datetime;

import java.time.LocalDate;
import java.time.Period;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

public class PeriodExample {
  public static void main(String[] args) {
    // Logger log = LoggerFactory.getLogger(PeriodExample.class);

    LocalDate start = LocalDate.of(2000, 1, 1);
    LocalDate today = LocalDate.now();
    Period period = Period.between(start, today);

    // log.info("Elapsed Time: {} years.", period.getYears());
  }
}
