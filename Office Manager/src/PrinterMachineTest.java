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
class PrinterMachineTest {

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
		Job j = new Job("PRT001", "Print this PDF document", "John");
		PrinterMachine printer = new PrinterMachine();
		printer.acceptJob(j);
		printer.processItsCurrentJob();
		assertEquals("Print this PDF document", j.getDescription());
		printer.setJobToNull();
		assertNull(printer.getCurrentJob());
	}

}
