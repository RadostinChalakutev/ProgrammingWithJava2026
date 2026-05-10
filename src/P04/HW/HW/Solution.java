import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

enum ContractType {
    PERMANENT,
    PART_TIME,
    TRAINEE
}

class Employee {
    private String name;
    private String id;
    private int workedHours;
    private ContractType contractType;
    private BigDecimal additionalSalaryPerHour;

    private static final Map<ContractType, BigDecimal> minimalSalaryPerHour = new HashMap<>();

    public Employee(String name, String id, int workedHours, ContractType contractType, BigDecimal additionalSalaryPerHour) {
        this.name = name;
        this.id = id;
        this.workedHours = workedHours;
        this.contractType = contractType;
        this.additionalSalaryPerHour = additionalSalaryPerHour;
    }

    public static void setMinimalSalaryPerHour(BigDecimal permanent, BigDecimal partTime, BigDecimal trainee) {
        minimalSalaryPerHour.put(ContractType.PERMANENT, permanent);
        minimalSalaryPerHour.put(ContractType.PART_TIME, partTime);
        minimalSalaryPerHour.put(ContractType.TRAINEE, trainee);
    }

    public BigDecimal salary() {
        BigDecimal minimalSalary = minimalSalaryPerHour.get(contractType);
        BigDecimal salaryPerHour = minimalSalary.add(additionalSalaryPerHour);

        return salaryPerHour
                .multiply(BigDecimal.valueOf(workedHours))
                .setScale(2, RoundingMode.HALF_UP);
    }

    public void increaseSalary(BigDecimal percent) {
        if (percent.compareTo(BigDecimal.ZERO) > 0) {
            BigDecimal multiplier = BigDecimal.ONE.add(
                    percent.divide(BigDecimal.valueOf(100), 10, RoundingMode.HALF_UP)
            );

            additionalSalaryPerHour = additionalSalaryPerHour
                    .multiply(multiplier)
                    .setScale(2, RoundingMode.HALF_UP);
        }
    }

    public String getId() {
        return id;
    }

    public ContractType getContractType() {
        return contractType;
    }
}

class Company {
    private String name;
    private int maxEmployees;
    private List<Employee> employees;

    public Company(String name, int maxEmployees) {
        this.name = name;
        this.maxEmployees = maxEmployees;
        this.employees = new ArrayList<>();
    }

    public void hireEmployee(Employee employee) {
        if (employees.size() >= maxEmployees) {
            return;
        }

        for (Employee e : employees) {
            if (e.getId().equals(employee.getId())) {
                return;
            }
        }

        employees.add(employee);
    }

    public void fireEmployee(Employee employee) {
        employees.removeIf(e -> e.getId().equals(employee.getId()));
    }

    public BigDecimal averageSalary() {
        if (employees.isEmpty()) {
            return BigDecimal.ZERO;
        }

        BigDecimal sum = BigDecimal.ZERO;

        for (Employee e : employees) {
            sum = sum.add(e.salary());
        }

        return sum.divide(BigDecimal.valueOf(employees.size()), 2, RoundingMode.HALF_UP);
    }

    public void increaseSalaries(BigDecimal percent) {
        if (percent.compareTo(BigDecimal.ZERO) > 0) {
            for (Employee e : employees) {
                e.increaseSalary(percent);
            }
        }
    }

    public BigDecimal averageSalaryPerContractType(ContractType contractType) {
        BigDecimal sum = BigDecimal.ZERO;
        int count = 0;

        for (Employee e : employees) {
            if (e.getContractType() == contractType) {
                sum = sum.add(e.salary());
                count++;
            }
        }

        if (count == 0) {
            return BigDecimal.ZERO;
        }

        return sum.divide(BigDecimal.valueOf(count), 2, RoundingMode.HALF_UP);
    }
}

public class Solution {
    public static void printBigDecimal(BigDecimal value) {
        if (value.compareTo(BigDecimal.ZERO) == 0) {
            System.out.println("0");
        } else {
            System.out.println(value.setScale(2, RoundingMode.HALF_UP));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String companyName = sc.next();
        int maxEmployees = sc.nextInt();

        BigDecimal permanentMinSalary = sc.nextBigDecimal();
        BigDecimal partTimeMinSalary = sc.nextBigDecimal();
        BigDecimal traineeMinSalary = sc.nextBigDecimal();

        Employee.setMinimalSalaryPerHour(
                permanentMinSalary,
                partTimeMinSalary,
                traineeMinSalary
        );

        String[] names = new String[6];
        for (int i = 0; i < names.length; i++) {
            names[i] = sc.next();
        }

        int[] workedHours = new int[6];
        for (int i = 0; i < workedHours.length; i++) {
            workedHours[i] = sc.nextInt();
        }

        ContractType[] contractTypes = new ContractType[6];
        for (int i = 0; i < contractTypes.length; i++) {
            contractTypes[i] = ContractType.valueOf(sc.next());
        }

        BigDecimal[] additionalSalaries = new BigDecimal[6];
        for (int i = 0; i < additionalSalaries.length; i++) {
            additionalSalaries[i] = sc.nextBigDecimal();
        }

        ContractType searchedContractType = ContractType.valueOf(sc.next());
        BigDecimal percent = sc.nextBigDecimal();

        Company company = new Company(companyName, maxEmployees);

        for (int i = 0; i < names.length; i++) {
            Employee employee = new Employee(
                    names[i],
                    String.valueOf(i + 1),
                    workedHours[i],
                    contractTypes[i],
                    additionalSalaries[i]
            );

            company.hireEmployee(employee);
        }

        printBigDecimal(company.averageSalary());

        company.increaseSalaries(percent);

        printBigDecimal(company.averageSalary());
        printBigDecimal(company.averageSalaryPerContractType(searchedContractType));
    }
}