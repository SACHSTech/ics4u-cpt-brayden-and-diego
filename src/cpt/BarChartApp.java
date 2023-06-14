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
import javafx.stage.Stage;
 
 
/**
 * A chart that displays rectangular bars with heights indicating data values
 * for categories. Used for displaying information when at least one axis has
 * discontinuous or discrete data.
 */

public class BarChartApp extends Application {
 
    final ObservableList<Team> data = FXCollections.observableArrayList(readFile.readDataFile("src/cpt/Comp Sci CPT spreadsheet - Points Per Game.csv"));
    
    

    private BarChart chart;
    private CategoryAxis xAxis;
    private NumberAxis yAxis;
 
    public Parent createContent() {
    
    StringBuilder stringBuilder = new StringBuilder();

    for (Team team : data) {
        String firstColumn = team.getName(); // Assuming the first column is the team name
        String assists = team.getAssists21();
        stringBuilder.append(firstColumn).append(", ");
        stringBuilder.append(assists).append(", ");

    }

    // Remove the trailing comma and whitespace
    if (stringBuilder.length() > 0) {
        stringBuilder.setLength(stringBuilder.length() - 2);
    }

    String firstColumnString = stringBuilder.toString();
    String assiststring = stringBuilder.toString();

    String[] teamname = new String[firstColumnString.length()];
        for (int i = 0; i < firstColumnString.length(); i++) {
        teamname[i] = String.valueOf(firstColumnString.charAt(i));
    }

    String[] assists = new String[assiststring.length()];
        for (int i = 0; i < assiststring.length(); i++) {
        assists[i] = String.valueOf(assiststring.charAt(i));
    }

        xAxis = new CategoryAxis();
        xAxis.setCategories(FXCollections.<String>observableArrayList(teamname));
        yAxis = new NumberAxis("Units Sold", 0.0d, 3000.0d, 1000.0d);
        ObservableList<BarChart.Series> barChartData = FXCollections.observableArrayList(
              new BarChart.Series("Apples", FXCollections.observableArrayList(
                new BarChart.Data(teamname[1], assists[1])))
            );
        chart = new BarChart(xAxis, yAxis, barChartData, 25.0d);
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