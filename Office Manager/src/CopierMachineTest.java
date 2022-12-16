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
class CopierMachineTest {

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
		Job j = new Job("CPY001", "Copy this pdf file please", "Anthony");
        CopierMachine copierMachine = new CopierMachine();
        copierMachine.acceptJob(j);
        copierMachine.processItsCurrentJob();
		copierMachine.setNumberOfCopies(7);
		assertEquals(7, copierMachine.getCopies());
		copierMachine.setJobToNull();
		assertNull(copierMachine.getCurrentJob());
	}

}
