import java.util.ArrayList;
import java.util.List;

/**
 * A classe TestPresidential serve para simular e testar as funcionalidades implementadas para uma eleicao presidencial com votos manuais.
 *
 * @author Grupo 4 Turma 7
 * @version 26/06/2022
 */
public class TestPresidential {
    private PollingTable pt;
    private Voter voter1, voter2, voter3, voter4, voter5;
    private Vote vote1, vote2, vote3;
    private VoteManager vm;
    private Candidate candidate1, candidate2, president;
    private CandidateManager cm;
    private PresidentialElection pe;
    private List <Vote> votes;
    private List <Candidate> candidates;

    /**
     * Construtor da classe TestPresidential.
     * Instancia uma nova simulacao de teste.
     */
    public TestPresidential() {
       pt = new PollingTable("1", "5", "Freguesia de teste", "4", "5");
       
       voter1 = new Voter("Joao", 20, pt, "12345678", true);
       voter2 = new Voter("Ana", 21, pt, "87654321", true);
       voter3 = new Voter("Manuel", 22, pt, "11223344", true);
       voter4 = new Voter("Marcelo", 50, pt, "11111111", true);
       voter5 = new Voter("Antonio", 55, pt, "22222222", true);
       
       vote1 = new Vote(voter1, Parties.A);
       vote2 = new Vote(voter2, Parties.A);
       vote3 = new Vote(voter3, Parties.B);
       
       vm = new VoteManager();
       vm.addVote(vote1);
       vm.addVote(vote2);
       vm.addVote(vote3);
       
       candidate1 = new Candidate(voter4, vm, ElectionType.PRESIDENTIAL, Parties.A, "Presidente");
       candidate2 = new Candidate(voter5, vm, ElectionType.PRESIDENTIAL, Parties.B, "Presidente");
       
       cm = new CandidateManager();
       cm.addCandidate(candidate1);
       cm.addCandidate(candidate2);
       
       pe = new PresidentialElection(ElectionType.PRESIDENTIAL, cm, vm, "8:00-19:00");
       votes = pe.getVotes();
       candidates = pe.getCandidates();
       president = pe.getPresident();
    }

    /**
     * Teste ao metodo que elege o Presidente da Republica.
     */
    public void testElectPresident() {
        pe.electPresident(candidates);
    }
    
    /**
     * Teste ao metodo que mostra no ecra o numero de votos que cada candidato obteve.
     */
    public void testNumberOfVotesEachCandidate() {
        pe.getNumberOfVotesEachCandidate();
    }
    
    /**
     * Teste ao metodo que mostra no ecra a percentagem de votos obtida pelos candidatos.
     */
    public void testGetVotesPercentage() {
        pe.getVotesPercentage();
    }
    
    /**
     * Teste ao metodo que mostra no ecra informacao sobre a eleicao.
     */
    public void testShowInfo() {
        System.out.println(pe.toString());
    }
}