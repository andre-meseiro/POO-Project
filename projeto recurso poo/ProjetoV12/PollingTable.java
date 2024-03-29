/**
 * A classe PollingTable representa uma mesa de voto.
 *
 * @author Grupo 4 Turma 7
 * @version 05/05/2022 (atualizacao 24/05/2022)
 */
public class PollingTable {
    private final String tableId;
    private final String associatedParishId;
    private final String associatedParishName;
    private final String tableNumber;
    private final String numberOfVotersTable;
    private static final int OPENING_TIME = 8;
    private static final int CLOSING_TIME = 19;

    /**
     * Construtor da classe PollingTable.
     * Instancia uma nova mesa de voto.
     * 
     * @param tableId - id da mesa de voto
     * @param associatedParishId - id da freguesia onde a mesa de voto se encontra
     * @param associatedParishName - nome da freguesia onde a mesa de voto se encontra
     * @param tableNumber - numero da mesa
     * @param numberOfVotersTable - numero de eleitores da mesa
     */
    public PollingTable(String tableId, String associatedParishId, String associatedParishName, String tableNumber, String numberOfVotersTable ) {
        this.tableId = tableId;
        this.associatedParishId = associatedParishId;
        this.associatedParishName = associatedParishName;
        this.tableNumber = tableNumber;
        this.numberOfVotersTable = numberOfVotersTable;
    }
    
    public String getTableId() {
        return tableId;
    }
    
    public String getAssociatedParishId() {
        return associatedParishId;
    }
    
    public String getAssociatedParishName() {
        return associatedParishName;
    }
    
    public String getTableNumber() {
        return tableNumber;
    }
    
    public String getNumberOfVotersTable() {
        return numberOfVotersTable;
    }
    
    public String getVotingPeriod() {
        return (OPENING_TIME + " ate " + CLOSING_TIME);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("+++MESA DE VOTO+++");
        sb.append("\n");
        sb.append("ID da mesa: ");
        sb.append(tableId);
        sb.append("\n");
        sb.append("ID da junta de freguesia da mesa: ");
        sb.append(associatedParishId);
        sb.append("\n");
        sb.append("Nome da freguesia onde se encontra a mesa: ");
        sb.append(associatedParishName);
        sb.append("\n");
        sb.append("Numero da mesa: ");
        sb.append(tableNumber);
        sb.append("\n");
        sb.append("Numero de votantes da mesa: ");
        sb.append(numberOfVotersTable);
        sb.append("\n");
        sb.append("Pode votar: ");
        sb.append(getVotingPeriod());
        sb.append("\n");
        sb.append("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        
        return sb.toString();
    }
}