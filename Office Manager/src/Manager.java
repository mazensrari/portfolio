import java.util.ArrayList;

public abstract class Manager {

	private ArrayList<Machine> machines;
	private String currentMachine;
	private ArrayList<Job> pendingJobs;

	public Manager() {
		machines = new ArrayList<Machine>();
		currentMachine = null;
		pendingJobs = new ArrayList<Job>();
	}

	// DISCLAIMER: I could've used an Arrays for the machines variable instead of a
	// List.
	// however, I've used the list under suggestion of one of the teaching
	// assistants.
	// this should allow more flexibility, when the office manager may need to add
	// new machines to the system.

//	private void setUpMachines() {
//        machines = new String[6];
//        machines[0] = null;
//        machines[1] = "PRT";
//        machines[2] = "CPY";
//        machines[3] = "SCN";
//        machines[4] = "CFE";
//        machines[5] = "VND";    {

	public ArrayList<Machine> getMachines() {
		return machines;
	}

	public void setMachines(ArrayList<Machine> machines) {
		this.machines = machines;
	}

	public String getCurrentMachine() {
		return currentMachine;
	}

	public void setCurrentMachine(String currentMachine) {
		this.currentMachine = currentMachine;
	}

	public int getSizeOfPendingJobs() {
		return pendingJobs.size();
	}

	public void setPendingJobs(ArrayList<Job> pendingJobs) {
		this.pendingJobs = pendingJobs;
	}

	public void addJob(Job job) {
		pendingJobs.add(job);
	}

	public Machine getWorkingMachine(Job job) {
		String jobCode = job.getJobCode();
		for (Machine m : machines) {
			String machineType = m.getMachineType();
			if (jobCode.equals(machineType)) {
				return m;
			}
		}
		return null;
	}

	public void assignJob(Job job, Machine type) {
		// is there any job ready to be assigned in the arrayList?
		// yes = loop through the arrayList of machines and match the job to the right
		// machine
		// no = no jobs exist therefore no jobs should be assigned
		if (pendingJobs.contains(job)) {
				Machine m = getWorkingMachine(job);
				if (m != null) {
					// assign the job =
					// then that job should be assigned to the machine and the size of the arrayList
					// should be - the job that has been assigned
					m.acceptJob(job);
				} else {
					System.out.println("Sorry, no suitable machine for this job was found.");
					pendingJobs.remove(job);
				}
			}
		pendingJobs.remove(job);
	}


	public void assignEveryJob() {
		for (Job job : pendingJobs) {
			Machine m = getWorkingMachine(job);
			if (m != null) {
				m.acceptJob(job);
			}
		}
	}

	public void addMachine(Machine m) {
		machines.add(m);
	}

	public void processjob() {
		// look at this method as the green light for the processing of jobs
		for (Machine m : machines) {
			m.processItsCurrentJob();
			if (m instanceof ScannerMachine) {
				Job j = ((ScannerMachine) m).clearJob();
				Machine p = getWorkingMachine(j);
				p.acceptJob(j);
				p.processItsCurrentJob();
			}
		}
		pendingJobs.removeAll(pendingJobs);
	}

	protected abstract Listener getStatus(Machine type);

}
