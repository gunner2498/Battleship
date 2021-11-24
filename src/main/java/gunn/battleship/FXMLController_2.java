package gunn.battleship;

/*
Name; Gavin Gunn
Class; Grade 12 Com Studies
Date; 22/11/21
Assignment#; 1
Description; Creating a functioning single player game of battleship
 */
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;

public class FXMLController_2 implements Initializable {

    @FXML
void continueClick(ActionEvent event) throws IOException {
MainApp.setRoot("primary.fxml");
}
@FXML
    

    /**
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO

    }//End of Main
}//End of Class
