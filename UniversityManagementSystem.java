import java.util.ArrayList;
import java.util.List;

// Course class
class Course {
    private String courseName;
    private Professor professor;
    private List<Student> enrolledStudents;

    public Course(String courseName) {
        this.courseName = courseName;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void assignProfessor(Professor professor) {
        this.professor = professor;
        System.out.println(professor.getName() + " has been assigned to teach " + courseName);
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
        System.out.println(student.getName() + " has enrolled in " + courseName);
    }

    public void showCourseDetails() {
        System.out.println("\nCourse: " + courseName);
        System.out.println("Professor: " + (professor != null ? professor.getName() : "Not Assigned"));
        System.out.println("Enrolled Students:");
        for (Student student : enrolledStudents) {
            System.out.println("- " + student.getName());
        }
    }
}

// Student class
class Student {
    private String name;
    private List<Course> enrolledCourses;

    public Student(String name) {
        this.name = name;
        this.enrolledCourses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void enrollCourse(Course course) {
        enrolledCourses.add(course);
        course.enrollStudent(this);
    }

    public void viewEnrolledCourses() {
        System.out.println("\nStudent: " + name + " is enrolled in:");
        for (Course course : enrolledCourses) {
            System.out.println("- " + course.getCourseName());
        }
    }
}

// Professor class
class Professor {
    private String name;
    private List<Course> assignedCourses;

    public Professor(String name) {
        this.name = name;
        this.assignedCourses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void assignCourse(Course course) {
        assignedCourses.add(course);
        course.assignProfessor(this);
    }

    public void viewAssignedCourses() {
        System.out.println("\nProfessor: " + name + " teaches:");
        for (Course course : assignedCourses) {
            System.out.println("- " + course.getCourseName());
        }
    }
}

// University Management System Simulation
public class UniversityManagementSystem {
    public static void main(String[] args) {
        // Creating courses
        Course math = new Course("Mathematics");
        Course cs = new Course("Computer Science");

        // Creating students
        Student alice = new Student("Alice");
        Student bob = new Student("Bob");

        // Creating professors
        Professor drSmith = new Professor("Dr. Smith");
        Professor drJohnson = new Professor("Dr. Johnson");

        // Assigning professors to courses
        drSmith.assignCourse(math);
        drJohnson.assignCourse(cs);

        // Enrolling students in courses
        alice.enrollCourse(math);
        alice.enrollCourse(cs);
        bob.enrollCourse(cs);

        // Viewing enrolled courses of students
        alice.viewEnrolledCourses();
        bob.viewEnrolledCourses();

        // Viewing assigned courses of professors
        drSmith.viewAssignedCourses();
        drJohnson.viewAssignedCourses();

        // Displaying course details
        math.showCourseDetails();
        cs.showCourseDetails();
    }
}
