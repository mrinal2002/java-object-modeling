import java.util.ArrayList;
import java.util.List;

// Employee class (Exists within a Department)
class Employee {
    private String name;
    private String position;

    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', position='" + position + "'}";
    }
}

// Department class (Exists within a Company)
class Department {
    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(String name, String position) {
        employees.add(new Employee(name, position));
    }

    public void showEmployees() {
        System.out.println("\nDepartment: " + name);
        if (employees.isEmpty()) {
            System.out.println("No employees in this department.");
        } else {
            for (Employee emp : employees) {
                System.out.println(emp);
            }
        }
    }
}

// Company class (Contains Departments and Employees)
class Company {
    private String name;
    private List<Department> departments;

    public Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public void showCompanyDetails() {
        System.out.println("\nCompany: " + name);
        for (Department dept : departments) {
            dept.showEmployees();
        }
    }

    // When Company object is deleted, Departments and Employees are also removed
    public void closeCompany() {
        System.out.println("\nClosing company: " + name);
        departments.clear();  // All departments and employees are removed
        System.out.println("All departments and employees have been removed.");
    }
}

// Main class to demonstrate Composition
public class CompanyCompositionDemo {
    public static void main(String[] args) {
        // Creating a company
        Company techCompany = new Company("Tech Innovators");

        // Creating departments
        Department itDept = new Department("IT");
        Department hrDept = new Department("HR");

        // Adding employees to departments
        itDept.addEmployee("Alice", "Software Engineer");
        itDept.addEmployee("Bob", "System Administrator");
        hrDept.addEmployee("Charlie", "HR Manager");
        hrDept.addEmployee("David", "Recruiter");

        // Adding departments to company
        techCompany.addDepartment(itDept);
        techCompany.addDepartment(hrDept);

        // Displaying company structure
        techCompany.showCompanyDetails();

        // Deleting the company (Removes all associated departments and employees)
        techCompany.closeCompany();
    }
}
