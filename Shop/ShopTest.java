import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ShopTest
{
    @Test
    public void constructorTest(){
        Shop poundland = new Shop(100);
        assertEquals(100, poundland.getPrice(), "The price of items should be 100\n");
        assertEquals(0,   poundland.getNoOfItemsSold(), "The number of items sold should be zero\n");
        
        Shop fiverr = new Shop(500);
        assertEquals(500, fiverr.getPrice(), "The price of items should be 500\n");
        assertEquals(0,   fiverr.getNoOfItemsSold(), "The number of items sold should be zero\n");
    }
    
    @Test
    public void sellTest(){
        Shop poundland = new Shop(100);
        poundland.sell(4);
        assertEquals(100, poundland.getPrice(), "The price of items should be 100\n");
        assertEquals(4,   poundland.getNoOfItemsSold(), "The number of items sold should be four\n");
        poundland.sell(6);
        assertEquals(100, poundland.getPrice());
        assertEquals(10,   poundland.getNoOfItemsSold(), "The number of items sold should now be ten\n");
    }
    
    @Test
    public void totalTest(){
        Shop poundland = new Shop(100);
        poundland.sell(4);
        assertEquals(400, poundland.getTotal(), "The total income after selling 4 items should be 400\n");
        poundland.sell(6);
        assertEquals(1000, poundland.getTotal(), "The total income after selling 10 items should be 1000\n");
        //JOptionPane.showMessageDialog(null,poundland);
    }
    
    @Test
    public void orderStockTestO(){
        Shop poundland = new Shop(100);
        assertEquals(100, poundland.getStockAvailable(), "The stock available should be 100");
        assertEquals(1000,   poundland.getMaxStock(), "The max level of stock should be 1000");
        poundland.sell(75);
        assertEquals(25, poundland.getStockAvailable(), "The stock available should be 25");
        assertEquals(1000,   poundland.getMaxStock(), "The max level of stock should be 1000");
        poundland.orderStock(150);
        assertEquals(175, poundland.getStockAvailable(),"The stock available should now be 225");
        assertEquals(1000, poundland.getMaxStock());
        poundland.orderStock(900);
        assertEquals(175, poundland.getStockAvailable(), "The stock available should still be 225 because the order is invalid");
        assertEquals(1000, poundland.getMaxStock());
    }
}
