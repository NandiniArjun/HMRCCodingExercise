import fruit.AppleOrange;

import java.util.ArrayList;
import java.util.List;


//main class where the program execution begins
public class CheckoutSystem {

    public static void main(String args[]){

        boolean otherItemExists = false;

        List<String> shoppingCart = new ArrayList<>();
        shoppingCart.add("Apple");
        shoppingCart.add("Orange");
        shoppingCart.add("Apple");
        shoppingCart.add("Apple");

        //make all lowercase to uppercase
        shoppingCart.replaceAll(String::toUpperCase);

        AppleOrange fruits = new AppleOrange();
        //Check if cart has any other items apart from apple and oranges
        otherItemExists = fruits.checkForOtherItems(shoppingCart);

        Checkout pricing = new SimpleCheckout();

        if(!otherItemExists){
            pricing.addPrice("APPLE", 0.25);
            pricing.addPrice("ORANGE", 0.6);
            pricing = new DiscountValue(pricing, "Apple", 2, 0.25);
            pricing = new DiscountValue(pricing, "Orange", 3, 0.60);
            System.out.println(pricing.calculateTotal(shoppingCart));
        } else {
            System.out.println("Cart includes other items. Please make sure cart only includes apples and oranges");
        }
    }
}
