
/**
 * Aggiungi qui una descrizione della classe Customer
 * 
 * @author (Mazen Srari) 
 * @version (v1)
 */
public class Customer
{

    private int amountSpent, totalBudget;
    private Shop currentShop;

    public Customer() 
    /**
     * Constructor
     */ 
    {
        amountSpent = 0;
        totalBudget = -1;
        currentShop = null;
    }

    public boolean hasUnlimitedBudget() {
        // if the total budget is unlimited = true or false = limited
        if (totalBudget == -1) {
            return true;
        } else {
            return false;
        }
    }

    public Shop getCurrentShop() {
        // a new Customer should have a currentShop value of null
        return currentShop;
    }

    public int getAmountSpent() {
        // a new Customer should not have spent any money at the beginning
        return amountSpent;
    }

    public void enter(Shop newShop) {
        if (currentShop == null){
            currentShop = newShop;
        }
    }

    private boolean enoughMoney (int amount) {
        if(amount * currentShop.getPrice() <= totalBudget || hasUnlimitedBudget() == true){
            return true;
        } else {
            return false; 
        }
    }

    public void exit() {
        currentShop = null;
    }

    public void buy(int amount) {
        // calculate the amount the customer has spent in the current shop
        // customer can only buy when in a shop, with enough money and if the shop has enough stock
        if (currentShop != null && enoughMoney(amount) && currentShop.getStockAvailable() > 0){
            // change the amount the shop has sold
            currentShop.sell(amount);
            //evaluate the total budget spent by the customer in a shop
            //when a customer buys multiple items that should be reflected in the total spent
            int totalSpent = amount * currentShop.getPrice(); 
            amountSpent += totalSpent;
            // If the customer has unlimited budget, the value of the budget after purchase should not change.
            if(hasUnlimitedBudget() == false) {
                totalBudget -= totalSpent;
                // change the value of the total budget our customer has after the purchase
            } else if (hasUnlimitedBudget() == true) {
                totalBudget = -1;
            } else {
                System.out.println("Sorry, this transaction was declined.");
            }
        }
    }

    public void setBudget(int givenBudget) { 
        totalBudget = givenBudget;
    }

    public int getBudget() { 
        return totalBudget;
    }

    public String toString(){
        String msg =  "This customer buys items that cost " + currentShop.getPrice() + "p and has bought ";
        msg += amountSpent + "p worth of items. Their budget now holds " + getBudget() + "p.";
        return msg;
    }
}

