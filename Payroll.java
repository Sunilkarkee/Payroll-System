
import java.util.ArrayList;

abstract class Employee {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employee [name = " + name + ", id =" + id + ", salary =" + calculateSalary() + "]";
    }

}

class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }

}

class PartTimeEmployee extends Employee {
    private int workingHours;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int workingHours, double hourlyRate) {
        super(name, id);
        this.hourlyRate = hourlyRate;
        this.workingHours = workingHours;
    }

    @Override
    public double calculateSalary() {
        return workingHours * hourlyRate;
    }

}

class PayrollSystem {
    private ArrayList<Employee> employeeList;

    public PayrollSystem() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void removeEmployee(int id) {
        Employee employeeToRemove = null;
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {

                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null) {
            employeeList.remove(employeeToRemove);
        }

    }

    public void displayEmployees() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
}

public class Payroll {
    public static void main(String[] args) {
        PayrollSystem payrollsystem = new PayrollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee("Ramesh", 232, 80000);
        PartTimeEmployee emp2 = new PartTimeEmployee("Raakesh", 2444, 4, 600);
        payrollsystem.addEmployee(emp1);
        payrollsystem.addEmployee(emp2);
        payrollsystem.displayEmployees();

    }

}
