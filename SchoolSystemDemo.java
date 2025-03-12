import java.util.ArrayList;
import java.util.List;

// Course class (Students can enroll in multiple courses)
class Course {
    private String courseName;
    private List<Student> enrolledStudents;

    public Course(String courseName) {
        this.courseName = courseName;
        this.enrolledStudents = new ArrayList<>();
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
        student.addCourse(this);
    }

    public void showEnrolledStudents() {
        System.out.println("\nCourse: " + courseName);
        if (enrolledStudents.isEmpty()) {
            System.out.println("No students enrolled.");
        } else {
            for (Student student : enrolledStudents) {
                System.out.println("Student: " + student.getName());
            }
        }
    }

    public String getCourseName() {
        return courseName;
    }
}

// Student class (Can enroll in multiple courses)
class Student {
    private String name;
    private List<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void showEnrolledCourses() {
        System.out.println("\nStudent: " + name);
        if (courses.isEmpty()) {
            System.out.println("No courses enrolled.");
        } else {
            for (Course course : courses) {
                System.out.println("Enrolled in: " + course.getCourseName());
            }
        }
    }

    public String getName() {
        return name;
    }
}

// School class (Aggregates multiple students)
class School {
    private String schoolName;
    private List<Student> students;

    public School(String schoolName) {
        this.schoolName = schoolName;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void showStudents() {
        System.out.println("\nSchool: " + schoolName);
        if (students.isEmpty()) {
            System.out.println("No students enrolled.");
        } else {
            for (Student student : students) {
                System.out.println("Student: " + student.getName());
            }
        }
    }
}

// Main class to demonstrate Association and Aggregation
public class SchoolSystemDemo {
    public static void main(String[] args) {
        // Creating a school
        School school = new School("Greenwood High");

        // Creating students
        Student alice = new Student("Alice");
        Student bob = new Student("Bob");

        // Adding students to the school (Aggregation)
        school.addStudent(alice);
        school.addStudent(bob);

        // Creating courses
        Course math = new Course("Mathematics");
        Course science = new Course("Science");

        // Enrolling students in courses (Association)
        math.enrollStudent(alice);
        math.enrollStudent(bob);
        science.enrollStudent(bob);

        // Displaying students in the school
        school.showStudents();

        // Displaying students enrolled in each course
        math.showEnrolledStudents();
        science.showEnrolledStudents();

        // Displaying courses each student is enrolled in
        alice.showEnrolledCourses();
        bob.showEnrolledCourses();
    }
}
