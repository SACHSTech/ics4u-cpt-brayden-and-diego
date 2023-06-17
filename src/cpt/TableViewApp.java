/*
 * Copyright (c) 2008, 2016, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 *
 * This file is available and licensed under the following license:
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  - Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *  - Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the distribution.
 *  - Neither the name of Oracle Corporation nor the names of its
 *    contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package cpt;



import java.util.ArrayList;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * A simple table with a header row.
 *
 * @sampleName TableView
 * @preview preview.png
 * @docUrl http://www.oracle.com/pls/topic/lookup?ctx=javase80&id=JFXUI336 Using JavaFX UI Controls
 * @see javafx.scene.control.TableColumn
 * @see javafx.scene.control.TablePosition
 * @see javafx.scene.control.TableRow
 * @see javafx.scene.control.TableView
 * @see javafx.scene.control.cell.PropertyValueFactory
 * @embedded
 *
 * @related /Controls/TableCellFactory
 * @related /Controls/TreeTableView
 */
public class TableViewApp {

    private static TextField search;

    public static Parent createTable() {
       
        final ObservableList<Team> data = FXCollections.observableArrayList(readFile.readDataFile("src/cpt/Comp Sci CPT spreadsheet - Points Per Game.csv"));

        
        TableView tableView = new TableView(); //create new tableview
       
        //create two string arrays for the column name and the fields that go within the cells
        final String[] columns = {"Team Name", "PPG 2022", "PPG 2021", "PCT 2022", "PCT 2021", "Assists 2022", "Assists 2021", "TPG 2022", "TPG 2021", "TRG 2022", "TRG 2021" };
        final String[] teamFields = {"teamName", "ppg22", "ppg21", "pct22", "pct21", "assists22", "assists21", "tpg22", "tpg21", "trg22", "trg21" };
        
        TableColumn<Team, String>[] columnsFinal = new TableColumn[columns.length];


        for (int i =0; i < columns.length; i ++){
            TableColumn<Team, String> x = new TableColumn<>(columns[i]); //create a new column with name grabbed from string array column
            x.setCellValueFactory(new PropertyValueFactory<>(teamFields[i])); //Set the cell value factory using the field name
            columnsFinal[i] = x;
        }
        

        Button [] buttonsFinal = new Button[columns.length];
        for (int i = 0; i < columns.length; i++) {
            final int index = i; 
            String x = columns[i]; //get column name
            Button button = new Button("Sort by " + x); //create a new button that gives users the option to sort by properties
            button.setOnAction(e -> tableView.setItems(sorter(data, teamFields[index]))); //call the sorter method to sort data based on column
            buttonsFinal[i] = button;
        }

       
        search = new TextField(); //create a textfield to allow users to sort
        search.setPromptText("Search for Team: ");
        search.setOnKeyReleased(event -> handleSearch(event, tableView, data));


        HBox buttons = new HBox(10);
        buttons.getChildren().addAll(buttonsFinal);
        tableView.setItems(data);
        tableView.getColumns().addAll(columnsFinal);
        

        VBox finalDisplay = new VBox(10);
        finalDisplay.getChildren().addAll(search, buttons, tableView);

        return finalDisplay;

    }
    
    //method to use our sorting algorithmn on an obserbable list
    private static ObservableList<Team> sorter(ObservableList<Team> x, String property){
        ArrayList<Team> y = new ArrayList<>(x);
        Sortingpt2.sort(y, property);
        return FXCollections.observableArrayList(y);
    }

   private static void handleSearch(KeyEvent event, TableView<Team> tableView, ObservableList<Team> data) {
        String searchText = search.getText().toLowerCase(); //retrive search text given by user and change to lowercase
        ObservableList<Team> filteredData = FXCollections.observableArrayList(); //create a new observable list for filtered data

        for (Team team : data) {
            if (team.getTeamName().toLowerCase().contains(searchText)) {
                filteredData.add(team);
        }
    }

        tableView.setItems(filteredData);
}



}
