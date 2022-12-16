
/**
 * Write a description of class NumberDisplay here.
 * 
 * @author (Mazen Srari) 
 * @version (02/10/2022)
 */
public class NumberDisplay
{
    private int value;
    private int limit;

    /**
     * Constructor for objects of class NumberDisplay
     */
    public NumberDisplay(int limit)
    {
        this.limit = limit;
        value = 0;      
    }

    public int getValue() {
        return value;
    }

    public int getLimit() {
        return limit;
    }

    public void increment() {
        value = (value + 1) % limit;
    }

    public int getSecondsInMinute(){
        return limit; 
    }

    public int getHoursInDay() {
        return limit;
    }

    public int getMinutesInHour() {
        return limit;
    }

    public String getFormattedValue() {
        // This method will format the value of the clock from single to double digits
        // String + int concatenation method and a boolean statement to run the double digit clock
        if (value < 10) {
            return "0" + value;
        } else { 
            return "" + value;
        }
    }

    public void setTime (int newTime ) { 
        value = newTime;
    }
}