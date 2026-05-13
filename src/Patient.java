class Patient extends Person {

    private int age;

    private Appointment[] appointments = new Appointment[10];
    private int appointmentCount = 0;

    public Patient(int id, String name, int age, String contactNumber) {

        super(id, name, contactNumber);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void updateDetails(String name, int age, String contact) {

        setName(name);
        this.age = age;
        setContactNumber(contact);

        System.out.println("Patient details updated.");
    }

    public void bookAppointment(Appointment appointment) {

        if (appointmentCount < appointments.length) {

            appointments[appointmentCount++] = appointment;

            System.out.println("Appointment added successfully.");
        }
    }

    public void viewAppointments() {

        System.out.println("\nAppointments of " + getName());

        if (appointmentCount == 0) {

            System.out.println("No appointments found.");
            return;
        }

        for (int i = 0; i < appointmentCount; i++) {

            System.out.println(appointments[i]);
        }
    }

    public void cancelAppointment(int appointmentId) {

        for (int i = 0; i < appointmentCount; i++) {

            if (appointments[i].getAppointmentId() == appointmentId) {

                appointments[i].cancelAppointment();

                System.out.println("Appointment cancelled.");
                return;
            }
        }

        System.out.println("Appointment not found.");
    }

    @Override
    void displayRole() {

        System.out.println("Role: Patient");
    }
}
