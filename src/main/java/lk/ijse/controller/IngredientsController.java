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
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lk.ijse.BO.BOFactory;
import lk.ijse.BO.Custom.EmployeeBO;
import lk.ijse.BO.Custom.IngredientBO;
import lk.ijse.Model.EmployeeModel;
import lk.ijse.Model.IngredientModel;
import lk.ijse.Model.TM.EmployeeTM;
import lk.ijse.Model.TM.IngredientTM;
import lk.ijse.Repository.IngredientRepo;

public class IngredientsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView IngredientPage;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnPrint;

    @FXML
    private TableColumn<?, ?> colDesc;

    @FXML
    private TableColumn<?, ?> colIid;

    @FXML
    private TableColumn<?, ?> colQOh;

    @FXML
    private TableColumn<?, ?> colSID;

    @FXML
    private TableColumn<IngredientTM, JFXButton> coldelete;

    @FXML
    private TableColumn<IngredientTM, JFXButton> colupdate;

    @FXML
    private TableView<IngredientTM> ingredientTable;

    @FXML
    private Text title;
    @FXML
    private AnchorPane pane;

    IngredientBO ingredientBO = (IngredientBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.INGREDIENT);
    @FXML
    void addNewIngredient(ActionEvent event) throws IOException {
        AddIngredient.apane = pane;
        Parent parent = FXMLLoader.load(getClass().getResource("/view/addIngredient.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Add New Ingredient Form");
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    void getReport(ActionEvent event) {

    }

    public void loadvalues() throws SQLException {
        try {

            //gellAllIngredient
            ObservableList<IngredientTM> observableList = FXCollections.observableArrayList();

            ArrayList<IngredientModel> ingredientModels = ingredientBO.getAllIngredients();
            for (IngredientModel ingredientModel : ingredientModels) {

                ingredientTable.getItems().add(new IngredientTM(ingredientModel.getI_ID(),ingredientModel.getDescription(),ingredientModel.getQty_On_Hand(),ingredientModel.getSupplier(), new JFXButton("Update"), new JFXButton("Delete")));
                //  observableList.add(customerTM);
                ingredientTable.setItems(observableList);
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
                String id = observableList.get(i).getI_ID();
                observableList.get(i).getDelete().setOnAction(actionEvent -> {
                    Alert confirmDialog = new Alert(Alert.AlertType.CONFIRMATION);
                    confirmDialog.setTitle("Confirm Deletion");
                    confirmDialog.setHeaderText("Are you sure you want to delete this Ingredient?");
                    confirmDialog.setContentText("Press OK to confirm or Cancel to abort.");

                    confirmDialog.showAndWait().ifPresent(response -> {
                        if (response == ButtonType.OK) {
                            try {
                                boolean deleted = ingredientBO.deleteIngredients(id);
                                if (deleted) {
                                    Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                                    successAlert.setTitle("Success");
                                    successAlert.setHeaderText(null);
                                    successAlert.setContentText("Ingredient Deleted Successfully");
                                    successAlert.showAndWait();
                                    // Reload values after successful deletion

                                } else {
                                    // Handle deletion failure
                                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                                    errorAlert.setTitle("Error");
                                    errorAlert.setHeaderText(null);
                                    errorAlert.setContentText("Failed to delete Ingredient.");
                                    errorAlert.showAndWait();
                                }
                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            } catch (ClassNotFoundException e) {
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
                        parent = FXMLLoader.load(getClass().getResource("/view/UpdateIngredient.fxml"));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    Scene scene = new Scene(parent);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.setTitle("Update Ingredient");
                    stage.centerOnScreen();
                    stage.show();
                });
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void setValues() {
        colIid.setCellValueFactory(new PropertyValueFactory<>("I_ID"));
       colDesc.setCellValueFactory(new PropertyValueFactory<>("Description"));
       colQOh.setCellValueFactory(new PropertyValueFactory<>("Qty_On_Hand"));
       colSID.setCellValueFactory(new PropertyValueFactory<>("SupplierController"));
       colupdate.setCellValueFactory(new PropertyValueFactory<IngredientTM,JFXButton>("Update"));
       coldelete.setCellValueFactory(new PropertyValueFactory<IngredientTM,JFXButton>("Delete"));
    }


    @FXML
    void initialize() throws SQLException {
        assert IngredientPage != null : "fx:id=\"IngredientPage\" was not injected: check your FXML file 'IngredientsController.fxml'.";
        assert btnAdd != null : "fx:id=\"btnAdd\" was not injected: check your FXML file 'IngredientsController.fxml'.";
        assert btnPrint != null : "fx:id=\"btnPrint\" was not injected: check your FXML file 'IngredientsController.fxml'.";
        assert colDesc != null : "fx:id=\"colDesc\" was not injected: check your FXML file 'IngredientsController.fxml'.";
        assert colIid != null : "fx:id=\"colIid\" was not injected: check your FXML file 'IngredientsController.fxml'.";
        assert colQOh != null : "fx:id=\"colQOh\" was not injected: check your FXML file 'IngredientsController.fxml'.";
        assert colSID != null : "fx:id=\"colSID\" was not injected: check your FXML file 'IngredientsController.fxml'.";
        assert coldelete != null : "fx:id=\"coldelete\" was not injected: check your FXML file 'IngredientsController.fxml'.";
        assert colupdate != null : "fx:id=\"colupdate\" was not injected: check your FXML file 'IngredientsController.fxml'.";
        assert ingredientTable != null : "fx:id=\"ingredientTable\" was not injected: check your FXML file 'IngredientsController.fxml'.";
        assert title != null : "fx:id=\"title\" was not injected: check your FXML file 'IngredientsController.fxml'.";
        loadvalues();
        setValues();
    }
}


