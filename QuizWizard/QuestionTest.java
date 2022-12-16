
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
 * The test class QuestionTest.
 *
 * @author  (Mazen Srari)
 * @version (v1.0)
 */
public class QuestionTest
{
    /**
     * Default constructor for test class QuestionTest
     */
    public QuestionTest()
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
    public void constructorQuestionTest() {
        Question qs = new Question("What's the Capital of England", 4);
        assertEquals(0, qs.getSizeOfAnswers());
        assertEquals("What's the Capital of England", qs.getQuestionTxt());
    }

    @Test
    public void addAnswerTest() {
        Question qs = new Question("What's the Capital of England", 4);
        qs.addAnswer("The capital of England is London");
        // this should assert that the List is now 1 and not 0.
        assertEquals(1, qs.getSizeOfAnswers());
        qs.addAnswer("The capital of England is Rome");
        qs.addAnswer("The capital of England is Paris");
        assertEquals(3, qs.getSizeOfAnswers());
        //get the text of each answer and compare it to input
    }

    @Test
    public void addTooManyAnswersTest() {
        Question qs = new Question("What's the Capital of England", 4);
        qs.addAnswer("The capital of England is London");
        // this should assert that the List is now 1 and not 0.
        assertEquals(1, qs.getSizeOfAnswers());
        qs.addAnswer("The capital of England is Rome");
        qs.addAnswer("The capital of England is Paris");
        qs.addAnswer("The capital of England is Madrid");
        assertEquals(4, qs.getSizeOfAnswers());
        qs.addAnswer("The capital of England is Lisbon");
        assertEquals(4, qs.getSizeOfAnswers());
    }

    @Test
    public void getFormattedQuestionTest() {
        // a test that returns the right formatted value of a question
        Question qs = new Question("What's the Capital of England?", 4);
        String s = qs.getFormattedQs();
        assertEquals("What's the Capital of England?\n", s);
        Question qz = new Question("What's the Capital of Denmark?", 4);
        String z = qz.getFormattedQs();
        assertEquals("What's the Capital of Denmark?\n", z);
        // after this, assert if the answers are added and displayed correctly
        qs.addAnswer("London");
        String a1 = qs.getFormattedQs();
        assertEquals("What's the Capital of England?\na) London\n", a1);
        qs.addAnswer("Rome");
        String a2 = qs.getFormattedQs();
        assertEquals("What's the Capital of England?\na) London\nb) Rome\n", a2);
        qs.addAnswer("Paris");
        String a3 = qs.getFormattedQs();
        assertEquals("What's the Capital of England?\na) London\nb) Rome\nc) Paris\n", a3);
    }

}

