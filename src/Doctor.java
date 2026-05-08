// ========================= Doctor.java =========================
package CaseStudy;
public class Doctor 
{
    private int doctorId;
    private String name;
    private String specialization;

    private Schedule schedule;

    public Doctor(int doctorId, String name, String specialization) 
    {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;

        this.schedule = new Schedule(doctorId);
    }

    public void setAvailability(String slot) 
    {
        schedule.addTimeSlot(slot);
        System.out.println("Doctor availability added: " + slot);
    }

    public boolean confirmAppointment() {
        System.out.println("Doctor " + name + " confirmed the appointment.");
        return true;
    }

    public void viewSchedule() 
    {
        System.out.println("\nSchedule of Doctor: " + name);
        schedule.showSlots();
    }

    public void updateAvailability(String oldSlot, String newSlot) 
    {
        schedule.removeTimeSlot(oldSlot);
        schedule.addTimeSlot(newSlot);

        System.out.println("Availability updated.");
    }

    public Schedule getSchedule() 
    {
        return schedule;
    }

    public int getDoctorId() 
    {
        return doctorId;
    }

    public String getName() 
    {
        return name;
    }
}
