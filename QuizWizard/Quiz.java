import java.util.ArrayList;
import java.util.HashMap;

/**
 * Aggiungi qui una descrizione della classe Quiz
 * 
 * @author (Mazen Srari) 
 * @version (v1.0)
 */
public class Quiz
{
    private HashMap<String, Question> quizzes;
    private Question question;
    
    /**
     * Constructor of Class Quiz
     */
    public Quiz(String quizTag) //int numOfQuestions
    {
        //questions = new ArrayList<Question>(); 
        quizzes = new HashMap<String, Question>();
    }

    public int getSizeOfQuiz() {
        return quizzes.size();
    }
    
    public Question getQuestion(String code) {
        quizzes.get(code);
        return quizzes.get(code);
    }
    
    public HashMap<String, Question> getQuiz() {
        return quizzes;
    }
        
    public void addQuestion (String code, Question question) {
        quizzes.put(code, question);
    }

    public void removeQuestion (String code) {
        // as long as the code matches a given question, it will be removed.
        quizzes.remove(code);
    }
    
    public void replaceQuestion (String code, Question newQuestion) {
        //find the question that needs to be replaced and replace it with the new one
        quizzes.replace(code, newQuestion);
        question = newQuestion;
    }
}
