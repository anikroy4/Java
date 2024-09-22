import java.util.ArrayList;
import java.util.Scanner;

abstract class Employee {
    private String Name;
    private String ID;

    public Employee(String Name, String ID) {
        this.Name = Name;
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public String getId() {
        return ID;
    }

    public abstract double calculateSalary();
}

class SalariedEmployee extends Employee {
    private double MonthlySalary;

    public SalariedEmployee(String Name, String ID, double monthlySalary) {
        super(Name, ID);
        this.MonthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return MonthlySalary;
    }
}

class HourlySalariedEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public HourlySalariedEmployee(String name, String id, double hourlyRate, int hoursWorked) {
        super(name, id);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}

class CommissionedEmployee extends Employee {
    private double baseSalary;
    private double commission;

    public CommissionedEmployee(String name, String id, double baseSalary, double commission) {
        super(name, id);
        this.baseSalary = baseSalary;
        this.commission = commission;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + commission;
    }
}

class EmployeeRecordSystem {
    private ArrayList<Employee> Employees;

    public EmployeeRecordSystem() {
        Employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        Employees.add(employee);
    }

    public void displayEmployeeInfo(String id) {
        for (Employee employee : Employees) {
            if (employee.getId().equals(id)) {
                System.out.println("Name: " + employee.getName() + ", ID: " + employee.getId() + ", Salary: " + employee.calculateSalary());
                return;
            }
        }
        System.out.println("Employee not found.");
    }
}

public class EmployeeRecordApp {
    public static void main(String[] args) {
        EmployeeRecordSystem employeeSystem = new EmployeeRecordSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Employee\n2. View Employee\n3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter employee type (1: Salaried, 2: Hourly, 3: Commissioned): ");
                    int type = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("ID: ");
                    String id = scanner.nextLine();
                    if (type == 1) {
                        System.out.print("Monthly Salary: ");
                        double salary = scanner.nextDouble();
                        employeeSystem.addEmployee(new SalariedEmployee(name, id, salary));
                    } else if (type == 2) {
                        System.out.print("Hourly Rate: ");
                        double rate = scanner.nextDouble();
                        System.out.print("Hours Worked: ");
                        int hours = scanner.nextInt();
                        employeeSystem.addEmployee(new HourlySalariedEmployee(name, id, rate, hours));
                    } else if (type == 3) {
                        System.out.print("Base Salary: ");
                        double base = scanner.nextDouble();
                        System.out.print("Commission: ");
                        double commission = scanner.nextDouble();
                        employeeSystem.addEmployee(new CommissionedEmployee(name, id, base, commission));
                    } else {
                        System.out.println("Invalid type.");
                    }
                    break;
                case 2:
                    System.out.print("Enter employee ID to view: ");
                    String viewId = scanner.nextLine();
                    employeeSystem.displayEmployeeInfo(viewId);
                    break;
                case 3:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
