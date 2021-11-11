module Gunn {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    opens gunn.battleship to javafx.fxml;
    exports gunn.battleship;
}