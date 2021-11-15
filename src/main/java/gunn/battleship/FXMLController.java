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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
public class FXMLController implements Initializable {
    
/*@FXML
private ImageView Explosion;
@FXML      //new stuff for the pictures
private ImageView Water:
*/
        
@FXML
    private Button BTN_START;

    @FXML
    private ImageView JFX_IMG_01;

    @FXML
    private ImageView JFX_IMG_02;

    @FXML
    private ImageView JFX_IMG_03;

    @FXML
    private ImageView JFX_IMG_04;

    @FXML
    private ImageView JFX_IMG_05;

    @FXML
    private ImageView JFX_IMG_06;

    @FXML
    private ImageView JFX_IMG_07;

    @FXML
    private ImageView JFX_IMG_08;

    @FXML
    private ImageView JFX_IMG_09;

    @FXML
    private ImageView JFX_IMG_10;

    @FXML
    private ImageView JFX_IMG_11;

    @FXML
    private ImageView JFX_IMG_12;

    @FXML
    private ImageView JFX_IMG_13;

    @FXML
    private ImageView JFX_IMG_14;

    @FXML
    private ImageView JFX_IMG_15;

    @FXML
    private ImageView JFX_IMG_16;

    @FXML
    private ImageView JFX_IMG_17;

    @FXML
    private ImageView JFX_IMG_18;

    @FXML
    private ImageView JFX_IMG_19;

    @FXML
    private ImageView JFX_IMG_20;

    @FXML
    private ImageView JFX_IMG_21;

    @FXML
    private ImageView JFX_IMG_22;

    @FXML
    private ImageView JFX_IMG_23;

    @FXML
    private ImageView JFX_IMG_24;

    @FXML
    private ImageView JFX_IMG_25;

int spot1;
int spot2;
int spot3;
    @FXML
    void imgClick(MouseEvent event) 
    {
     ImageView img = (ImageView) event.getSource();
    
     Image clouds = new Image(getClass().getResource("/Clouds.jpeg").toString());
     Image explosion = new Image(getClass().getResource("/Explosion.jpeg").toString());
     Image water = new Image(getClass().getResource("/Water.jpeg").toString());
     if (img.getAccessibleText().equals("2L"))
     {
      img.setImage(explosion);   //Work in progress image changing code
     }
     else
     {
      img.setImage(water);   
     }
    }

    void spotPick(){
           //1= 1,2 
        spot1  = ThreadLocalRandom.current().nextInt(1,11+1);
        spot2 = ThreadLocalRandom.current().nextInt(1,11+1);
        spot3 = ThreadLocalRandom.current().nextInt(1,11+1);
        while (spot1 == spot2) {
            spot2 = ThreadLocalRandom.current().nextInt(1,11+1);
        }
         while (spot1==spot3 || spot2==spot3) {
            spot3 = ThreadLocalRandom.current().nextInt(1,11+1);
        }
    }
    
    @FXML
    void btnStart(MouseEvent event) 
    {
        spotPick();
        //1 = 
        if (spot1 == 1 || spot2 == 1 || spot3 == 1)
        {
         JFX_IMG_01.setAccessibleText("2L");
         JFX_IMG_02.setAccessibleText("2L");
        }
        else if (spot1 == 2 || spot2 == 2 || spot3 == 2)
        {
         JFX_IMG_07.setAccessibleText("2L");
         JFX_IMG_08.setAccessibleText("2L");   
        }
        else if (spot1 == 3 || spot2 == 3 || spot3 == 3)
        {
         JFX_IMG_21.setAccessibleText("2L");
         JFX_IMG_22.setAccessibleText("2L");   
        }
        else if (spot1 == 4 || spot2 == 4 || spot3 == 4)
        {
         JFX_IMG_12.setAccessibleText("2L");
         JFX_IMG_17.setAccessibleText("2L");   
        }
        else if (spot1 == 5 || spot2 == 5 || spot3 == 5)
        {
         JFX_IMG_09.setAccessibleText("2L");
         JFX_IMG_14.setAccessibleText("2L");   
        }
        else if (spot1 == 6 || spot2 == 6 || spot3 == 6)
        {
         JFX_IMG_10.setAccessibleText("2L");
         JFX_IMG_15.setAccessibleText("2L");   
        }
        else if (spot1 == 7 || spot2 == 7 || spot3 == 7)
        {
         JFX_IMG_19.setAccessibleText("2L");
         JFX_IMG_20.setAccessibleText("2L");   
        }
        else if (spot1 == 8 || spot2 == 8 || spot3 == 8)
        {
         JFX_IMG_24.setAccessibleText("2L");
         JFX_IMG_25.setAccessibleText("2L");   
        }
        else if (spot1 == 9 || spot2 == 9 || spot3 == 9)
        {
         JFX_IMG_13.setAccessibleText("2L");
         JFX_IMG_18.setAccessibleText("2L");
         JFX_IMG_23.setAccessibleText("2L");
        }
        else if (spot1 == 10 || spot2 == 10 || spot3 == 10)
        {
         JFX_IMG_03.setAccessibleText("2L");
         JFX_IMG_04.setAccessibleText("2L");
         JFX_IMG_05.setAccessibleText("2L");   
        }
        else if (spot1 == 11 || spot2 == 11 || spot3 == 11)
        {
         JFX_IMG_06.setAccessibleText("2L");
         JFX_IMG_11.setAccessibleText("2L");
         JFX_IMG_16.setAccessibleText("2L");    
        }
    }
    
    

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // TODO
    }
    
}
