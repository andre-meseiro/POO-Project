import java.util.List;

/**
 * A classe TestTables serve como teste para as funcionalidades implementadas no gestor de mesas de voto, que importa informacao das mesmas.
 *
 * @author Grupo 4 Turma 7
 * @version 27/06/2022
 */
public class TestTables {
    private PollingTablesManager ptm;

    /**
     * Construtor da classe TestTables.
     * Instancia um novo teste.
     */
    public TestTables() {
        ptm = new PollingTablesManager("Mesas.csv");
    }

    /**
     * Teste ao metodo que retorna uma lista com as mesas que estao numa determinada freguesia.
     *
     * @param parishName - o nome da freguesia
     * @return List <PollingTable> - lista com as mesas
     */
    public List <PollingTable> testGetTablesInParish(String parishName) {
        return ptm.getTablesInParish(parishName);
    }
    
    /**
     * Teste ao metodo que retorna o numero de votantes de uma terminada mesa.
     * 
     * @param parishName - nome da freguesia
     * @param tableId - o id da mesa
     * @return int - o numero de votantes da mesa
     */
    public int testGetNumberOfVotersCertainTable(String parishName, String tableId) {
        return ptm.getNumberOfVotersCertainTable(parishName, tableId);
    }
    
    /**
     * Teste ao metodo que retorna o numero total de votantes numa determinada freguesia.
     * 
     * @param parishName - o nome da freguesia
     * @return int - o numero total de votantes
     */
    public int getNumberOfVotersInParish(String parishName) {
        return ptm.getNumberOfVotersInParish(parishName);
    }
    
    /**
     * Teste ao metodo que mostra a informacao das mesas de voto.
     */
    public void testShowTablesInfo() {
        ptm.showTablesInfo();
    }
}