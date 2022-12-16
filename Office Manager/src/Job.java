


public class Job {

	final String description;
	String jobCode;
	String owner;

	public Job(String jobCode, String description, String owner) {
		this.jobCode = jobCode;
		this.owner = owner;
		this.description = description;

	}

	public String getDescription() {
		return description;
	}

	public String getJobCode() {
		return jobCode;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

}
