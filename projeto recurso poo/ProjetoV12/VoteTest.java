

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

/**
 * The test class VoteTest.
 *
 * @author  Grupo 4 Turma 7
 * @version 27/06/2022
 */
public class VoteTest
{
    private Vote vote1;
    private Voter voter1;
    private PollingTable pt1;
    
    /**
     * Default constructor for test class VoteTest
     */
    public VoteTest()
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
        vote1 = new Vote(voter1, Parties.A);
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
        assertEquals("A", vote1.getSelectedOption());
        assertEquals(Parties.A, vote1.getPartyVoted());
        assertEquals("Valido", vote1.getVoteType());
        assertFalse(vote1.isAntecipated());
        assertEquals(LocalDate.now(), vote1.getVoteDate());
    }
}