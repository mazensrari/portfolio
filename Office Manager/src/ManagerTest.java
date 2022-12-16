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
class ManagerTest {

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

//	@Test
//	void constructorTest() {
//		Manager mg = new Manager();
//		assertNotNull(mg);
//	}

	@Test
	void assignJobTest() {
	Job jb1 = new Job("PRT001", "Print this PDF file", "Michael");
	Machine m = new PrinterMachine();
	Manager mg = new Listener("Office Manager");
	mg.addJob(jb1);
	assertEquals(1, mg.getSizeOfPendingJobs());
	mg.assignJob(jb1,m);
    m.acceptJob(jb1);
    assertEquals(0, mg.getSizeOfPendingJobs());
	}
}
