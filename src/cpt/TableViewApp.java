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

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
public class TableViewApp extends Application {

    private TableView<Team> tableView;

    public Parent createContent() {
       
        final ObservableList<Team> data = FXCollections.observableArrayList(readFile.readDataFile("src/cpt/Comp Sci CPT spreadsheet - Points Per Game.csv"));

        
        TableView tableView = new TableView();
       

        TableColumn<String, Team> firstNameCol = new TableColumn<>();
        firstNameCol.setText("Team Name");
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("teamName"));
        
        TableColumn<String, Team> PPG22Col = new TableColumn<>();
        PPG22Col.setText("PPG 2022");
        PPG22Col.setCellValueFactory(new PropertyValueFactory<>("ppg22"));
        
        TableColumn<String, Team> PPG21Col = new TableColumn<>();
        PPG21Col.setText("PPG 2021");
        PPG21Col.setMinWidth(200);
        PPG21Col.setCellValueFactory(new PropertyValueFactory<>("ppg21"));
        
        TableColumn<String, Team> pct22Col = new TableColumn<>();
        pct22Col.setText("PCT 2022");
        pct22Col.setCellValueFactory(new PropertyValueFactory<>("pct22"));

        TableColumn<String, Team> pct21Col = new TableColumn<>();
        pct21Col.setText("PCT 2021");
        pct21Col.setCellValueFactory(new PropertyValueFactory<>("pct21"));

        TableColumn<String, Team> assists22Col = new TableColumn<>();
        assists22Col.setText("Assists 2022");
        assists22Col.setCellValueFactory(new PropertyValueFactory<>("assists22"));

        TableColumn<String, Team> assists21Col = new TableColumn<>();
        assists21Col.setText("Assists 2021");
        assists21Col.setCellValueFactory(new PropertyValueFactory<>("assists21"));

        TableColumn<String, Team> tpg22Col = new TableColumn<>();
        tpg22Col.setText("TPG 2022");
        tpg22Col.setCellValueFactory(new PropertyValueFactory<>("tpg22"));

        TableColumn<String, Team> tpg21Col = new TableColumn<>();
        tpg21Col.setText("TPG 2021");
        tpg21Col.setCellValueFactory(new PropertyValueFactory<>("tpg21"));

        TableColumn<String, Team> trg22Col = new TableColumn<>();
        trg22Col.setText("TRG 2022");
        trg22Col.setCellValueFactory(new PropertyValueFactory<>("trg22"));

        TableColumn<String, Team> trg21Col = new TableColumn<>();
        trg21Col.setText("TRG 2021");
        trg21Col.setCellValueFactory(new PropertyValueFactory<>("trg21"));

        Button sortTeamNameButton = new Button("Sort by Team Name");
        sortTeamNameButton.setOnAction(e -> tableView.setItems(sorter(data, "teamName")));

        Button sortPPG22Button = new Button("Sort by PPG 2022");
        sortPPG22Button.setOnAction(e -> tableView.setItems(sorter(data, "ppg22")));

        Button sortPPG21Button = new Button("Sort by PPG 2021");
        sortPPG21Button.setOnAction(e -> tableView.setItems(sorter(data, "ppg21")));

        Button sortPCT22Button = new Button("Sort by PCT 2022");
        sortPCT22Button.setOnAction(e -> tableView.setItems(sorter(data, "pct22")));

        Button sortPCT21Button = new Button("Sort by PCT 2021");
        sortPCT21Button.setOnAction(e -> tableView.setItems(sorter(data, "pct21")));

        Button sortAssists22Button = new Button("Sort by Assists 2022");
        sortAssists22Button.setOnAction(e -> tableView.setItems(sorter(data, "assists22")));

        Button sortAssists21Button = new Button("Sort by Assists 2021");
        sortAssists21Button.setOnAction(e -> tableView.setItems(sorter(data, "assists21")));

        Button sortTPG22Button = new Button("Sort by TPG 2022");
        sortTPG22Button.setOnAction(e -> tableView.setItems(sorter(data, "tpg22")));

        Button sortTPG21Button = new Button("Sort by TPG 2021");
        sortTPG21Button.setOnAction(e -> tableView.setItems(sorter(data, "tpg21")));

        Button sortTRG22Button = new Button("Sort by TRG 2022");
        sortTRG22Button.setOnAction(e -> tableView.setItems(sorter(data, "trg22")));

        Button sortTRG21Button = new Button("Sort by TRG 2021");
        sortTRG21Button.setOnAction(e -> tableView.setItems(sorter(data, "trg21")));

        HBox buttons = new HBox(10);
        buttons.getChildren().addAll(sortTeamNameButton, sortPPG22Button, sortPPG21Button, sortPCT22Button, sortPCT21Button, sortAssists22Button, sortAssists21Button, sortTPG22Button, sortTPG21Button, sortTRG22Button, sortTRG21Button);
       
        tableView.setItems(data);
        tableView.getColumns().addAll(firstNameCol, PPG22Col, PPG21Col, pct22Col, pct21Col, assists22Col, assists21Col, tpg22Col, tpg21Col, trg22Col, trg21Col);
        

        VBox finalDisplay = new VBox(10);
        finalDisplay.getChildren().addAll(buttons, tableView);

        return finalDisplay;

    }
    
    //method to use our sorting algorithmn on an obserbable list
    private ObservableList<Team> sorter(ObservableList<Team> x, String property){
        ArrayList<Team> y = new ArrayList<>(x);
        Sortingpt2.sort(y, property);
        return FXCollections.observableArrayList(y);
    }

    @Override public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }

    /**
     * Java main for when running without JavaFX launcher
     * @param args command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
