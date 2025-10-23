package rev.streams;

import java.time.LocalDate;

/** Salary history record */
public record SalaryHistory(
    Long employeeId,
    LocalDate effectiveDate,
    Double previousSalary,
    Double newSalary,
    String reason) {
  public double increasePercentage() {
    return previousSalary != null && previousSalary > 0
        ? ((newSalary - previousSalary) / previousSalary) * 100
        : 0.0;
  }
}
