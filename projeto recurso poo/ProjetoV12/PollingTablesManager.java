import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
/**
 * A classe PollingTablesManager serve para importar o ficheiro das mesas e gerir a sua informacao.
 *
 * @author Grupo 4 Turma 7 baseado nos codigos exemplo mostrados nas aulas TP's e nos powerpoints
 * @version 24/05/2022
 */
public class PollingTablesManager {
    private List <PollingTable> tables;

    /**
     * Construtor da classe PollingTablesManager.
     * Instancia um novo gerente para as mesas de voto.
     * 
     * @param fileName - nome do ficheiro a ler
     */
    public PollingTablesManager(String fileName) {
        this.tables = new ArrayList <> ();
        readTablesInfo(fileName);
    }
    
    /**
     * Metodo que le a informacao do ficheiro das mesas.
     * 
     * @param fileName - nome do ficheiro a ler
     */
    private void readTablesInfo(String fileName) {
        String str = fileName;
        String line = "";
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(str);
            bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
                String[] aux = line.split(",", 5);
                tables.add(new PollingTable(aux[0], aux[1], aux[2], aux[3], aux[4]));
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
    
    /**
     * Metodo que retorna uma lista com as mesas que estao numa determinada freguesia.
     * 
     * @param parishName - o nome da freguesia
     * @return List <PollingTable> - lista com as mesas
     */
    public List <PollingTable> getTablesInParish(String parishName) {
        if(parishName == "" || parishName == null) {
            return null;
        }
        else {
            List <PollingTable> tablesInParish = new ArrayList <> ();
            for(PollingTable pollingTable : tables) {
                if(pollingTable.getAssociatedParishName().equalsIgnoreCase(parishName)) {
                    tablesInParish.add(pollingTable);
                }
            }
            return tablesInParish;
        }
    }
    
    /**
     * Metodo que retorna o numero de votantes de uma determinada mesa.
     * 
     * @param parishName - nome da freguesia
     * @param tableId - o id da mesa
     * @return int - o numero de votantes da mesa
     */
    public int getNumberOfVotersCertainTable(String parishName, String tableId) {
        int numVotersTable = 0;
        if(parishName == "" || parishName == null || tableId == "" || tableId == null) {
            return numVotersTable;
        }
        else {
            List<PollingTable> tablesInParish = getTablesInParish(parishName);
            for(PollingTable pollingTable: tablesInParish) {
                if(pollingTable.getAssociatedParishName().equals(parishName) && pollingTable.getTableId().equalsIgnoreCase(tableId)) {
                    numVotersTable = Integer.parseInt(pollingTable.getNumberOfVotersTable());
                }
            }
            return numVotersTable;
        }
    }
    
    /**
     * Metodo que retorna o numero total de votantes numa determinada freguesia.
     * 
     * @param parishName - o nome da freguesia
     * @return int - o numero total de votantes
     */
    public int getNumberOfVotersInParish(String parishName) {
        int numVoters = 0;
        if(parishName == "" || parishName == null) {
            return numVoters;
        }
        else {
            List <PollingTable> tablesInParish = getTablesInParish(parishName);
            for(PollingTable pollingTable : tablesInParish) {
                if(pollingTable.getAssociatedParishName().equals(parishName)) {
                    numVoters += Integer.parseInt(pollingTable.getNumberOfVotersTable());
                }
            }
            return numVoters;
        }
    }
    
    /**
     * Metodo que mostra a informacao das mesas de voto.
     */
    public void showTablesInfo() {
        System.out.println("+++Mesas de Voto+++ \n");
        for(PollingTable pollingTable : tables) {
            System.out.println(pollingTable.toString());
        }
    }
}