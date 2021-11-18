package gunn.battleship;
/*
Name; Gavin Gunn
Class; Grade 12 Com Studies
Date; 22/11/21
Assignment#; 1
Description; Creating a functioning single player game of battleship
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
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.TextField;

public class FXMLController implements Initializable {
  
    //imports
    
    @FXML
    private Label LBL_GAMEBRAIN;
    
    @FXML
    private TextField TXT_NAME;
    
    @FXML
    private Button BTN_RESET;
    
     @FXML
    private Label LBL_HIT;
    
    @FXML
    private Label LBL_MISS;
    
    @FXML
    private Label LBL_TIMER;
    
    @FXML
    private Button BTN_START;

    @FXML
    private Button BTN_EXIT;

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

    //Globals
int spot1;
int spot2;
int spot3;
int timer=0;
int total=0;
int hitTotal=0;
int missTotal=0;
public static String Name;
int score =0;
int endTime=0;

    ImageView Store[];


    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), ae -> counter())); //timers brain

    void counter(){           //timer label counter
          timer++;
          LBL_TIMER.setText("" + timer);
    }
    
    
    
    

    
    @FXML
    void exitClick(MouseEvent event) //exit button
    {
     System.exit(0);
    }
    
    
    @FXML
    void imgClick(MouseEvent event) //variables for images
    {
     ImageView img = (ImageView) event.getSource();
    
     Image clouds = new Image(getClass().getResource("/Clouds.jpeg").toString());
     Image explosion = new Image(getClass().getResource("/Explosion.jpeg").toString());
     Image water = new Image(getClass().getResource("/Water.jpeg").toString());
     if (img.getAccessibleText().equals("2L"))
     {
      img.setImage(explosion);   // image changing code
      System.out.println(hitTotal);
      hitTotal=hitTotal+1;
      LBL_HIT.setText("" + hitTotal);
      img.setAccessibleText("Neg");
     }
     if(img.getAccessibleText().equals(""))
     {
      img.setImage(water);
      missTotal =missTotal+1;
      LBL_MISS.setText("" +missTotal);
      img.setAccessibleText("Neg");
      
       if (total == hitTotal)
    {
     timer = endTime;
     timeline.stop(); //stop timer code
     for (ImageView name : Store) 
     {
      name.setAccessibleText("Neg");
     }
     score = ((hitTotal/missTotal)*1000)- (endTime*5);
     LBL_GAMEBRAIN.setText("User " + Name + ", Final score: " + score );//not working  outputting 0
    
    }
    
    if (missTotal == 10)
    {
     timer = endTime;   
     timeline.stop(); //stop timer code
     for (ImageView name : Store) 
     {
      name.setAccessibleText("Neg");
     }
     score = ((hitTotal/missTotal)*1000)- (endTime*5);
     LBL_GAMEBRAIN.setText("User " + Name + ", Final score: " + score ); //not working  outputting 0
    } 
      
     }
    }
    
    
    @FXML
    void resetClick(ActionEvent event) {
    BTN_START.setVisible(true);
    TXT_NAME.setVisible(true);
    LBL_GAMEBRAIN.setText("");
    LBL_TIMER.setText("0000");
    LBL_GAMEBRAIN.setText("");
    TXT_NAME.setText("");
    LBL_MISS.setText("");
    LBL_HIT.setText("");
    hitTotal=0;
    missTotal=0;
    score =0;
    endTime=0;
    timer=0;
    total=0;
    
    
     for (ImageView name : Store) 
     {
      name.setAccessibleText("");
      name.setImage(new Image(getClass().getResource("/Clouds.jpeg").toString()));
     } //work in progress to revert photos to cloud
          
   }   
        


    void spotPick(){   //code for randomizers and conditions for no overlap
            
        spot1 = ThreadLocalRandom.current().nextInt(1,11+1);
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
    void btnStart(MouseEvent event) //Code for setting images to a hit in game, setting button invisible, Timer initiation and updating total +spots
    {
        for (ImageView name : Store) 
     {
      name.setAccessibleText("");
      name.setImage(new Image(getClass().getResource("/Clouds.jpeg").toString()));
     } //work in progress to revert photos to cloud
        
        Name = TXT_NAME.getText();
  
        spotPick();
        
        if (spot1 == 1 || spot2 == 1 || spot3 == 1)
        {
         JFX_IMG_01.setAccessibleText("2L");
         JFX_IMG_02.setAccessibleText("2L");
         total =total+ 2;
        }
        if (spot1 == 2 || spot2 == 2 || spot3 == 2)
        {
         JFX_IMG_07.setAccessibleText("2L");
         JFX_IMG_08.setAccessibleText("2L");
         total =total+ 2;
        }
        if (spot1 == 3 || spot2 == 3 || spot3 == 3)
        {
         JFX_IMG_21.setAccessibleText("2L");
         JFX_IMG_22.setAccessibleText("2L");
         total =total+ 2;
        }
        if (spot1 == 4 || spot2 == 4 || spot3 == 4)
        {
         JFX_IMG_12.setAccessibleText("2L");
         JFX_IMG_17.setAccessibleText("2L");
         total =total+ 2;
        }
        if (spot1 == 5 || spot2 == 5 || spot3 == 5)
        {
         JFX_IMG_09.setAccessibleText("2L");
         JFX_IMG_14.setAccessibleText("2L"); 
         total =total+ 2;
        }
        if (spot1 == 6 || spot2 == 6 || spot3 == 6)
        {
         JFX_IMG_10.setAccessibleText("2L");
         JFX_IMG_15.setAccessibleText("2L"); 
         total =total+ 2;
        }
        if (spot1 == 7 || spot2 == 7 || spot3 == 7)
        {
         JFX_IMG_19.setAccessibleText("2L");
         JFX_IMG_20.setAccessibleText("2L");
         total =total+ 2;
        }
        if (spot1 == 8 || spot2 == 8 || spot3 == 8)
        {
         JFX_IMG_24.setAccessibleText("2L");
         JFX_IMG_25.setAccessibleText("2L");
         total =total+ 2;
        }
        if (spot1 == 9 || spot2 == 9 || spot3 == 9)
        {
         JFX_IMG_13.setAccessibleText("2L");
         JFX_IMG_18.setAccessibleText("2L");
         JFX_IMG_23.setAccessibleText("2L");
         total =total+ 3;
        }
        if (spot1 == 10 || spot2 == 10 || spot3 == 10)
        {
         JFX_IMG_03.setAccessibleText("2L");
         JFX_IMG_04.setAccessibleText("2L");
         JFX_IMG_05.setAccessibleText("2L"); 
         total =total+ 3;
        }                                                    
        if (spot1 == 11 || spot2 == 11 || spot3 == 11)  
        {
         JFX_IMG_06.setAccessibleText("2L");
         JFX_IMG_11.setAccessibleText("2L");
         JFX_IMG_16.setAccessibleText("2L");
         total =total+ 3;
        }
        
      
            
        
        TXT_NAME.setVisible(false);
        BTN_START.setVisible(false);
       
        
        timeline.setCycleCount(Timeline.INDEFINITE);//starts timer
        timeline.play();
        
        
    }
    
   
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    ImageView picR[] = {JFX_IMG_01, JFX_IMG_02, JFX_IMG_03, JFX_IMG_04, JFX_IMG_05, JFX_IMG_06, JFX_IMG_07,JFX_IMG_08,JFX_IMG_09,JFX_IMG_10,JFX_IMG_11,JFX_IMG_12,JFX_IMG_13,JFX_IMG_14,JFX_IMG_15,JFX_IMG_16,JFX_IMG_17,JFX_IMG_18,JFX_IMG_19,JFX_IMG_20,JFX_IMG_21,JFX_IMG_22,JFX_IMG_23,JFX_IMG_24,JFX_IMG_25};
       Store=picR;
    
      // TODO
    }//
    
}
