package gunn.battleship;
/*
Put header here


 */

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
public class FXMLController implements Initializable {
    
/*@FXML
private ImageView Explosion;
@FXML      //new stuff for the pictures
private ImageView Water:
*/
        


    @FXML
    void btnStart(MouseEvent event) 
    {
        //1= 1,2 
        int spot1  = ThreadLocalRandom.current().nextInt(1,11+1);
        int spot2 = ThreadLocalRandom.current().nextInt(1,11+1);
        int spot3 = ThreadLocalRandom.current().nextInt(1,11+1);
        while (spot1 == spot2) {
            spot2 = ThreadLocalRandom.current().nextInt(1,11+1);
        }
         while (spot1==spot3 || spot2==spot3) {
            spot3 = ThreadLocalRandom.current().nextInt(1,11+1);
        }
        //1 = 
        if (spot1 == 1 || spot2 == 1 || spot3 == 1)
        {
                    
        }
        else if (spot1 == 2 || spot2 == 2 || spot3 == 2)
        {
            
        }
        else if (spot1 == 3 || spot2 == 3 || spot3 == 3)
        {
            
        }
        else if (spot1 == 4 || spot2 == 4 || spot3 == 4)
        {
            
        }
        else if (spot1 == 5 || spot2 == 5 || spot3 == 5)
        {
            
        }
        else if (spot1 == 6 || spot2 == 6 || spot3 == 6)
        {
            
        }
        else if (spot1 == 7 || spot2 == 7 || spot3 == 7)
        {
            
        }
        else if (spot1 == 8 || spot2 == 8 || spot3 == 8)
        {
            
        }
        else if (spot1 == 9 || spot2 == 9 || spot3 == 9)
        {
            
        }
        else if (spot1 == 10 || spot2 == 10 || spot3 == 10)
        {
            
        }
        else if (spot1 == 11 || spot2 == 11 || spot3 == 11)
        {
            
        }
    }
    
    @FXML
    void imgClick(MouseEvent event) {

    }

    

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // TODO
    }
    
}
