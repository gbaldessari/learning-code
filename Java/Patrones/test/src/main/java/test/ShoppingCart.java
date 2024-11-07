package test;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Book> cart;
    public ShoppingCart() {
        cart = new ArrayList<Book>();
    }
    public void add(Book book) {
        cart.add(book);
    }
    public int getTotal(){
        int total = 0;
        for (Book book : cart) {
            total += book.getPrice();
        }
        return total;
    }
}
