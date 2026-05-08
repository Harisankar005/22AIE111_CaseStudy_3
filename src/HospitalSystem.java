// ========================= HospitalSystem.java =========================
package CaseStudy;
public class HospitalSystem 
{

    private int systemId;

    private Appointment[] appointments = new Appointment[50];

    private int count = 0;
    private int appointmentCounter = 1;

    public HospitalSystem(int systemId) 
    {
        this.systemId = systemId;
    }

    public Appointment createAppointment(
            Patient patient,
            Doctor doctor,
            String slot) {

        System.out.println("\nChecking doctor availability...");

        if (!doctor.getSchedule().checkAvailability(slot)) 
        {
            System.out.println("Appointment booking failed.");
            return null;
        }

        if (!doctor.confirmAppointment()) 
        {
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

        if (count < appointments.length) 
        {
            appointments[count++] = appointment;
        }

        patient.bookAppointment(appointment);

        System.out.println("Appointment stored in Hospital System.");

        return appointment;
    }

    public void managePatients() 
    {
        System.out.println("Managing patient information...");
    }

    public void manageDoctors() 
    {
        System.out.println("Managing doctor information...");
    }

    public void generateReports() 
    {
        System.out.println("\nGenerating Hospital Report...");
        System.out.println("Total Appointments: " + count);
    }

    public void maintainRecords() 
    {
        System.out.println("Maintaining medical records...");
    }
}
