package CaseStudy;
class Schedule {

    private int doctorId;

    private String[] availableSlots = new String[10];

    private int count = 0;

    public Schedule(int doctorId) {

        this.doctorId = doctorId;
    }

    public void addTimeSlot(String slot) {

        if (count < availableSlots.length) {

            availableSlots[count++] = slot;

            System.out.println("Slot added: " + slot);
        }
    }

    public void removeTimeSlot(String slot) {

        for (int i = 0; i < count; i++) {

            if (availableSlots[i].equals(slot)) {

                for (int j = i; j < count - 1; j++) {

                    availableSlots[j] = availableSlots[j + 1];
                }

                count--;

                System.out.println("Slot removed.");
                return;
            }
        }
    }

    public boolean checkAvailability(String slot) {

        for (int i = 0; i < count; i++) {

            if (availableSlots[i].equals(slot)) {

                return true;
            }
        }

        return false;
    }

    public void showSlots() {

        for (int i = 0; i < count; i++) {

            System.out.println((i + 1) + ". " + availableSlots[i]);
        }
    }
}