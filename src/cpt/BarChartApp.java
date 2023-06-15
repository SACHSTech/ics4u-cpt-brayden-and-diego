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

    public static Parent createBarGraph() {
        xAxis = new CategoryAxis();
        yAxis = new NumberAxis("Units Sold", 0.0d, 40, 10.0d);

        ObservableList<String> teamNames = FXCollections.observableArrayList();
        ObservableList<Number> chartData = FXCollections.observableArrayList();

        boolean isFirstRow = true;
        // Extract data from the first two columns of the ObservableList
        for (Team entry : data) {
            String teamName = entry.getTeamName();
            
            if (isFirstRow){
                isFirstRow = false;
                continue;
            }

            double unitsSold = Double.parseDouble(entry.getAssists21());

            teamNames.add(teamName);
            chartData.add(unitsSold);
        }

        xAxis.setCategories(teamNames);

        ObservableList<BarChart.Series<String, Number>> barChartData = FXCollections.observableArrayList();
        BarChart.Series<String, Number> series = new BarChart.Series<>();
        series.setName("Units Sold");

        for (int i = 0; i < chartData.size(); i++) {
            XYChart.Data<String, Number> dataPoint = new XYChart.Data<>(teamNames.get(i), chartData.get(i));
            series.getData().add(dataPoint);
        }

        barChartData.add(series);

        chart = new BarChart<>(xAxis, yAxis, barChartData, 25.0d);
        return chart;
    }
 
    
}