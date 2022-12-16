
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class NumberDisplayTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class NumberDisplayTest
{
    /**
     * Default constructor for test class NumberDisplayTest
     */
    public NumberDisplayTest()
    {
    }

    @Test
    public void constructorTest(){
        // construct a new numberDisplay object with limit of 3
        NumberDisplay numDisp = new NumberDisplay(3);
        // for our new NumberDisplay (numDisp) its expected value is 0
        assertEquals(0, numDisp.getValue());
        // for our new NumberDisplay (numDisp) its limit should be 3
        assertEquals(3, numDisp.getLimit());
    }

    @Test
    public void incrementTest() {
        NumberDisplay numDisp = new NumberDisplay(3);
        assertEquals(0, numDisp.getValue());
        assertEquals(3, numDisp.getLimit());
        numDisp.increment();
        assertEquals(1, numDisp.getValue());
        numDisp.increment();
        assertEquals(2, numDisp.getValue());
        numDisp.increment();
        assertEquals(0, numDisp.getValue());
    }

    @Test
    public void formattedValueTest() {
        // assess if the terminal is resetting the formatted value to a double digit 
        NumberDisplay numDisp = new NumberDisplay(11);
        assertEquals("00", numDisp.getFormattedValue());
        numDisp.increment();
        assertEquals("01", numDisp.getFormattedValue());
        numDisp.increment();
        assertEquals("02", numDisp.getFormattedValue());
        numDisp.increment();
        assertEquals("03", numDisp.getFormattedValue());
        numDisp.increment();
        assertEquals("04", numDisp.getFormattedValue());
        numDisp.increment();
        assertEquals("05", numDisp.getFormattedValue());
        numDisp.increment();
        assertEquals("06", numDisp.getFormattedValue());
        numDisp.increment();
        assertEquals("07", numDisp.getFormattedValue());
        numDisp.increment();
        assertEquals("08", numDisp.getFormattedValue());
        numDisp.increment();
        assertEquals("09", numDisp.getFormattedValue());
        numDisp.increment();
        assertEquals("10", numDisp.getFormattedValue());
        numDisp.increment();
        assertEquals("00", numDisp.getFormattedValue());
        numDisp.increment();
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
