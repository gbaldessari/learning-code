import org.junit.Test;
import test.Book;
import test.ShoppingCart;

import static org.junit.Assert.*;

public class BookCartTest {
    @Test
    public void testAddGetTotal() {
        Book b1 = new Book("Book 1", 10, "1");
        Book b2 = new Book("Book 2", 20, "2");
        ShoppingCart cart = new ShoppingCart();
        cart.add(b1);
        cart.add(b2);
        assertEquals(30,cart.getTotal());
    }
}
