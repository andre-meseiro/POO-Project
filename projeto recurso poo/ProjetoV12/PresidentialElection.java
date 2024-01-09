import java.util.ArrayList;
import java.util.List;
/**
 * A classe PresidentialElection representa uma eleicao presidencial.
 * 
 * @author Grupo 4 Turma 7
 * @version 14/05/2022
 */
public class PresidentialElection extends Election {
    private CandidateManager cm;
    private List <Candidate> candidates;
    private Candidate president;
    private VoteManager vm;
    private List <Vote> votes;
    private int numberOfVotesPresidential;
    private String electionType;
    private String timePeriod;
    
    /**
     * Construtor da classe PresidentialElection.
     * Instancia uma nova eleicao presidencial.
     * 
     * @param type - atributo da super classe
     * @param timePeriod - periodo em que se realiza a eleicao
     * @param cm - gerente de candidatos
     * @param vm - gerente de votos
     */
    public PresidentialElection(ElectionType type, CandidateManager cm, VoteManager vm, String timePeriod) {
        super(type);
        this.cm = cm;
        this.vm = vm;
        this.timePeriod = timePeriod;
        electionType = "Presidencial";
        president = null;
        candidates = cm.getCandidates();
        votes = vm.getVotes();
        numberOfVotesPresidential = votes.size();
    }
    
    public List <Candidate> getCandidates() {
        return candidates;
    }
    
    public List <Vote> getVotes() {
        return votes;
    }
    
    public int getNumberOfVotesPresidential() {
        return numberOfVotesPresidential;
    }
    
    public Candidate getPresident(){
        return president;
    }
    
    @Override
    public String getElectionType() {
        return electionType;
    }
    
    @Override
    public String getTimePeriod() {
        return timePeriod;
    }
    
    /**
     * Elege o Presidente da Republica.
     * 
     * @param candidates - lista de candidatos
     */
    public void electPresident(List <Candidate> candidates) {
        this.candidates = candidates;
        int max = 0;
        int secMax = 0;
        Candidate secCandidate = null;
        for(int i = 0; i < candidates.size(); i++) {
            for(int j = 0; j < candidates.size(); j++) {
                if(candidates.get(i).getNumberOfVotesObtained() > max && candidates.get(i).getNumberOfVotesObtained() >= 0.5 * numberOfVotesPresidential) {
                    max = candidates.get(i).getNumberOfVotesObtained();
                    president = candidates.get(i);
                }
                if(candidates.get(j).getNumberOfVotesObtained() > secMax && candidates.get(i).getNumberOfVotesObtained() <= max) {
                    secMax = candidates.get(j).getNumberOfVotesObtained();
                    secCandidate = candidates.get(j);
                }
                if(max == secMax || max < 0.5 * numberOfVotesPresidential) {
                    clean();
                    secondRound(president, secCandidate);
                }
            }
        }
    }
    
    /**
     * Metodo que mostra no ecra o numero de votos que cada candidato obteve.
     */
    public void getNumberOfVotesEachCandidate() {
        for(Candidate candidate : candidates) {
            System.out.println(candidate.getNumberOfVotesObtained());
        }
    }
    
    /**
     * Metodo que mostra no ecra a percentagem de votos obtida pelos candidatos.
     * 
     */
    public void getVotesPercentage() {
        for(Candidate candidate : candidates) {
            System.out.println((candidate.getNumberOfVotesObtained() * 100) / numberOfVotesPresidential);
        }
    }
    
    /**
     * Metodo auxiliar que representa a segunda volta, caso exista empate ou nenhum dos candidatos obtenha 50% dos votos.
     * 
     * @param candidate1, candidate2 - candidatos que tenham empatado ou obtido o maior numero de votos
     */
    private void secondRound(Candidate candidate1, Candidate candidate2) {
        if(candidate1.getNumberOfVotesObtained() > candidate2.getNumberOfVotesObtained()){
            president = candidate1;
        }
        else {
            president = candidate2;
        }
    }
    
    /**
     * Metodo auxiliar que limpa a lista de votos.
     */
    private void clean(){
        votes.clear();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("+++ELEICAO PRESIDENCIAL+++");
        sb.append("\n");
        sb.append("Tipo de eleicao: ");
        sb.append(electionType);
        sb.append("\n");
        sb.append("Periodo em que decorre a eleicao: ");
        sb.append(timePeriod);
        sb.append("\n");
        sb.append("Informacoes sobre o presidente eleito: ");
        sb.append("\n");
        sb.append(president.toString());
        sb.append("\n");
        sb.append("Informacao sobre os candidatos: ");
        sb.append("\n");
        for(Candidate candidate : candidates) {
            sb.append(candidate.toString());
        }
        sb.append("\n");
        sb.append("Numero de votos: ");
        sb.append(numberOfVotesPresidential);
        sb.append("\n");
        sb.append("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        
        return sb.toString();
    }
}