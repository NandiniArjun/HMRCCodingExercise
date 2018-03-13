import fruit.AppleOrange;

import java.util.Collections;
import java.util.List;

public class DiscountValue implements Checkout {

    private final Checkout baseCheckout;
    private final String discountedItem;
    private final int minimumAmount;
    private final double discountValue;

    public DiscountValue(Checkout base, String item, int min, double discount) {
        this.baseCheckout = base;
        this.discountedItem = item;
        this.minimumAmount = min;
        this.discountValue = discount;
    }

    @Override
    public double calculateTotal(List<String> shoppingCart) {
        int count = 0;
        if(discountedItem.toUpperCase().equals("APPLE"))
            count = AppleOrange.getAppleCount();
        else
            count = AppleOrange.getOrangeCount();
        // Integer division gives the number of times the discount is applied
        double deduction = (count / minimumAmount) * discountValue;
        return baseCheckout.calculateTotal(shoppingCart) - deduction;
    }

    //dummy method
    @Override
    public void addPrice(String item, double price) {

    }
}
