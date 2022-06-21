/**
 * Name: Grace
 * Date: 2022-05-04
 * Description: UserHoldMediaController class, user can see all the hold medias and checkout media in system.
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

public class UserHoldMediaController {

	/**
	 * Current login user
	 */
	private User currentUser;

	@FXML
	private ImageView bookImage;

	@FXML
	private Button bthCheckOut;

	@FXML
	private Button btnRemove;

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
	private TableColumn<ItemStatus, Boolean> statusColumn;
	@FXML
	private TableColumn<ItemStatus, String> authorColumn;
	@FXML
	private TableColumn<ItemStatus, String> typeColumn;
	@FXML
	private TableColumn<ItemStatus, Date> holdDateColumn;

	/**
	 * All hold medias by current users.
	 */
	private ObservableList<ItemStatus> holdMedias;

	/**
	 * The selected media when user click on the table.
	 */
	private ObservableList<ItemStatus> selectedItems;

	/**
	 * The hold media in sorted.
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
		ArrayList<ItemStatus> allHolds = Handler.sharedInstance().getCurrHolds();
		ArrayList<ItemStatus> currentUserHolds = new ArrayList<ItemStatus>();
		for (int index = 0; index < allHolds.size(); index++) {
			if (allHolds.get(index).getUserName().equals(currentUser.getName())) {
				currentUserHolds.add(allHolds.get(index));
			}
		}
		holdMedias = FXCollections.observableArrayList(currentUserHolds);
		// 0. Initialize the columns.
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("mediaName"));

		authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));

		typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));

		holdDateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
		statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
		// 1. Wrap the ObservableList in a FilteredList (initially display all data).
		filteredData = new FilteredList<>(holdMedias, p -> true);
		// filteredData.
		// 2. Set the filter Predicate whenever the filter changes.
		filterField.textProperty().addListener(
			(observable, oldValue, newValue) -> {
				filteredData.setPredicate(media -> {
					// If filter text is empty, display all media.
					if (newValue == null || newValue.isEmpty()) {
						return true;
					}

					// Compare name of every media with filter text.
					String lowerCaseFilter = newValue.toLowerCase();
					if (media.getMediaName().toLowerCase().contains(lowerCaseFilter)) {
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
		bthCheckOut.setDisable(true);
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
			bthCheckOut.setDisable(!selectedItems.get(0).getStatus());
		}
	}

	/**
	 * remove hold media action.
	 * @param event, the action event.
	 */
	@FXML
	private void removeMedia(ActionEvent event) {
		if (selectedItems != null && selectedItems.get(0) != null) {
			Handler.sharedInstance().removeHold(selectedItems.get(0).getItem(), currentUser);
			// The index of the sorted and filtered list.
			int visibleIndex = mediaTable.getSelectionModel().getSelectedIndex();

			// Source index of master data.
			int sourceIndex = sortedData.getSourceIndexFor(holdMedias, visibleIndex);

			// Remove.
			holdMedias.remove(sourceIndex);
			mediaTable.refresh();
		}
	}

	/**
	 * checkout hold media action.
	 * @param event, the action event.
	 */
	@FXML
	private void checkout(ActionEvent event) {
		if (selectedItems != null && selectedItems.get(0) != null && selectedItems.get(0).getStatus()) {
			Handler.sharedInstance().removeHold(selectedItems.get(0).getItem(), currentUser);
			
			if (Handler.sharedInstance().checkOut(currentUser, selectedItems.get(0).getItem())) {
				selectedItems.get(0).getItem().setCheckOutNumber(selectedItems.get(0).getItem().getCheckOutNumber() + 1);
				// The index of the sorted and filtered list.
				int visibleIndex = mediaTable.getSelectionModel().getSelectedIndex();

				// Source index of master data.
				int sourceIndex = sortedData.getSourceIndexFor(holdMedias, visibleIndex);

				// Remove.
				holdMedias.remove(sourceIndex);
				mediaTable.refresh();
			}			
		}
	}
}
