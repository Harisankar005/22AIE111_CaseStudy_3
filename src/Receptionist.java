package CaseStudy;
class Receptionist extends Person {

    public Receptionist(
            int id,
            String name,
            String contactNumber) {

        super(id, name, contactNumber);
    }

    public Appointment scheduleAppointment(
            HospitalSystem system,
            Patient patient,
            Doctor doctor,
            String slot) {

        return system.createAppointment(
                patient,
                doctor,
                slot
        );
    }

    public void manageAppointments() {

        System.out.println("Managing appointments...");
    }

    public void updateSchedule() {

        System.out.println("Schedule updated.");
    }

    @Override
    void displayRole() {

        System.out.println("Role: Receptionist");
    }
}