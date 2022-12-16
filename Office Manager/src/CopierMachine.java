/**
 * 
 */

/**
 * @author Mazen Srari
 *
 */
public class CopierMachine extends Machine {

	private int copies;

	/**
	 * 
	 */
	public CopierMachine() {
		super();
		machineType = "CPY";
	}

	public void setNumberOfCopies(int copies) {
		this.copies = copies;
	}

	public int getCopies() {
		return copies;
	}

	@Override
	public void processItsCurrentJob() {
		// Copiers need an extra variable for copies
		// LOOP output with prefix e.g. printed 1 of 4 copies
		// at the end of that loop, the job field switches to null
		Machine cpy = new CopierMachine();
		cpy.acceptJob(this.currentJob);
		for (int i = 0; i < copies; i++) {
			System.out.println("Printed: " + i + "of" + copies + "copies.");
		}
		cpy.setJobToNull();
	}

}
