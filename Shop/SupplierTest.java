

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class SupplierTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SupplierTest
{
    /**
     * Default constructor for test class SupplierTest
     */
    public SupplierTest()
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
    
    @Test
    public void ConstructorTest() {
        Supplier JFK = new Supplier();
        assertEquals(-1, JFK.getStockAvailable(), "The amount of stock should be unlimited");
        assertEquals(0,   JFK.getStockSold(), "The number of stock sold should be zero\n");
    }
    
     @Test
    public void testSupplierSellStock(){
        Supplier JFK = new Supplier();
        JFK.sellStock(100);
        assertEquals(-1, JFK.getStockAvailable(), "The stock still available should be unlimited");
        assertEquals(100,   JFK.getStockSold(), "The number of stock sold should be 100");
        JFK.sellStock(342);
        assertEquals(-1, JFK.getStockAvailable(), "The stock still available should be unlimited");
        assertEquals(442,   JFK.getStockSold(), "The number of stock sold should now be 442");
    }
}
