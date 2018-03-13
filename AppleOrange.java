import java.util.List;

import static java.util.Collections.frequency;

public class AppleOrange {

    private static final String APPLE = "APPLE";
    private static final String ORANGE = "ORANGE";

    static int applesCount = 0;
    static int orangesCount = 0;

    public boolean checkForOtherItems(List<String> shoppingCart){

        boolean otherItemExists = false;
        applesCount = frequency(shoppingCart, APPLE);
        orangesCount = frequency(shoppingCart, ORANGE);

        if((applesCount + orangesCount) != shoppingCart.size())
            otherItemExists = true;

        return otherItemExists;
    }

    public static int getAppleCount(){
        return applesCount;
    }

    public static int getOrangeCount(){
        return orangesCount;
    }
}
