
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class QuizTest.
 *
 * @author  (Mazen Srari)
 * @version (v1.0)
 */
public class QuizTest
{
    /**
     * Default constructor for test class QuizTest
     */
    public QuizTest()
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
    public void constructorQuizTest() {
        Quiz qz = new Quiz("module 123");
        assertEquals(0, qz.getSizeOfQuiz());
    }

    @Test
    public void addQuestionTest() {
        Quiz qz = new Quiz("module 123");
        Question qs1 = new Question("What's the Capital of England", 4);
        Question qs2 = new Question("What's the Capital of Italy", 4);
        Question qs3 = new Question("What's the Capital of Ecuador", 4);
        Question qs4 = new Question("What's the Capital of China", 4);
        qz.addQuestion("QQ1", qs1);
        assertEquals(1, qz.getSizeOfQuiz());
        // this should assert that the new question has been added to the quiz class.
        qz.addQuestion("QQ2", qs2);
        qz.addQuestion("QQ3", qs3);
        qz.addQuestion("QQ4", qs4);
        assertEquals(4, qz.getSizeOfQuiz());
    }

    @Test
    public void removeQuestionTest() {
        Quiz qz = new Quiz("module 123");
        Question qs1 = new Question("What's the Capital of England", 4);
        qz.addQuestion("QQ1", qs1);
        assertEquals(1, qz.getSizeOfQuiz());
        qz.removeQuestion("QQ1");
        assertEquals(0, qz.getSizeOfQuiz());
    }

    @Test
    public void replaceQuestionTest() {
        Quiz qz = new Quiz("module 123");
        Question qs1 = new Question("What's the Capital of England", 4);
        Question qs2 = new Question("What's the Capital of Italy", 4);
        qz.addQuestion("QQ1", qs1);
        qz.addQuestion("QQ2", qs2);
        qz.replaceQuestion("QQ1", qs2);
        // We are asserting that the content of the second question is 
        // now replacing the content of the first question
        assertEquals(qs2, qz.getQuestion("QQ1"));
    }
}
