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

    public static Parent createBarGraph() {
        xAxis = new CategoryAxis();
        yAxis = new NumberAxis("Units Sold", 0.0d, 40, 10.0d);
        
        // Extract data from the first two columns of the ObservableList
        for (Team entry : data) {
            String teamName = entry.getTeamName();
            
            if (isFirstRow){
                isFirstRow = false;
                continue;
            }


            teamNames.add(teamName);
            
        }
        xAxis.setGapStartAndEnd(true);
        // Set the desired font size for the x-axis labels
        double labelFontSize = 7.0;


        xAxis.setStyle("-fx-tick-label-font-size: " + labelFontSize + "px;");

        xAxis.setCategories(teamNames);

        ObservableList<BarChart.Series<String, Number>> barChartData = FXCollections.observableArrayList();
        BarChart.Series<String, Number> series = new BarChart.Series<>();
        series.setName("Units Sold");

        for (int i = 0; i < chartData.size(); i++) {
            XYChart.Data<String, Number> dataPoint = new XYChart.Data<>(teamNames.get(i), chartData.get(i));
            series.getData().add(dataPoint);
        }

        barChartData.add(series);
        xAxis.setLabel("Teams");
        chart = new BarChart<>(xAxis, yAxis, barChartData, 25.0d);
        return chart;
    }
    
    public static ObservableList<Number> dataExtract(String property){
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
}