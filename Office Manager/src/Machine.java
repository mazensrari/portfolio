import java.util.ArrayList;

public abstract class Machine {

	protected String machineType;
	private Boolean online;
	private Boolean error;
	private ArrayList<Listener> listeners;
	protected Job currentJob;

	public Machine() {
		listeners = new ArrayList<Listener>();
		machineType = null;
		online = true;
		error = false;
		currentJob = null;
	}

	public Boolean goOnline() {
		return online = true;
	}

	public Boolean goOffline() {
		return online = false;
	}
	
	public Boolean goError() {
		return error = true;
	}

	public Boolean resetMachine() {
		return error = false;
	}

	public Job displayJob() {
		return currentJob;
	}

	public Job setJobToNull() {
		return this.currentJob = null;
	}

	public Machine acceptJob(Job job) {
		if (currentJob == null && online == true && error == false && (job.jobCode.contains(machineType))) {
			currentJob = job;
		} else if (!job.jobCode.contains(machineType)) {
			goError();
			System.out.println("This job code didn't match the machine type. The machine needs a reset.");
		} else {
			System.out.println("This job couldn't be accepted by the machine. Please check the machine status.");
		}
		return null;
	}

	public abstract void processItsCurrentJob();

	public String getMachineType() {
		return machineType;
	}

	public Boolean getOnline() {
		return online;
	}

	public Boolean getError() {
		return error;
	}

	public Job getCurrentJob() {
		return currentJob;
	}

	public void registerListener(Listener listener) {
		listeners.add(listener);
	}

	public Listener showStatus() {
		for (Listener l : listeners) {
			if (online = true) {
				l.getStatus(this);
				System.out.println("The machine is online");
			}
			if (online = false) {
				l.getStatus(this);
				System.out.println("The machine is offline");
			}
			if (error = false) {
				l.getStatus(this);
				System.out.println("The machine is not in an error status");
			}
			if (error = true) {
				l.getStatus(this);
				System.out.println("The machine is in an error status");
			}
		}
		return null;
	}

	public void notifyListener(Manager listener) {
		if (online == true || online == false || error == true || error == false) {
			showStatus();
		}
	}

}
