import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * @author 44755
 *
 */
class VendingMachineTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void processItsCurrentJobTest() {
		Job j = new Job("VND001", "Twix chocolate bars", "Michela");
		VendingMachine vending = new VendingMachine();
		vending.acceptJob(j);
		vending.processItsCurrentJob();
		vending.setJobToNull();
		assertNull(vending.getCurrentJob());
		Job j2 = new Job("VND002", "Snickers chocolate bars", "1");
		vending.acceptJob(j2);
		vending.processItsCurrentJob();
		vending.setJobToNull();
		assertNull(vending.getCurrentJob());
	}

}
