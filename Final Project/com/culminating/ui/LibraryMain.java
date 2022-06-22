/**
 * Name: Grace Sui
 * Date: 2022-05-04
 * Description: LibraryMain class, show the login dialog.
 */

package com.culminating.ui;

import javafx.application.Application;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import com.culminating.utils.Handler;


public class LibraryMain extends Application {

   @Override
   public void start(Stage primaryStage) {
   	try {
   	   GridPane root = (GridPane)FXMLLoader.load(getClass().getResource("Login.fxml")); //get login dialog
   	   Scene scene = new Scene(root,400,275);
   	   primaryStage.setTitle("Library System");
   	   primaryStage.setScene(scene);
   	   //make the window on screen center.
   	   Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
   	   primaryStage.setX((screenBounds.getWidth() - primaryStage.getWidth()) / 2);
   	   primaryStage.setY((screenBounds.getHeight() - primaryStage.getHeight()) / 2);
   	   primaryStage.show();  //show login dialog
   	} catch(Exception e) {
   	   e.printStackTrace();
   	}
   }
   
   
   /**
    * Description: Save users, medias, checkouts and holds records to file when quit the system.
    */
   @Override
   public void stop(){
   	Handler.sharedInstance().saveUsersTofile();
   	Handler.sharedInstance().saveMediasTofile();
   	Handler.sharedInstance().saveHoldMediaTofile();
   	Handler.sharedInstance().saveCheckoutsMediaTofile();
   }
   
   public static void main(String[] args) {
   	launch(args);
   }
}
