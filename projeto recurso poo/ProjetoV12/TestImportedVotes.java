
import java.util.List;

/**
 * A classe TestImportedVotes serve como teste para as funcionalidades implementadas no gestor dos votos importados.
 *
 * @author Grupo 4 Turma 7
 * @version 28/06/2022
 */
public class TestImportedVotes {
    private VotesAssemblyCouncilParishManager vacpm1;

    /**
     * Construtor da classe TestImportedVotes.
     * Instancia um novo teste.
     */
    public TestImportedVotes() {
        vacpm1 = new VotesAssemblyCouncilParishManager("VotosFreguesias.csv");
    }

    /**
     * Teste ao metodo que retorna todos os partidos.
     *
     * @param parishName - o nome da freguesia
     * @return List <String> - lista com os partidos
     */
    public List <String> testGetPoliticalParties(String parishName) {
        return vacpm1.getPoliticalParties(parishName);
    }
    
    /**
     * Teste ao metodo que retorna o numero total de votos de um partido.
     * 
     * @param politicalParty - o nome do partido
     */
    public int testTotalVotesCertainParty(String politicalParty) {
        return vacpm1.totalVotesCertainParty(politicalParty);
    }
    
    /**
     * Teste ao metodo que retorna o partido com mais votos totais. 
     */
    public int testHelp() {
        return vacpm1.help();    
    }
    
    /**
     * Teste ao metodo que retorna o numero total de votos de uma determinada freguesia.
     * 
     * @param parishName - o nome da freguesia
     * @return int - o numero total de votos
     */
    public int testGetTotalVotesInParish(String parishName) {
        return vacpm1.getTotalVotesInParish(parishName);
    }
    
    
    /**
     * Teste ao metodo que retorna o numero de votos que um determinado partido obteve numa certa freguesia.
     * 
     * @param parishName - o nome da freguesia
     * @param politicalParty - o nome do partido
     * @return int - o numero de votos
     */
    public int testGetNumberOfVotesCertainPartyInParish(String parishName, String politicalParty) {
        return vacpm1.getNumberOfVotesCertainPartyInParish(parishName, politicalParty);
    }
    
    /**
     * Teste ao metodo que retorna a taxa de abstencao de uma determinada freguesia.
     * 
     * @param parishName - o nome da freguesia
     * @return double - a taxa de abstencao (em %)
     */
    public double testGetAbstentionRateInParish(String parishName) {
        return vacpm1.getAbstentionRateInParish(parishName);
    }
    
    /**
     * Teste ao metodo que retorna o partido vencedor numa determinada freguesia.
     * 
     * @param parishName - o nome da freguesia
     * @return String - o partido vencedor
     */
    public String testGetWinnerInParish(String parishName) {
        return vacpm1.getWinnerInParish(parishName);
    }
    
    /**
     * Teste ao metodo que mostra a informacao sobre os votos.
     */
    public void testShowVotesInfo() {
        vacpm1.showVotesInfo();
    }
}