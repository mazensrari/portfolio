
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class EmployeeTest.
 *
 * @author  (Mazen Srari)
 * @version (23/09/2022)
 */
public class EmployeeTest
{
    /**
     * Default constructor for test class EmployeeTest
     */
    public EmployeeTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void nameCorrect() {
        Employee emp1 = new Employee("James", 20);
        assertEquals("James", emp1.getName());
        Employee emp2 = new Employee("Sarah", 25);
        assertEquals("Sarah", emp2.getName());
    }

    @Test
    public void ageCorrect() {
        Employee emp1 = new Employee("James", 20);
        assertEquals(20, emp1.getAge());
        Employee emp2 = new Employee("Sarah", 25, 4, "Saturn Road", "K");
        assertEquals(25, emp2.getAge());
    }

    @Test
    public void numHolidays() {
        Employee emp1 = new Employee("James", 20, 1, "Jorge Street", "M");
        assertEquals(10, emp1.getNumHolidays());
        Employee emp2 = new Employee("Sarah", 25, 4, "Saturn Road", "K");
        assertEquals(10, emp2.getNumHolidays());
    }

    @Test
    public void payscale() {
        Employee emp1 = new Employee("James", 20, 1, "Jorge Street", "M");
        assertEquals(1, emp1.getPayscale());
        Employee emp2 = new Employee("Sarah", 25, 4, "Saturn Road", "K");
        assertEquals(1, emp2.getPayscale());
    }

    @Test
    public void changeName() {
        Employee emp1 = new Employee("Sarah", 25, 4, "Saturn Road", "K");
        assertEquals("Sarah", emp1.getName());
        emp1.setName("Sarah Someone");
        assertEquals("Sarah Someone", emp1.getName());
    }

    @Test
    public void updateNumHolidays() {
        Employee emp1 = new Employee("James", 20, 1, "Jorge Street", "M");
        assertEquals(10, emp1.getNumHolidays());
        emp1.setNumHolidays(15);
        assertEquals(15, emp1.getNumHolidays());
    }

    @Test
    public void updatePayscale() {
        Employee emp1 = new Employee("James", 20, 1, "Jorge Street", "M");
        assertEquals(1, emp1.getPayscale());
        emp1.promote();
        assertEquals(2, emp1.getPayscale());
        emp1.promote();
        assertEquals(3, emp1.getPayscale());
    }

    @Test
    public void haveBirthday() {
        Employee emp1 = new Employee("James", 20, 1, "Jorge Street", "M");
        assertEquals(20, emp1.getAge());
        emp1.increaseAge();
        assertEquals(21, emp1.getAge());
        emp1.increaseAge();
        assertEquals(22, emp1.getAge());
    }

    @Test
    public void houseCorrect() {
        Employee emp1 = new Employee("James", 20, 1, "Jorge Street", "M");
        assertEquals(1, emp1.getHouse());
        Employee emp2 = new Employee("Sarah", 25, 4, "Saturn Road", "K");
        assertEquals(4, emp2.getHouse());
    }

    @Test
    public void updateHouse() {
        Employee emp1 = new Employee("James", 20, 1, "Jorge Street", "M");
        assertEquals(1, emp1.getHouse());
        emp1.setHouse(6);
        assertEquals(6, emp1.getHouse());
    }

    @Test
    public void streetCorrect() {
        Employee emp1 = new Employee("James", 20, 1, "Jorge Street", "M");
        assertEquals("Jorge Street", emp1.getStreet());
        Employee emp2 = new Employee("Sarah", 25, 4, "Saturn Road", "K");
        assertEquals("Saturn Road", emp2.getStreet());
    }

    @Test
    public void updateStreet() {
        Employee emp1 = new Employee("Sarah", 25, 4, "Saturn Road", "K");
        assertEquals("Saturn Road", emp1.getStreet());
        emp1.setStreet("Buckingham Street");
        assertEquals("Buckingham Street", emp1.getStreet());
    }
    
    @Test
    public void mentorCorrect() {
        Employee emp1 = new Employee("James", 20, 1, "Jorge Street", "M");
        assertEquals("M", emp1.getMentor());
        emp1.setMentor("J");
        assertEquals("J", emp1.getMentor());
    }

    @Test
    public void updateMentor() {
         Employee emp1 = new Employee("James", 20, 1, "Jorge Street", "M");
        assertEquals("M", emp1.getMentor());
        emp1.setMentor("K");
        assertEquals("K", emp1.getMentor());
    }
}
