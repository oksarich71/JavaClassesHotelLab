import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiningTest {

    Dining cafe;
    Guest guest1;

    @Before
    public void before(){
        cafe = new Dining(3, "Cafe");
        guest1 = new Guest("Thomas", 300);
    }

    @Test
    public void startEmpty(){
        assertEquals(0, cafe.guestCount());
    }

    @Test
    public void canAddPatron(){
        cafe.addGuest(guest1);
        assertEquals(1, cafe.guestCount());
    }

    @Test
    public void canCheckOutGuest(){
        cafe.addGuest(guest1);
        cafe.checkOutGuest(guest1);
        assertEquals(0, cafe.guestCount());
    }
}
