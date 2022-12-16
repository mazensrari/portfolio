/**
 * 
 */

/**
 * @author Mazen Srari
 *
 */
public class CoffeeMachine extends Machine {

	/**
	 * 
	 */
	public CoffeeMachine() {
		super();
		machineType = "CFE";
	}

	@Override
	public void processItsCurrentJob() {
		Machine cfe = new CoffeeMachine();
		Job j = this.currentJob;
		cfe.acceptJob(j);
		if (j.getOwner() == "1") {
			System.out.println("Hooray, your coffee is free. Enjoy!");
		} else {
			System.out.println("You'll be charged 10p for this order. Thank you and have a good day!");
		}
		cfe.setJobToNull();
	}

}
