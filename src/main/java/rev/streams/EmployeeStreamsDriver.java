package rev.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import rev.streams.model.Employee;
import rev.streams.model.EmployeeDataFactory;

@Slf4j
public class EmployeeStreamsDriver {

  public static void main(String[] args) {
    // create stream from list
    List<Employee> employees = EmployeeDataFactory.createSampleEmployees();

    // get distinct emp departments
    Stream<Employee> employeesStream1 = employees.stream();

    var departmentNames = employeesStream1.map(Employee::department).distinct().toList();
    log.info("Employee Department Names: {}", departmentNames);

    // get map of employee id & full name
    Stream<Employee> employeesStream2 = employees.stream();
    var empMap = employeesStream2.collect(Collectors.toMap(Employee::id, Employee::fullName));
    log.info("Employee id:fullName Map: {}", empMap);

    // group by emp dep
    Stream<Employee> employeesStream3 = employees.stream();
    var empGroupByDepartment =
        employeesStream3.collect(Collectors.groupingBy(Employee::department));
    log.info("Employee group by departments: {}", empGroupByDepartment);

    // partition by emp active status
    Stream<Employee> employeesStream4 = employees.stream();
    var activeEmpMap = employeesStream4.collect(Collectors.partitioningBy(Employee::isActive));
    log.info("Employee isActive: {}", activeEmpMap);

    // count total emp
    Stream<Employee> employeesStream5 = employees.stream();
    var totalEmpCnt = employeesStream5.collect(Collectors.counting());
    // (Long) employeesStream5.count();
    log.info("Total Employee cnt: {}", totalEmpCnt);

    // get skills set for all emp
    Stream<Employee> employeesStream6 = employees.stream();
    var skillSet =
        employeesStream6.flatMap(emp -> emp.skills().stream()).collect(Collectors.toSet());
    log.info("skillSet: {}", skillSet);

    // get min salary of all emp
    Stream<Employee> employeesStream7 = employees.stream();
    var empWithMinSalary =
        employeesStream7.collect(Collectors.minBy(Comparator.comparing(Employee::salary)));
    // employeesStream7.min(Comparator.comparing(Employee::salary));
    log.info("empWithMinSalary: {}", empWithMinSalary);

    // get max salaried emp of all emp
    Stream<Employee> employeesStream8 = employees.stream();
    var empWithMaxSalary =
        employeesStream8.collect(Collectors.maxBy(Comparator.comparing(Employee::salary)));
    // employeesStream8.max(Comparator.comparing(Employee::salary));
    log.info("empWithMaxSalary: {}", empWithMaxSalary);

    Stream<Employee> employeesStream9 = employees.stream();
    var totalSalaryOfEmployees = (Double) employeesStream9.mapToDouble(Employee::salary).sum();
    // (Double) employeesStream9.mapToDouble(Employee::salary).sum();
    log.info("totalSalaryOfEmployees: {}", totalSalaryOfEmployees);

    Stream<Employee> employeesStream10 = employees.stream();
    var avgAge = employeesStream10.collect(Collectors.averagingInt(Employee::age));
    log.info("avgAge: {}", avgAge);
  }

  private static void createStream() {
    // From List
    List<Employee> employees = EmployeeDataFactory.createSampleEmployees();
    Stream<Employee> stream1 = employees.stream();

    // From Set
    Set<String> departments = Set.of("Engineering", "Sales", "HR");
    Stream<String> stream2 = departments.stream();

    // From Map - various approaches
    Map<Long, Employee> employeeMap =
        employees.stream().collect(Collectors.toMap(Employee::id, e -> e));

    log.info("employees: {}", employeeMap);

    // Stream of entries
    Stream<Map.Entry<Long, Employee>> stream3 = employeeMap.entrySet().stream();

    // Stream of keys
    Stream<Long> stream4 = employeeMap.keySet().stream();

    // Stream of values
    Stream<Employee> stream5 = employeeMap.values().stream();

    // Sequenced Collections (Java 21)
    List<Employee> sequenced = new ArrayList<>(employees);
    Stream<Employee> firstThree = sequenced.stream().limit(3);
    Stream<Employee> lastThree = sequenced.reversed().stream().limit(3);
  }
}
