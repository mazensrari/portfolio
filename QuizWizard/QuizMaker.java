
/**
 * Aggiungi qui una descrizione della classe QuizMaker
 * 
 * @author (Mazen Srari) 
 * @version (v1.0)
 */
public class QuizMaker
{
    private InputReader input;
    private Quiz quiz;
    private String owner;
    private String quizTag;

    /**
     * Constructor of Class QuizMaker
     */
    public QuizMaker()
    {
        input = new InputReader();
        quiz = new Quiz(quizTag);
        owner = new String();
        quizTag = new String();
    }

    public void start() {
        printInstructions();
        boolean isRunning = true;
        while (isRunning) {
            String command = input.getText("Now type 'quiz' to begin, or 'quit' to quit the program. Type 'help' to read the instructions again.\n");
            if (command.equals("help")) {
                printInstructions();
            } else if (command.equals("quiz")) {
                setOwnersAndModules();
                boolean keepAddingQs = true;  
                //Enter your Question and number of answers below.
                while (keepAddingQs) {
                    addQuestionToQuiz();
                    // input reader to ask question text and num of answers
                    // loop to add answers one after the other
                    // ask if there's more questions? y keep going, n ask if quitting
                    String moreQs = input.getText("Do you wish to add more Questions? Type 'yes' or 'no'.\n");
                    if (moreQs.equals("no")) {
                        // keepAddingQs = false;
                        String removeReplace = input.getText("Do you wish to change something before viewing your quiz?\nType 'remove' to remove a question, 'replace' to replace it with a new one, or just 'continue' to move forward.\n");
                        if (removeReplace.equals("remove")) {
                            removeQuestionInQuiz();
                        } else if (removeReplace.equals("replace")) {
                            replaceQuestionInQuiz();
                        } else if (removeReplace.equals("continue")) {
                            String print = input.getText("You have created the Quiz.\n" + "Do you want to view it? Type 'view' to view, or 'quit' to leave.\n");
                            //print option
                            if (print.equals("view")) {
                                printQuiz();
                                isRunning = false;
                            } else if (command.equals("quit")) {
                                isRunning = false;
                            }
                        }
                        keepAddingQs = false;
                    }                
                }
                // quit option 
            } else if (command.equals("quit")) {
                isRunning = false;
            }
        }
        printGoodbye(); 
    }

    public void setOwnersAndModules() {
        System.out.println("Let's create a quiz together!\n");
        String owner = input.getText("Please tell me who's the owner of this quiz? This information is for internal purposes only.\n");
        setOwner(owner);
        String quizTag = input.getText("Now enter the module reference for the quiz.\n E.g., 'DC1000: Foundations of Technology Solutions'\n");
        setQuizTag(quizTag);
    }

    public void printInstructions() {
        System.out.println("Welcome to the QuizMaker! Follow the instructions below to create your quiz.\n");
        System.out.println("Before you start, make sure you know the following:\n");
        System.out.println("how many Q&As your quiz has, who's the owner of the quiz, and the module reference.\n");
        System.out.println("You can also 'remove' or 'replace' your questions, when necessary.\n");
        // System.out.println("When you're ready, type 'quiz' to begin, or type 'quit' to leave!\n");
    }

    public void printGoodbye() {
        System.out.println("Thank you for using QuizWizard. See you again soon!");
    }

    public void addQuestionToQuiz() {
        String questionTxt = input.getText("Please enter your Question\n");
        int numberOfAnswers = input.getNumber("Please enter how many answers your Question has (as a whole number, like 4 or 2)\n");
        // We make a new question here using the user input.
        Question question = new Question(questionTxt , numberOfAnswers);
        for(int i = 0; i < numberOfAnswers; i++) {
            // get the text of the answer from user and add answer to question
            String answerTxt = input.getText("Please enter your Answer\n");
            question.addAnswer(answerTxt);
        }
        // if statement to prevent users from entering an unformatted alphanumeric code (case sensitive?)
        // code.toUpper() 
        String code = input.getText("Please enter the unique code of the Question, namely sequences of 3 Alphanumeric characters\n E.g., AA1\n");
        quiz.addQuestion(code, question);
        System.out.println("Your question has been added to the quiz.");
    }

    public void replaceQuestionInQuiz() {
        String code = input.getText("Please enter the Alphanumeric code of the Question you'd like to replace.\n");
        String questionTxt= input.getText("Please enter your new Question\n");
        int numberOfAnswers = input.getNumber("Please enter how many answers your new Question has (as a whole number, like 4 or 2)\n");
        Question question = new Question(questionTxt , numberOfAnswers);
        for(int i = 0; i < numberOfAnswers; i++) {
            // get the text of the answer from user and add answer to question
            String answerTxt = input.getText("Please enter your Answer\n");
            question.addAnswer(answerTxt);
        }
        quiz.replaceQuestion (code, question);
        quiz.addQuestion(code, question);
        String endReplace = input.getText("Your question has been replaced. Do you want to view your quiz? type 'yes' or 'no'.\n");
        boolean isRunning = true;
        if (endReplace.equals("yes")) {
            printQuiz();
            isRunning = false;
        } else if (endReplace.equals("no")) {
            isRunning = false;
        }
    }

    public void removeQuestionInQuiz() {
        String code = input.getText("Please enter the Alphanumeric code of the Question you'd like to remove.\n");
        quiz.removeQuestion(code);
        String endRemove = input.getText("Your question has been removed. Do you want to view your quiz? type 'yes' or 'no'.\n");
        boolean isRunning = true;
        if (endRemove.equals("yes")) {
            printQuiz();
            isRunning = false;
        } else if (endRemove.equals("no")) {
            isRunning = false;
        }
    }

    public void printQuestion() {
        String code = input.getText("Please enter the Alphanumeric code of a Question");
        System.out.println(quiz.getQuestion(code).getFormattedQs());
    }
    
    public Question getQuestion (String code) { 
        return quiz.getQuiz().get(code);
    }

    public void printQuiz() { 
        // keySet method? 
        System.out.println("Module Reference: " + quizTag + "\n");
        for(String key: quiz.getQuiz().keySet()) {
            System.out.println(quiz.getQuestion(key).getFormattedQs());
        }
    }

    public void setOwner(String newOwner) {
        owner = newOwner;
    }

    public void setQuizTag(String newQuizTag) {
        quizTag = newQuizTag;
    }

    public String getOwner(String quizTag) {
        return owner;
    }

    public String getQuizTag() {
        return quizTag;
    }
    
    public Quiz getQuiz(String quizTag) {
        return quiz;
    }
    
}
