
/**
 * Write a description of class Employee here.
 * 
 * @author (Mazen Srari) 
 * @version (23/09/2022)
 */
public class Employee
{
    // The age of the employee
    private int age;
    // The number of days holiday the employee is entitled to
    private int numHolidays;
    // The name of this employee
    private String name;
    // The payscale of this employee
    private int payscale;
    // The employee's house number
    private int house;
    // The Employee's street name
    private String street;
    // the Employee's mentor
    private String mentor;

    /**
     * Constructor for objects of class Employee
     */
    public Employee (String givenName, int givenAge)
    {
        name = givenName;
        age = givenAge;
        numHolidays = 10;
        payscale = 1;
    }
    
    /**
     * Constructor for objects of class Employee
     */
    public Employee (String givenName, int givenAge, int givenHouse, 
    String givenStreet, String givenMentor)
    {
        name = givenName;
        age = givenAge;
        numHolidays = 10;
        payscale = 1;
        house = givenHouse;
        street = givenStreet;
        mentor = givenMentor;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getNumHolidays() {
        return numHolidays;
    }

    public int getPayscale() {
        return payscale;
    }

    public void setName(String newName) {
        name = newName;
    }

    public void setNumHolidays(int updateHolidays) {
        numHolidays = updateHolidays;
    }

    public void promote() {
        payscale = payscale + 1;
    }

    public void increaseAge() {
        age = age + 1;
    }

    public String getMentor() { 
        return mentor;
    }

    public String getStreet() {
        return street;
    }

    public int getHouse() { 
        return house;
    }

    public void setMentor(String newMentor) {
        mentor = newMentor;
    }

    public void setHouse(int newHouse) {
        house = newHouse;
    }

    public void setStreet(String newStreet) {
        street = newStreet;
    }
}

