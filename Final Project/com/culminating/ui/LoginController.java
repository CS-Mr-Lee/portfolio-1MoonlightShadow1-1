/**
 * Name: Grace
 * Date: 2022-05-04
 * Description: LoginController class, will check username and password correct or not.
 */
package com.culminating.ui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import com.culminating.user.*;
import com.culminating.utils.Handler;

public class LoginController implements Initializable{
	@FXML
	private TextField userTextField;
	@FXML
	private PasswordField passwordField;
	@FXML
	private Text actiontarget;
	@FXML
	private RadioButton optionStaff;
	@FXML
	private RadioButton optionUser;

	/**
	 * login action.
	 * @param event, the action event.
	 */
	@FXML
	protected void handleSubmitButtonAction(ActionEvent event) {  //login button action
		if (userTextField.getText() != null && !userTextField.getText().isEmpty()
			&& passwordField.getText() != null && !passwordField.getText().isEmpty()) {
			User user = new User();
			user.setName(userTextField.getText());
			user.setPassword(passwordField.getText());
			if (optionUser.isSelected()) {
				user.setType("Borrower");
			} else {
				user.setType("Librarian");
			}
			//check if the user exist in system or not.
			int index = Handler.sharedInstance().searchUser(user, false);
			if (index > -1) { // show ParentMainView if find the user in system
				user = Handler.sharedInstance().getUsers().get(index);
				ParentMainView myTable = new ParentMainView();
				myTable.setCurrentUser(user);
				try {
					myTable.start((Stage)userTextField.getScene().getWindow());
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else { // show error if user doesn't exist
				
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Login error");
				// Header Text: null
				alert.setHeaderText(null);
				alert.setContentText("Username or password is wrong!");
				alert.showAndWait();
			}
		}
	}
	
	/**
	 * cancel action.
	 * @param event, the action event.
	 */
	@FXML
	protected void handleCancelButtonAction(ActionEvent event) { //cance button action
		
		Platform.exit();
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//make the optionStaff and optionUser same group so that user only can choose one of the option.
		ToggleGroup group = new ToggleGroup();
		optionStaff.setToggleGroup(group);
		optionUser.setToggleGroup(group);
		optionUser.setSelected(true);
	}
}
