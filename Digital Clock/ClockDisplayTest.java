

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ClockDisplayTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ClockDisplayTest
{
    /**
     * Default constructor for test class ClockDisplayTest
     */
    public ClockDisplayTest()
    {
    }
    
    
    @Test
    public void clockDisplayConstructor() {
        ClockDisplay display = new ClockDisplay();
        NumberDisplay seconds = display.getSeconds();
        int secondsValue = seconds.getValue();
        assertEquals(0, secondsValue);
        NumberDisplay minutes = display.getMinutes();
        int minutesValue = minutes.getValue();
        assertEquals(0, minutesValue);
        NumberDisplay hours = display.getHours();
        int hoursValue = hours.getValue();
        assertEquals(0, hoursValue);
    }


    @Test
    public void timeTickTest() {
        ClockDisplay display = new ClockDisplay();
        display.timeTick();
        NumberDisplay seconds = display.getSeconds();   
        int secondsValue = seconds.getValue();
        assertEquals(1, secondsValue);
        NumberDisplay minutes = display.getMinutes();
        int minutesValue = minutes.getValue();
        assertEquals(0, minutesValue);
        NumberDisplay hours = display.getHours();
        int hoursValue = hours.getValue();
        assertEquals(0, hoursValue);
        display.timeTick();
        secondsValue = seconds.getValue();
        assertEquals(2, secondsValue);
        minutesValue = minutes.getValue();
        assertEquals(0, minutesValue);
        hoursValue = hours.getValue();
        assertEquals(0, hoursValue);
        for (int i=0; i<60; i++) {
            display.timeTick();
        }
        secondsValue = seconds.getValue();
        assertEquals("After 62 ticks, the time should be zero hours, one minute and two seconds\n",2, secondsValue);
        minutesValue = minutes.getValue();
        assertEquals("After 62 ticks, the time should be zero hours, one minute and two seconds\n",1, minutesValue);
        hoursValue = hours.getValue();
        assertEquals("After 62 ticks, the time should be zero hours, one minute and two seconds\n",0, hoursValue);
        for (int i=0; i<(60*60); i++) {
            display.timeTick();
        }
        secondsValue = seconds.getValue();
        assertEquals("After " + ((60*60)+62) + " ticks, the time should be one hour, one minute and two seconds\n",2, secondsValue);
        minutesValue = minutes.getValue();
        assertEquals("After " + ((60*60)+62) + " ticks, the time should be one hour, one minute and two seconds\n",1, minutesValue);
        hoursValue = hours.getValue();
        assertEquals("After " + ((60*60)+62) + " ticks, the time should be one hour, one minute and two seconds\n",1, hoursValue);
    }
    
    @Test
    public void updateDisplay12HoursTest() {
        //I need a test that resets if the clock goes over 12 and changes the suffix
        ClockDisplay display = new ClockDisplay();
        display.setTime(3,05);
        assertEquals("3.05am", display.updateDisplay12Hour());
        display.setTime(16,12); 
        assertEquals("4.12pm", display.updateDisplay12Hour());
    }
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}