import java.util.ArrayList;

public class Function {
    private int capacity;
    private String name;
    private ArrayList<Guest> guests;

    public Function(int capacity, String name) {

        this.capacity = capacity;
        this.name = name;
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
} // class end
