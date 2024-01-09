

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class VoterTest.
 *
 * @author  Grupo 4 Turma 7
 * @version 27/06/2022
 */
public class VoterTest
{
    private Voter voter1;
    private PollingTable pt1;
    
    /**
     * Default constructor for test class VoterTest
     */
    public VoterTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        pt1 = new PollingTable("6", "99", "Sado", "1", "933");
        voter1 = new Voter("Joana", 22, pt1, "12345678", true);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
    
    /**
     * Test creation and the initial state of a voter.
     */
    @Test
    public void testConstructor() {
        assertEquals("Joana", voter1.getName());
        assertEquals(22, voter1.getAge());
        assertEquals(pt1, voter1.getPollingTable());
        assertEquals("12345678", voter1.getNumber());
        assertTrue(voter1.isInPortugal());
    }
}