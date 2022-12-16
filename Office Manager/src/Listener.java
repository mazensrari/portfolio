
public class Listener extends Manager {

	private String listener;

	public Listener(String listener) {
		super();
		this.listener = listener;
	}

	public String getListener() {
		return listener;
	}

	public void setListener(String newListener) {
		listener = newListener;
	}

	public Listener getStatus(Machine type) {
		return type.showStatus();
	}

}