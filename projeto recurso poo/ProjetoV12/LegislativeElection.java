 

import java.util.ArrayList;
import java.util.List;
import java.util.*;
/**
 * A classe LegislativeElection representa uma eleicao legislativa.
 * 
 * @author Grupo 4 Turma 7
 * @version 14/05/2022
 */
public class LegislativeElection extends Election {
    private int numberOfMandates;
    private int numberOfVotesLegislatives;
    private String representative;
    private String electionType;
    private String timePeriod;
    private VotesAssemblyCouncilParishManager vac;
    private List <VotesAssemblyCouncilParish> votes;
    
    /**
     * Construtor da classe LegislativeElection.
     * Instancia uma nova eleicao legislativa.
     * 
     * @param type - atributo da super classe
     * @param timePeriod - periodo em que se realiza a eleicao
       */
    public LegislativeElection(ElectionType type, String timePeriod) {
        super(type);
        electionType = "Legislativa";
        this.timePeriod = timePeriod;
        representative = null;
        numberOfMandates = 0;
        vac = new VotesAssemblyCouncilParishManager("VotosFreguesias.csv");
        votes = vac.getVotes();
        numberOfVotesLegislatives = votes.size();
     }
    
    @Override
    public String getElectionType() {
        return electionType;
    }
    
    @Override
    public String getTimePeriod() {
        return timePeriod; 
    }
    
    public int getNumberOfVotesLegislatives() {
        return numberOfVotesLegislatives;
    }
    
    /**
     * Elege o representante.
     * 
     * @param candidates - lista de candidatos
     */
    public void electRepresentative() {
        vac.help();
    }
    
    /*
    private void backSecond(Candidate candidate1, Candidate candidate2) {
        if(candidate1.getNumberOfVotesObtained() > candidate2.getNumberOfVotesObtained()){
            representative = candidate1;
        }
        else{
            representative = candidate2;
        }
    }
    
    private void clean(){
        votes.clear();
    }
   
    public Candidate getRepresentative() {
        return representative;
    }
    
    /**
     * Calcula o numero de mandatos atribuidos de acordo com o Metodo de Hondt.
     */
    
    /*
    public void CalculateMandates() {
        ArrayList<Double> values = new ArrayList<>();
        double countA, countB, countC, countD, countE, countF, countG;
        countA=0;
        countB=0;
        countC=0;
        countD=0;
        countE=0;
        countF=0;
        countG=0;
        int max=0;
        
        for(int i = 0; i < votes.size(); i++){
            if(votes.get(i).getSelectedOption().equalsIgnoreCase("A")){
                countA++;
            }
             else if(votes.get(i).getSelectedOption().equalsIgnoreCase("B")){
                countB++;
            }else if(votes.get(i).getSelectedOption().equalsIgnoreCase("C")){
                countC++;
            }else if(votes.get(i).getSelectedOption().equalsIgnoreCase("D")){
                countD++;
            }else if(votes.get(i).getSelectedOption().equalsIgnoreCase("E")){
                countE++;
            }else if(votes.get(i).getSelectedOption().equalsIgnoreCase("F")){
                countF++;
            }else if(votes.get(i).getSelectedOption().equalsIgnoreCase("G")){
                countG++;
            }
        
            for(int j = 1; j < 132; j++){
               double totalA = countA/j;
               double totalB = countB/j;
               double totalC = countC/j;
               double totalD = countD/j;
               double totalE = countE/j;
               double totalF = countF/j;
               double totalG = countG/j;
               
               values.add(totalA);
               values.add(totalB);
               values.add(totalC);
               values.add(totalD);
               values.add(totalE);
               values.add(totalF);
               values.add(totalG);
            }
        }
            Collections.sort(values, Collections.reverseOrder());
        for(int k = 1; k < values.size(); k++){
            System.out.println("Numero de votos: "+ votes.get(k).getSelectedOption());
                        
        }
        
    }
    */    
    /**
     * Metodo que mostra no ecra a percentagem de votos obtida pelos partidos.
     * 
     */
    public void getVotesPercentage() {
        System.out.println("O partido A teve: " + vac.totalVotesCertainParty("Partido A")/vac.help());
        System.out.println("O partido B teve: " + vac.totalVotesCertainParty("Partido B")/vac.help());
        System.out.println("O partido C teve: " + vac.totalVotesCertainParty("Partido C")/vac.help());
        System.out.println("O partido E teve: " + vac.totalVotesCertainParty("Partido D")/vac.help());
        System.out.println("O partido F teve: " + vac.totalVotesCertainParty("Partido E")/vac.help());
        System.out.println("O partido G teve: " + vac.totalVotesCertainParty("Partido F")/vac.help());
        System.out.println("O partido A teve: " + vac.totalVotesCertainParty("Partido G")/vac.help());
    }
    
    public int getNumberOfMandates() {
        return numberOfMandates;
    }
    
    @Override
    public String toString(){
       StringBuilder sb = new StringBuilder();
       
       sb.append("+++ELEICAO LEGISLATIVA+++");
       sb.append("\n");
       sb.append("Tipo de eleicao: ");
       sb.append(electionType);
       sb.append("\n");
       sb.append("Periodo em que decorre a eleicao: ");
       sb.append(timePeriod);
       sb.append("Informacoes sobre o representante eleito: ");
       sb.append(representative.toString());
       sb.append("Numero de mandatos atribuidos: ");
       sb.append(numberOfMandates);
       sb.append("\n");
       sb.append("Informacao sobre os candidatos: ");
       sb.append("\n");
       sb.append("Numero de votos: ");
       sb.append(numberOfVotesLegislatives);
       sb.append("\n");
       sb.append("+++++++++++++++++++++++++++++++++++++++++++++++++");
       
       return sb.toString();
    }
}