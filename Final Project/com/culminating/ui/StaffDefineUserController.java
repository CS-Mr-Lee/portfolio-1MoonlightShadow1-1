/**
 * Name: Grace
 * Date: 2022-05-04
 * Description: StaffDefineUserController class, staff add/update/delete user.
 */

package com.culminating.ui;

import java.time.LocalDate;

import com.culminating.user.Borrower;
import com.culminating.user.Librarian;
import com.culminating.user.User;
import com.culminating.utils.Handler;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
   
public class StaffDefineUserController {
   
   @FXML
   private Button addUserBtn;
   
   @FXML
   private Button deleteUserBtn;
   
   @FXML
   private Button doneUserBtn;
   
   @FXML
   private TextField filterField;
   
   @FXML
   private TextField nameField;
   
   @FXML
   private PasswordField passwordField;
   
   @FXML
   private ComboBox genderField;
   
   @FXML
   private TextField addressField;
   
   @FXML
   private ComboBox typeField;
   
   @FXML
   private DatePicker birthday;
   
   @FXML
   private TableView<User> userTable;
   @FXML
   private TableColumn<User, String> nameColumn;
   @FXML
   private TableColumn<User, String> genderColumn;
   @FXML
   private TableColumn<User, LocalDate> birthDateColumn;
   @FXML
   private TableColumn<User, String> addressColumn;
   @FXML
   private TableColumn<User, String> typeColumn;
   @FXML
   private TableColumn<User, String> passwordColumn;

   /**
    * All users in system.
    */
   private ObservableList<User> users;

   /**
    * The selected user when click on the table.
    */
   private ObservableList<User> selectedItems;
   
   /**
    * The users in sorted.
    */
   private SortedList<User> sortedData;

   /**
    * The filter users by search.
    */
   private FilteredList<User> filteredData;

   /**
    * Initializes the controller class. This method is automatically called
    * after the fxml file has been loaded.
    * 
    * Initializes the table columns and sets up sorting and filtering.
    */
   @FXML
   private void initialize() {
   	users = FXCollections.observableArrayList(Handler.sharedInstance().getUsers());
   	// 0. Initialize the columns.
   	nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
   	
   	genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
   	
   	birthDateColumn.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
   	
   	addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
   	
   	typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
   	// 1. Wrap the ObservableList in a FilteredList (initially display all data).
   	filteredData = new FilteredList<>(users, p -> true);
   	//filteredData.
   	// 2. Set the filter Predicate whenever the filter changes.
   	filterField.textProperty().addListener(
   	   (observable, oldValue, newValue) -> {
   	   	filteredData.setPredicate(person -> {
   	   	   // If filter text is empty, display all persons.
   	   	   if (newValue == null || newValue.isEmpty()) {
   	   	   	return true;
   	   	   }
   	   	   // Compare name of every person with filter text.
   	   	   String lowerCaseFilter = newValue.toLowerCase();

   	   	   if (person.getName().toLowerCase().contains(lowerCaseFilter)) {
   	   	   	return true; // Filter matches first name.
   	   	   }
   	   	   return false; // Does not match.
   	   });
   	});

   	// 3. Wrap the FilteredList in a SortedList.
   	sortedData = new SortedList<>(filteredData);

   	// 4. Bind the SortedList comparator to the TableView comparator.
   	sortedData.comparatorProperty().bind(userTable.comparatorProperty());

   	// 5. Add sorted (and filtered) data to the table.
   	userTable.setItems(sortedData);

   	//Obtain TableView SelectionModel Instance
   	TableViewSelectionModel selectionModel = userTable.getSelectionModel();

   	// set selection mode to only 1 row
   	selectionModel.setSelectionMode(SelectionMode.SINGLE);

   	//Get Selected Rows
   	selectedItems = selectionModel.getSelectedItems();

   	//Listening for Selection Changes
   	selectedItems.addListener(new ListChangeListener<User>() {
   	   @Override
   	   public void onChanged(Change<? extends User> change) {
   	   	showUserDetails();
   	   }
   	});
   	genderField.getItems().add("Male");
   	genderField.getItems().add("Female");
   	genderField.getItems().add("Other");
   	typeField.getItems().add("Borrower");
   	typeField.getItems().add("Librarian");
   	typeField.setValue("Borrower");
   	genderField.setValue("Male");
   }
   
   /**
    * show user detail information.
    */
   private void showUserDetails() {
   	if(selectedItems != null && selectedItems.get(0) != null) {
   	   nameField.setText(selectedItems.get(0).getName());
   	   passwordField.setText(selectedItems.get(0).getPassword());
   	   genderField.setValue(selectedItems.get(0).getGender());
   	   addressField.setText(selectedItems.get(0).getAddress());
   	   typeField.setValue(selectedItems.get(0).getType());
   	   birthday.setValue(selectedItems.get(0).getBirthDate());
   	}   	
   }
   
   /**
    * update user action.
    * @param event, the action event.
    */
   @FXML
   private void updateUser(ActionEvent event) {
   	if(nameField.getText() != null && !nameField.getText().isEmpty()
   	   	&& passwordField.getText() != null && !passwordField.getText().isEmpty()
   	   	&& genderField.getValue() != null
   	   	&& addressField.getText() != null && !addressField.getText().isEmpty()
   	   	&& birthday.getValue() != null ) {
   	   Handler.sharedInstance().updateUser(selectedItems.get(0));
   	   nameField.setText(selectedItems.get(0).getName());
   	   selectedItems.get(0).setGender((String)genderField.getValue());
   	   selectedItems.get(0).setType((String) typeField.getValue());
   	   selectedItems.get(0).setAddress(addressField.getText());
   	   selectedItems.get(0).setPassword(passwordField.getText());
   	   selectedItems.get(0).setBirthDate(birthday.getValue());
   	   userTable.refresh();
   	}
   }
   
   /**
    * delete user action.
    * @param event, the action event.
    */
   @FXML
   protected void deleteUser(ActionEvent event) {
   	if (selectedItems != null && selectedItems.get(0) != null) {
   	   boolean existHoldOrCheckoutItem = false;
   	   for (int i = 0; i< Handler.sharedInstance().getCurrHolds().size(); i++) {
   	   	if (Handler.sharedInstance().getCurrHolds().get(i).getUserName().equals(selectedItems.get(0).getName())) {
   	   	   existHoldOrCheckoutItem = true;
   	   	   break;
   	   	}
   	   }
   	   if (!existHoldOrCheckoutItem) {
   	   	for (int i = 0; i< Handler.sharedInstance().getCurrentCheckOuts().size(); i++) {
   	   	   if (Handler.sharedInstance().getCurrentCheckOuts().get(i).getUserName().equals(selectedItems.get(0).getName())) {
   	   	   	existHoldOrCheckoutItem = true;
   	   	   	break;
   	   	   }
   	   	}
   	   	if (!existHoldOrCheckoutItem) { 
   	   	   // The index of the sorted and filtered list.
   	   	   int visibleIndex = userTable.getSelectionModel().getSelectedIndex();

   	   	   // Source index of users.
   	   	   int sourceIndex = sortedData.getSourceIndexFor(users, visibleIndex);

   	   	   Handler.sharedInstance().removeUser(selectedItems.get(0));
   	   	   
   	   	   // Remove.
   	   	   users.remove(sourceIndex);
   	   	} else {
   	   	   Alert alert = new Alert(AlertType.ERROR);
   	   	   alert.setTitle("Delete user error");
   	   	   // Header Text: null
   	   	   alert.setHeaderText(null);
   	   	   alert.setContentText("User has checkout media, cannot remove right now!");
   	   	   alert.showAndWait();
   	   	}
   	   } else {
   	   	Alert alert = new Alert(AlertType.ERROR);
   	   	alert.setTitle("Delete user error");
   	   	// Header Text: null
   	   	alert.setHeaderText(null);
   	   	alert.setContentText("User has hold media, cannot remove right now!");
   	   	alert.showAndWait();
   	   }
   	   
   	}
   }   
   
   /**
    * add user action.
    * @param event, the action event.
    */
   @FXML
   private void addUser(ActionEvent event) {
   	if(nameField.getText() != null && !nameField.getText().isEmpty()
   	   	&& passwordField.getText() != null && !passwordField.getText().isEmpty()
   	   	&& genderField.getValue() != null 
   	   	&& addressField.getText() != null && !addressField.getText().isEmpty()
   	   	&& birthday.getValue() != null ) {
   	   if (typeField.getValue().equals("Borrower")) {
   	   	User user = new Borrower(nameField.getText(), addressField.getText(), 
   	   	   	(String)genderField.getValue(), birthday.getValue(), null, passwordField.getText());
   	   	
   	   	if (Handler.sharedInstance().addUser(user)) {
   	   	   users.add(user);
   	   	} else {
   	   	   Alert alert = new Alert(AlertType.ERROR);
   	   	   alert.setTitle("Add user error");
   	   	   // Header Text: null
   	   	   alert.setHeaderText(null);
   	   	   alert.setContentText("Username Already exist!");
   	   	   alert.showAndWait();
   	   	}
   	   	
   	   } else {
   	   	User user = new Librarian(nameField.getText(), addressField.getText(), 
   	   	   	(String)genderField.getValue(), birthday.getValue(), null, passwordField.getText());
   	   	users.add(user);
   	   	if (Handler.sharedInstance().addUser(user)) {
   	   	   users.add(user);
   	   	} else {
   	   	   Alert alert = new Alert(AlertType.ERROR);
   	   	   alert.setTitle("Add user error");
   	   	   // Header Text: null
   	   	   alert.setHeaderText(null);
   	   	   alert.setContentText("Username Already exist!");
   	   	   alert.showAndWait();
   	   	}
   	   }
   	}
   }
}
