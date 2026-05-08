//========================= Main.java =========================
package CaseStudy;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        HospitalSystem system = new HospitalSystem(1);

        Receptionist receptionist =
                new Receptionist(
                        301,
                        "Anu",
                        "8888888888"
                );

        // Doctor Creation
        System.out.println("=========== DOCTOR SETUP ===========");

        System.out.print("Enter Doctor ID: ");
        int doctorId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Doctor Name: ");
        String doctorName = sc.nextLine();

        System.out.print("Enter Specialization: ");
        String specialization = sc.nextLine();

        Doctor doctor =
                new Doctor(
                        doctorId,
                        doctorName,
                        specialization
                );

        // Add Slots
        System.out.print("\nEnter number of slots: ");
        int slotCount = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < slotCount; i++) {

            System.out.print("Enter Slot " + (i + 1) + ": ");
            String slot = sc.nextLine();

            doctor.setAvailability(slot);
        }

        // MULTIPLE PATIENTS
        Patient[] patients = new Patient[20];

        int patientCount = 0;

        int choice;

        do {

            System.out.println("\n=================================");
            System.out.println(" HOSPITAL APPOINTMENT SYSTEM");
            System.out.println("=================================");

            System.out.println("1. Add Patient");
            System.out.println("2. View Doctor Schedule");
            System.out.println("3. Book Appointment");
            System.out.println("4. View Patient Appointments");
            System.out.println("5. Cancel Appointment");
            System.out.println("6. Generate Report");
            System.out.println("7. Exit");

            System.out.print("\nEnter Choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    if (patientCount >= patients.length) {

                        System.out.println("Patient storage full.");
                        break;
                    }

                    System.out.println("\n====== ADD PATIENT ======");

                    System.out.print("Enter Patient ID: ");
                    int patientId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Patient Name: ");
                    String patientName = sc.nextLine();

                    System.out.print("Enter Patient Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Contact Number: ");
                    String contact = sc.nextLine();

                    patients[patientCount++] =
                            new Patient(
                                    patientId,
                                    patientName,
                                    age,
                                    contact
                            );

                    System.out.println("Patient added successfully.");

                    break;

                case 2:

                    doctor.viewSchedule();

                    break;

                case 3:

                    if (patientCount == 0) {

                        System.out.println("No patients available.");
                        break;
                    }

                    System.out.println("\nAvailable Patients:");

                    for (int i = 0; i < patientCount; i++) {

                        System.out.println(
                                patients[i].getPatientId()
                                + " - "
                                + patients[i].getName()
                        );
                    }

                    System.out.print("\nEnter Patient ID: ");

                    int selectedId = sc.nextInt();
                    sc.nextLine();

                    Patient selectedPatient = null;

                    for (int i = 0; i < patientCount; i++) {

                        if (patients[i].getPatientId() == selectedId) {

                            selectedPatient = patients[i];
                            break;
                        }
                    }

                    if (selectedPatient == null) {

                        System.out.println("Patient not found.");
                        break;
                    }

                    System.out.print("Enter Slot to Book: ");

                    String bookingSlot = sc.nextLine();

                    receptionist.scheduleAppointment(
                            system,
                            selectedPatient,
                            doctor,
                            bookingSlot
                    );

                    break;

                case 4:

                    System.out.print("\nEnter Patient ID: ");

                    int viewId = sc.nextInt();

                    for (int i = 0; i < patientCount; i++) {

                        if (patients[i].getPatientId() == viewId) {

                            patients[i].viewAppointments();
                        }
                    }

                    break;

                case 5:

                    System.out.print("\nEnter Patient ID: ");

                    int cancelPatientId = sc.nextInt();

                    System.out.print("Enter Appointment ID: ");

                    int appointmentId = sc.nextInt();

                    for (int i = 0; i < patientCount; i++) {

                        if (patients[i].getPatientId() == cancelPatientId) {

                            patients[i].cancelAppointment(
                                    appointmentId
                            );
                        }
                    }

                    break;

                case 6:

                    system.generateReports();

                    break;

                case 7:

                    System.out.println("\nExiting System...");
                    break;

                default:

                    System.out.println("Invalid choice.");
            }

        } while (choice != 7);

        sc.close();
    }
}
