import java.util.ArrayList;

public class Dining {

    private int capacity;
    private String type;
    private ArrayList<Guest> guests;

    public Dining(int capacity, String type) {
        this.capacity = capacity;
        this.type = type;
        this.guests = new ArrayList<>();
    }
    public int guestCount() {
        return this.guests.size();
    }

    public void addGuest(Guest guest) {
        if(this.guestCount() < this.capacity) {
            this.guests.add(guest);
        }else{
            System.out.println("Sorry room full");
        }
    }

    public void checkOutGuest(Guest guest) {
        this.guests.remove(guest);
    }
}// class end
