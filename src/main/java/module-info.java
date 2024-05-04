module com.hannoobz.wordladdersolver {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.hannoobz.wordladdersolver to javafx.fxml;
    exports com.hannoobz.wordladdersolver;
}
