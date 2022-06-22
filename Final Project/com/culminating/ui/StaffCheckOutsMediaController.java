/**
 * Name: Grace Sui
 * Date: 2022-05-04
 * Description: StaffCheckOutsMediaController class, The staff checkout media controller.
 */
package com.culminating.ui;

import java.util.ArrayList;
import java.util.Date;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class StaffCheckOutsMediaController {
	/**
	 * Current login user
	 */
	private User currentUser;

	@FXML
	private ImageView bookImage;

	@FXML
	private Button bthCheckIn;

	@FXML
	private Button btnRenew;

	@FXML
	private TextField filterField;

	@FXML
	private TextField publisherField;

	@FXML
	private Label descriptionField;

	@FXML
	private TextField languageField;

	@FXML
	private TableView<ItemStatus> mediaTable;

	@FXML
	private TableColumn<ItemStatus, String> nameColumn;

	@FXML
	private TableColumn<ItemStatus, Integer> renewColumn;

	@FXML
	private TableColumn<ItemStatus, String> authorColumn;

	@FXML
	private TableColumn<ItemStatus, String> typeColumn;

	@FXML
	private TableColumn<ItemStatus, Date> borrowDateColumn;

	@FXML
	private TableColumn<ItemStatus, Date> checkOutByColumn;

	/**
	 * All checkout medias by all users.
	 */
	private ObservableList<ItemStatus> checkoutMedias;

	/**
	 * The selected media when user click on the table.
	 */
	private ObservableList<ItemStatus> selectedItems;

	/**
	 * The medias in sorted.
	 */
	private SortedList<ItemStatus> sortedData;

	/**
	 * The filter medias by user search.
	 */
	private FilteredList<ItemStatus> filteredData;

	/**
	 * initial the media table data.
	 * Initializes the table columns and sets up sorting and filtering.
	 * @param user, the current login user.
	 */
	public void initData(User user) {
		this.currentUser = user;
		ArrayList<ItemStatus> allCheckouts = Handler.sharedInstance().getCurrentCheckOuts();
		checkoutMedias = FXCollections.observableArrayList(allCheckouts);
      
		// 0. Initialize the columns.
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("mediaName"));
		authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
		typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
		borrowDateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
		renewColumn.setCellValueFactory(new PropertyValueFactory<>("renewTimes"));
		checkOutByColumn.setCellValueFactory(new PropertyValueFactory<>("userName"));
		
		// 1. Wrap the ObservableList in a FilteredList (initially display all data).
		filteredData = new FilteredList<>(checkoutMedias, p -> true);
		// filteredData.
		// 2. Set the filter Predicate whenever the filter changes.
		filterField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(person -> {
				// If filter text is empty, display all medias.
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				// Compare media name of every media with filter text.
				String lowerCaseFilter = newValue.toLowerCase();

				if (person.getMediaName().toLowerCase().contains(lowerCaseFilter)) {
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
		selectedItems.addListener(new ListChangeListener<ItemStatus>() {
			@Override
			public void onChanged(Change<? extends ItemStatus> change) {
				showMediaDetails();
			}
		});
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded. 
	 */
	@FXML
	private void initialize() {

	}

        /**
	 * Show media detail information when user click the mmedia on the table  
	 */
	private void showMediaDetails() {
		if (selectedItems != null && selectedItems.get(0) != null) {
			Image image = new Image(selectedItems.get(0).getItem().getImagePath());
			bookImage.setImage(image);
			bookImage.setPreserveRatio(false);

			publisherField.setText(selectedItems.get(0).getItem().getPublisher());
			publisherField.setEditable(false);
			descriptionField.setText(selectedItems.get(0).getItem().getDescription());
			descriptionField.setWrapText(true);
			languageField.setText(selectedItems.get(0).getItem().getLanguage());
			languageField.setEditable(false);
		}
	}
   
	/**
	 * renew media action.
	 * @param event, the action event.
	 */
	@FXML
	protected void renewMedia(ActionEvent event) {
		if (selectedItems != null && selectedItems.get(0) != null) {
			currentUser = selectedItems.get(0).getUser();
			Handler.sharedInstance().renew(currentUser,selectedItems.get(0).getItem());
			mediaTable.refresh();
		}
	}
   
	/**
	 * Checkin media action.
	 * @param event, the action event.
	 */
	@FXML
	protected void checkIn(ActionEvent event) {
		if (selectedItems != null && selectedItems.get(0) != null) {
			currentUser = selectedItems.get(0).getUser();
			Handler.sharedInstance().checkIn(currentUser, selectedItems.get(0).getItem());
			// The index of the sorted and filtered list.
			int visibleIndex = mediaTable.getSelectionModel().getSelectedIndex();

			// Source index of checkoutMedias.
			int sourceIndex = sortedData.getSourceIndexFor(checkoutMedias, visibleIndex);

			// Remove.
			checkoutMedias.remove(sourceIndex);
			mediaTable.refresh();
		}		
	}
}
