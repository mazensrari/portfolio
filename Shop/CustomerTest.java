
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class CustomerTest.
 *
 * @author  (Mazen Srari)
 * @version (v1)
 */
public class CustomerTest
{
    /**
     * Default constructor for test class CustomerTest
     */
    public CustomerTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

    /** 
     *  The amount spent by the customer should start at 0 and increase correctly as
     *  the customer buys items.
     */
    @Test 
    public void ConstructorCustomer(){
        Customer customer1 = new Customer();
        assertEquals(0, customer1.getAmountSpent(), "A new customer should have an amount spent of zero\n");
        assertNull(customer1.getCurrentShop(), "A new customer's shop should be null\n");
        assertTrue(customer1.hasUnlimitedBudget(), "A new customer should have unlimited budget\n");
    } 

    /** 
     * The shop the customer is in starts as null and is correctly updated to be a Shop
     * objects as the customer visits various shops.*/
    @Test
    public void testCustomerEnterExitShops(){
        Customer customer = new Customer();
        Shop shop1 = new Shop(150);
        Shop shop2 = new Shop(200);

        customer.enter(shop1);
        assertEquals(shop1, customer.getCurrentShop(), "The customer should have entered shop1\n");
        assertEquals(150, customer.getCurrentShop().getPrice(), "The price of things in the customer's current shop is 150\n");

        customer.enter(shop2);
        assertEquals(shop1, customer.getCurrentShop(), "The customer should still be in shop1 (they did not exit!)\n");
        assertEquals(150, customer.getCurrentShop().getPrice(), "The price of things in the customer's current shop is (still) 150\n");

        customer.exit();
        customer.enter(shop2);
        assertEquals(shop2, customer.getCurrentShop(), "The customer has exited shop1 and is now in shop2\n");
        assertEquals(200, customer.getCurrentShop().getPrice(), "The price of things in the customer's current shop is 200\n");

        customer.exit();
        assertNull(customer.getCurrentShop(), "The customer has exited shop2 and is no longer in a shop\n");
    }

    /** 
     * The customer should be able to find out the correct price of items in his/her
     * current shop.
     */

    @Test
    public void testCustomerBuys(){
        Customer customer = new Customer();
        Shop shop = new Shop(200);

        customer.buy(5);
        assertEquals(0, customer.getAmountSpent(), "The customer has not yet entered a shop and so cannot have spent anything\n");

        customer.enter(shop);
        customer.buy(4);
        assertEquals(800, customer.getAmountSpent(), "The customer has entered a shop and bought 4 things that cost of 200 each\n");
        assertEquals(800, shop.getTotal(), "The shop has sold 4 things at a cost of 200 each\n");
        customer.buy(2);
        assertEquals(1200, customer.getAmountSpent(), "The customer has now bought a total of 6 things that cost of 200 each\n");
        assertEquals(1200, shop.getTotal(), "The shop has now sold 6 things at a cost of 200 each\n");
    }

    /**
     * Test 4 As the customer buys items, the running income of the shop should be updated
     * accordingly.
     */
    @Test
    public void testCustomerBudget(){
        Customer customer = new Customer();
        customer.setBudget(400);
        Shop shop = new Shop(200);
        assertEquals(400, customer.getBudget(), "This customer has been given a budget of 400\n");
        assertFalse(customer.hasUnlimitedBudget(), "This customer no longer has unlimited budget\n");

        customer.enter(shop);
        // test purchase over budget
        customer.buy(4);
        assertEquals(0, customer.getAmountSpent(), "The customer did not have enough budget to buy 4 items at 200 each\nSo could not buy anything\n");
        assertEquals(0, shop.getTotal(), "The customer did not have budget to buy and so the shop should not have sold anything\n");
        // test purchase within budget
        customer.buy(1);
        assertEquals(200, customer.getAmountSpent(), "The customer purchase 1 item costing 200 which is within budget and allowed\n");
        assertEquals(200, shop.getTotal(), "The customer purchased one item costing 200 from this shop\n");
        customer.buy(1);
        assertEquals(400, customer.getAmountSpent(), "The customer purchase a second item costing 200 which is within budget and allowed\n");
        assertEquals(400, shop.getTotal(), "The customer purchased a second item costing 200 from this shop\n");
        // test budget used up
        customer.buy(1);
        assertEquals(400, customer.getAmountSpent(), "The customer has spent their budget and can no longer buy anything\n");
        assertEquals(400, shop.getTotal(), "The customer has spent their budget and should not have bought anything more from this shop\n");
    }
}
