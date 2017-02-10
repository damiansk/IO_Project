package Controller;

import Model.TripModel;
import POJO.Trip;
import Util.TreeTableFormatFactory;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;

import java.net.URL;
import java.util.ResourceBundle;

public class TripsController implements Initializable {

    @FXML
    private TreeTableColumn<TreeTableFormatFactory,String> tripLabel;
    @FXML
    private TreeTableColumn<TreeTableFormatFactory,String> tripContent;
    @FXML
    private TreeTableView<TreeTableFormatFactory> tripsTree;

    private TripModel tripModel;

    public TripsController() {
        tripModel = new TripModel();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Trip> trips = tripModel.getTrips();
        TreeItem<TreeTableFormatFactory> root = new TreeItem<>(new TreeTableFormatFactory("","", null));

        for (Trip trip: trips) {
            root.getChildren().add(generateTreeItem(trip));
        }

        tripLabel.setCellValueFactory((TreeTableColumn.CellDataFeatures<TreeTableFormatFactory, String> parameter) -> parameter.getValue().getValue().getLabelProperty());
        tripContent.setCellValueFactory((TreeTableColumn.CellDataFeatures<TreeTableFormatFactory, String> parameter) -> parameter.getValue().getValue().getDescriptionProperty());

        tripsTree.setShowRoot(false);
        tripsTree.setRoot(root);
    }

    private TreeItem<TreeTableFormatFactory> generateTreeItem(Trip trip) {
        TreeItem<TreeTableFormatFactory> root = new TreeItem<>(new TreeTableFormatFactory(trip.getTitle(), "", trip));
        root.getChildren().add(new TreeItem<>(new TreeTableFormatFactory("Opis", trip.getDescription(), trip)));
        root.getChildren().add(new TreeItem<>(new TreeTableFormatFactory("Ilosc dni", Integer.toString(trip.getDays()), trip)));
        root.getChildren().add(new TreeItem<>(new TreeTableFormatFactory("Cena", Float.toString(trip.getPrice()), trip)));
        root.getChildren().add(new TreeItem<>(new TreeTableFormatFactory("Data", trip.getDate().toString(), trip)));
        return root;
    }

    @FXML
    private void handleButtonAddTrip() {
        System.out.println("Add!");
    }

    @FXML
    private void handleButtonEditTrip() {
        TreeItem<TreeTableFormatFactory> selectedItem = tripsTree.getSelectionModel().getSelectedItem();

        if (selectedItem != null) {
            // TODO getConnectedObject return trip to edit - make function like add/edit in Sale
            System.out.println(selectedItem.getValue().getConnectedObject());
            System.out.println("Edit!");
        }
    }

}
