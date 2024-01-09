

import javafx.scene.control.Label;
import javafx.scene.paint.Color;

/**
 * A classe auxiliar LabelValorPieChart representa as css para a label que aparece ao clicar no grafico.
 *
 * @author Grupo 4 Turma 7 - adaptado do codigo fornecido na aula
 * @version 01/07/2022
 */
public class LabelValorPieChart extends Label {
    
    public LabelValorPieChart() {
        setText("");
        setTextFill(Color.WHITE);
        setStyle("-fx-font:12 Arial");
    }
}