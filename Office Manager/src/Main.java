/**
 * 
 */

/**
 * @author 44755
 *
 */
public class Main {

	public static void main(String[] args) {
		Manager m = new Listener("Listener London Office");
		m.assignEveryJob();
		m.processjob();
		System.out.println("Welcome to the Office Equipment Management Software.");
	}
}
