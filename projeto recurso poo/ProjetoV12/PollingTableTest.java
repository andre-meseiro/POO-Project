

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class PollingTableTest.
 *
 * @author  Grupo 4 Turma 7
 * @version 27/06/2022
 */
public class PollingTableTest
{
    private PollingTable pt1;
    
    /**
     * Default constructor for test class PollingTableTest
     */
    public PollingTableTest()
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
        assertEquals("6", pt1.getTableId());
        assertEquals("99", pt1.getAssociatedParishId());
        assertEquals("Sado", pt1.getAssociatedParishName());
        assertEquals("1", pt1.getTableNumber());
        assertEquals("933", pt1.getNumberOfVotersTable());
        assertEquals("8 ate 19", pt1.getVotingPeriod());
    }
}