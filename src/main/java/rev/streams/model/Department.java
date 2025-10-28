package rev.streams.model;

/** Department record */
public record Department(
    Long id, String name, String code, Long headEmployeeId, Double budget, String location) {}
