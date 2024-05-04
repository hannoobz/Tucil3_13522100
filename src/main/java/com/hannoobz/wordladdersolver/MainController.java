package com.hannoobz.wordladdersolver;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

import com.hannoobz.wordladdersolver.Dictionary.GameDictionary;
import com.hannoobz.wordladdersolver.Solver.AStar;
import com.hannoobz.wordladdersolver.Solver.BaseSolver;
import com.hannoobz.wordladdersolver.Solver.GreedyBFS;
import com.hannoobz.wordladdersolver.Solver.UniformCostSearch;
import com.hannoobz.wordladdersolver.WordNode.WordNode;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;



public class MainController {
    private GameDictionary gameDictionary;
    private BaseSolver solver;
    private long runtime;
    private Integer visitedNode;


    @FXML
    private ToggleGroup group;

    @FXML
    private TextField start;

    @FXML
    private TextField target;

    public void passGameDictionary(GameDictionary gameDictionary){
        this.gameDictionary = gameDictionary;
    }

    public void clickSolve() {
        RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
        String startString = start.getText().toLowerCase();
        String targetString = target.getText().toLowerCase();
        String radioButtonLabel = selectedRadioButton.getText();
        System.out.println("Selected Radio Button: " + radioButtonLabel);
        System.out.println("Starting Text: " + startString);
        System.out.println("Target Text: " + targetString);


        switch (radioButtonLabel) {
            case "GreedyBFS":
                solver = new GreedyBFS(startString, targetString);
                break;

            case "UCS":
                solver = new UniformCostSearch(startString, targetString);
                break;

            case "A*":
                solver = new AStar(startString, targetString);
                break;
        }
        Instant startTime = Instant.now();
        solver.solve(gameDictionary);
        Instant endTime = Instant.now();
        WordNode currentNode = solver.getTargetNode();

        ArrayList<String> pathSolution = new ArrayList<>();
        while (currentNode!=null) {
            // System.out.println("Final:"+currentNode.getWord());
            pathSolution.add(0,currentNode.getWord());
            currentNode = currentNode.getParent();
        }

        this.runtime = Duration.between(startTime, endTime).toMillis();
        this.visitedNode = solver.getVisitCount();
        // System.out.println("Runtime: "+ Duration.between(startTime, endTime).toMillis()+"ms");
        // System.out.println("Visited Node: "+solver.getVisitCount());
        try {
            SolutionController solutionController = new SolutionController();
            solutionController.solutionPopUp(this.runtime, this.visitedNode,pathSolution,radioButtonLabel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}