/*
 * W20- Java Intermediate
 * Final Assignment
 * and open the template in the editor.
 */
package alienhunt;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;








/**
 * FXMLDocumentController Class implements Initializable to handle all behaviour and user interaction with the FXML file and application.
 * It includes the initializer method, all of the button interactions, the animations, the media, the game parts like randomizing the alien 
 * selection and handling results and scores.
 * 
 * @author Kerry Nelson Milovic
 * @version 1.0
 * @since 2020-04-21
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private Label label;
    @FXML
    private Label score;
    @FXML
    private Label highScoreLabel;
    private int[] alienArray = {0,1,1,0,0,0,0,0};
    int martiansFound;
    int jupiteransFound;
    int buttonIndex;
    int typeID;
    int scoreResult;
    String homePlanet;
    String typeName;
    int numberEyes;
    /**
     * To draw a martian, added to canvas in the intialize() method.
     */
    private GraphicsContext aMartianPic;
    /**
     *  To draw details of a martian, added to canvas in the intialize() method.
     */
    public GraphicsContext aMartianPicDetails;
     /**
     * To draw a Jupiteran, added to canvas2 in the intialize() method.
     */
    public GraphicsContext aJupiteranPic;
   /**
     * To draw a Jupiteran's details, added to canvas2 in the intialize() method.
     */
    
    public GraphicsContext aJupiteranPicDetails;

    /**
     *To draw the second Jupiteran if required at the end of the game, added to canvas3 in the initialize() method.
     */
    public GraphicsContext endGamePic;

    /**
     *To draw the the details of the second Jupiteran if required at the end of the game, added to canvas3 in the initialize() method.
     */
    public GraphicsContext endGamePicDetails;
    int highScore = 0;
    String filePath = "C:\\temp\\alienHuntScores.txt";
    File scores = new File(filePath);
    @FXML
    private javafx.scene.canvas.Canvas canvas;
    @FXML
    private javafx.scene.canvas.Canvas canvas2;
    @FXML
    private javafx.scene.canvas.Canvas canvas3;
    @FXML
    private Button play;
    @FXML
    private Button button;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    private Button button6;
    @FXML
    private Button button7;
    @FXML
    private Button button8;
    @FXML
    AnchorPane AnchorPane;
    @FXML
    AnchorPane fullPane;
    @FXML
    AnchorPane mainPane;
    @FXML
    AnchorPane topPane;
    BorderPane rootLayout;
    @FXML
    private ImageView earth;
    @FXML
    private ImageView smokeRing;
    @FXML
    private ImageView fogOverlay;
    @FXML
    private ImageView smokeScreen;
    @FXML
    private ImageView smokeWall;
    @FXML
    private ImageView martianSpaceship;
    @FXML
    private ImageView spaceTopMenu;
    
    
    
 /**
 * 
 * initialize() method loads after the application starts, assigns the graphic contexts to the appropriate canvasses 
 * and quickly fades out the overlayed images of smoke on the start of the application. 
 * 
 * 
     * @param url to receive a url 
     * @param rb to receive a resourceBundle
 */
   
  
   
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
       
       // assigns the graphic contexts to the appropriate canvasses after start
        aMartianPic = canvas.getGraphicsContext2D();
        aMartianPicDetails = canvas.getGraphicsContext2D();
        aJupiteranPic = canvas2.getGraphicsContext2D();
        aJupiteranPicDetails = canvas2.getGraphicsContext2D();
        endGamePic = canvas3.getGraphicsContext2D();
        endGamePicDetails = canvas3.getGraphicsContext2D();
        
        
        // hides the overlayed images of smoke on the start of the application
        FadeTransition ftRing = new FadeTransition(Duration.millis(10),smokeRing );
        ftRing .setFromValue(1.0);
        ftRing .setToValue(0.0);
        ftRing .setCycleCount(1);
        ftRing .setAutoReverse(false);
        ftRing .play();
        
        FadeTransition ftScreen = new FadeTransition(Duration.millis(10), smokeScreen);
        ftScreen.setFromValue(1.0);
        ftScreen.setToValue(0.0);
        ftScreen.setCycleCount(1);
        ftScreen.setAutoReverse(false);
        ftScreen.play();
        
        FadeTransition ft = new FadeTransition(Duration.millis(10), fogOverlay);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
        
        FadeTransition ftWall = new FadeTransition(Duration.millis(10), smokeWall);
        ftWall.setFromValue(1.0);
        ftWall.setToValue(0.0);
        ftWall.setCycleCount(1);
        ftWall.setAutoReverse(false);
        ftWall.play();
        
       
        
        
        
    }
   /**
 * 
 * handleButtonActionlay(ActionEvent event) receives a user event and starts the game with playing by calling many other methods that reset the game for the user like
 * rotating earth, clearing canvases, shuffling the aliens and resetting the number found to 0, playing an audio file and providing appropriate text for a new game.
 * 
 * 
 */
        
   @FXML
     private void handleButtonActionPlay(ActionEvent event) {
        earthAnimation();
        clearGraphics();
        play.setDisable(true);
        System.out.println("In play mode");
       shuffleArray(alienArray);
       label.setText("You want to play? Dangerous choice. Pick a button...");
       String path = "C://temp/MartianScanner.mp3";
        Media media = new Media(new File(path).toURI().toString());
       MediaPlayer mediaPlayer = new MediaPlayer(media);
       mediaPlayer.setAutoPlay(true);
      highScoreLabel.setText("High Score: "+highScore);
      martiansFound=0;
      jupiteransFound=0;
       button.setDisable(false);
        button2.setDisable(false);
        button3.setDisable(false);
        button4.setDisable(false);
        button5.setDisable(false);
        button6.setDisable(false);
        button7.setDisable(false);
        button8.setDisable(false);
        score.setText("");
       
    }

    /**
     *shuffle(int[] alienArray) receives the alienArray and uses Sattato's algorithm. It initializes an index and temp integer value, creates a random object and then uses a loop to pass through each index in the array. 
     * First a random number between 0-1 is assigned to the local random index variable and then that index variable is assigned to a temp variable, then the value of the loop of the random index number within the alien array is assigned to the 
     * value of the current array and the value of the current array is assigned back to temp. 
     * 
     *
     * @param alienArray
     */
    public void shuffleArray(int[] alienArray){
        int index;
        int temp;
        Random random = new Random();
        for (int i = alienArray.length - 1; i > 0; i--)
        { 
            index = random.nextInt(i+1);// First a random number between 0-1 is assigned to the index variable
            temp = alienArray[index];// the value of the random array value is assigned to temp
            alienArray[index]= alienArray[i]; // the value of that the random alien array is assigned to the index array
            alienArray[i] =temp;// the value of the current array is passed to temp so it can be assigned in the next loop 
        }
      
    }

    /**
     *updateScore() method updates the variables and score displayed for total number of martians and jupiteran found based on the value of the button index being 0 or not and updates the values of the type and typeName.
     * 
     */
    public void updateScore(){
        if (alienArray[buttonIndex] == 0)
        {
            martiansFound++;
            typeName="Martian";
            typeID=2;
            
        }
        else
        {
            jupiteransFound++;
            typeName = "Jupiteran";
            typeID=1;
        }
          score.setText("Martians: "+ martiansFound + "\n"+ "Jupiterans: " + jupiteransFound);
    } 
    
    
    
    /**
     *handleButtonAction() method sets this button's index to be passed to be used by the update score method, it disables the button and then depending on which type ID the update score method resulted in 
     * and the current count of martians and jupiterans, it  could end initiate the end of the game, or updates the text displayed to the user, creates an alien object and uses the either martian or jupiteran draw method passing the graphic contexts as
     * parameters.
     * 
     */
    
  
   
 @FXML
    private void handleButtonAction(ActionEvent event) {

        buttonIndex = 0;
        button.setDisable(true);
        updateScore();
        System.out.println("You clicked");
        if (martiansFound == 6){
            endGame();
        }
        else if (typeID == 2 && martiansFound <6){
            Martian Martian1 = new Martian(2, "Mars", "Martian", 2);
            label.setText("You picked a " + typeName +". You live to pick again.");
            Martian1.draw(aMartianPic, aMartianPicDetails);
        
        }
        else if (jupiteransFound < 2){
            label.setText("You picked a " + typeName +". You live to pick again.");
            Jupiteran Jupiteran1 = new Jupiteran (1,"Jupiter","Jupiteran",3);
             Jupiteran1.draw(aJupiteranPic, aJupiteranPicDetails);
        }
        else{
            endGame();
        }
    }
    
    /**
     *handleButtonAction2() method sets this button's index to be passed to be used by the update score method, it disables the button and then depending on which type ID the update score method resulted in 
     * and the current count of martians and jupiterans, it  could end initiate the end of the game, or updates the text displayed to the user, creates an alien object and uses the either martian or jupiteran draw method passing the graphic contexts as
     * parameters.
     * 
     */

    
   

    @FXML
   private void handleButtonAction2(ActionEvent event) {

        buttonIndex = 1;
        button2.setDisable(true);
        updateScore();
        System.out.println("You clicked");
        if (martiansFound == 6){
            endGame();
        }
        else if (typeID == 2 && martiansFound <6){
            Martian Martian1 = new Martian(2, "Mars", "Martian", 2);
            label.setText("You picked a " + typeName +". You live to pick again.");
             Martian1.draw(aMartianPic, aMartianPicDetails);
        }
        else if (jupiteransFound < 2){
            label.setText("You picked a " + typeName +". You live to pick again.");
            Jupiteran Jupiteran1 = new Jupiteran (1,"Jupiter","Jupiteran",3);
             Jupiteran1.draw(aJupiteranPic, aJupiteranPicDetails);
        }
        else{
            endGame();
        }
    
    }
   
    /**
     *handleButtonAction3() method sets this button's index to be passed to be used by the update score method, it disables the button and then depending on which type ID the update score method resulted in 
     * and the current count of martians and jupiterans, it  could end initiate the end of the game, or updates the text displayed to the user, creates an alien object and uses the either martian or jupiteran draw method passing the graphic contexts as
     * parameters.
     * 
     */
    @FXML
    private void handleButtonAction3(ActionEvent event) {

        buttonIndex = 2;
        button3.setDisable(true);
        updateScore();
        System.out.println("You clicked");
        if (martiansFound == 6){
            endGame();
        }
        else if (typeID == 2 && martiansFound <6){
            Martian Martian1 = new Martian(2, "Mars", "Martian", 2);
            label.setText("You picked a " + typeName +". You live to pick again.");
              Martian1.draw(aMartianPic, aMartianPicDetails);
                }
        else if (jupiteransFound < 2){
            label.setText("You picked a " + typeName +". You live to pick again.");
            Jupiteran Jupiteran1 = new Jupiteran (1,"Jupiter","Jupiteran",3);
             Jupiteran1.draw(aJupiteranPic, aJupiteranPicDetails);
        }
        else{
            endGame();
        }
    }
    
     /**
     *handleButtonAction4() method sets this button's index to be passed to be used by the update score method, it disables the button and then depending on which type ID the update score method resulted in 
     * and the current count of martians and jupiterans, it  could end initiate the end of the game, or updates the text displayed to the user, creates an alien object and uses the either martian or jupiteran draw method passing the graphic contexts as
     * parameters.
     * 
     */
    
    @FXML
    private void handleButtonAction4(ActionEvent event) {

        buttonIndex = 3;
        button4.setDisable(true);
        updateScore();
        System.out.println("You clicked");
        if (martiansFound == 6){
            endGame();
        }
        else if (typeID == 2 && martiansFound <6){
            Martian Martian1 = new Martian(2, "Mars", "Martian", 2);
            label.setText("You picked a " + typeName +". You live to pick again.");
              Martian1.draw(aMartianPic, aMartianPicDetails);
        }
        else if (jupiteransFound < 2){
            label.setText("You picked a " + typeName +". You live to pick again.");
            Jupiteran Jupiteran1 = new Jupiteran (1,"Jupiter","Jupiteran",3);
             Jupiteran1.draw(aJupiteranPic, aJupiteranPicDetails);
        }
        else{
            endGame();
        }
    }
    
     /**
     *handleButtonAction5() method sets this button's index to be passed to be used by the update score method, it disables the button and then depending on which type ID the update score method resulted in 
     * and the current count of martians and jupiterans, it  could end initiate the end of the game, or updates the text displayed to the user, creates an alien object and uses the either martian or jupiteran draw method passing the graphic contexts as
     * parameters.
     * 
     */
    @FXML
    private void handleButtonAction5(ActionEvent event) {

        buttonIndex = 4;
        button5.setDisable(true);
        updateScore();
        System.out.println("You clicked");
        if (martiansFound == 6){
            endGame();
        }
        else if (typeID == 2 && martiansFound <6){
            Martian Martian1 = new Martian(2, "Mars", "Martian", 2);
            label.setText("You picked a " + typeName +". You live to pick again.");
              Martian1.draw(aMartianPic, aMartianPicDetails);
        }
        else if (jupiteransFound < 2){
            label.setText("You picked a " + typeName +". You live to pick again.");
            Jupiteran Jupiteran1 = new Jupiteran (1,"Jupiter","Jupiteran",3);
             Jupiteran1.draw(aJupiteranPic, aJupiteranPicDetails);

        }
        else{
            endGame();
        }
    }
    
     /**
     *handleButtonAction6() method sets this button's index to be passed to be used by the update score method, it disables the button and then depending on which type ID the update score method resulted in 
     * and the current count of martians and jupiterans, it  could end initiate the end of the game, or updates the text displayed to the user, creates an alien object and uses the either martian or jupiteran draw method passing the graphic contexts as
     * parameters.
     * 
     */
    
    @FXML
    private void handleButtonAction6(ActionEvent event) {

        buttonIndex = 5;
        button6.setDisable(true);
        updateScore();
        System.out.println("You clicked");
        if (martiansFound == 6){
            endGame();
        }
        else if (typeID == 2 && martiansFound <6){
            Martian Martian1 = new Martian(2, "Mars", "Martian", 2);
            label.setText("You picked a " + typeName +". You live to pick again.");
              Martian1.draw(aMartianPic, aMartianPicDetails);
        }
        else if (jupiteransFound < 2){
            label.setText("You picked a " + typeName +". You live to pick again.");
            Jupiteran Jupiteran1 = new Jupiteran (1,"Jupiter","Jupiteran",3);
             Jupiteran1.draw(aJupiteranPic, aJupiteranPicDetails);

        }
        else{
            endGame();
        }
    }
    
     /**
     *handleButtonAction7() method sets this button's index to be passed to be used by the update score method, it disables the button and then depending on which type ID the update score method resulted in 
     * and the current count of martians and jupiterans, it  could end initiate the end of the game, or updates the text displayed to the user, creates an alien object and uses the either martian or jupiteran draw method passing the graphic contexts as
     * parameters.
     * 
     */
    @FXML
    private void handleButtonAction7(ActionEvent event) {

        buttonIndex = 6;
        button7.setDisable(true);
        updateScore();
        System.out.println("You clicked");
       if (martiansFound == 6){
            endGame();
        }
        else if (typeID == 2 && martiansFound <6){
            Martian Martian1 = new Martian(2, "Mars", "Martian", 2);
            label.setText("You picked a " + typeName +". You live to pick again.");
              Martian1.draw(aMartianPic, aMartianPicDetails);
        }
        else if (jupiteransFound < 2){
            label.setText("You picked a " + typeName +". You live to pick again.");
            Jupiteran Jupiteran1 = new Jupiteran (1,"Jupiter","Jupiteran",3);
             Jupiteran1.draw(aJupiteranPic, aJupiteranPicDetails);

        }
        else{
            endGame();
        }
    }
    
     /**
     *handleButtonAction8() method sets this button's index to be passed to be used by the update score method, it disables the button and then depending on which type ID the update score method resulted in 
     * and the current count of martians and jupiterans, it  could end initiate the end of the game, or updates the text displayed to the user, creates an alien object and uses the either martian or jupiteran draw method passing the graphic contexts as
     * parameters.
     * 
     */
    @FXML
    private void handleButtonAction8(ActionEvent event) {

        buttonIndex = 7;
        button8.setDisable(true);
        updateScore();
        System.out.println("You clicked");
        if (martiansFound == 6){
            endGame();
        }
        else if (typeID == 2 && martiansFound <6){
            Martian Martian1 = new Martian(2, "Mars", "Martian", 2);
            label.setText("You picked a " + typeName +". You live to pick again.");
             Martian1.draw(aMartianPic, aMartianPicDetails);
             
        }
        else if (jupiteransFound < 2){
            label.setText("You picked a " + typeName +". You live to pick again.");
            Jupiteran Jupiteran1 = new Jupiteran (1,"Jupiter","Jupiteran",3);
             Jupiteran1.draw(aJupiteranPic, aJupiteranPicDetails);

        }
        else{
            endGame();
        }
    }
    
  
    
    /**
     * earthAnimation() method first quickly fades the earth back in once by passing the earth image to a newly create FadeTransition object so it can be used at the beginning 
     * of the game even if a user has ended the world. It then creates a translate transition object which also receives the earth image and starts with the image off the screen 
     * to move across the topPane anchorPane and indefinite number of times and then plays. 
     */
    public void earthAnimation(){
        FadeTransition ft = new FadeTransition(Duration.millis(10), earth);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
        
        TranslateTransition tt = new TranslateTransition(Duration.seconds(3),earth);
        tt.setFromX(-(earth.getFitWidth()));
        tt.setToX(topPane.getPrefWidth());
        tt.setCycleCount(Timeline.INDEFINITE);
        tt.play();
    }

    /**
     * earthDestroyed() method fades the earth one as the world ends by passing the earth image to a newly create FadeTransition object. 
     */
    public void earthDestroyed(){
        FadeTransition ft = new FadeTransition(Duration.seconds(5), earth);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
        
    }
   

    /**
     *clearGraphics() method uses the graphic context's clearRect method to clear each of the canvases and fades out each of the smoke graphics. It is one of the steps to reset when 
     * a user plays a new game.
     */
    public void clearGraphics(){
       aMartianPic.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
       aJupiteranPic.clearRect(0, 0, canvas2.getWidth(), canvas2.getHeight());
       endGamePic.clearRect(0, 0, canvas3.getWidth(), canvas3.getHeight());
       
        FadeTransition ftRing = new FadeTransition(Duration.millis(10),smokeRing );
        ftRing .setFromValue(1.0);
        ftRing .setToValue(0.0);
        ftRing .setCycleCount(1);
        ftRing .setAutoReverse(false);
        ftRing .play();
        
        FadeTransition ftScreen = new FadeTransition(Duration.millis(10), smokeScreen);
        ftScreen.setFromValue(1.0);
        ftScreen.setToValue(0.0);
        ftScreen.setCycleCount(1);
        ftScreen.setAutoReverse(false);
        ftScreen.play();
        
        FadeTransition ft = new FadeTransition(Duration.millis(10), fogOverlay);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
        
        FadeTransition ftWall = new FadeTransition(Duration.millis(10), smokeWall);
        ftWall.setFromValue(1.0);
        ftWall.setToValue(0.0);
        ftWall.setCycleCount(1);
        ftWall.setAutoReverse(false);
        ftWall.play();
    }
  
    /**
     *endGame() disables all of the buttons and re-enables the play button so the user must start a new game to make more button choices. If the user has won, it gives them their score and 
     * if their score is higher than the existing highScore the highScore is updated and they are notified they made a new highscore or just what their score was. If they lost it lets them know, 
     * creates a new Jupiteran so there are two Jupiterans on the screen and passes the graphic contexts for the second jupiteran to the Jupiteran's drawEnd method. The score results are passed to the Write score
     * method, the earthDestroyed and endGameGraphics methods are called. 
     */
    public void endGame(){
      
        play.setDisable(false);
        button.setDisable(true);
        button2.setDisable(true);
        button2.setDisable(true);
        button3.setDisable(true);
        button4.setDisable(true);
        button5.setDisable(true);
        button6.setDisable(true);
        button7.setDisable(true);
        button8.setDisable(true);
  
        if (martiansFound == 6){
              label.setText("You won, unlikely scenario. Good on ya I guess");
              scoreResult = 10;
              writeScore(scoreResult);
              if (scoreResult > highScore){
                  highScore = scoreResult;
                  score.setText("New High Score \n" + highScore);
              }
              else 
              {
                  score.setText("Your score \n" + scoreResult);
              }
        }
        else{
              label.setText("That's it. The world is ending.");
              Jupiteran Jupiteran1 = new Jupiteran (1,"Jupiter","Jupiteran",3);
              Jupiteran1.drawEnd(endGamePic, endGamePicDetails);
              scoreResult = 0 + martiansFound;
              writeScore(scoreResult);
              earthDestroyed();
              endGameGraphics();
             
                                
     
              if (scoreResult > highScore){
                  highScore = scoreResult;
                  score.setText("New High Score \n" + highScore);
              }
              else 
              {
                  score.setText("Your score \n" + scoreResult);
              }

                         
        }
       
        
    }
    
    /**
     *endGameGraphics creates a new RotateTransition object and passes the canvas holding the 2nd jupiteran added at the end of the game. The Jupiteran is rotated 160 degrees 4 times 
     * and the Graphic is played. Then 4 FadeTransition objects are created and four different images are passed fade in the images of smoke to give the 
     * impression the Jupiteran movement smoked out the screen. 
     */
    public void endGameGraphics(){
         RotateTransition rotate = new RotateTransition(Duration.millis(1000), canvas3);
         rotate.setByAngle(360f);
         rotate.setCycleCount(4);
         rotate.setAutoReverse(true);
         rotate.play();
         
        FadeTransition ftRing = new FadeTransition(Duration.millis(2000),smokeRing );
        ftRing.setFromValue(0);
        ftRing.setToValue(1);
        ftRing.setCycleCount(1);
        ftRing.setAutoReverse(false);
        ftRing.play();
        
        FadeTransition ftScreen = new FadeTransition(Duration.millis(2000), smokeScreen);
        ftScreen.setFromValue(0);
        ftScreen.setToValue(1);
        ftScreen.setCycleCount(1);
        ftScreen.setAutoReverse(false);
        ftScreen.play();
        
        FadeTransition ft = new FadeTransition(Duration.millis(2000), fogOverlay);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
        
        FadeTransition ftWall = new FadeTransition(Duration.seconds(2), smokeWall);
        ftWall.setFromValue(0);
        ftWall.setToValue(1);
        ftWall.setCycleCount(1);
        ftWall.setAutoReverse(false);
        ftWall.play();
        
        
    }

    /**
     * scoresExists() method declares a path and gets the value of the declared filepath for the scores file and then updates a boolean variable using the Files exist method and
     * and returns the boolean value. 
     * @return exists - true if the filepath already exists. 
     */
    public boolean scoresExists(){
        Path path = Paths.get(filePath);
        boolean exists = Files.exists(path);
        return exists;
    }

    /**
     *writeScore() method receives the scoreResult and then creates a new date and date format object then declares a string that is assigned the date using the datFormat's format method.
     * A results string variable is created to include all relevant score information. Then the scores file is passed to a new FileWriter object which is passed to a new BufferedWriter object. 
     * The results are passed to the buffered writer's write method followed by the newline method to define a line separator and the buffered writer is closed. The catch clause prints IOException objects. 
     * @param scoreResult //passed from endGame method depending on the number of martiansfound.
     */
    public void writeScore(int scoreResult){
        
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
        String strDate = dateFormat.format(date);
        String result = "You scored " + scoreResult + " points on " + strDate;
       
        try {
            if(!scoresExists()){
  
                System.out.print("Creating a new score file");
            }
              else{
                 System.out.print("Updating the existing score file");
                }
            
            FileWriter fw = new FileWriter(scores,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(result);
            bw.newLine();
            bw.close();
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
}
