/**
 * A super classe abstrata Election representa uma eleicao.
 * 
 * @author Grupo 4 Turma 7
 * @version 14/05/2022
 */
public abstract class Election implements IGeneralElection {
    private ElectionType type;
    
    /**
     * Construtor da classe Election.
     * 
     * @param type - o tipo de eleicao de acordo com o enumerado ElectionType
     */
    public Election(ElectionType type) {
        this.type = type;
    }
    
    @Override
    public String getElectionType() {
        return "";
    }
    
    @Override
    public String getTimePeriod() {
        return "";
    }
}