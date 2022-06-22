/**
 * Name: Grace
 * Date: 2022-05-04
 * Description: StaffDefineMediaController class, staff add/update/delete media.
 */
 
package com.culminating.ui;

import java.time.LocalDate;

import com.culminating.media.Book;
import com.culminating.media.DVD;
import com.culminating.media.EBook;
import com.culminating.media.Media;
import com.culminating.media.VideoGames;
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
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class StaffDefineMediaController {

   
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
   private TextField amountField;
   
   @FXML
   private TextField sinField;
   
   @FXML
   private TextArea descriptionField;
   
   @FXML
   private TextField publisherField;
   
   @FXML
   private TextField languageField;
   
   @FXML
   private TextField authorField;
   
   @FXML
   private TextField imageField;
   
   @FXML
   private ComboBox typeField;
   
   @FXML
   private DatePicker publishDateField;
   
   @FXML
   private TableView<Media> mediaTable;
   @FXML
   private TableColumn<Media, String> nameColumn;
   @FXML
   private TableColumn<Media, Integer> totalColumn;
   @FXML
   private TableColumn<Media, Integer> checkOutColumn;
   @FXML
   private TableColumn<Media, String> authorColumn;
   @FXML
   private TableColumn<Media, String> typeColumn;
   @FXML
   private TableColumn<Media, LocalDate> publishDateColumn;
   
   /**
    * All medias in system.
    */
   private ObservableList<Media> medias;

   /**
    * The selected media when user click on the table.
    */
   private ObservableList<Media> selectedItems;

   /**
    * The medias in sorted.
    */
   private SortedList<Media> sortedData;
   
   /**
    * The filter medias by user search.
    */
   private FilteredList<Media> filteredData;

   /**
    * Initializes the controller class. This method is automatically called
    * after the fxml file has been loaded.
    * 
    * Initializes the table columns and sets up sorting and filtering.
    */
   @FXML
   private void initialize() {
        
   	medias = FXCollections.observableArrayList(Handler.sharedInstance().getMedias());
   	// 0. Initialize the columns.
   	nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
   	
   	totalColumn.setCellValueFactory(new PropertyValueFactory<>("totalNumber"));
   	
   	checkOutColumn.setCellValueFactory(new PropertyValueFactory<>("checkOutNumber"));
   	
   	authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
   	
   	typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
   	
   	publishDateColumn.setCellValueFactory(new PropertyValueFactory<>("publishDate"));
   	// 1. Wrap the ObservableList in a FilteredList (initially display all data).
   	filteredData = new FilteredList<>(medias, p -> true);
      
   	//filteredData.
   	// 2. Set the filter Predicate whenever the filter changes.
   	filterField.textProperty().addListener(
   	   (observable, oldValue, newValue) -> {
   	   	filteredData.setPredicate(media -> {
   	   	   // If filter text is empty, display all media.
   	   	   if (newValue == null || newValue.isEmpty()) {
   	   	   	return true;
   	   	   }

   	   	   // Compare media name of every media
   	   	   // with filter text.
   	   	   String lowerCaseFilter = newValue.toLowerCase();

   	   	   if (media.getName().toLowerCase().contains(lowerCaseFilter)) {
   	   	   	return true; // Filter matches first name.
   	   	   }
   	   	   return false; // Does not match.
   	   	   });
   	   	});

   	// 3. Wrap the FilteredList in a SortedList.
   	sortedData = new SortedList<>(filteredData);

   	// 4. Bind the SortedList comparator to the TableView comparator.
   	sortedData.comparatorProperty().bind(mediaTable.comparatorProperty());

   	// 5. Add sorted (and filtered) data to the table.
   	mediaTable.setItems(sortedData);

   	//Obtain TableView SelectionModel Instance
   	TableViewSelectionModel selectionModel = mediaTable.getSelectionModel();

   	// set selection mode to only 1 row
   	selectionModel.setSelectionMode(SelectionMode.SINGLE);

   	//Get Selected Rows
   	selectedItems = selectionModel.getSelectedItems();

   	//Listening for Selection Changes and show the detail information of the selected media
   	selectedItems.addListener(new ListChangeListener<Media>() {
   	   @Override
   	   public void onChanged(Change<? extends Media> change) {
   	   	showMediaDetails();
   	   }
   	});
   	typeField.getItems().add("Book");
   	typeField.getItems().add("DVD");
   	typeField.getItems().add("EBook");
   	typeField.getItems().add("VideoGames");
   	typeField.setValue("Book");
   }
   
   /**
    * Show media detail information when user click the mmedia on the table  
    */
   private void showMediaDetails() {
   	if(selectedItems != null && selectedItems.get(0) != null) {
   	   nameField.setText(selectedItems.get(0).getName());
   	   amountField.setText(String.valueOf(selectedItems.get(0).getTotalNumber()));
   	   sinField.setText(String.valueOf(selectedItems.get(0).getSIN()));
   	   descriptionField.setText(selectedItems.get(0).getDescription());
   	   typeField.setValue(selectedItems.get(0).getType());
   	   publishDateField.setValue(selectedItems.get(0).getPublishDate());
   	   languageField.setText(String.valueOf(selectedItems.get(0).getLanguage()));
   	   authorField.setText(selectedItems.get(0).getAuthor());
   	   publisherField.setText(selectedItems.get(0).getPublisher());
   	   imageField.setText(selectedItems.get(0).getImagePath());
   	}   	
   }
   
   /**
    * update media action.
    * @param event, the action event.
    */
   @FXML
   protected void updateMedia(ActionEvent event) {
   	if(nameField.getText() != null && !nameField.getText().isEmpty()
   	   && amountField.getText() != null && !amountField.getText().isEmpty()
   	   && publishDateField.getValue() != null 
   	   && sinField.getText() != null && !sinField.getText().isEmpty()
   	   && amountField.getText() != null && !amountField.getText().isEmpty()
   	   && publisherField.getText() != null && !publisherField.getText().isEmpty()
   	   && authorField.getText() != null && !authorField.getText().isEmpty()
   	   && languageField.getText() != null && !languageField.getText().isEmpty()) {
   	
   	   Handler.sharedInstance().updateMedia(selectedItems.get(0));
   	   int addQuantity = Integer.parseInt(amountField.getText()) - selectedItems.get(0).getTotalNumber();
   	   int diff = selectedItems.get(0).getTotalNumber() - selectedItems.get(0).getCheckOutNumber();
   	   selectedItems.get(0).setName(nameField.getText());
   	   selectedItems.get(0).setAuthor(authorField.getText());
   	   selectedItems.get(0).setTotalNumber(Integer.parseInt(amountField.getText()));
   	   selectedItems.get(0).setSIN(selectedItems.get(0).getSIN());
   	   selectedItems.get(0).setPublishDate(publishDateField.getValue());
   	   selectedItems.get(0).setLanguage(languageField.getText());
   	   selectedItems.get(0).setPublisher(publisherField.getText());
   	   selectedItems.get(0).setImagePath(imageField.getText());
   	   selectedItems.get(0).setDescription(descriptionField.getText());
   	   
   	   if (addQuantity > 0 && diff == 0) {
   	   	for (int i = 0; i < addQuantity; i++) {
   	   	   int index = Handler.sharedInstance().searchFirstHoldMediaItem(selectedItems.get(0));
   	   	   if(index > -1) {
   	   	   	Handler.sharedInstance().getCurrHolds().get(index).setStatus(true);
   	   	   }
   	   	}
   	   }
   	   
   	   mediaTable.refresh();
   	}
   }
   
   /**
    * delete media action.
    * @param event, the action event.
    */
   @FXML
   protected void deleteMedia(ActionEvent event) {
   	if (selectedItems != null && selectedItems.get(0) != null) {

   	   boolean existHoldOrCheckoutItem = false;
   	   for (int i = 0; i < Handler.sharedInstance().getCurrHolds().size(); i++) {
   	   	if (Handler.sharedInstance().getCurrHolds().get(i).getMediaSIN() == selectedItems.get(0).getSIN()
   	   	   	&& Handler.sharedInstance().getCurrHolds().get(i).getType().equals(selectedItems.get(0).getType())) {
   	   	   existHoldOrCheckoutItem = true;
   	   	   break;
   	   	}
   	   }
   	   if (!existHoldOrCheckoutItem) {
   	   	for (int i = 0; i < Handler.sharedInstance().getCurrentCheckOuts().size(); i++) {
   	   	   if (Handler.sharedInstance().getCurrentCheckOuts().get(i).getMediaSIN() == selectedItems.get(0).getSIN()
   	   	   	   && Handler.sharedInstance().getCurrentCheckOuts().get(i).getType().equals(selectedItems.get(0).getType())) {
   	   	   	existHoldOrCheckoutItem = true;
   	   	   	break;
   	   	   }
   	   	}
   	   	if (!existHoldOrCheckoutItem) {
   	   	   // The index of the sorted and filtered list.
   	   	   int visibleIndex = mediaTable.getSelectionModel().getSelectedIndex();

   	   	   // Source index of medias.
   	   	   int sourceIndex = sortedData.getSourceIndexFor(medias,visibleIndex);

   	   	   Handler.sharedInstance().removeMedia(selectedItems.get(0));

   	   	   // Remove.
   	   	   medias.remove(sourceIndex);
   	   	} else {
   	   	   Alert alert = new Alert(AlertType.ERROR);
   	   	   alert.setTitle("Delete media error");
   	   	   // Header Text: null
   	   	   alert.setHeaderText(null);
   	   	   alert.setContentText("Media is checkout by user, cannot remove right now!!");
   	   	   alert.showAndWait();
   	   	}
   	   }  else {
   	   	Alert alert = new Alert(AlertType.ERROR);
   	   	alert.setTitle("Delete media error");
   	   	// Header Text: null
   	   	alert.setHeaderText(null);
   	   	alert.setContentText("Media is on holding by user, cannot remove right now!");
   	   	alert.showAndWait();
   	   }

   	}   	   	
   }
   
   /**
    * add media action.
    * @param event, the action event.
    */
   @FXML
   protected void addMedia(ActionEvent event) {
   	if(nameField.getText() != null && !nameField.getText().isEmpty()
   	   	&& amountField.getText() != null && !amountField.getText().isEmpty()
   	   	&& publishDateField.getValue() != null 
   	   	&& sinField.getText() != null && !sinField.getText().isEmpty()
   	   	&& amountField.getText() != null && !amountField.getText().isEmpty()
   	   	&& publisherField.getText() != null && !publisherField.getText().isEmpty()
   	   	&& authorField.getText() != null && !authorField.getText().isEmpty()
   	   	&& languageField.getText() != null && !languageField.getText().isEmpty()) {
   	   if (typeField.getValue().equals("Book")) {
   	   	Book book = new Book();
   	   	book.setName(nameField.getText());
   	   	book.setAuthor(authorField.getText());
   	   	book.setTotalNumber(Integer.parseInt(amountField.getText()));
   	   	book.setSIN(Integer.parseInt(sinField.getText()));
   	   	book.setPublishDate(publishDateField.getValue());
   	   	book.setLanguage(languageField.getText());
   	   	book.setPublisher(publisherField.getText());
   	   	book.setImagePath(imageField.getText());
   	   	book.setDescription(descriptionField.getText());
   	   	
   	   	if (Handler.sharedInstance().addMedia(book)) {
   	   	   medias.add(book);
   	   	} else {
   	   	   Alert alert = new Alert(AlertType.ERROR);
   	   	   alert.setTitle("Add media error");
   	   	   // Header Text: null
   	   	   alert.setHeaderText(null);
   	   	   alert.setContentText("Media Already exist!");
   	   	   alert.showAndWait();
   	   	}
   	   } else if (typeField.getValue().equals("DVD")){
   	   	DVD dvd = new DVD();
   	   	dvd.setName(nameField.getText());
   	   	dvd.setAuthor(authorField.getText());
   	   	dvd.setTotalNumber(Integer.parseInt(amountField.getText()));
   	   	dvd.setSIN(Integer.parseInt(sinField.getText()));
   	   	dvd.setPublishDate(publishDateField.getValue());
   	   	dvd.setLanguage(languageField.getText());
   	   	dvd.setPublisher(publisherField.getText());
   	   	dvd.setImagePath(imageField.getText());
   	   	dvd.setDescription(descriptionField.getText());
   	   	if (Handler.sharedInstance().addMedia(dvd)) {
   	   	   medias.add(dvd);
   	   	} else {
   	   	   Alert alert = new Alert(AlertType.ERROR);
   	   	   alert.setTitle("Add media error");
   	   	   // Header Text: null
   	   	   alert.setHeaderText(null);
   	   	   alert.setContentText("Media Already exist!");
   	   	   alert.showAndWait();
   	   	}
   	   } else if (typeField.getValue().equals("VideoGames")){
   	   	VideoGames game = new VideoGames();
   	   	game.setName(nameField.getText());
   	   	game.setAuthor(authorField.getText());
   	   	game.setTotalNumber(Integer.parseInt(amountField.getText()));
   	   	game.setSIN(Integer.parseInt(sinField.getText()));
   	   	game.setPublishDate(publishDateField.getValue());
   	   	game.setLanguage(languageField.getText());
   	   	game.setPublisher(publisherField.getText());
   	   	game.setImagePath(imageField.getText());
   	   	game.setDescription(descriptionField.getText());
   	   	if (Handler.sharedInstance().addMedia(game)) {
   	   	   medias.add(game);
   	   	} else {
   	   	   Alert alert = new Alert(AlertType.ERROR);
   	   	   alert.setTitle("Add media error");
   	   	   // Header Text: null
   	   	   alert.setHeaderText(null);
   	   	   alert.setContentText("Media Already exist!");
   	   	   alert.showAndWait();
   	   	}
   	   } else if (typeField.getValue().equals("EBook")){
   	   	EBook book = new EBook();
   	   	book.setName(nameField.getText());
   	   	book.setAuthor(authorField.getText());
   	   	book.setTotalNumber(Integer.parseInt(amountField.getText()));
   	   	book.setSIN(Integer.parseInt(sinField.getText()));
   	   	book.setPublishDate(publishDateField.getValue());
   	   	book.setLanguage(languageField.getText());
   	   	book.setPublisher(publisherField.getText());
   	   	book.setImagePath(imageField.getText());
   	   	book.setDescription(descriptionField.getText());
   	   	if (Handler.sharedInstance().addMedia(book)) {
   	   	   medias.add(book);
   	   	} else {
   	   	   Alert alert = new Alert(AlertType.ERROR);
   	   	   alert.setTitle("Add media error");
   	   	   // Header Text: null
   	   	   alert.setHeaderText(null);
   	   	   alert.setContentText("Media Already exist!");
   	   	   alert.showAndWait();
   	   	}
   	   }
   	}
   }
}
