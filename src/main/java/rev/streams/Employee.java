package rev.streams;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Objects;

/** Employee record - immutable by default Java 21 features: records, compact constructors */
public record Employee(
    Long id,
    String firstName,
    String lastName,
    String gender,
    String email,
    String department,
    Position position,
    Double salary,
    LocalDate joinDate,
    LocalDate birthDate,
    Long managerId,
    EmploymentStatus status,
    List<String> skills,
    Address address) {
  // Compact constructor for validation
  public Employee {
    Objects.requireNonNull(id, "ID cannot be null");
    Objects.requireNonNull(firstName, "First name cannot be null");
    Objects.requireNonNull(lastName, "Last name cannot be null");
    Objects.requireNonNull(gender, "Gender cannot be null");
    Objects.requireNonNull(department, "Department cannot be null");
    Objects.requireNonNull(position, "Position cannot be null");

    if (salary != null && salary < 0) {
      throw new IllegalArgumentException("Salary cannot be negative");
    }

    // Ensure immutable collections
    skills = skills != null ? List.copyOf(skills) : List.of();
  }

  // Derived properties
  public String fullName() {
    return firstName + " " + lastName;
  }

  public int age() {
    return birthDate != null ? Period.between(birthDate, LocalDate.now()).getYears() : 0;
  }

  public int yearsOfService() {
    return Period.between(joinDate, LocalDate.now()).getYears();
  }

  public boolean hasSkill(String skill) {
    return skills.stream().anyMatch(s -> s.equalsIgnoreCase(skill));
  }

  public boolean isManager() {
    return position.level() >= 4; // Manager level and above
  }

  public boolean isActive() {
    return status == EmploymentStatus.ACTIVE;
  }
}
