/*
 * W20- Java Intermediate
 * Final Assignment
 * and open the template in the editor.
 */
package alienhunt;


import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


/**
 * AlienHunt Class = An application that extends the application class which declares a BorderPane and primary stage, 
 * initializes Rootlayout and passes the primary stage to the start method. 
 * @author kerry
 * 
 * @author Kerry Nelson Milovic
 * @version 1.0
 * @since 2020-04-21
 */

public class alienHunt extends Application {

   
    public BorderPane rootLayout; // the root
    public Stage primaryStage; // the stage
     /**
      *start(Stage primaryStage) assigns the alienHunt primary stage as the primaryStage, sets the title
      * and calls the RootLayout() method when the application launches. 
     * @throws java.io.IOException
     * 
     */
    

    @Override
    public void start(Stage primaryStage) throws IOException {
       
        
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Alien Hunt");
        RootLayout();
        
    }
    

    /**
     * RootLayout() loads an FXML file and casts it as a BorderPane and assigns it to the BorderPane root layout.
     * It creates a scene and passes the rootLayout to the newly created scene and then shows it. 
     * @throws IOException
     */
    public void RootLayout() throws IOException{
        try{
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(alienHunt.class.getResource("FXMLDocument.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch (IOException e) {
            System.out.print(e);
        }
            
            
        }
    
    /**
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    }
     
        
    
   
    

