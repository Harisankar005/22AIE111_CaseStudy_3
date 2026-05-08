// ========================= Receptionist.java =========================
package CaseStudy;
public class Receptionist 
{
    private int receptionistId;
    private String name;
    private String contactNumber;

    public Receptionist(int receptionistId, String name, String contactNumber) 
    {
        this.receptionistId = receptionistId;
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public Appointment scheduleAppointment(
            HospitalSystem system,
            Patient patient,
            Doctor doctor,
            String slot) {

        System.out.println("\nReceptionist is scheduling appointment...");
        return system.createAppointment(patient, doctor, slot);
    }

    public void manageAppointments() 
    {
        System.out.println("Receptionist is managing appointments.");
    }

    public void updateSchedule() 
    {
        System.out.println("Receptionist updated the schedule.");
    }
}
