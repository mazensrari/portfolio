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
class JobTest {

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
	void constructorTest() {
		Job job1 = new Job("PRT001","Print this new file please", "Mike");
		assertNotNull(job1);
	}

	@Test
	void getJobCodeTest() {
		Job job1 = new Job("PRT001","Print this new file please", "Mike");
		assertEquals("PRT001", job1.getJobCode());
	}

	@Test
	void getOwnerTest() {
		Job job1 = new Job("PRT001", "Print this new file please", "Mike");
		assertEquals("Mike", job1.getOwner());
	}

	@Test
	void getDescriptionTest() {
		Job job1 = new Job("PRT001", "Print this new file please", "Mike");
		assertEquals("Print this new file please", job1.getDescription());

	}
}
