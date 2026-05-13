package CaseStudy;
class MedicalRecord {

    private int recordId;

    private int patientId;

    private String diagnosis;

    private String prescription;

    public MedicalRecord(
            int recordId,
            int patientId,
            String diagnosis,
            String prescription) {

        this.recordId = recordId;

        this.patientId = patientId;

        this.diagnosis = diagnosis;

        this.prescription = prescription;
    }

    public void addRecord() {

        System.out.println("Medical record added.");
    }

    public void updateRecord(
            String diagnosis,
            String prescription) {

        this.diagnosis = diagnosis;

        this.prescription = prescription;

        System.out.println("Medical record updated.");
    }

    public void viewRecord() {

        System.out.println("\nDiagnosis: " + diagnosis);

        System.out.println("Prescription: " + prescription);
    }

    public void deleteRecord() {

        diagnosis = "";
        prescription = "";

        System.out.println("Medical record deleted.");
    }
}