import java.util.ArrayList;

public class Bedroom {
    private int number;
    private int capacity;
    private ArrayList<Guest> guests;
    private String type;
    private int rate;
    private boolean status;

    public Bedroom(int number, int capacity, String type, int rate){
        this.number = number;
        this.capacity = capacity;
        this.type = type;
        this.guests = new ArrayList<>();
        this.rate = rate;
        this.status = true;
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

    public int createBill(Booking booking){
        int bill = booking.getNights() * this.rate;
        return bill;
    }

    public void changeStatus() {
        if (this.status == true){
            this.status = false;
        }
        else {
            this.status = true;
        }
    }

    public boolean checkStatus() {
        return this.status;
    }
}
