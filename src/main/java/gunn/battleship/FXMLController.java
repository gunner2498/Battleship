package gunn.battleship;

/*
Name; Gavin Gunn
Class; Grade 12 Com Studies
Date; 22/11/21
Assignment#; 1
Description; Creating a functioning single player game of battleship
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
import javafx.scene.layout.TilePane;

public class FXMLController implements Initializable {

    //imports
    @FXML
    private TilePane TPN_WALL;
    @FXML
    private Label LBL_NAME;
    
    @FXML
    private Button BTN_ENTER;
    
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
    int timer = 0;
    int total = 0;
    int hitTotal = 0;
    int missTotal = 0;
    public static String Name;
    int score = 0;
    int endTime = 0;
    int multiplier = 0;
    String leaderboardName[] = new String[5]; 
    int leaderboardScore[] = new int [5];
    String HPlayer1 = "Player 1";
    String HPlayer2 = "Player 2";
    String HPlayer3 = "Player 3";
    String HPlayer4 = "Player 4";        
    String HPlayer5 = "Player 5";
    String HPlayer6 = "Player 6";
    int HScore1 = -100000;
    int HScore2 = -100000;
    int HScore3 = -100000;
    int HScore4 = -100000;
    int HScore5 = -100000;
    int HScore6 = -100000;
            
            ;
    ImageView Store[];//array

    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), ae -> counter())); //timers brain

    void counter() {           //timer label counter
        timer++;
        LBL_TIMER.setText("" + timer);
    }

     
    /* //File highscores
    void readScores() {
        try {

            BufferedReader readFile = new BufferedReader(new FileReader("Netbeans_Name_File"));
            for (int i = 0; i < 5; i++) {
                leaderboardName[i] = readFile.readLine();
                leaderboardScore[i] = Integer.parseInt(readFile.readLine());
            }
            readFile.close();
        } catch (IOException e) {
        }
    }
    
    void writeScore() {
        try {
            BufferedWriter outFile = new BufferedWriter(new FileWriter("Netbeans_Name_File"));
            for (int i = 0; i < 5; i++) {
                outFile.write(leaderboardName[i]);
                outFile.newLine();
                outFile.write(leaderboardScore[i]);
                outFile.newLine();
            }
            outFile.close();
        } catch (IOException e) {
        }
    }
    
     */
    
    
    @FXML
    void enterClick(MouseEvent event) 
    {
     BTN_START.setVisible(true);
     BTN_ENTER.setVisible(false);
    }
    
    @FXML
    void exitClick(MouseEvent event) //exit button
    {
        System.exit(0);
    }
    
    void wrapUp()
    {
    endTime = timer;
            timeline.stop(); //stop timer code
            TPN_WALL.setVisible(true);
            for (ImageView name : Store) {
                name.setAccessibleText("Neg");
            }
            
            if(total == hitTotal)
            {
              multiplier = 1000;  
            }
            if(missTotal == 11)
            {
              multiplier = 100;
            }
            
            
            score = (int) Math.floor(((double) ((multiplier + ((2 * ((hitTotal * 2) / (missTotal))) * 1000) - (endTime * 10)))));//score calc code
            
            if( score > HScore1) //Local high scores and bumping
            {   
              HScore6 = HScore5;
              HScore5 = HScore4;
              HScore4 = HScore3;
              HScore3 = HScore2;
              HScore2 = HScore1;
              
              HPlayer6 = HPlayer5;
              HPlayer5 = HPlayer4;
              HPlayer4 = HPlayer3;
              HPlayer3 = HPlayer2;
              HPlayer2 = HPlayer1;
              
              HPlayer1 = Name;
              HScore1 = score;
            }
            else if( score > HScore2)
            {
              HScore6 = HScore5;
              HScore5 = HScore4;
              HScore4 = HScore3;
              HScore3 = HScore2; 
              
              HPlayer6 = HPlayer5;
              HPlayer5 = HPlayer4;
              HPlayer4 = HPlayer3;
              HPlayer3 = HPlayer2;
              
              HPlayer2 = Name;
              HScore2 = score;
            }
            else if( score > HScore3)
            {
              HScore6 = HScore5;
              HScore5 = HScore4;
              HScore4 = HScore3; 
              
              HPlayer6 = HPlayer5;
              HPlayer5 = HPlayer4;
              HPlayer4 = HPlayer3;
                
              HPlayer3 = Name;
              HScore3 = score;
            }
            else if( score > HScore4)
            { 
              HScore6 = HScore5;
              HScore5 = HScore4;
              
              HPlayer6 = HPlayer5;
              HPlayer5 = HPlayer4;
              
              HPlayer4 = Name;
              HScore4 = score;
            }
            else if( score > HScore5)
            {
             HScore6 = HScore5;
              
             HPlayer6 = HPlayer5;
              
              HPlayer5 = Name;
              HScore5 = score;
            }
            
            
            
            LBL_GAMEBRAIN.setText("User " + Name + ", Final score: " + score + "\n" + "\n" + "\t" + "Highscores" 
            + "\n" + "1,  " + HPlayer1 + ": " + HScore1 
            + "\n" + "2,  " + HPlayer2 + ": " + HScore2      
            + "\n" + "3,  " + HPlayer3 + ": " + HScore3 
            + "\n" + "4,  " + HPlayer4 + ": " + HScore4 
            + "\n" + "5,  " + HPlayer5 + ": " + HScore5 
            );
            
    }
    
    @FXML
    void imgClick(MouseEvent event) //variables for images
    {
        ImageView img = (ImageView) event.getSource();

        Image clouds = new Image(getClass().getResource("/Clouds.jpeg").toString());
        Image explosion = new Image(getClass().getResource("/Explosion.jpeg").toString());
        Image water = new Image(getClass().getResource("/Water.jpeg").toString());
        if (img.getAccessibleText().equals("2L"))// image changing code and prep
        {
            img.setImage(explosion);
            System.out.println(hitTotal);
            hitTotal = hitTotal + 1;
            LBL_HIT.setText("" + hitTotal);
            img.setAccessibleText("Neg");
        }
        if (img.getAccessibleText().equals("")) {
            img.setImage(water);
            missTotal = missTotal + 1;
            LBL_MISS.setText("" + missTotal);
            img.setAccessibleText("Neg");
        }

        if (total == hitTotal) //endgame code for calculating win scores
        {
            wrapUp();
        }

        if (missTotal == 11)//endgame code for calculating win scores
        {
            wrapUp();
        }

    }

    @FXML
    void resetClick(ActionEvent event) { //reset buttons and numbers
        BTN_ENTER.setVisible(true);
        TXT_NAME.setVisible(true);
        LBL_NAME.setText("Name:");
        LBL_GAMEBRAIN.setText("");
        LBL_TIMER.setText("0000");
        LBL_GAMEBRAIN.setText("");
        TXT_NAME.setText("");
        LBL_MISS.setText("");
        LBL_HIT.setText("");
        hitTotal = 0;
        missTotal = 0;
        score = 0;
        endTime = 0;
        timer = 0;
        total = 0;

        for (ImageView name : Store) //array to reset all images to default
        {
            name.setAccessibleText("");
            name.setImage(new Image(getClass().getResource("/Clouds.jpeg").toString()));
        } //work in progress to revert photos to cloud

    }

    void spotPick() {   //code for randomizers and conditions for no overlap

        spot1 = ThreadLocalRandom.current().nextInt(1, 11 + 1);
        spot2 = ThreadLocalRandom.current().nextInt(1, 11 + 1);
        spot3 = ThreadLocalRandom.current().nextInt(1, 11 + 1);
        while (spot1 == spot2) {
            spot2 = ThreadLocalRandom.current().nextInt(1, 11 + 1);
        }
        while (spot1 == spot3 || spot2 == spot3) {
            spot3 = ThreadLocalRandom.current().nextInt(1, 11 + 1);
        }
    }

    @FXML
    void btnStart(MouseEvent event) //Code for setting images to a hit in game, setting button invisible, Timer initiation and updating total +spots
    {
        for (ImageView name : Store) {
            name.setAccessibleText("");
            name.setImage(new Image(getClass().getResource("/Clouds.jpeg").toString()));
        } //work in progress to revert photos to cloud

        Name = TXT_NAME.getText();

        spotPick();

        if (spot1 == 1 || spot2 == 1 || spot3 == 1) {
            JFX_IMG_01.setAccessibleText("2L");
            JFX_IMG_02.setAccessibleText("2L");
            total = total + 2;
        }
        if (spot1 == 2 || spot2 == 2 || spot3 == 2) {
            JFX_IMG_07.setAccessibleText("2L");
            JFX_IMG_08.setAccessibleText("2L");
            total = total + 2;
        }
        if (spot1 == 3 || spot2 == 3 || spot3 == 3) {
            JFX_IMG_21.setAccessibleText("2L");
            JFX_IMG_22.setAccessibleText("2L");
            total = total + 2;
        }
        if (spot1 == 4 || spot2 == 4 || spot3 == 4) {
            JFX_IMG_12.setAccessibleText("2L");
            JFX_IMG_17.setAccessibleText("2L");
            total = total + 2;
        }
        if (spot1 == 5 || spot2 == 5 || spot3 == 5) {
            JFX_IMG_09.setAccessibleText("2L");
            JFX_IMG_14.setAccessibleText("2L");
            total = total + 2;
        }
        if (spot1 == 6 || spot2 == 6 || spot3 == 6) {
            JFX_IMG_10.setAccessibleText("2L");
            JFX_IMG_15.setAccessibleText("2L");
            total = total + 2;
        }
        if (spot1 == 7 || spot2 == 7 || spot3 == 7) {
            JFX_IMG_19.setAccessibleText("2L");
            JFX_IMG_20.setAccessibleText("2L");
            total = total + 2;
        }
        if (spot1 == 8 || spot2 == 8 || spot3 == 8) {
            JFX_IMG_24.setAccessibleText("2L");
            JFX_IMG_25.setAccessibleText("2L");
            total = total + 2;
        }
        if (spot1 == 9 || spot2 == 9 || spot3 == 9) {
            JFX_IMG_13.setAccessibleText("2L");
            JFX_IMG_18.setAccessibleText("2L");
            JFX_IMG_23.setAccessibleText("2L");
            total = total + 3;
        }
        if (spot1 == 10 || spot2 == 10 || spot3 == 10) {
            JFX_IMG_03.setAccessibleText("2L");
            JFX_IMG_04.setAccessibleText("2L");
            JFX_IMG_05.setAccessibleText("2L");
            total = total + 3;
        }
        if (spot1 == 11 || spot2 == 11 || spot3 == 11) {
            JFX_IMG_06.setAccessibleText("2L");
            JFX_IMG_11.setAccessibleText("2L");
            JFX_IMG_16.setAccessibleText("2L");
            total = total + 3;
        }
        LBL_NAME.setText("Player: " + Name);
        TXT_NAME.setVisible(false); //to prevebnt double clicks and changes
        BTN_START.setVisible(false);
        BTN_ENTER.setVisible(false);
        TPN_WALL.setVisible(false);
        timeline.setCycleCount(Timeline.INDEFINITE);//starts timer
        timeline.play();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ImageView picR[] = {JFX_IMG_01, JFX_IMG_02, JFX_IMG_03, JFX_IMG_04, JFX_IMG_05, JFX_IMG_06, JFX_IMG_07,
            JFX_IMG_08, JFX_IMG_09, JFX_IMG_10, JFX_IMG_11, JFX_IMG_12, JFX_IMG_13, JFX_IMG_14,
            JFX_IMG_15, JFX_IMG_16, JFX_IMG_17, JFX_IMG_18, JFX_IMG_19, JFX_IMG_20, JFX_IMG_21,
            JFX_IMG_22, JFX_IMG_23, JFX_IMG_24, JFX_IMG_25};
        Store = picR;
        BTN_START.setVisible(false);
        TPN_WALL.setVisible(true);
    //readScores();
    //writeScore();    
        // TODO
        
    }//End of Main
}//End of Class
