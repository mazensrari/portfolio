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
class MachineTest {

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
	void acceptJobTest() {
		Job jb1 = new Job("PRT001", "Print this PDF file", "Michael");
		Machine m = new PrinterMachine();
		m.acceptJob(jb1);
		assertEquals(m.currentJob, jb1);
		Job jb2 = new Job("PRT001", "Print this PDF file", "Michael");
		Machine m2 = new PrinterMachine();
		m.acceptJob(jb2);
		m.goOffline();
		assertEquals(m2.currentJob, null);
		Job jb3 = new Job("PRT001", "Print this PDF file", "Michael");
		Machine m3 = new CoffeeMachine();
		m3.acceptJob(jb3);
		assertEquals(m3.getError(), true);
		m3.resetMachine();
		assertEquals(m3.getError(), false);			
	}
	
	@Test
	void showStatusTest() {
		Machine m = new PrinterMachine();
		Manager l = new Listener("listener");
		m.showStatus();
		l.getStatus(m);
		assertEquals(m.showStatus(), l.getStatus(m));
	}

	@Test
	void notifyListenerTest() {
		Machine m = new CoffeeMachine();
		Manager l = new Listener("listener");
		m.notifyListener(l);
		l.getStatus(m);
		assertEquals(m.showStatus(), l.getStatus(m));
	}
}
