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

public class BarChartApp extends Application {
 
    final ObservableList<Team> data = FXCollections.observableArrayList(readFile.readDataFile("src/cpt/Comp Sci CPT spreadsheet - Points Per Game.csv"));
    
    private BarChart<String, Number> chart;
    private CategoryAxis xAxis;
    private NumberAxis yAxis;

    public Parent createContent() {
        xAxis = new CategoryAxis();
        yAxis = new NumberAxis("Points Per Game", 0.0d, 120, 10.0d);

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

            double chartdata= Double.parseDouble(entry.getPpg21());

            teamNames.add(teamName);
            chartData.add(chartdata);
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

        chart = new BarChart<>(xAxis, yAxis, barChartData, 0d);
        return chart;
        
    }
 
    @Override public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }
 
    /**
     * Java main for when running without JavaFX launcher
     */
    public static void main(String[] args) {
        launch(args);
    }
}