import java.util.ArrayList;
import java.util.List;
/**
 * A classe Candidate representa um candidato.
 *
 * @author Grupo 4 Turma 7
 * @version 13/05/2022
 */
public class Candidate {
    private Voter voter;
    private VoteManager vm;
    private List <Vote> votes;
    private int numberOfVotesObtained;
    private ElectionType type;
    private Parties party;
    private String role;

    /**
     * Construtor da classe Candidate.
     * Instancia um novo candidato.
     * 
     * @param voter - o votante
     * @param vm - o gerente dos votos
     * @param type - o tipo de eleição
     * @param party - o partido
     * @param role - o cargo
     */
    public Candidate(Voter voter, VoteManager vm, ElectionType type, Parties party, String role) {
        if(voter != null && voter.getAge() > 35 && vm != null && role.equalsIgnoreCase("Presidente")) {
            numberOfVotesObtained = 0;
            this.voter = voter;
            this.vm = vm;
            votes = vm.getVotes();
            this.party = party;
            for(Vote vote : votes) {
                if(vote.getPartyVoted().equals(party)) {
                    numberOfVotesObtained++;
                }
            }
            this.type = type;
            this.role = role;
        }
        else if(voter != null && votes != null && role != "" && role != null) {
            numberOfVotesObtained = 0;
            this.voter = voter;
            this.vm = vm;
            votes = vm.getVotes();
            this.party = party;
            for(Vote vote : votes) {
                if(vote.getPartyVoted().equals(party)) {
                    numberOfVotesObtained++;
                }
            }
            this.type = type;
            this.role = role;
        }
    }
    
    public Voter getVoter() {
        return voter;
    }
    
    public List <Vote> getVotes() {
        return votes;
    }
    
    public int getNumberOfVotesObtained() {
        return numberOfVotesObtained;
    }
    
    public ElectionType getElectionType() {
        return type;
    }
    
    public Parties getPoliticalParty() {
        return party;
    }
    
    public String getRole() {
        return role;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("+++CANDIDATO+++");
        sb.append("\n");
        sb.append("Informacao sobre o candidato: ");
        sb.append("\n");
        sb.append(voter.toString());
        sb.append("\n");
        sb.append("Numero de votos obtidos: ");
        sb.append(numberOfVotesObtained);
        sb.append("\n");
        sb.append("Candidata-se para a eleicao: ");
        sb.append(type);
        sb.append("\n");
        sb.append("Pertence ao partido: ");
        sb.append(party);
        sb.append("\n");
        sb.append("Candidata-se para o seguinte cargo: ");
        sb.append(role);
        sb.append("\n");
        sb.append("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        sb.append("\n");
        
        return sb.toString();
    }
}