package CaseStudy;
class HospitalSystem {

    private int systemId;

    private Appointment[] appointments =
            new Appointment[50];

    private int appointmentCount = 0;

    private int appointmentCounter = 1;

    public HospitalSystem(int systemId) {

        this.systemId = systemId;
    }

    public boolean checkConflict(
            int doctorId,
            String slot) {

        for (int i = 0; i < appointmentCount; i++) {

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

        if (!doctor.getSchedule().checkAvailability(slot)) {

            System.out.println("Slot unavailable.");

            return null;
        }

        if (checkConflict(
                doctor.getId(),
                slot)) {

            System.out.println("Appointment conflict detected.");

            return null;
        }

        if (!doctor.confirmAppointment()) {

            return null;
        }

        Appointment appointment =
                new Appointment(
                        appointmentCounter++,
                        "2026-05-10",
                        slot,
                        "Confirmed",
                        patient.getId(),
                        doctor.getId()
                );

        appointments[appointmentCount++] =
                appointment;

        patient.bookAppointment(appointment);

        appointment.createAppointment();

        return appointment;
    }

    public void generateReports() {

        System.out.println("\n===== REPORT =====");

        for (int i = 0; i < appointmentCount; i++) {

            System.out.println(appointments[i]);
        }
    }

    public void managePatients() {

        System.out.println("Managing patients...");
    }

    public void manageDoctors() {

        System.out.println("Managing doctors...");
    }

    public void maintainRecords() {

        System.out.println("Maintaining records...");
    }
}