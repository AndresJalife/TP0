import java.util.ArrayList;
import java.util.HashMap;

public class Supermarket {
    private HashMap<String, Integer> prices;
    private ArrayList<String> cart;

    public Supermarket(HashMap prices){
        this.prices = prices;
        cart = new ArrayList<String>();
    }

    public void addToCart(String product){
        if (prices.containsKey(product)){
            cart.add(product);
            System.out.println("uno");
        }
        else {
            throw new UnknownItemException();
        }
    }

    public Integer getCartValue(){
        Integer totalValue = 0;
        for (String product: cart){
            totalValue += prices.get(product);
        }
        return totalValue;
    }

    public Integer payWith(Integer cash){
        //Receives an Integer cash to pay the check and returns the change.
        //If its greater than the total value its ok.
        //If its less it raises an NotEnoughMoney exception.

        Integer totalValue = getCartValue();
        if (cash < totalValue){
            throw new NotEnoughMoneyException();
        }
        this.cart = new ArrayList<String>();
        return cash - totalValue;
    }

}
