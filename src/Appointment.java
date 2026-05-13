package CaseStudy;
class Appointment {

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

    public int getAppointmentId() {
        return appointmentId;
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

    public void createAppointment() {

        System.out.println("Appointment created.");
    }

    public void cancelAppointment() {

        status = "Cancelled";
    }

    public void rescheduleAppointment(String newTime) {

        time = newTime;

        System.out.println("Appointment rescheduled.");
    }

    public boolean checkConflict() {

        return false;
    }

    @Override
    public String toString() {

        return "Appointment ID: "
                + appointmentId
                + ", Time: "
                + time
                + ", Status: "
                + status;
    }
}