

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class InputReaderTest.
 *
 * @author  (Mazen Srari)
 * @version (v1.0)
 */
public class InputReaderTest
{
    /**
     * Default constructor for test class InputReaderTest
     */
    public InputReaderTest()
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
    public void constructorInputReaderTest() {
        InputReader scanner = new InputReader();
        assertNotNull(scanner.getScanner());
    }
    
    @Test
    public void getTextTest() {
        InputReader scanner = new InputReader("TestText.txt");
        String text = scanner.getText("Enter some text");
        assertEquals("What's the capital of England?", text);
        text = scanner.getText("Enter some text");
        assertEquals("What's 70 divided by 2?", text);
    }
    
    @Test
    public void getNumberTest() {
        InputReader scanner = new InputReader("TestNumbers.txt");
        int number = scanner.getNumber("Enter a number");
        assertEquals(4, number);
        number = scanner.getNumber("Enter a number");
        assertEquals(2, number);
    }
    
    @Test
    public void getMixedInput() {
        InputReader scanner = new InputReader("TestMixedInput.txt");
        int number = scanner.getNumber("Enter a number");
        assertEquals(7, number);
        String text = scanner.getText("Enter some text");
        assertEquals("The capital of England is London", text);
        number = scanner.getNumber("Enter a number");
        assertEquals(-4, number);
        text = scanner.getText("Enter some text");
        assertEquals("What's the name of the current US President?", text);
    }
}
