// ========================= Patient.java =========================
package CaseStudy;
public class Patient 
{
    private int patientId;
    private String name;
    private int age;
    private String contactNumber;

    private Appointment[] appointments = new Appointment[10];
    private int count = 0;

    public Patient(int patientId, String name, int age, String contactNumber) 
    {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;
    }

    public void bookAppointment(Appointment appointment) 
    {
        if (count < appointments.length) 
        {
            appointments[count++] = appointment;
            System.out.println("Appointment booked for patient: " + name);
        } 
        else 
        {
            System.out.println("Appointment storage full.");
        }
    }

    public void viewAppointments() 
    {
        System.out.println("\nAppointments of Patient: " + name);

        if (count == 0) 
        {
            System.out.println("No appointments found.");
            return;
        }

        for (int i = 0; i < count; i++) 
        {
            System.out.println(appointments[i]);
        }
    }

    public void cancelAppointment(int appointmentId) 
    {
        for (int i = 0; i < count; i++) 
        {
            if (appointments[i].getAppointmentId() == appointmentId) 
            {
                appointments[i].cancelAppointment();
                System.out.println("Appointment cancelled successfully.");
                return;
            }
        }

        System.out.println("Appointment not found.");
    }

    public void updateDetails(String name, int age, String contactNumber) 
    {
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;

        System.out.println("Patient details updated.");
    }

    public int getPatientId() 
    {
        return patientId;
    }

    public String getName() 
    {
        return name;
    }
}
