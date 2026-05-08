//========================= Main.java =========================
package CaseStudy;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Create Hospital System
        HospitalSystem system = new HospitalSystem(1);

        // Fixed Receptionist
        Receptionist receptionist = new Receptionist(
                301,
                "Anu",
                "8888888888"
        );

        // Input Doctor Details
        System.out.println("======================================");
        System.out.println(" HOSPITAL APPOINTMENT MANAGEMENT");
        System.out.println("======================================");

        System.out.print("\nEnter Doctor ID: ");
        int doctorId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Doctor Name: ");
        String doctorName = sc.nextLine();

        System.out.print("Enter Doctor Specialization: ");
        String specialization = sc.nextLine();

        Doctor doctor = new Doctor(
                doctorId,
                doctorName,
                specialization
        );

        // Add Doctor Availability
        System.out.print("\nHow many available slots to add? ");
        int slotCount = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < slotCount; i++) {

            System.out.print("Enter Slot " + (i + 1) + ": ");
            String slot = sc.nextLine();

            doctor.setAvailability(slot);
        }

        // Input Patient Details
        System.out.println("\n========== ENTER PATIENT DETAILS ==========");

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

        Patient patient = new Patient(
                patientId,
                patientName,
                age,
                contact
        );

        int choice;

        do {

            System.out.println("\n======================================");
            System.out.println("               MENU");
            System.out.println("======================================");

            System.out.println("1. View Doctor Schedule");
            System.out.println("2. Book Appointment");
            System.out.println("3. View Appointments");
            System.out.println("4. Cancel Appointment");
            System.out.println("5. Update Patient Details");
            System.out.println("6. Add Medical Record");
            System.out.println("7. Generate Hospital Report");
            System.out.println("8. Exit");

            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    doctor.viewSchedule();
                    break;

                case 2:

                    System.out.print("\nEnter Slot to Book: ");
                    String bookingSlot = sc.nextLine();

                    receptionist.scheduleAppointment(
                            system,
                            patient,
                            doctor,
                            bookingSlot
                    );

                    break;

                case 3:

                    patient.viewAppointments();
                    break;

                case 4:

                    System.out.print("\nEnter Appointment ID to Cancel: ");
                    int cancelId = sc.nextInt();

                    patient.cancelAppointment(cancelId);
                    break;

                case 5:

                    System.out.print("\nEnter New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Age: ");
                    int newAge = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Contact Number: ");
                    String newContact = sc.nextLine();

                    patient.updateDetails(
                            newName,
                            newAge,
                            newContact
                    );

                    break;

                case 6:

                    System.out.println("\n====== ADD MEDICAL RECORD ======");

                    System.out.print("Enter Record ID: ");
                    int recordId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Diagnosis: ");
                    String diagnosis = sc.nextLine();

                    System.out.print("Enter Prescription: ");
                    String prescription = sc.nextLine();

                    MedicalRecord record = new MedicalRecord(
                            recordId,
                            patient.getPatientId(),
                            diagnosis,
                            prescription
                    );

                    record.addRecord();
                    record.viewRecord();

                    break;

                case 7:

                    system.managePatients();
                    system.manageDoctors();
                    system.maintainRecords();
                    system.generateReports();

                    break;

                case 8:

                    System.out.println("\nExiting System...");
                    System.out.println("Thank you.");
                    break;

                default:

                    System.out.println("\nInvalid choice.");
            }

        } while (choice != 8);

        sc.close();
    }
}
