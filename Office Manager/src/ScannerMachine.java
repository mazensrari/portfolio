/**
 * 
 */

/**
 * @author 44755
 *
 */
public class ScannerMachine extends Machine {

	/**
	 * 
	 */
	public ScannerMachine() {
		super();
		machineType = "SCN";
	}

	@Override
	public void processItsCurrentJob() {
//		Scanner passes the job onto Printer
		// It does so by switching the 'owner' to "SCN"
		// it doesn't turn the job null because the job is now for Printer
		Job j = this.currentJob;
		if (j != null) {
			j.setOwner(this.machineType);
			j.setJobCode("PRT");
		}
	}

	public Job clearJob() {
		Machine scn = new ScannerMachine();
		Job j = this.currentJob;
		scn.setJobToNull();
		return j;
	}

}
