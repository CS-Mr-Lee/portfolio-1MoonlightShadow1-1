/**
 * Name: Grace
 * Date: 2022-05-04
 * Description: The ParentMainView class, decide to show staff UI or user UI according to user type.
 * Librarian: will show staff UI; Borrower will show borrower UI
 */
package com.culminating.ui;

import com.culminating.user.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ParentMainView extends Application {
   /**
    * Current login user
    */
   private User currentUser;

   @Override
   public void start(Stage primaryStage) throws Exception {
   	primaryStage.setTitle("Library System");
   	FXMLLoader loader = new FXMLLoader();
   	if (currentUser.getType().equals("Librarian")) {
   	   loader.setLocation(getClass().getResource("StaffParentMain.fxml")); //show staff UI
   	} else {
   	   loader.setLocation(getClass().getResource("UserParentMain.fxml")); //show borrower UI
   	}

   	Pane myPane = loader.load();

   	// access the controller and set currentUser to the login user
   	if (currentUser.getType().equals("Librarian")) {
   	   StaffParentMainController mainWindowController = loader.getController();
   	   mainWindowController.initData(currentUser);
   	} else {
   	   UserParentMainController mainWindowController = loader.getController();
   	   mainWindowController.initData(currentUser);
   	}

   	Scene myScene = new Scene(myPane);
   	myScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
   	primaryStage.setScene(myScene);
   }

   /**
    * get current login user.
    */
   public User getCurrentUser() {
   	return currentUser;
   }

   /**
    * set current login user
    * @param currentUser, the login user.
    */
   public void setCurrentUser(User currentUser) {
   	this.currentUser = currentUser;
   }
}
