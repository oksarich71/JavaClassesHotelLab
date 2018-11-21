import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FunctionTest {

    Function roomA;
    Guest guest1;
    Guest guest2;

    @Before
    public void before(){
        roomA = new Function(50, "A");
        guest1 = new Guest("Ian", 300);
        guest2 = new Guest("Jenna", 300);
    }

    @Test
    public void roomAvailable() {
        assertEquals(0, roomA.guestCount());
    }

    @Test
    public void addGuestToRoom(){
        roomA.addGuest(guest1);
        assertEquals(1, roomA.guestCount());
    }

    @Test
    public void canCheckOutGuest(){
        roomA.addGuest(guest2);
        roomA.checkOutGuest(guest2);
        assertEquals(0, roomA.guestCount());
    }
}
