import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HotelTest {
    Hotel hotel;
    Bedroom room1;
    Bedroom room2;
    Function roomA;
    Function roomB;
    Dining cafe;
    Dining bistro;
    Guest guest1;
    Guest guest2;
    Guest guest3;

    @Before
    public void before(){
        hotel = new Hotel("Marriott", 500);
        room1 = new Bedroom(1, 2, "Double", 80);
        room2 = new Bedroom(2, 1, "Single", 60);
        roomA = new Function(3, "A");
        roomB = new Function(5, "B");
        cafe = new Dining(5, "Cafe");
        bistro = new Dining(10, "Bistro");
        guest1 = new Guest("Thomas", 3000);
        guest2 = new Guest("Oksana", 5000);
        guest3 = new Guest("Jackie", 5000);
    }

    @Test
    public void hotelHasRooms(){
        hotel.addBedroom(room1);
        hotel.addBedroom(room2);
        hotel.addFunctionRoom(roomA);
        hotel.addFunctionRoom(roomB);
        hotel.addDiningRoom(cafe);
        hotel.addDiningRoom(bistro);
        assertEquals(6, hotel.totalRooms());
    }

    @Test
    public void checkGuestIn(){
        hotel.checkIn(guest1, bistro);
        assertEquals(1, bistro.guestCount());

    }

    @Test
    public void checkGuestInBedroom(){
        hotel.checkIn(guest1, room1);
        assertEquals(1, room1.guestCount());
    }

    @Test
    public void checkGuestInFunction(){
        hotel.checkIn(guest1, roomA);
        assertEquals(1, roomA.guestCount());
    }

    @Test
    public void capacityLimitTest(){
        hotel.checkIn(guest1, room1);
        hotel.checkIn(guest2, room1);
        hotel.checkIn(guest3, room1);
        assertEquals(2, room1.guestCount());
    }

    @Test
    public void bookRoomTest(){
        hotel.bookRoom(room1, 5);
        assertEquals(1, hotel.bookingCount());
    }

    @Test
    public void canPayBill(){
        // booking object created and added to bookings arraylist
        Booking newBooking = hotel.bookRoom(room1, 5);

        int bill = room1.createBill(newBooking);

        // want to get a bill from somewhere

        // guest needs to pay bill
        guest1.payBill(bill);
        hotel.receivePayment(bill);

        // asserting that the money has left the guest
        assertEquals(2600, guest1.wallet());
        // asserting that money has arrived in till
        assertEquals(900, hotel.till());
    }

    @Test
    public void roomAlreadyBooked(){
        hotel.bookRoom(room1, 5);
        assertEquals(null, hotel.bookRoom(room1, 5));
    }

}
