package CaseStudy;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        HospitalSystem system =
                new HospitalSystem(1);

        Receptionist receptionist =
                new Receptionist(
                        100,
                        "Anu",
                        "9999999999"
                );

        Doctor[] doctors = new Doctor[10];

        int doctorCount = 0;

        Patient[] patients = new Patient[20];

        int patientCount = 0;

        int choice;

        do {

            System.out.println("\n================================");

            System.out.println(" HOSPITAL MANAGEMENT SYSTEM");

            System.out.println("================================");

            System.out.println("1. Add Doctor");

            System.out.println("2. Add Patient");

            System.out.println("3. View Doctors");

            System.out.println("4. Book Appointment");

            System.out.println("5. View Patient Appointments");

            System.out.println("6. Cancel Appointment");

            System.out.println("7. Add Medical Record");

            System.out.println("8. Generate Report");

            System.out.println("9. Exit");

            System.out.print("\nEnter choice: ");

            choice = sc.nextInt();

            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.println("\n===== ADD DOCTOR =====");

                    System.out.print("Enter Doctor ID: ");
                    int doctorId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Doctor Name: ");
                    String doctorName = sc.nextLine();

                    System.out.print("Enter Contact Number: ");
                    String doctorContact = sc.nextLine();

                    System.out.print("Enter Specialization: ");
                    String specialization = sc.nextLine();

                    doctors[doctorCount] =
                            new Doctor(
                                    doctorId,
                                    doctorName,
                                    doctorContact,
                                    specialization
                            );

                    System.out.print("Enter number of slots: ");

                    int slotCount = sc.nextInt();

                    sc.nextLine();

                    for (int i = 0; i < slotCount; i++) {

                        System.out.print(
                                "Enter slot "
                                        + (i + 1)
                                        + ": "
                        );

                        String slot = sc.nextLine();

                        doctors[doctorCount]
                                .setAvailability(slot);
                    }

                    doctorCount++;

                    System.out.println("Doctor added successfully.");

                    break;

                case 2:

                    System.out.println("\n===== ADD PATIENT =====");

                    System.out.print("Enter Patient ID: ");
                    int patientId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Patient Name: ");
                    String patientName = sc.nextLine();

                    System.out.print("Enter Patient Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Contact Number: ");
                    String patientContact = sc.nextLine();

                    patients[patientCount++] =
                            new Patient(
                                    patientId,
                                    patientName,
                                    age,
                                    patientContact
                            );

                    System.out.println("Patient added.");

                    break;

                case 3:

                    System.out.println("\n===== DOCTORS =====");

                    for (int i = 0; i < doctorCount; i++) {

                        System.out.println(
                                doctors[i].getId()
                                        + " - Dr. "
                                        + doctors[i].getName()
                                        + " ("
                                        + doctors[i].getSpecialization()
                                        + ")"
                        );
                    }

                    break;

                case 4:

                    if (doctorCount == 0 ||
                            patientCount == 0) {

                        System.out.println(
                                "Add doctors and patients first."
                        );

                        break;
                    }

                    System.out.println("\n===== AVAILABLE DOCTORS =====");

                    for (int i = 0; i < doctorCount; i++) {

                        System.out.println(
                                doctors[i].getId()
                                        + " - Dr. "
                                        + doctors[i].getName()
                        );
                    }

                    System.out.print(
                            "\nEnter Doctor ID: "
                    );

                    int selectedDoctorId =
                            sc.nextInt();

                    sc.nextLine();

                    Doctor selectedDoctor = null;

                    for (int i = 0; i < doctorCount; i++) {

                        if (doctors[i].getId()
                                == selectedDoctorId) {

                            selectedDoctor =
                                    doctors[i];
                        }
                    }

                    if (selectedDoctor == null) {

                        System.out.println(
                                "Doctor not found."
                        );

                        break;
                    }

                    // SHOW SLOTS
                    System.out.println(
                            "\nAvailable Slots:"
                    );

                    selectedDoctor.viewSchedule();

                    System.out.println(
                            "\n===== AVAILABLE PATIENTS ====="
                    );

                    for (int i = 0; i < patientCount; i++) {

                        System.out.println(
                                patients[i].getId()
                                        + " - "
                                        + patients[i].getName()
                        );
                    }

                    System.out.print(
                            "\nEnter Patient ID: "
                    );

                    int selectedPatientId =
                            sc.nextInt();

                    sc.nextLine();

                    Patient selectedPatient = null;

                    for (int i = 0; i < patientCount; i++) {

                        if (patients[i].getId()
                                == selectedPatientId) {

                            selectedPatient =
                                    patients[i];
                        }
                    }

                    if (selectedPatient == null) {

                        System.out.println(
                                "Patient not found."
                        );

                        break;
                    }

                    System.out.print(
                            "Enter slot to book: "
                    );

                    String bookingSlot =
                            sc.nextLine();

                    receptionist.scheduleAppointment(
                            system,
                            selectedPatient,
                            selectedDoctor,
                            bookingSlot
                    );

                    break;

                case 5:

                    System.out.print(
                            "Enter Patient ID: "
                    );

                    int viewId = sc.nextInt();

                    for (int i = 0; i < patientCount; i++) {

                        if (patients[i].getId()
                                == viewId) {

                            patients[i]
                                    .viewAppointments();
                        }
                    }

                    break;

                case 6:

                    System.out.print(
                            "Enter Patient ID: "
                    );

                    int cancelPatientId =
                            sc.nextInt();

                    System.out.print(
                            "Enter Appointment ID: "
                    );

                    int appointmentId =
                            sc.nextInt();

                    for (int i = 0; i < patientCount; i++) {

                        if (patients[i].getId()
                                == cancelPatientId) {

                            patients[i]
                                    .cancelAppointment(
                                            appointmentId
                                    );
                        }
                    }

                    break;

                case 7:

                    System.out.print(
                            "Enter Record ID: "
                    );

                    int recordId = sc.nextInt();

                    sc.nextLine();

                    System.out.print(
                            "Enter Patient ID: "
                    );

                    int recordPatientId =
                            sc.nextInt();

                    sc.nextLine();

                    System.out.print(
                            "Enter Diagnosis: "
                    );

                    String diagnosis =
                            sc.nextLine();

                    System.out.print(
                            "Enter Prescription: "
                    );

                    String prescription =
                            sc.nextLine();

                    MedicalRecord record =
                            new MedicalRecord(
                                    recordId,
                                    recordPatientId,
                                    diagnosis,
                                    prescription
                            );

                    record.addRecord();

                    record.viewRecord();

                    break;

                case 8:

                    system.generateReports();

                    break;

                case 9:

                    System.out.println(
                            "Exiting System..."
                    );

                    break;

                default:

                    System.out.println(
                            "Invalid choice."
                    );
            }

        } while (choice != 9);

        sc.close();
    }
}
