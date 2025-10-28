package rev.streams.model;

import java.time.LocalDate;

/** Project record */
public record Project(
    Long id,
    String name,
    String code,
    Long departmentId,
    LocalDate startDate,
    LocalDate endDate,
    ProjectStatus status,
    Double budget) {}
