/**
 * Name: Grace
 * Date: 2022-05-04
 * Description: StaffParentMainController class, staff main window frame
 *    contain the define media, define user, show holds media, and show checkout media
 */
 
package com.culminating.ui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.culminating.user.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class StaffParentMainController implements Initializable {
   private final Background YellowBackground = new Background(new BackgroundFill(Color.web("#FFFF00"), CornerRadii.EMPTY,   Insets.EMPTY));
   private final Background blueBackground = new Background(new BackgroundFill(Color.web("#42d1f5"), CornerRadii.EMPTY,   Insets.EMPTY));

   @FXML
   GridPane logoPane;
   
   @FXML
   BorderPane parentPane;

   @FXML
   private Label userName;

   private User currentUser;
   @FXML
   private VBox parentLeftVbox;

   @FXML
   private HBox topHbox;

   @FXML
   private ImageView logo;
   
   @FXML
   private ImageView mainPageImg;

   @FXML
   private Button btnUser;
   
   @FXML
   private Button btnMedia;
   
   @FXML
   private Button btnHold;
   
   @FXML
   private Button btnSwithUser;

   /**
    * Initializes the controller class. This method is automatically called
    * after the fxml file has been loaded.
    */
   @Override
   public void initialize(URL location, ResourceBundle resources) {
   	parentLeftVbox.setBackground(YellowBackground);
   	logoPane.setBackground(blueBackground);
   }

   /**
    * set the current user to login user and load the backgroud image.
    * @param user, the current login user.
    */
   public void initData(User user) {
   	this.currentUser = user;
   	userName.setText("Welcome " + user.getName());
   	FileInputStream input;
   	try {
   	   input = new FileInputStream("com//culminating//ui//schoolbanner.jpg");
   	   Image image = new Image(input);
   	   logo.setImage(image);
   	   logo.fitWidthProperty().bind(logoPane.widthProperty());
   	   logo.setPreserveRatio(false);
   	   
   	   FileInputStream input2 = new FileInputStream("com//culminating//ui//mainpage.jpg");
   	   Image image2 = new Image(input2);
   	   mainPageImg.setImage(image2);
   	   mainPageImg.setPreserveRatio(true);
   	   parentPane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
   	} catch (FileNotFoundException e) {
   	   e.printStackTrace();
   	}
   }

   /**
    * show all users action.
    * @param event, the ActionEvent.
    */
   @FXML
   private void showUsers(ActionEvent event) {
   	FXMLLoader loader = new FXMLLoader();
   	loader.setLocation(getClass().getResource("StaffDefineUser.fxml"));
   	try {
   	   Pane myPane = loader.load();
   	   parentPane.setCenter(myPane);
   	} catch (IOException e) {
   	   e.printStackTrace();
   	}
   }
   
   /**
    * swith user action, ask user relogin.
    * @param event, the ActionEvent.
    */
   @FXML
   private void swithUser(ActionEvent event) {
   	try {
         FXMLLoader loader = new FXMLLoader();
         loader.setLocation(getClass().getResource("Login.fxml"));
   	   Pane myPane = loader.load();
   	   parentPane.setCenter(myPane);
   	} catch (IOException e) {
   	   e.printStackTrace();
   	}
   }
   
   /**
    * show all medias action.
    * @param event, the ActionEvent.
    */
   @FXML
   private void showMedias(ActionEvent event) {
   	FXMLLoader loader = new FXMLLoader();
   	loader.setLocation(getClass().getResource("StaffDefineMedia.fxml"));
   	try {
   	   Pane myPane = loader.load();
   	   parentPane.setCenter(myPane);
   	} catch (IOException e) {
   	   e.printStackTrace();
   	}
   }
   
   /**
    * show all hold medias action.
    * @param event, the ActionEvent.
    */
   @FXML
   private void showHolds(ActionEvent event) {
   	FXMLLoader loader = new FXMLLoader();
   	loader.setLocation(getClass().getResource("StaffHoldMedia.fxml"));
   	try {
   	   Pane myPane = loader.load();
   	   StaffHoldMediaController mainWindowController = loader.getController();
   	   mainWindowController.initData(currentUser);
   	   parentPane.setCenter(myPane);
   	} catch (IOException e) {
   	   e.printStackTrace();
   	}
   }
   
   /**
    * show all checkout medias action.
    * @param event, the ActionEvent.
    */
   @FXML
   private void showCheckouts(ActionEvent event) {
   	FXMLLoader loader = new FXMLLoader();
   	loader.setLocation(getClass().getResource("StaffCheckOutsMedia.fxml"));
   	try {
   	   Pane myPane = loader.load();
   	   StaffCheckOutsMediaController mainWindowController = loader.getController();
   	   mainWindowController.initData(currentUser);
   	   parentPane.setCenter(myPane);
   	} catch (IOException e) {
   	   e.printStackTrace();
   	}
   }
}
