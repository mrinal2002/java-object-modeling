import java.util.ArrayList;
import java.util.List;

// Patient class
class Patient {
    private String name;
    private List<Doctor> doctors;

    public Patient(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addDoctor(Doctor doctor) {
        if (!doctors.contains(doctor)) {
            doctors.add(doctor);
            doctor.addPatient(this); // Ensuring two-way association
        }
    }

    public void showDoctors() {
        System.out.println("Patient: " + name + " has consulted:");
        for (Doctor doctor : doctors) {
            System.out.println("- Dr. " + doctor.getName());
        }
    }
}

// Doctor class
class Doctor {
    private String name;
    private List<Patient> patients;

    public Doctor(String name) {
        this.name = name;
        this.patients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addPatient(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
            patient.addDoctor(this); // Ensuring two-way association
        }
    }

    // Communication method
    public void consult(Patient patient) {
        System.out.println("Dr. " + name + " is consulting Patient: " + patient.getName());
        addPatient(patient); // Establishing association
    }

    public void showPatients() {
        System.out.println("Dr. " + name + " has consulted:");
        for (Patient patient : patients) {
            System.out.println("- " + patient.getName());
        }
    }
}

// Hospital class
class Hospital {
    private String hospitalName;
    private List<Doctor> doctors;
    private List<Patient> patients;

    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void showHospitalDetails() {
        System.out.println("\nHospital: " + hospitalName);
        System.out.println("Doctors in the hospital:");
        for (Doctor doctor : doctors) {
            System.out.println("- Dr. " + doctor.getName());
        }

        System.out.println("Patients in the hospital:");
        for (Patient patient : patients) {
            System.out.println("- " + patient.getName());
        }
    }
}

// Main class to demonstrate association and communication
public class HospitalSystem {
    public static void main(String[] args) {
        // Creating a hospital
        Hospital hospital = new Hospital("City Medical Center");

        // Creating doctors
        Doctor doctor1 = new Doctor("John");
        Doctor doctor2 = new Doctor("Emily");

        // Creating patients
        Patient patient1 = new Patient("Alice");
        Patient patient2 = new Patient("Bob");

        // Adding doctors and patients to the hospital
        hospital.addDoctor(doctor1);
        hospital.addDoctor(doctor2);
        hospital.addPatient(patient1);
        hospital.addPatient(patient2);

        // Establishing doctor-patient consultations (Association)
        doctor1.consult(patient1);
        doctor2.consult(patient1);
        doctor2.consult(patient2);

        // Display hospital details
        hospital.showHospitalDetails();

        // Display doctors' patients
        doctor1.showPatients();
        doctor2.showPatients();

        // Display patients' doctors
        patient1.showDoctors();
        patient2.showDoctors();
    }
}
