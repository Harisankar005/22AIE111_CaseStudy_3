//========================= Main.java =========================
package CaseStudy;
public class Main 
{
	 public static void main(String[] args) 
	 {
	
	     HospitalSystem system = new HospitalSystem(1);
	
	     Patient patient = new Patient(
	             101,
	             "Harisankar",
	             20,
	             "9999999999"
	     );
	
	     Doctor doctor = new Doctor(
	             201,
	             "Dr. Kumar",
	             "Cardiology"
	     );
	
	     doctor.setAvailability("10:00 AM");
	     doctor.setAvailability("11:00 AM");
	
	     doctor.viewSchedule();
	
	     doctor.updateAvailability("11:00 AM", "12:00 PM");
	
	     doctor.viewSchedule();
	
	     Receptionist receptionist = new Receptionist(
	             301,
	             "Anu",
	             "8888888888"
	     );
	
	     receptionist.manageAppointments();
	     receptionist.updateSchedule();
	
	     Appointment appointment = receptionist.scheduleAppointment(
	             system,
	             patient,
	             doctor,
	             "10:00 AM"
	     );
	
	     patient.viewAppointments();
	
	     if (appointment != null) {
	         appointment.rescheduleAppointment("12:00 PM");
	     }
	
	     patient.viewAppointments();
	
	     patient.cancelAppointment(1);
	
	     patient.viewAppointments();
	
	     patient.updateDetails(
	             "Harisankar B",
	             21,
	             "9876543210"
	     );
	
	     MedicalRecord record = new MedicalRecord(
	             401,
	             patient.getPatientId(),
	             "Fever",
	             "Paracetamol"
	     );
	
	     record.addRecord();
	     record.viewRecord();
	
	     record.updateRecord(
	             "Viral Fever",
	             "Antibiotics"
	     );
	
	     record.viewRecord();
	
	     record.deleteRecord();
	
	     system.managePatients();
	     system.manageDoctors();
	     system.maintainRecords();
	     system.generateReports();
	 }
}
