import java.time.LocalDate;
/**
 * A classe Vote representa um voto.
 * 
 * @author Grupo 4 Turma 7
 * @version 06/05/2022
 */
public class Vote {
    private Voter voter;
    private Parties partyVoted;
    private String selectedOption;
    private String voteType;
    private boolean voteAntecipated;
    private LocalDate date;
    
    /**
     * Construtor da classe Vote.
     * Instancia um voto normal.
     * 
     * @param voter - votante associado ao voto
     * @param partyVoted - o partido selecionado de acordo com o enumerado Parties
     */
    public Vote(Voter voter, Parties partyVoted) {
        voteAntecipated = false;
        this.voter = voter;
        boolean ableToVote = voter.canVote();
        if(ableToVote == true) {
            this.partyVoted = partyVoted;
            switch(partyVoted) {
                case A:
                    this.selectedOption = "A";
                    break;
                case B:
                    this.selectedOption = "B";
                    break;
                case C:
                    this.selectedOption = "C";
                    break;
                case D:
                    this.selectedOption = "D";
                    break;
                case E:
                    this.selectedOption = "E";
                    break;
                case F:
                    this.selectedOption = "F";
                    break;
                case G:
                    this.selectedOption = "G";
                    break;
                case NULL:
                    this.selectedOption = null;
                    break;
                default:
                    this.selectedOption = "";
                    break;
            }
            date = date.now();
            if(selectedOption == null) {
                voteType = "Nulo";
            }
            else if(selectedOption == "") {
                voteType = "Branco";
            }
            else {
                voteType = "Valido";
            }
            ableToVote = false;
        }
        else {
            System.out.println("Este votante ja efetuou o seu voto.");
        }
    }
    
    /**
     * Construtor da classe Vote.
     * Instancia um voto antecipado.
     * 
     * @param voter - o votante associado ao voto
     * @param partyVoted - o partido selecionado
     * @param day - dia em que o voto foi guardado
     * @param month - mes em que o voto foi guardado
     * @param year - ano em que o voto foi guardado
     */
    public Vote(Voter voter, Parties partyVoted, int day, int month, int year) {
        voteAntecipated = true;
        this.voter = voter;
        boolean ableToVote = voter.canVote();
        if(ableToVote == true) {
            this.partyVoted = partyVoted;
            switch(partyVoted) {
                case A:
                    selectedOption = "A";
                    break;
                case B:
                    selectedOption = "B";
                    break;
                case C:
                    selectedOption = "C";
                    break;
                case D:
                    selectedOption = "D";
                    break;
                case E:
                    selectedOption = "E";
                    break;
                case F:
                    selectedOption = "F";
                    break;
                case G:
                    selectedOption = "G";
                    break;
                case NULL:
                    selectedOption = null;
                    break;
                default:
                    selectedOption = "";
                    break;
            }
            date = LocalDate.of(year, month, day);
            if(selectedOption == null) {
                voteType = "Nulo";
            }
            else if(selectedOption == "") {
                voteType = "Branco";
            }
            else {
                voteType = "Valido";
            }
            ableToVote = false;
        }
        else {
            System.out.println("Este votante ja efetuou o seu voto.");
        }
    }
    
    public String getSelectedOption() {
        return selectedOption;
    }
    
    public Parties getPartyVoted() {
        return partyVoted;
    }
    
    public String getVoteType() {
        return voteType;
    }
    
    public boolean isAntecipated() {
        return voteAntecipated;
    }
    
    public LocalDate getVoteDate() {
        return date;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("+++VOTO+++");
        sb.append("\n");
        sb.append("Votante: ");
        sb.append(voter.getName());
        sb.append("\n");
        sb.append("Data do voto: ");
        sb.append(date);
        sb.append("\n");
        sb.append("Opcao escolhida: ");
        sb.append(selectedOption);
        sb.append("\n");
        sb.append("Tipo de voto: ");
        sb.append(voteType);
        sb.append("\n");
        sb.append("Voto antecipado? ");
        if(!voteAntecipated) {
            sb.append("Nao");
        }
        else {
            sb.append("Sim");
        }
        sb.append("\n");
        sb.append("+++++++++++++++++++++++++++++++");
        
        return sb.toString();
    }
}