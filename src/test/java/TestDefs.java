import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class TestDefs {

    private UnknownItemException err;

    private Supermarket supermarket;
    private Integer totalValue;

    @Given("^Supermarket with 3 products$")
    public void create_a_supermarket_with_3_products(){
        HashMap hash = new HashMap();
        hash.put("Banana", 15);
        hash.put("Coffee", 50);
        hash.put("Beef", 105);
        supermarket = new Supermarket(hash);
    }

    @When("^Adding one true product")
    public void trying_to_add_one_true_product(){
        try {
            supermarket.addToCart("Banana");
        } catch (UnknownItemException e){
            err = e;
        }
    }

    @When("^Adding one false product")
    public void trying_to_add_one_false_product(){
        try {
            supermarket.addToCart("Cheese");
        } catch (UnknownItemException e){
            err = e;
        }
    }

    @Then("^Nothing happens")
    public void there_is_no_exception(){
//        assertEquals(err, null);
    }

    @Then("^UnknownItemException raises")
    public void there_is_an_UnknownItemException(){
        assertEquals(err.getClass(), UnknownItemException.class);
    }

    @Then("^total value must be (\\d+)$")
    public void the_Cart_value_is_correct(Integer arg1){
        assertEquals(supermarket.getCartValue(), arg1);
    }



}

