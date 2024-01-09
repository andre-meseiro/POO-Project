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
 * A classe MenuUtilizador representa o menu de um utilizador.
 *
 * @author Grupo 4 Turma 7
 * @version 01/07/2022
 */
public class MenuUtilizador extends BorderPane {
    
    public MenuUtilizador() {
        MenuBar mb = new MenuBar();
    
        Menu menuResultados = new Menu("Resultados");
        Menu menuSair = new Menu("Sair");
        
        MenuItem mostrar = new MenuItem("Mostrar");
        MenuItem sair = new MenuItem("Exit");
        
        menuResultados.getItems().add(mostrar);
        menuSair.getItems().add(sair);
    
        mb.getMenus().addAll(menuResultados, menuSair);
        
        sair.setOnAction(e -> Platform.exit());
        
        this.setTop(mb);
    }
}