

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

/**
 * The test class CandidateTest.
 *
 * @author  Grupo 4 Turma 7
 * @version 27/06/2022
 */
public class CandidateTest
{
    private Voter voter1;
    private PollingTable pt1;
    private VoteManager vm1;
    private Candidate candidate1;
    private ElectionType type;
    private Parties party;
    private List <Vote> votes;
    
    /**
     * Default constructor for test class CandidateTest
     */
    public CandidateTest()
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
        voter1 = new Voter("Joaquim", 55, pt1, "12345678", true);
        vm1 = new VoteManager();
        type = ElectionType.PRESIDENTIAL;
        party = Parties.A;
        candidate1 = new Candidate(voter1, vm1, type, party, "Presidente");
        votes = candidate1.getVotes();
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
        assertEquals(voter1, candidate1.getVoter());
        assertEquals(votes, candidate1.getVotes());
        assertEquals(0, candidate1.getNumberOfVotesObtained());
        assertEquals(type, candidate1.getElectionType());
        assertEquals(party, candidate1.getPoliticalParty());
        assertEquals("Presidente", candidate1.getRole());
    }
}