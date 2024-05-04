package com.hannoobz.wordladdersolver;

// import com.sun.tools.javac.Main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;



import java.io.IOException;

import com.hannoobz.wordladdersolver.Dictionary.GameDictionary;

public class MainGUI extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainGUI.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 320);
        GameDictionary gameDictionary = new GameDictionary();
        gameDictionary.read("words.txt");
        stage.setTitle("Word Ladder Solver - by @hannoobz");
        stage.setScene(scene);
        stage.setResizable(false);
        MainController controller = fxmlLoader.getController();
        controller.passGameDictionary(gameDictionary);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}