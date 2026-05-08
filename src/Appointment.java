// ========================= Appointment.java =========================
package CaseStudy;
public class Appointment 
{
    private int appointmentId;
    private String date;
    private String time;
    private String status;

    private int patientId;
    private int doctorId;

    public Appointment(
            int appointmentId,
            String date,
            String time,
            String status,
            int patientId,
            int doctorId) {

        this.appointmentId = appointmentId;
        this.date = date;
        this.time = time;
        this.status = status;
        this.patientId = patientId;
        this.doctorId = doctorId;
    }

    public void createAppointment() 
    {
        System.out.println("Appointment created successfully.");
    }

    public void cancelAppointment() 
    {
        status = "Cancelled";
    }

    public void rescheduleAppointment(String newTime) 
    {
        this.time = newTime;
        System.out.println("Appointment rescheduled to " + newTime);
    }

    public boolean checkConflict() 
    {
        System.out.println("Checking appointment conflict...");
        return false;
    }

    public int getAppointmentId() 
    {
        return appointmentId;
    }

    @Override
    public String toString() 
    {
        return "Appointment ID: " + appointmentId +
                ", Date: " + date +
                ", Time: " + time +
                ", Status: " + status;
    }
    public int getDoctorId() {
        return doctorId;
    }

    public String getTime() {
        return time;
    }

    public String getStatus() {
        return status;
    }
}
