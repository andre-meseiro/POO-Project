

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * A classe Resultados representa a parte grafica dos resultados dos votos importados.
 *
 * @author Grupo 4 Turma 7 - adaptado do codigo fornecido na aula
 * @version 01/07/2022
 */
public class Resultados extends Application {

    /**
     * The start method is the main entry point for every JavaFX application. 
     * It is called after the init() method has returned and after 
     * the system is ready for the application to begin running.
     *
     * @param  stage the primary stage for this application.
     */
    @Override
    public void start(Stage stage) {
        AnchorPane root = new AnchorPane();
        
        LabelValorPieChart lvpc = new LabelValorPieChart();
        ResultadosGrafico rg = null;
        rg = new ResultadosGrafico(lvpc, "Votos", "VotosFreguesias.csv");
        
        root.getChildren().add(rg);
        root.getChildren().add(lvpc);
        
        Scene scene = new Scene(root);

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Platform.exit();
            }
        });
        
        stage.setTitle("Votos");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}        