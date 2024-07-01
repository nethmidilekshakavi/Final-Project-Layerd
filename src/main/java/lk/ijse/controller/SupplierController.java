package lk.ijse.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lk.ijse.Model.SupplierModel;
import lk.ijse.Model.TM.SupplierTM;
import lk.ijse.Model.TM.customerTM;
import lk.ijse.Repository.SupplierRepo;

public class SupplierController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView SupplierPane;

    @FXML
    private TableView<SupplierTM> SupplierTable;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnPrint;

    @FXML
    private TableColumn<SupplierTM, String> colAddress;

    @FXML
    private TableColumn<SupplierTM,String> colAmountDue;

    @FXML
    private TableColumn<?, ?> colDateOfPayment;

    @FXML
    private TableColumn<?, ?> colIngredients;

    @FXML
    private TableColumn<?, ?> colMobile;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPaid;

    @FXML
    private TableColumn<?, ?> colPaymentType;

    @FXML
    private TableColumn<?, ?> coldateOfPurches;

    @FXML
    private TableColumn<customerTM, JFXButton> coldelete;

    @FXML
    private TableColumn<customerTM, JFXButton> colupdate;

    @FXML
    private Text title;

    @FXML
    private AnchorPane pane;

    @FXML
    void addNewSupplier(ActionEvent event) throws IOException {
        AddNewSupplier.apane = pane;
        Parent parent = FXMLLoader.load(getClass().getResource("/view/AddNewSupplier.fxml"));
        Scene scene =new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Add New SupplierController Form");
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    void getReport(ActionEvent event) {

    }
    public void loadvalues() throws SQLException {
        ArrayList<SupplierModel> allSupplier = SupplierRepo.getAll();
        ObservableList<SupplierTM> observableList = FXCollections.observableArrayList();

        for (int i = 0; i < allSupplier.size(); i++) {
            String mobile = String.valueOf(allSupplier.get(i).getPhone_Number());
            SupplierTM supplierTM = new SupplierTM(allSupplier.get(i).getS_ID(), allSupplier.get(i).getName(), allSupplier.get(i).getAddress(), mobile, allSupplier.get(i).getIngredient(), allSupplier.get(i).getDate_Of_Purchase(), allSupplier.get(i).getAmount_due(), allSupplier.get(i).getDate_of_Payment(), allSupplier.get(i).getPayment_Type(), allSupplier.get(i).getAmount_Paid(), new JFXButton("Update"), new JFXButton("Delete"));
            observableList.add(supplierTM);
            SupplierTable.setItems(observableList);
        }

        for (int i = 0; i < observableList.size(); i++) {
            observableList.get(i).getUpdate().setStyle("-fx-background-color: rgba(16, 176, 72)");
            observableList.get(i).getUpdate().setPrefWidth(100);
            observableList.get(i).getUpdate().setPrefHeight(30);
            observableList.get(i).getUpdate().setCursor(Cursor.HAND);
            observableList.get(i).getDelete().setStyle("-fx-background-color: rgba(166, 7, 33)");
            observableList.get(i).getDelete().setPrefWidth(100);
            observableList.get(i).getDelete().setPrefHeight(30);
            observableList.get(i).getDelete().setCursor(Cursor.HAND);
            observableList.get(i).getUpdate().setTextFill(Color.WHITE);
            observableList.get(i).getDelete().setTextFill(Color.WHITE);

        }
        for (int i = 0; i < observableList.size(); i++) {
            String id = observableList.get(i).getS_ID();
            observableList.get(i).getDelete().setOnAction(actionEvent -> {
                Alert confirmDialog = new Alert(Alert.AlertType.CONFIRMATION);
                confirmDialog.setTitle("Confirm Deletion");
                confirmDialog.setHeaderText("Are you sure you want to delete this SupplierController?");
                confirmDialog.setContentText("Press OK to confirm or Cancel to abort.");

                confirmDialog.showAndWait().ifPresent(response -> {
                    if (response == ButtonType.OK) {
                        try {
                            boolean deleted = SupplierRepo.delete(id);
                            if (deleted) {
                                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                                successAlert.setTitle("Success");
                                successAlert.setHeaderText(null);
                                successAlert.setContentText("SupplierController Deleted Successfully");
                                successAlert.showAndWait();
                                // Reload values after successful deletion

                            } else {
                                // Handle deletion failure
                                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                                errorAlert.setTitle("Error");
                                errorAlert.setHeaderText(null);
                                errorAlert.setContentText("Failed to delete SupplierController.");
                                errorAlert.showAndWait();
                            }
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                        try {
                            loadvalues();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
            });


            observableList.get(i).getUpdate().setOnAction(actionEvent -> {
                Parent parent = null;
                try {
                    parent = FXMLLoader.load(getClass().getResource("/view/updateSupplier.fxml"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Scene scene =new Scene(parent);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Update SupplierController");
                stage.centerOnScreen();
                stage.show();
            });
        }
    }
    public void setValues(){
        colName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        colMobile.setCellValueFactory(new PropertyValueFactory<>("Phone_Number"));
        colIngredients.setCellValueFactory(new PropertyValueFactory<>("Ingredient"));
        coldateOfPurches.setCellValueFactory(new PropertyValueFactory<>("Date_Of_Purchase"));
        colAmountDue.setCellValueFactory(new PropertyValueFactory<>("Amount_due"));
        colDateOfPayment.setCellValueFactory(new PropertyValueFactory<>("Date_of_Payment"));
        colPaymentType.setCellValueFactory(new PropertyValueFactory<>("Payment_Type"));
        colPaid.setCellValueFactory(new PropertyValueFactory<>("Amount_Paid"));
        colupdate.setCellValueFactory(new PropertyValueFactory<customerTM,JFXButton>("Update"));
        coldelete.setCellValueFactory(new PropertyValueFactory<customerTM,JFXButton>("Delete"));
    }
    @FXML
    void initialize() throws SQLException {
        assert SupplierPane != null : "fx:id=\"SupplierPane\" was not injected: check your FXML file 'SupplierController.fxml'.";
        assert SupplierTable != null : "fx:id=\"SupplierTable\" was not injected: check your FXML file 'SupplierController.fxml'.";
        assert btnAdd != null : "fx:id=\"btnAdd\" was not injected: check your FXML file 'SupplierController.fxml'.";
        assert btnPrint != null : "fx:id=\"btnPrint\" was not injected: check your FXML file 'SupplierController.fxml'.";
        assert colAddress != null : "fx:id=\"colAddress\" was not injected: check your FXML file 'SupplierController.fxml'.";
        assert colAmountDue != null : "fx:id=\"colAmountDue\" was not injected: check your FXML file 'SupplierController.fxml'.";
        assert colDateOfPayment != null : "fx:id=\"colDateOfPayment\" was not injected: check your FXML file 'SupplierController.fxml'.";
        assert colIngredients != null : "fx:id=\"colIngredients\" was not injected: check your FXML file 'SupplierController.fxml'.";
        assert colMobile != null : "fx:id=\"colMobile\" was not injected: check your FXML file 'SupplierController.fxml'.";
        assert colName != null : "fx:id=\"colName\" was not injected: check your FXML file 'SupplierController.fxml'.";
        assert colPaid != null : "fx:id=\"colPaid\" was not injected: check your FXML file 'SupplierController.fxml'.";
        assert colPaymentType != null : "fx:id=\"colPaymentType\" was not injected: check your FXML file 'SupplierController.fxml'.";
        assert coldateOfPurches != null : "fx:id=\"coldateOfPurches\" was not injected: check your FXML file 'SupplierController.fxml'.";
        assert coldelete != null : "fx:id=\"coldelete\" was not injected: check your FXML file 'SupplierController.fxml'.";
        assert colupdate != null : "fx:id=\"colupdate\" was not injected: check your FXML file 'SupplierController.fxml'.";
        assert title != null : "fx:id=\"title\" was not injected: check your FXML file 'SupplierController.fxml'.";
    loadvalues();
    setValues();
    }

}
