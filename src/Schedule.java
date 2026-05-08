// ========================= Schedule.java =========================
package CaseStudy;
public class Schedule 
{

    private int doctorId;

    private String[] availableSlots = new String[10];
    private int count = 0;

    public Schedule(int doctorId) 
    {
        this.doctorId = doctorId;
    }

    public void addTimeSlot(String slot) 
    {
        if (count < availableSlots.length) 
        {
            availableSlots[count++] = slot;
            System.out.println("Time slot added: " + slot);
        } 
        else 
        {
            System.out.println("Schedule is full.");
        }
    }

    public void removeTimeSlot(String slot) 
    {

        for (int i = 0; i < count; i++) 
        {

            if (availableSlots[i].equals(slot)) 
            {

                for (int j = i; j < count - 1; j++) 
                {
                    availableSlots[j] = availableSlots[j + 1];
                }

                count--;

                System.out.println("Time slot removed: " + slot);
                return;
            }
        }

        System.out.println("Slot not found.");
    }

    public boolean checkAvailability(String slot) 
    {

        for (int i = 0; i < count; i++) 
        {

            if (availableSlots[i].equals(slot)) 
            {
                System.out.println("Slot available.");
                return true;
            }
        }

        System.out.println("Slot unavailable.");
        return false;
    }

    public void showSlots() 
    {

        if (count == 0) 
        {
            System.out.println("No available slots.");
            return;
        }

        for (int i = 0; i < count; i++) 
        {
            System.out.println(availableSlots[i]);
        }
    }
}
