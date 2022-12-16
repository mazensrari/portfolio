/**
 * 
 */

/**
 * @author 44755
 *
 */
public class PrinterMachine extends Machine {

	/**
	 * 
	 */
	public PrinterMachine() {
		super();
		machineType = "PRT";
	}

	@Override
	public void processItsCurrentJob() {
		// Printer will display job description
		// after that the job field switches to null
		Machine prt = new PrinterMachine();
		Job j = this.currentJob;
		prt.acceptJob(j);
		System.out.println("Job desctiption: " + j.getDescription());
		prt.setJobToNull();
	}
}
