 

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
 * A classe MenuGestor representa o menu de um gestor.
 *
 * @author Grupo 4 Turma 7
 * @version 01/07/2022
 */
public class MenuGestor extends BorderPane {
    private VotesAssemblyCouncilParishManager vacpm;
    
    public MenuGestor() {
        MenuBar mb = new MenuBar();
    
        Menu menuResultados = new Menu("Resultados");
        Menu menuVotos = new Menu("Votos");
        Menu menuSair = new Menu("Sair");
        
        MenuItem mostrar = new MenuItem("Mostrar");
        MenuItem sair = new MenuItem("Exit");
        MenuItem carregar = new MenuItem("Carregar");
        
        menuResultados.getItems().add(mostrar);
        menuSair.getItems().add(sair);
        menuVotos.getItems().add(carregar);
    
        mb.getMenus().addAll(menuResultados, menuVotos, menuSair);
        
        sair.setOnAction(e -> Platform.exit());
        
        carregar.setOnAction(e -> vacpm = new VotesAssemblyCouncilParishManager("VotosFreguesias.csv"));
        
        this.setTop(mb);
    }
}