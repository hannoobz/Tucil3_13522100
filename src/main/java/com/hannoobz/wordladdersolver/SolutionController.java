package com.hannoobz.wordladdersolver;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class SolutionController {
        @FXML
        private Label runtimeLabel;

        @FXML
        private Label visitedNodeLabel;

        @FXML
        private ListView<String> solutionList;

        @FXML
        private Label algoLabel;

        @FXML
        private Label lengthLabel;

public void solutionPopUp(Long runtime, Integer visitedNode, ArrayList<String> pathSolution,String algo) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(MainGUI.class.getResource("solution-view.fxml"));
    Parent root = fxmlLoader.load();
    SolutionController solutionController = fxmlLoader.getController();
    solutionController.setList(pathSolution);
    solutionController.setLabels(runtime, visitedNode,algo,pathSolution);
    Stage stage = new Stage();
    stage.setScene(new Scene(root, 200, 320));
    stage.show();
    System.out.println(pathSolution);
}

public void setLabels(Long runtime, Integer visitedNode,String algo,ArrayList<String> pathSolution) {
    String runtimeResult = "Runtime: " + runtime+"ms";
    String visitedNodeResult = "Visited Node: " + visitedNode;
    String algoUsed = "Algorithm: " + algo;
    String lengthResult = "Length: "+(pathSolution.size()-2);

    runtimeLabel.setText(runtimeResult);
    visitedNodeLabel.setText(visitedNodeResult);
    algoLabel.setText(algoUsed);
    lengthLabel.setText(lengthResult);
}

public void setList(ArrayList<String> pathSolution){
    ObservableList<String> path = FXCollections.observableArrayList(pathSolution);
    solutionList.setItems(path);
}

}
