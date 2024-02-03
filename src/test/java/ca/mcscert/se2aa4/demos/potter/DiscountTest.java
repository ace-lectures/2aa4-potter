package ca.mcscert.se2aa4.demos.potter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DiscountTest {

    private Cart aCart;

    @BeforeEach
    public void initializeCart() {
        aCart = new Cart(Book.BOOK1, Book.BOOK2, Book.BOOK3);
    }

    @Test
    public void twoDifferentBooks() {
        Discount theDiscount = new Discount(2, .95);
        assertTrue(theDiscount.canBeApplied(aCart));
        aCart.remove(Book.BOOK3);
        assertTrue(theDiscount.canBeApplied(aCart));
        aCart.remove(Book.BOOK2);
        assertFalse(theDiscount.canBeApplied(aCart));
    }

    @Test
    public void threeDifferentBooks() {
        Discount theDiscount = new Discount(3, .95);
        assertTrue(theDiscount.canBeApplied(aCart));
        aCart.remove(Book.BOOK3);
        assertFalse(theDiscount.canBeApplied(aCart));
        aCart.remove(Book.BOOK1);
        assertFalse(theDiscount.canBeApplied(aCart));
    }

}
