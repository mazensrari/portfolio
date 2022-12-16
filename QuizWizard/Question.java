import java.util.ArrayList;

/**
 * 
 * @author (Mazen Srari) 
 * @version (v1.0)
 */
public class Question
{
    private ArrayList<String> answers;
    int numOfAnswers;
    String questionTxt;
    private char letter;

    /**
     * Constructor of Class Question
     */
    public Question(String questionTxt,int numOfAnswers)
    {
        // at the beginning, the ArrayList answers should be empty. We will test it.
        answers = new ArrayList<String>();
        this.numOfAnswers = numOfAnswers;
        this.questionTxt = questionTxt;
        resetLetter();
    }

    public String getQuestionTxt() {
        return questionTxt;
    }

    public int getNumOfAnswers() { 
        return numOfAnswers;
    }

    /**
     * This method will return a specific answer rather than the whole List.
     */
    public String getAnswer(int index) {
        return answers.get(index);
    }

    public int getSizeOfAnswers() {
        return answers.size();
    }

    public void addAnswer(String answer) {
        if (numOfAnswers <= answers.size()) { 
            System.out.println("You're trying to insert more answers than expected.");
        } else {
            answers.add(answer);
        }
    }

    private void resetLetter() {
        letter = 'a';
    }

    public String getFormattedQs() { 
        //(eg. question text?
        // a) ans1
        // b) ans2
        // c) ans3
        // return formatted qs
        resetLetter();
        String formatted = questionTxt;
        formatted += "\n";
        for (int i = 0; i < answers.size(); i++) {
            formatted += letter;
            letter += 1;
            formatted += ") ";
            formatted += answers.get(i);
            formatted += "\n";
        } 
        return formatted; 
    } 

}    

