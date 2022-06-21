/**
 * Name: Grace
 * Date: 2022-05-04
 * Description: UserBorrowMediaController class, user use this class to checkout media
 */
package com.culminating.ui;

import java.time.LocalDate;
import java.util.ArrayList;
import com.culminating.media.Media;
import com.culminating.user.User;
import com.culminating.utils.Handler;
import com.culminating.utils.ItemStatus;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class UserBorrowMediaController {

	/**
	 * Current login user
	 */
	private User currentUser;

	@FXML
	private ImageView bookImage;

	@FXML
	private Button bthCheckOut;

	@FXML
	private Button bthHold;

	@FXML
	private TextField filterField;

	@FXML
	private TextField publisherField;

	@FXML
	private Label descriptionField;
	@FXML
	private TextField languageField;
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
	 * set currentUser to login user.
	 * @param user, the current login user.
	 */
	public void initData(User user) {
		this.currentUser = user;
	}

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
		// filteredData.
		// 2. Set the filter Predicate whenever the filter changes.
		filterField.textProperty().addListener(
			(observable, oldValue, newValue) -> {
				filteredData.setPredicate(media -> {
					// If filter text is empty, display all medias.
					if (newValue == null || newValue.isEmpty()) {
						return true;
					}

					// Compare name of every media with filter text.
					String lowerCaseFilter = newValue.toLowerCase();
					if (media.getName().toLowerCase().contains(lowerCaseFilter)) {
						return true; // Filter matches name.
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

		// Obtain TableView SelectionModel Instance
		TableViewSelectionModel selectionModel = mediaTable.getSelectionModel();

		// set selection mode to only 1 row
		selectionModel.setSelectionMode(SelectionMode.SINGLE);

		// Get Selected Rows
		selectedItems = selectionModel.getSelectedItems();

		// Listening for Selection Changes
		selectedItems.addListener(new ListChangeListener<Media>() {
			@Override
			public void onChanged(Change<? extends Media> change) {
				showMediaDetails();
			}
		});
	}

	/**
	 * Show media detail information when user click the mmedia on the table  
	 */
	private void showMediaDetails() {
		if (selectedItems != null && selectedItems.get(0) != null) {
			Image image = new Image(selectedItems.get(0).getImagePath());
			bookImage.setImage(image);
			bookImage.setPreserveRatio(false);

			publisherField.setText(selectedItems.get(0).getPublisher());
			publisherField.setEditable(false);
			descriptionField.setText(selectedItems.get(0).getDescription());
			descriptionField.setWrapText(true);
			languageField.setText(selectedItems.get(0).getLanguage());
			languageField.setEditable(false);
			if (selectedItems.get(0).getCheckOutNumber() < selectedItems.get(0).getTotalNumber()) {
				bthCheckOut.setDisable(false);
				bthHold.setDisable(true);
			} else {
				bthCheckOut.setDisable(true);
				bthHold.setDisable(false);
			}
		}
	}

	/**
	 * hold media action.
	 * @param event, the ActionEvent.
	 */
	@FXML
	private void holdMedia(ActionEvent event) {
		if (selectedItems != null && selectedItems.get(0) != null) {
			if (!Handler.sharedInstance().addHold(selectedItems.get(0),	currentUser)) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Hold media error");
				// Header Text: null
				alert.setHeaderText(null);
				alert.setContentText("You already have this media on hold!");
				alert.showAndWait();
			} else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Hold Media");
				// Header Text: null
				alert.setHeaderText(null);
				alert.setContentText("Media is successfully placed on hold!");
				alert.showAndWait();
			}
		}
	}
   
	/**
	 * checkout media action.
	 * @param event, the ActionEvent.
	 */
	@FXML
	private void checkout(ActionEvent event) {
		if (selectedItems != null && selectedItems.get(0) != null) {
			ArrayList<ItemStatus> allCheckouts = Handler.sharedInstance().getCurrentCheckOuts();
			ArrayList<ItemStatus> currentUserCheckouts = new ArrayList<ItemStatus>();
			for (int index = 0; index < allCheckouts.size(); index++) {
				if (allCheckouts.get(index).getUserName().equals(currentUser.getName())) {
					currentUserCheckouts.add(allCheckouts.get(index));
				}
			}

			int totalHold = Handler.sharedInstance().searchTotalHoldOnMedia(selectedItems.get(0));
			if ((selectedItems.get(0).getCheckOutNumber() + totalHold) >= selectedItems.get(0).getTotalNumber()) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Checkout error");
				// Header Text: null
				alert.setHeaderText(null);
				alert.setContentText("Another user is holding this media, you cannot check it out");
				alert.showAndWait();
			} else if (currentUserCheckouts.size() + 1 > Handler.maxCheckoutBooks) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Checkout error");
				// Header Text: null
				alert.setHeaderText(null);
				alert.setContentText("You can only checkout " + Handler.maxCheckoutBooks + " medias in total.");
				alert.showAndWait();
			} else {
				if (Handler.sharedInstance().checkOut(currentUser,selectedItems.get(0))) {
					selectedItems.get(0).setCheckOutNumber(selectedItems.get(0).getCheckOutNumber() + 1);
					if (selectedItems.get(0).getCheckOutNumber() < selectedItems.get(0).getTotalNumber()) {
						bthCheckOut.setDisable(false);
					} else {
						bthCheckOut.setDisable(true);
					}

				} else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Checkout error");
					// Header Text: null
					alert.setHeaderText(null);
					alert.setContentText("Already checkout!");
					alert.showAndWait();
				}
				mediaTable.refresh();
			}

		}
	}
}
