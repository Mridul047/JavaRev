package rev.streams;

import java.time.LocalDate;

/** Performance review record */
public record PerformanceReview(
    Long id,
    Long employeeId,
    LocalDate reviewDate,
    int rating, // 1-5
    String comments,
    Long reviewerId) {
  public PerformanceReview {
    if (rating < 1 || rating > 5) {
      throw new IllegalArgumentException("Rating must be between 1 and 5");
    }
  }

  public boolean isExcellent() {
    return rating >= 4;
  }
}
