 

import java.util.ArrayList;
import java.util.List;
/**
 * A classe LocalElection representa uma eleicao autarquica.
 * 
 * @author Grupo 4 Turma 7
 * @version 14/05/2022
 */
public class LocalElection extends Election {
    private Candidate townHallRepresentative;
    private Candidate cityCouncilRepresentative;
    private Candidate parishAssembliesRepresentative;
    private int numberOfMandates;
    private int numberOfVotesLocal;
    private String electionType;
    private String timePeriod;
    private VotesAssemblyCouncilParishManager vac;
    private VotesAssemblyCouncilParishManager vac2;
    private VotesAssemblyCouncilParishManager vac3;
    private List <VotesAssemblyCouncilParish> votes;
    private List <VotesAssemblyCouncilParish> votes2;
    private List <VotesAssemblyCouncilParish> votes3;
    
    /**
     * Construtor da classe LocalElection.
     * Instancia uma nova eleicao autarquica.
     * 
     * @param type - atributo da super classe
     * @param timePeriod - periodo em que se realiza a eleicao
     */
    public LocalElection(ElectionType type, String timePeriod) {
        super(type);
        electionType = "Autarquica";
        this.timePeriod = timePeriod;
        votes = vac.getVotes();
        votes2 = vac2.getVotes();
        votes3 = vac3.getVotes();
        numberOfVotesLocal = votes.size() + votes2.size() + votes.size();
        townHallRepresentative = null;
        cityCouncilRepresentative = null;
        parishAssembliesRepresentative = null;
        numberOfMandates = 0;
        vac = new VotesAssemblyCouncilParishManager("VotosFreguesias.csv");
        vac2 = new VotesAssemblyCouncilParishManager("VotosAssembleia.csv");
        vac3 = new VotesAssemblyCouncilParishManager("VotosCamara.csv");
    }
    
    @Override
    public String getElectionType(){
        return electionType;
    }
    
    @Override
    public String getTimePeriod(){
        return timePeriod; 
    }
    
    public int getNumberOfVotesLocal(){
        return numberOfVotesLocal;
    }
    
    /**
     * Calcula o numero de mandatos atribuidos de acordo com o Metodo de Hondt.
     */
    public void CalculateMandates() {
        
    }
    
    public int getNumberOfMandates(){
        return numberOfMandates;
    }
    
    /**
     * Elege o representante para a camara municipal.
     */
    public void electHallRepresentative(String councilName) {
        
    }
    
    public Candidate getTownHallRepresentative(){
        return townHallRepresentative;
    }
    
    /**
     * Elege o representante para a assembleia municipal.
     * 
     * @param candidate - lista de candidatos
     */
    public void electCouncilRepresentative(String councilName) {
        
    }
    
    public Candidate getCityRepresentative(){
        return cityCouncilRepresentative;
    }
    
    /**
     * Elege o representante para as assembleia de freguesia.
     * 
     * @param candidates - lista de candidatos
     */
    public void electAssembliesRepresentative(String parishName) {
        vac.getWinnerInParish(parishName);
    }
    
    public Candidate getParishAssembliesRepresentative() {
        return parishAssembliesRepresentative;
    }
    
    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
       
       sb.append("+++ELEICAO AUTARQUICA+++");
       sb.append("\n");
       sb.append("Tipo de eleicao: ");
       sb.append(electionType);
       sb.append("\n");
       sb.append("Periodo em que decorre a eleicao: ");
       sb.append(timePeriod);
       sb.append("Informacoes sobre os representantes eleitos: ");
       sb.append(townHallRepresentative.toString());
       sb.append("\n");
       sb.append(cityCouncilRepresentative.toString());
       sb.append("\n");
       sb.append(parishAssembliesRepresentative.toString());
       sb.append("\n");
       sb.append("Numero de mandatos atribuidos: ");
       sb.append(numberOfMandates);
       sb.append("\n");
       sb.append("Numero de votos: ");
       sb.append(numberOfVotesLocal);
       sb.append("\n");
       sb.append("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
       
       return sb.toString();
    }
}