/**
 * 
 */

/**
 * @author 44755
 *
 */
public class VendingMachine extends Machine {

	/**
	 * 
	 */
	public VendingMachine() {
		super();
		machineType = "VND";
	}

	@Override
	public void processItsCurrentJob() {
		Machine vnd = new VendingMachine();
		Job j = this.currentJob;
		vnd.acceptJob(j);
		if (j.getOwner() == "1") {
			System.out.println("Hooray, your food is free. Enjoy!");
		} else {
			System.out.println("You'll be charged 10p for this order. Thank you and have a good day!");
		}
		vnd.setJobToNull();
	}
}
