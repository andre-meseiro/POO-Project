import java.util.ArrayList;
import java.util.List;
/**
 * A classe VoteManager serve para gerir uma lista de votos.
 *
 * @author Grupo 4 Turma 7
 * @version 25/05/2022
 */
public class VoteManager {
    private List <Vote> votes;

    /**
     * Construtor da classe VoteManager.
     * Instancia uma nova lista de votos.
     */
    public VoteManager() {
        votes = new ArrayList <> ();
    }
    
    /**
     * Metodo para adicionar um voto na lista.
     * 
     * @param vote - o voto a adicionar
     */
    public boolean addVote(Vote vote) {
        if(vote != null) {
            votes.add(vote);
            return true;
        }
        return false;
    }
    
    public int getNumberOfVotesList() {
        return votes.size();
    }
    
    public List <Vote> getVotes() {
        return votes;
    }
    
    /**
     * Método para limpar a lista de votos.
     */
    public void clearVotes() {
        votes.clear();
    }
    
    /**
     * Metodo que retorna o numero de votos validos.
     * 
     * @return int - o numero de votos
     */
    public int getValidVotes() {
        int validVotes = 0;
        for(Vote vote : votes) {
            if(vote.getVoteType().equalsIgnoreCase("Valido")) {
                validVotes++;
            }
        }
        return validVotes;
    }
    
    /**
     * Metodo que retorna o numero de votos invalidos.
     * 
     * @return int - o numero de votos
     */
    public int getInvalidVotes() {
        int invalidVotes = 0;
        for(Vote vote : votes) {
            if(vote.getVoteType().equalsIgnoreCase("Nulo") || vote.getVoteType().equalsIgnoreCase("Branco")) {
                invalidVotes++;
            }
        }
        return invalidVotes;
    }
    
    /**
     * Metodo que retorna a taxa de abstencao.
     * 
     * @return double - a taxa de abstencao (em %)
     */
    public double getAbstentionRate() {
        double abstention = 0.0;
        
        double votes = (double) getValidVotes();
        double numberOfVotes = (double) getNumberOfVotesList();
        
        abstention = ((votes * 100) / numberOfVotes);
        return abstention;
    }
    
    /**
     * Metodo para mostra a informacao dos votos contidos na lista.
     */
    public void showVotesInfo() {
        if(votes.isEmpty()) {
            System.out.println("Lista de votos vazia");
        }
        else {
            for(Vote vote : votes) {
                System.out.println("+++VOTOS+++ \n");
                System.out.println("Numero de votos contidos na lista: " + votes.size() + "\n");
                System.out.println(vote.toString());
            }
        }
    }
}