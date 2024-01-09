import java.util.ArrayList;
import java.util.List;
/**
 * A classe CandidateManager serve para gerir uma lista de candidatos.
 *
 * @author Grupo 4 Turma 7
 * @version 27/05/2022
 */
public class CandidateManager {
    private List <Candidate> candidates;

    /**
     * Construtor da classe CandidateManager.
     * Instancia uma nova lista de candidatos.
     */
    public CandidateManager() {
        candidates = new ArrayList <> ();
    }

    /**
     * Metodo para adicionar um candidato na lista.
     *
     * @param candidate - o candidato a adicionar
     * @return true caso seja possivel adicionar falso caso contrario
     */
    public boolean addCandidate(Candidate candidate) {
        if(candidate != null) {
            candidates.add(candidate);
            return true;
        }
        return false;
    }
    
    public List <Candidate> getCandidates() {
        return candidates;
    }
    
    public int getNumberOfCandidates() {
        return candidates.size();
    }
    
    /**
     * Metodo para mostrar informacoes sobre os candidatos da lista.
     */
    public void showCandidatesInfo() {
        if(candidates.isEmpty()) {
            System.out.println("Lista vazia.");
        }
        for(Candidate candidate : candidates) {
            System.out.println("+++CANDIDATOS+++ \n");
            System.out.println(candidate.toString());
        }
    }
}