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
class CoffeeMachineTest {

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
		Job j = new Job("CFE001", "Oat Latte", "Manuel");
		CoffeeMachine coffee = new CoffeeMachine();
		coffee.acceptJob(j);
		coffee.processItsCurrentJob();
		coffee.setJobToNull();
		assertNull(coffee.getCurrentJob());
		Job j2 = new Job("CFE002", "Coconut Latte", "1");
		coffee.acceptJob(j2);
		coffee.processItsCurrentJob();
		coffee.setJobToNull();
		assertNull(coffee.getCurrentJob());
	}
}
