 

import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

/**
 * A classe VotesAssemblyCouncilParishManager serve para importar os ficheiros dos votos e gerir a sua informacao.
 *
 * @author Grupo 4 Turma 7 baseado nos codigos exemplo mostrados nas aulas TP's e nos powerpoints
 * @version 25/05/2022
 */
public class VotesAssemblyCouncilParishManager {
    private List <VotesAssemblyCouncilParish> votes;
    private PollingTablesManager ptm;

    /**
     * Construtor da classe VotesAssemblyCouncilParishManager.
     * Instancia um novo gerente para as votos.
     * 
     * @param fileName - nome do ficheiro a ler
     */
    public VotesAssemblyCouncilParishManager(String fileName) {
        this.votes = new ArrayList <> ();
        ptm = new PollingTablesManager("Mesas.csv");
        readVotesInfo(fileName);
    }

    /**
     * Metodo que le a informacao do ficheiro dos votos.
     * 
     * @param fileName - nome do ficheiro a ler
     */
    private void readVotesInfo(String fileName) {
        String str = fileName;
        String line = "";
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(str);
            bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
                String[] aux = line.split(",", 4);
                votes.add(new VotesAssemblyCouncilParish(aux[0], aux[1], aux[2], aux[3]));
            }
        } catch(IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                bufferedReader.close();
            } catch(IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public List <VotesAssemblyCouncilParish> getVotes() {
        return votes;
    }
    
    /**
     * Metodo que retorna todos os partidos.
     * 
     * @param parishName - o nome da freguesia
     * @return List <String> - lista com os partidos
     */
    public List <String> getPoliticalParties(String parishName) {
        List <String> polParties = new ArrayList <> ();
        for(VotesAssemblyCouncilParish vote : votes) {
            if(!polParties.contains(vote.getPoliticalParty())) {
                polParties.add(vote.getPoliticalParty());
            }
        }
        return polParties;
    }
    
    /**
     * Metodo que retorna o numero total de votos de um certo partido.
     * 
     * @param politicalParty - o nome do partido
     */
    public int totalVotesCertainParty(String politicalParty) {
        int numVotes = 0;
        for(VotesAssemblyCouncilParish vote : votes) {
            if(vote.getPoliticalParty().equalsIgnoreCase(politicalParty)) {
                numVotes += Integer.parseInt(vote.getNumberOfVotes());
            }
        }
        return numVotes;
    }
    
    /**
     * Metodo para calcular o partido com mais votos totais.
     */
    public int help(){
        List <Integer> total= new ArrayList <> ();
            int partidoA=totalVotesCertainParty("Partido A");
            int partidoC=totalVotesCertainParty("Partido C");
            int partidoE=totalVotesCertainParty("Partido E");
            int partidoF=totalVotesCertainParty("Partido F");
            int partidoG=totalVotesCertainParty("Partido G");
            total.add(0,partidoA);
            total.add(1,partidoC);
            total.add(2,partidoE);
            total.add(3,partidoF);
            total.add(4,partidoG);
            int totalParty=Collections.max(total);
            return totalParty;

    }
    
    /**
     * Metodo que retorna o numero total de votos de uma determinada freguesia.
     * 
     * @param parishName - o nome da freguesia
     * @return int - o numero total de votos
     */
    public int getTotalVotesInParish(String parishName) {
        int numTotalVotes = 0;
        for(VotesAssemblyCouncilParish vote : votes) {
            if(vote.getParishName().equalsIgnoreCase(parishName)) {
                numTotalVotes += Integer.parseInt(vote.getNumberOfVotes());
            }
        }
        return numTotalVotes;
    }
    
    /**
     * Metodo que retorna o numero de votos que um determinado partido obteve numa certa freguesia.
     * 
     * @param parishName - o nome da freguesia
     * @param politicalParty - o nome do partido
     * @return int - o numero de votos
     */
    public int getNumberOfVotesCertainPartyInParish(String parishName, String politicalParty) {
        int numVotes = 0;
        for(VotesAssemblyCouncilParish vote : votes) {
            if(vote.getParishName().equalsIgnoreCase(parishName) && vote.getPoliticalParty().equalsIgnoreCase(politicalParty)) {
                numVotes += Integer.parseInt(vote.getNumberOfVotes());
            }
        }
        return numVotes;
    }
    
    /**
     * Metodo que retorna a taxa de abstencao de uma determinada freguesia.
     * 
     * @param parishName - o nome da freguesia
     * @return double - a taxa de abstencao (em %)
     */
    public double getAbstentionRateInParish(String parishName) {
        double abstention = 0.0;
        
        double totalVoters = (double) ptm.getNumberOfVotersInParish(parishName);
        double actualVotes = (double) getTotalVotesInParish(parishName);
        
        abstention = ((actualVotes * 100) / totalVoters);
        return abstention;
    }
    
    /**
     * Metodo que retorna o partido vencedor numa determinada freguesia.
     * 
     * @param parishName - o nome da freguesia
     * @return String - o partido vencedor
     */
    public String getWinnerInParish(String parishName) {
        Map <String, Integer> partiesVotes = new HashMap <> ();
        String winner = "";
        for(VotesAssemblyCouncilParish vote : votes) {
            if(vote.getParishName().equalsIgnoreCase(parishName)) {
                partiesVotes.put(vote.getPoliticalParty(), Integer.parseInt(vote.getNumberOfVotes()));
            }
        }
        int maxValueInMap=(Collections.max(partiesVotes.values()));
        for(Map.Entry<String, Integer> entry : partiesVotes.entrySet()) {
            if(entry.getValue() == maxValueInMap) {
                winner = entry.getKey();
            }
        }
        return winner;
    }
    
    /**
     * Metodo que mostra a informacao sobre os votos.
     */
    public void showVotesInfo() {
        for(VotesAssemblyCouncilParish vote : votes) {
            System.out.println(vote.toString());
        }
    }
}