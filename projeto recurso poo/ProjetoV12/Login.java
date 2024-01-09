 

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


/**
 * A classe Login representa um formulario de login para os utilizadores.
 *
 * @author Grupo 4 Turma 7
 * @version 01/07/2022
 */
public class Login extends Application {
    private MenuGestor menuGestor;
    private MenuAdmin menuAdmin;
    private MenuUtilizador menuUtil;
    
    /**
     * The start method is the main entry point for every JavaFX application. 
     * It is called after the init() method has returned and after 
     * the system is ready for the application to begin running.
     *
     * @param stage the primary stage for this application.
     */
    @Override
    public void start(Stage stage) {
        menuGestor = new MenuGestor();
        menuAdmin = new MenuAdmin();
        menuUtil = new MenuUtilizador();
        
        StackPane root = new StackPane();
        
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setVgap(10);
        pane.setHgap(10);
        pane.setPadding(new Insets(25, 25, 25, 25));
        
        Text sceneTitle = new Text("Introduza os seus dados");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        pane.add(sceneTitle, 0, 0, 2, 1);
        
        
        Label userName = new Label("Username:");
        pane.add(userName, 0, 1);
        
        TextField userTextField = new TextField();
        pane.add(userTextField, 1, 1);
        
        Label pw = new Label("Password:");
        pane.add(pw, 0, 2);
        
        PasswordField pwBox = new PasswordField();
        pane.add(pwBox, 1, 2);
        
        Button btn = new Button("Entrar");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        pane.add(hbBtn, 1, 4);
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent e) {
                Stage newWindow = new Stage();
                
                if(pwBox.getText().equalsIgnoreCase("gestor")) {
                    newWindow.setTitle("Gestor");
                    newWindow.setScene(new Scene (menuGestor, 400, 600));
                    newWindow.setResizable(false);
                    newWindow.show();
                }
                else if(pwBox.getText().equalsIgnoreCase("admin")) {
                    newWindow.setTitle("Administrador");
                    newWindow.setScene(new Scene (menuAdmin, 400, 600));
                    newWindow.setResizable(false);
                    newWindow.show();
                }
                else {
                    newWindow.setTitle("Utilizador");
                    newWindow.setScene(new Scene (menuUtil, 400, 600));
                    newWindow.setResizable(false);
                    newWindow.show();
                }
            }
        });
        
        root.getChildren().add(pane);
        
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.setMinWidth(600);
        stage.setMinHeight(400);
        stage.initStyle(StageStyle.DECORATED);
        stage.show();
    }
}