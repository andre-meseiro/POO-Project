 

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
import javafx.scene.text.*;
import javafx.scene.Group;
import javafx.scene.shape.*;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.stage.StageStyle;
import javafx.application.Platform;

/**
 * A classe MenuAdmin representa o menu de um administrador.
 *
 * @author Grupo 4 Turma 7
 * @version 01/07/2022
 */
public class MenuAdmin extends BorderPane {
    private VotesAssemblyCouncilParishManager vacpm;
    private TestPresidential testPre;
    private LegislativeElection legElec;
    private LocalElection locElec;
    private EuropeanElection euroElec;
    
    public MenuAdmin() {
        MenuBar mb = new MenuBar();
    
        Menu menuResultados = new Menu("Resultados");
        Menu menuVotos = new Menu("Votos");
        Menu menuEleicoes = new Menu("Eleicoes");
        Menu menuSair = new Menu("Sair");
        
        MenuItem mostrar = new MenuItem("Mostrar");
        MenuItem sair = new MenuItem("Exit");
        MenuItem carregar = new MenuItem("Carregar");
        MenuItem criar = new MenuItem("Presidencial");
        MenuItem criar2 = new MenuItem("Legislativa");
        MenuItem criar3 = new MenuItem("Europeia");
        MenuItem criar4= new MenuItem("Local");
        
        menuResultados.getItems().add(mostrar);
        menuSair.getItems().add(sair);
        menuVotos.getItems().add(carregar);
        menuEleicoes.getItems().addAll(criar, criar2, criar3, criar4);
    
        mb.getMenus().addAll(menuResultados, menuVotos, menuEleicoes, menuSair);
        
        sair.setOnAction(e -> Platform.exit());
        
        carregar.setOnAction(e -> vacpm = new VotesAssemblyCouncilParishManager("VotosFreguesias.csv"));
        
        criar.setOnAction(e -> testPre = new TestPresidential());
        
        criar2.setOnAction(e -> legElec = new LegislativeElection(ElectionType.LEGISLATIVE, "20-25"));
        
        criar4.setOnAction(e -> locElec = new LocalElection(ElectionType.LOCAL, "20-25"));
        
        criar3.setOnAction(e -> euroElec = new EuropeanElection(ElectionType.EUROPEAN, "20-25"));
        
        this.setTop(mb);
    }
}