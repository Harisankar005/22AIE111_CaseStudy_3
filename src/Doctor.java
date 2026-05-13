package CaseStudy;
class Doctor extends Person {

    private String specialization;

    private Schedule schedule;

    public Doctor(
            int id,
            String name,
            String contactNumber,
            String specialization) {

        super(id, name, contactNumber);

        this.specialization = specialization;

        this.schedule = new Schedule(id);
    }

    public String getSpecialization() {
        return specialization;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setAvailability(String slot) {

        schedule.addTimeSlot(slot);
    }

    public void updateAvailability(
            String oldSlot,
            String newSlot) {

        schedule.removeTimeSlot(oldSlot);

        schedule.addTimeSlot(newSlot);

        System.out.println("Doctor availability updated.");
    }

    public boolean confirmAppointment() {

        System.out.println("Doctor confirmed appointment.");

        return true;
    }

    public void viewSchedule() {

        System.out.println("\nSchedule of Dr. " + getName());

        schedule.showSlots();
    }

    @Override
    void displayRole() {

        System.out.println("Role: Doctor");
    }
}