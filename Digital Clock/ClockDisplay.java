
/**
 * Write a description of class ClockDisplay here.
 * 
 * @author (Mazen Srari) 
 * @version (02/10/2022)
 */
public class ClockDisplay 
{
    // instance variables - replace the example below with your own
    private NumberDisplay hoursDisplay;
    private NumberDisplay minutesDisplay;
    private NumberDisplay secondsDisplay;
    private NumberDisplay alarmHours;
    private NumberDisplay alarmMinutes;

    /**
     * Constructor for objects of class ClockDisplay
     */
    public ClockDisplay() {
        // initialise instance variables
        hoursDisplay = new NumberDisplay(24);
        minutesDisplay = new NumberDisplay(60);
        secondsDisplay = new NumberDisplay(60);
        updateDisplay();
        alarmHours = new NumberDisplay(24); 
        alarmMinutes = new NumberDisplay(60);
    }

    public void timeTick() {
        //increment the seconds first
        secondsDisplay.increment();
        if(secondsDisplay.getValue() == 0) {
            //the seconds rolled over
            minutesDisplay.increment();
            if(minutesDisplay.getValue() == 0) {
                hoursDisplay.increment();
            }
        }
        updateDisplay();
    }

    public void updateDisplay() {
        System.out.println(hoursDisplay.getFormattedValue() + ":" + minutesDisplay.getFormattedValue() 
            + ":" + secondsDisplay.getFormattedValue());
    }

    public String updateDisplay12Hour() {
        // this method should display the clock with the 12-hour format eg. 2.00 am
        //Declare a new variable hours to hold the number of hours
        //Get the hours value from the appropriate NumberDisplay object and store in hours
        int hours = hoursDisplay.getValue();
        //Declare a new variable suffix to hold ”am” or ”pm”
        String suffix = "";
        //If the value of hours is greater than 12
        //then let suffix become equal to ”pm”,
        //otherwise let suffix become equal to ”am”
        if(hours > 12) {
            suffix = "pm";
        } else {
            suffix = "am";
        }
        //If the value in hours is greater than 12,
        //then subtract 12 from it
        if(hours > 12) { 
            hours = hours - 12;
        }
        //Display the time by concatenating (joining together) hours + a dot + the minutes value from
        //the appropriate NumberDisplay object + suffix
        return (hours + "." + minutesDisplay.getFormattedValue() + suffix);

    }

    public NumberDisplay getHours() {
        return hoursDisplay;
    }

    public NumberDisplay getMinutes() {
        return minutesDisplay;
    }

    public NumberDisplay getSeconds() { 
        return secondsDisplay;
    }

    public void showTheClockRunning(){
        // This mutator method will show the clock running in intervals of 10ms
        ClockDisplay clock = new ClockDisplay();
        int tickThisManyTimes = 999999;
        // 1000ms = 1 second (1000 * 60)ms = 1 minute
        // a smaller value = a clock that runs faster
        int waitThisLongBetweenTicks = 10;
        while(0 < tickThisManyTimes--){
            clock.timeTick();
            try{
                Thread.sleep(waitThisLongBetweenTicks);
            }catch(InterruptedException ie){ /* Do nothing */ }
        }
    }

    public void setTime(int hours, int minutes) {
        // create an if condition to avoid the user entering values above h24 and m60
        if(hours > 24  || minutes > 60 || hours < 0 || minutes < 0) {
            // the program should say "the time entered is invalid. Set a valid time.
            System.out.println("The time entered is invalid. Set a valid time.");
        } else {
            hoursDisplay.setTime(hours);
            minutesDisplay.setTime(minutes);
        }
    }
    
    public void setAlarm(int alarmHours, int alarmMinutes) {
        // create an if condition to avoid the user entering values above h24 and m60
        if(alarmHours > 24  || alarmMinutes > 60 || alarmHours < 0 || alarmMinutes < 0) {
            // the program should show an error.
            System.out.println("The alarm entered is invalid. Set a valid alarm.");
        } else {
            setAlarm(alarmHours, alarmMinutes);
        }
    }
    
    public NumberDisplay getAlarmMinutes() {
        return alarmMinutes; 
    }
    
    public NumberDisplay getAlarmHours() {
        return alarmHours; 
    }
    
}

