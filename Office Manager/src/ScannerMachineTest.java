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
class ScannerMachineTest {

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
		Job job = new Job("SCN001", "Scan this PDF document", "Agatha");
		Machine scn = new ScannerMachine();
		Machine prt = new PrinterMachine();
		scn.acceptJob(job);
		scn.processItsCurrentJob();
		assertEquals("SCN", job.getOwner());
		assertEquals("PRT", job.getJobCode());
		prt.acceptJob(job);
		assertEquals(job, prt.getCurrentJob());
	}

}
