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
    //read the data file into an observablelist
    final static ObservableList<Team> data = FXCollections.observableArrayList(readFile.readDataFile("src/cpt/Comp Sci CPT spreadsheet - Points Per Game.csv"));
    
    //create chart, axis and the arraylist of the both axis
    private static BarChart<String, Number> chart;
    private static CategoryAxis xAxis;
    private static NumberAxis yAxis;
    static ObservableList<String> teamNames = FXCollections.observableArrayList();
    static ObservableList<Number> chartData = FXCollections.observableArrayList();
    //boolean to make sure the first line is always skipped (header)
    static boolean isFirstRow = true;


    /**
     * this method creates the bar graph 
     * @return parent bar graph
     */
    public static Parent createBarGraph() {
        //create x and y axis
        xAxis = new CategoryAxis();
        yAxis = new NumberAxis("Statistic", 10.0d, 130, 10.0d);
        chart = new BarChart<>(xAxis, yAxis);
        
        //added arrays of all attributes and button maes
        String[] chartTypes = {"ppg22", "ppg21", "pct22", "pct21", "assists22", "assists21", "tpg22", "tpg21", "trg22", "trg21"};
        String[] buttonNames = {"Points Per Game 2022", "Points Per Game 2021", "Shooting Percentage 2022", "Shooting Percentage 2021", "Assists Per Game 2022", "Assists Per Game 2021", "Turnovers Per Game 2022", "Turnovers Per Game 2021", "Total Rebounds Per Game 2022", "Total Rebounds Per Game 2021"};

        Button[] buttons = new Button[chartTypes.length];
        
        //for to create the nbuttons
        for (int i = 0; i < buttons.length; i++) {
            String variable = chartTypes[i]; // String variable from the first array
            String buttonText = buttonNames[i]; // String name for the button from the second array
            
            Button button = new Button(buttonText);
            
            //on action, use the extract, set a new label, set auto ranging and use the helper method to update the chart
            button.setOnAction(e -> {
            chartData = dataExtract(variable);
            yAxis.setLabel(buttonText);
            yAxis.setAutoRanging(true);
            updateChart();
            isFirstRow = true;
            });

            //add the button weve just created to the arrat
            buttons[i] = button;
        }
        
        //add the Xaxis (team nemes)
        for (Team entry : data) {
            String teamName = entry.getTeamName();
            //skip first row
            if (isFirstRow){
                isFirstRow = false;
                continue;
            }
            teamNames.add(teamName);
            
        }
        //reset boolean
        isFirstRow = true;
        xAxis.setGapStartAndEnd(true);
        
        // Set the desired font size for the x-axis labels
        double labelFontSize = 7.0;
        xAxis.setStyle("-fx-tick-label-font-size: " + labelFontSize + "px;");
        xAxis.setCategories(teamNames);

        //button layout
        HBox buttonsLayout = new HBox(10);
        buttonsLayout.getChildren().addAll(buttons);

        // Create the bar chart layout
        VBox chartLayout = new VBox(10);
        chartLayout.getChildren().addAll(buttonsLayout, chart);

    return chartLayout;
}
    
    /**
     * This method extracts a specific type of property of a team object to make a graph 
     * @param property: the property we want to the make graph for
     * @return: an obserbable list with the whole data 
     */ 
    private static ObservableList<Number> dataExtract(String property){
        //declare the data list
        ObservableList chartDataList = FXCollections.observableArrayList(); 
        
        //for each team in data, skip first row, get the desired stat, put into the arraylist
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
     
   
    /**
     * this method updates the chart, used after button pressed
     */
    private static void updateChart(){
        //prevents the code from breaking when it tries to clear a null chart 
        if (chart == null) {
            return;
        }
        //clear data from chart
        chart.getData().clear();

        //Iterate over the chartData list
        BarChart.Series<String, Number> series = new BarChart.Series<>();
          for (int i = 0; i < chartData.size(); i++) {
            XYChart.Data<String, Number> dataPoint = new XYChart.Data<>(teamNames.get(i), chartData.get(i));  // Create a data point for each item in the chartData list
            series.getData().add(dataPoint);
        }
        //add series to the chart
        chart.getData().add(series);
    }

}