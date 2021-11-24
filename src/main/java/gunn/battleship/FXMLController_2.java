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
import javafx.fxml.Initializable;
import javafx.fxml.FXML;


 public class FXMLController_2 implements Initializable {

       @FXML //swap to main game page
       private void continue_Click(ActionEvent event) throws IOException {
       MainApp.setRoot("primary");
    
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

    }//End of Main
}//End of Class
