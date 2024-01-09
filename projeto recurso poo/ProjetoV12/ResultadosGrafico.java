

import java.util.Iterator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import java.util.List;
import java.util.ArrayList;

/**
 * A classe ResultadosGrafico representa um grafico com os resultados dos votos.
 *
 * @author Grupo 4 Turma 7 - adaptado do codigo fornecido na aula
 * @version 01/07/2022
 */
public class ResultadosGrafico extends PieChart {
    private final ObservableList<PieChart.Data> pieChartData;
    private List <VotesAssemblyCouncilParish> votes;
    
    public ResultadosGrafico(Label caption, final String title, final String fileName) {
        pieChartData = FXCollections.observableArrayList();
        setFillData(fileName);
        setData(pieChartData);
        setHandler(caption);
        setTitle(title);
        setClockwise(true);
        setLabelsVisible(true);
        setLabelLineLength(50.0);
        setStartAngle(180.0);
        setCenterShape(true);
    }
    
    private void setFillData(final String fileName) {
        final VotesAssemblyCouncilParishManager vacpm = new VotesAssemblyCouncilParishManager(fileName);
        
        int value1 = vacpm.totalVotesCertainParty("Partido A");
        int value2 = vacpm.totalVotesCertainParty("Partido C");
        int value3 = vacpm.totalVotesCertainParty("Partido E");
        int value4 = vacpm.totalVotesCertainParty("Partido F");
        int value5 = vacpm.totalVotesCertainParty("Partido G");
        
        double v1 = Double.valueOf(value1);
        double v2 = Double.valueOf(value2);
        double v3 = Double.valueOf(value3);
        double v4 = Double.valueOf(value4);
        double v5 = Double.valueOf(value5);
        
        Data data1 = new Data("Partido A", v1);
        Data data2 = new Data("Partido C", v2);
        Data data3 = new Data("Partido E", v3);
        Data data4 = new Data("Partido F", v4);
        Data data5 = new Data("Partido G", v5);
        
        pieChartData.addAll(data1, data2, data3, data4, data5);  
    }
    
    private void setHandler(Label caption){
        Iterator<PieChart.Data> it = pieChartData.iterator();
        while(it.hasNext()) {
            PieChart.Data slice = it.next();
            slice.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    caption.setTranslateX(event.getSceneX());
                    caption.setTranslateY(event.getSceneY());
                    caption.setText(String.valueOf(slice.getPieValue()));
                }
            });
        }
    }
}