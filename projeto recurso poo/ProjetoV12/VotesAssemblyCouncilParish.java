/**
 * A classe VotesAssemblyCouncilParish guarda a informacao dos votos para a assembleia, para a camara
 * ou para a freguesia no distrito de Setubal.
 *
 * @author Grupo 4 Turma 7
 * @version 25/05/2022
 */
public class VotesAssemblyCouncilParish {
    private final String tableId;
    private final String parishName;
    private final String politicalParty;
    private final String numberOfVotes;

    /**
     * Construtor da classe VotesAssemblyCouncilParish.
     * 
     * @param tableId - o id da mesa
     * @param parishName - o nome da freguesia
     * @param politicalParty - o partido
     * @param numberOfVotes - o numero de votos
     */
    public VotesAssemblyCouncilParish(String tableId, String parishName, String politicalParty, String numberOfVotes) {
        this.tableId = tableId;
        this.parishName = parishName;
        this.politicalParty = politicalParty;
        this.numberOfVotes = numberOfVotes;
    }

    public String getTableId() {
        return tableId;
    }
    
    public String getParishName() {
        return parishName;
    }
    
    public String getPoliticalParty() {
        return politicalParty;
    }
    
    public String getNumberOfVotes() {
        return numberOfVotes;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("+++INFORMACAO VOTOS+++");
        sb.append("\n");
        sb.append(String.format(" | Freguesia: " + " %12s", parishName));
        sb.append(" | Id da mesa: " + tableId);
        sb.append(" | " + politicalParty);
        sb.append(" | Numero de votos: " + numberOfVotes);
        sb.append("\n");
        sb.append("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        
        return sb.toString();
    }    
}