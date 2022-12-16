import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

/**
 * This class will read the User Input
 * 
 * @author (Mazen Srari) 
 * @version (v1.0)
 */
public class InputReader
{
    private Scanner scanner;

    /**
     * Constructor of Class InputReader
     */
    public InputReader()
    {
        scanner = new Scanner(System.in);  
    }

    public Scanner getScanner() {
        return scanner;
    }

    /**
     * We will have this method read through a specific file only for
     * Testing purposes. The main scanner will read the keyboards input
     */
    public InputReader (String file) {
        try {
            scanner = new Scanner (new File(file));
        } catch (FileNotFoundException e) {
            System.err.println("The file " + file + " was not found");
            System.exit(1);
        }
    }

    public String getText(String prompt) {
        System.out.println(prompt);
        String input = scanner.nextLine();
        return input;
    }
    
     public int getNumber(String prompt) {
        System.out.println(prompt);
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

}
