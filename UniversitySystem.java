import java.util.ArrayList;
import java.util.List;

// Faculty class (Aggregation: Faculty can exist independently of University)
class Faculty {
    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Department class (Composition: Exists only within a University)
class Department {
    private String departmentName;

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }
}

// University class (Composes Departments, Aggregates Faculty)
class University {
    private String universityName;
    private List<Department> departments;
    private List<Faculty> facultyMembers;

    public University(String universityName) {
        this.universityName = universityName;
        this.departments = new ArrayList<>();
        this.facultyMembers = new ArrayList<>();
    }

    // Composition: University owns Departments
    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }

    // Aggregation: University associates with Faculty, but they exist independently
    public void addFaculty(Faculty faculty) {
        facultyMembers.add(faculty);
    }

    public void showDetails() {
        System.out.println("\nUniversity: " + universityName);

        System.out.println("Departments:");
        if (departments.isEmpty()) {
            System.out.println("No departments available.");
        } else {
            for (Department dept : departments) {
                System.out.println("- " + dept.getDepartmentName());
            }
        }

        System.out.println("Faculty Members:");
        if (facultyMembers.isEmpty()) {
            System.out.println("No faculty members available.");
        } else {
            for (Faculty faculty : facultyMembers) {
                System.out.println("- " + faculty.getName());
            }
        }
    }

    // When University is deleted, Departments are also deleted (Composition)
    public void closeUniversity() {
        System.out.println("\nClosing " + universityName + "... All departments are deleted.");
        departments.clear();
    }
}

// Main class to demonstrate Composition and Aggregation
public class UniversitySystem {
    public static void main(String[] args) {
        // Creating a university
        University university = new University("Global Tech University");

        // Adding departments (Composition)
        university.addDepartment("Computer Science");
        university.addDepartment("Mechanical Engineering");

        // Creating faculty members (Aggregation: They can exist independently)
        Faculty profJohn = new Faculty("Prof. John");
        Faculty profEmily = new Faculty("Prof. Emily");

        // Adding faculty members to the university
        university.addFaculty(profJohn);
        university.addFaculty(profEmily);

        // Display university details
        university.showDetails();

        // Closing the university (Composition: Departments will be deleted)
        university.closeUniversity();

        // Display updated university details
        university.showDetails();
    }
}
