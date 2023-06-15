/* ....Show License.... */
package cpt;
 
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 
 
/**
 * A chart that displays rectangular bars with heights indicating data values
 * for categories. Used for displaying information when at least one axis has
 * discontinuous or discrete data.
 */

public class BarChartApp {
 
    final static ObservableList<Team> data = FXCollections.observableArrayList(readFile.readDataFile("src/cpt/Comp Sci CPT spreadsheet - Points Per Game.csv"));
    
    private static BarChart<String, Number> chart;
    private static CategoryAxis xAxis;
    private static NumberAxis yAxis;
    static ObservableList<String> teamNames = FXCollections.observableArrayList();
    static ObservableList<Number> chartData = FXCollections.observableArrayList();
    static boolean isFirstRow = true;
    
     
    private static ObservableList<Number> dataExtract(String property){
        ObservableList chartDataList = FXCollections.observableArrayList(); 
        for (Team x : data) {
            if (isFirstRow){
                isFirstRow = false;
                continue;
            }
            double statistic =  Double.parseDouble(Sortingpt2.getProperty(x, property));
            chartDataList.add(statistic);
        }
        return chartDataList;
    }

    public static Parent createBarGraph() {
        xAxis = new CategoryAxis();
        yAxis = new NumberAxis("Statistic", 10.0d, 130, 10.0d);
        chart = new BarChart<>(xAxis, yAxis);
       
        String[] chartTypes = {"ppg22", "ppg21", "pct22", "pct21", "assists22", "assists21", "tpg22", "tpg21", "trg22", "trg21"};
       
        
        Button[] buttons = new Button[chartTypes.length];
        for (int i = 0; i < buttons.length; i++) {
            String x = chartTypes[i];
            Button a = new Button(x);
            a.setOnAction(e -> {chartData =  dataExtract(x);yAxis.setLabel(x);updateChart();isFirstRow = true;});
            buttons [i] = a;
        }
        
        for (Team entry : data) {
            String teamName = entry.getTeamName();
            
            if (isFirstRow){
                isFirstRow = false;
                continue;
            }
            teamNames.add(teamName);
            
        }
        isFirstRow = true;
        xAxis.setGapStartAndEnd(true);
        // Set the desired font size for the x-axis labels
        double labelFontSize = 7.0;
        xAxis.setStyle("-fx-tick-label-font-size: " + labelFontSize + "px;");
        xAxis.setCategories(teamNames);

         HBox buttonsLayout = new HBox(10);
    buttonsLayout.getChildren().addAll(buttons);

    // Create the bar chart layout
    VBox chartLayout = new VBox(10);
    chartLayout.getChildren().addAll(buttonsLayout, chart);

    return chartLayout;
}

     

        
    
   

    private static void updateChart(){
         if (chart == null) {
            return;
        }
        chart.getData().clear();
        BarChart.Series<String, Number> series = new BarChart.Series<>();
          for (int i = 0; i < chartData.size(); i++) {
            XYChart.Data<String, Number> dataPoint = new XYChart.Data<>(teamNames.get(i), chartData.get(i));
            series.getData().add(dataPoint);
        }
        chart.getData().add(series);
    }

}