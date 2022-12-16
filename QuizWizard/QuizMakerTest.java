
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class QuizMakerTest.
 *
 * @author  (Mazen Srari)
 * @version (v1.0)
 */
public class QuizMakerTest
{
    /**
     * Default constructor for test class QuizMakerTest
     */
    public QuizMakerTest()
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
    public void constructorQuizMakerTest() {
        QuizMaker qm = new QuizMaker();
        assertNotNull(qm);
    }

    @Test
    public void startTest() {
        //not entirely sure how to test such a method at the moment. The code works,
        // I've tested it manually multiple times
        // QuizMaker qm = new QuizMaker();
        // // Would i have to test a sequence of inputs? the InputReader class is already responsible for 
        // // getting and scanning inputs from user (text and numbers) and that class has been tested 
        // // thoroughly
    }

    @Test
    public void addQuestionToQuizTest() {
        QuizMaker qm = new QuizMaker();
        Quiz qz = new Quiz("Module A");
        InputReader scanner2 = new InputReader("TestText2.txt");
        String text2 = scanner2.getText("Enter your question.");
        Question qs1 = new Question("What's the Capital of England", 4);
        qz.addQuestion("QQ1", qs1);
        assertEquals("What's the Capital of England", text2);
        text2 = scanner2.getText("Enter your question.");
        Question qs2 = new Question("What's the Capital of Italy", 4);
        qz.addQuestion("QQ2", qs2);
        assertEquals("What's the Capital of Italy", text2);
        // this should assert that the new question has been added to the quiz class.
    }

    @Test
    public void replaceQuestionInQuizTest() {
        QuizMaker qm = new QuizMaker();
        Quiz qz = new Quiz("Module A");
        InputReader scanner3 = new InputReader("TestText3.txt");
        String text3 = scanner3.getText("Enter the code of the question you want to replace");
        Question qs1 = new Question("What's the Capital of England", 4);
        Question qs2 = new Question("What's the Capital of Italy", 4);
        qz.addQuestion("QQ1", qs1);
        qz.addQuestion("QQ2", qs2);
        qz.replaceQuestion("QQ1", qs2);
        qm.getQuestion("QQ1");
        assertNull(qm.getQuestion("QQ2"));
    }

    @Test
    public void removeQuestionInQuizTest() {
        QuizMaker qm = new QuizMaker();
        Quiz qz = new Quiz("Module A");
        Question qs1 = new Question("What's the Capital of England", 4);
        qz.addQuestion("QQ1", qs1);
        qz.removeQuestion("QQ1");
        assertNull(qm.getQuestion("QQ1"));
    }

}
