/**
 * @author (Mazen Srari) 
 * @version (v1)
 */

public class Shop
{
    private int price, noOfItemsSold, stockAvailable, maxStock;

    public Shop(int price)
    {
        this.price = price;
        noOfItemsSold = 0;
        stockAvailable = 100;
        maxStock = 1000;
    }

    public int getPrice(){
        return price;
    }

    public int getNoOfItemsSold(){
        return noOfItemsSold;
    }

    public int getStockAvailable() {
        return stockAvailable;
    }

    public int getMaxStock() {
        return maxStock;
    }

    public void sell(int amount){
        if (stockAvailable <= 0) {
            System.out.println("Sorry, this item is currently out of stock");
        } else {
            noOfItemsSold += amount;
            stockAvailable -= amount;
        }
    }

    public void orderStock(int amountOrder){ 
        // when the stock is below a certain threshold the shop can order new stock
        if (stockAvailable <= 25 && amountOrder < maxStock) {
            System.out.println("Stock is below sustainable level. Order new stock immediately.");
            Supplier currentSupplier = new Supplier();
            currentSupplier.sellStock(amountOrder);
            // the level of the stock will be replenished by the amount ordered
            stockAvailable += amountOrder;
        } else {
            System.out.println("The amount ordered is invalid. Please order different amount.");
        }
    }

    public int getTotal(){
        return price * noOfItemsSold;
    }

    public String toString(){
        String msg =  "This shop sells items that cost " + price + "p and has sold ";
        msg+= noOfItemsSold + " items. It's register holds " + getTotal() + "p.";
        return msg;
    }    
}
