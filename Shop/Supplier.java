
/**
 * @author (Mazen Srari) 
 * @version (v1)
 */
public class Supplier 
{
    // variabili d'istanza - sostituisci l'esempio che segue con il tuo
    private int stockAvailable, totalStockSold;

    /**
     * Costruttore degli oggetti di classe  Supplier
     */
    public Supplier() {
        // inizializza le variabili d'istanza
        stockAvailable = -1;
        totalStockSold = 0;
    }

    public int getStockAvailable() {
        return stockAvailable;
    }

    public int getStockSold() {
        return totalStockSold;
    }

    public boolean hasUnlimitedStock() {
        // if the total stock is unlimited = true or false = limited
        if (stockAvailable == -1) {
            return true;
        } else {
            return false;
        }
    }

    public void sellStock(int amountOrder) {
        if (stockAvailable == -1) {
            // The Supplier will always have enough stock to replenish the Shop
            stockAvailable = -1;
            // Once a Shop has ordered more stock, the total stock sold by the supplier will increase by = amount
            totalStockSold += amountOrder;
        }
    }
    
    public String toString(){
        String msg =  "This Supplier sells unlimited stock and has sold "  + getStockSold() +  " units so far";
        return msg;
    }
}
