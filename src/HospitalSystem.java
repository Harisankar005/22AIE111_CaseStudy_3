// ========================= HospitalSystem.java =========================
package CaseStudy;
public class HospitalSystem {

    private int systemId;

    private Appointment[] appointments = new Appointment[50];

    private int count = 0;
    private int appointmentCounter = 1;

    public HospitalSystem(int systemId) {
        this.systemId = systemId;
    }

    public boolean checkConflict(int doctorId, String slot) {

        for (int i = 0; i < count; i++) {

            if (appointments[i] != null &&
                appointments[i].getDoctorId() == doctorId &&
                appointments[i].getTime().equals(slot) &&
                !appointments[i].getStatus().equals("Cancelled")) {

                return true;
            }
        }

        return false;
    }

    public Appointment createAppointment(
            Patient patient,
            Doctor doctor,
            String slot) {

        System.out.println("\nChecking doctor availability...");

        if (!doctor.getSchedule().checkAvailability(slot)) {

            System.out.println("Slot unavailable.");
            return null;
        }

        // CHECK CONFLICT
        if (checkConflict(doctor.getDoctorId(), slot)) {

            System.out.println("Appointment conflict detected.");
            System.out.println("Another patient already booked this slot.");

            return null;
        }

        if (!doctor.confirmAppointment()) {

            System.out.println("Doctor rejected appointment.");
            return null;
        }

        Appointment appointment = new Appointment(
                appointmentCounter++,
                "2026-05-10",
                slot,
                "Confirmed",
                patient.getPatientId(),
                doctor.getDoctorId()
        );

        appointment.createAppointment();

        appointments[count++] = appointment;

        patient.bookAppointment(appointment);

        System.out.println("Appointment booked successfully.");

        return appointment;
    }

    public void generateReports() {

        System.out.println("\n========= HOSPITAL REPORT =========");

        System.out.println("Total Appointments: " + count);

        for (int i = 0; i < count; i++) {

            System.out.println(appointments[i]);
        }
    }

    public void managePatients() {
        System.out.println("Managing Patients...");
    }

    public void manageDoctors() {
        System.out.println("Managing Doctors...");
    }

    public void maintainRecords() {
        System.out.println("Maintaining Medical Records...");
    }
}
