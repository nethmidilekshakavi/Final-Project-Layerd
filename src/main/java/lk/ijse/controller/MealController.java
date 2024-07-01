package lk.ijse.controller;

import java.io.IOException;
import java.io.InputStream;
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
import lk.ijse.BO.Custom.CustomerBO;
import lk.ijse.BO.Custom.MealBO;
import lk.ijse.DB.DbConnection;
import lk.ijse.Model.CustomerModel;
import lk.ijse.Model.MealModel;
import lk.ijse.Model.TM.MealTM;
import lk.ijse.Model.TM.customerTM;
import lk.ijse.Repository.MealRepo;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class MealController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnPrint;

    @FXML
    private TableColumn<MealTM, String> colmid;

    @FXML
    private TableColumn<MealTM, String> colname;

    @FXML
    private TableColumn<MealTM, String> colprice;
    @FXML
    private TableColumn<MealTM, ImageView> colimage;

    @FXML
    private ImageView mealPane;

    @FXML
    private TableView<MealTM> mealTable;

    @FXML
    private TableColumn<MealTM, JFXButton> colDelete;

    @FXML
    private TableColumn<MealTM, JFXButton> colUpdate;

    @FXML
    private Text title;

    @FXML
    private AnchorPane pane;



    MealBO mealBO = (MealBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.MEAL);

    @FXML
    void addNewEmployee(ActionEvent event) throws IOException {
        AddMeal.apane = pane;
        Parent parent = FXMLLoader.load(getClass().getResource("/view/addMeal.fxml"));
        Scene scene =new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("ADD MealController");
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    void getReport(ActionEvent event) throws JRException, SQLException {
        InputStream resourceAsStream = getClass().getResourceAsStream("/Report/Meal.jrxml");
        JasperDesign load = JRXmlLoader.load(resourceAsStream);
        JasperReport jasperReport = JasperCompileManager.compileReport(load);
        JasperPrint jasperPrint = JasperFillManager.fillReport(
                jasperReport,
                null,
                DbConnection.getInstance().getConnection()
        );

        JasperViewer.viewReport(jasperPrint,false);


    }


    public void loadvalues() throws SQLException, ClassNotFoundException {

        //gellAllCustomer
        ObservableList<MealTM> observableList = FXCollections.observableArrayList();

        ArrayList<MealModel> mealModels = mealBO.getAllMeal();
        for (MealModel mealModel : mealModels) {
            mealTable.getItems().add(new MealTM(mealModel.getMID(),mealModel.getName(),mealModel.getPrice(), new JFXButton("Update"), new JFXButton("Delete")));
            mealTable.setItems(observableList);

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
        for (int i=0 ;i<observableList.size();i++){
            String id =observableList.get(i).getMID();
            String name =observableList.get(i).getName();
            String price =observableList.get(i).getPrice();
          // String meal = String.valueOf(observableList.get(i).getMeal());

            observableList.get(i).getUpdate();

            observableList.get(i).getDelete().setOnAction(actionEvent -> {
                Alert confirmDialog = new Alert(Alert.AlertType.CONFIRMATION);
                confirmDialog.setTitle("Confirm Deletion");
                confirmDialog.setHeaderText("Are you sure you want to delete this MealController?");
                confirmDialog.setContentText("Press OK to confirm or Cancel to abort.");

                confirmDialog.showAndWait().ifPresent(response -> {
                    if (response == ButtonType.OK) {
                        try {
                            boolean deleted = mealBO.deleteCustomer(id);
                            if (deleted) {
                                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                                successAlert.setTitle("Success");
                                successAlert.setHeaderText(null);
                                successAlert.setContentText("MealController Deleted Successfully");
                                successAlert.showAndWait();
                                // Reload values after successful deletion

                            } else {
                                // Handle deletion failure
                                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                                errorAlert.setTitle("Error");
                                errorAlert.setHeaderText(null);
                                errorAlert.setContentText("Failed to delete MealController.");
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
                        } catch (ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
            });


            observableList.get(i).getUpdate().setOnAction(actionEvent -> {
                Parent parent = null;
                try {
                    parent = FXMLLoader.load(getClass().getResource("/view/updateMeal.fxml"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Scene scene =new Scene(parent);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Update MealController");
                stage.centerOnScreen();
                stage.show();
            });
        }

    }
    public void setValues() {
        colmid.setCellValueFactory(new PropertyValueFactory<>("MID"));
        colname.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colprice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        colDelete.setCellValueFactory(new PropertyValueFactory<MealTM,JFXButton>("Delete"));
        colUpdate.setCellValueFactory(new PropertyValueFactory<MealTM,JFXButton>("Update"));
        colimage.setCellValueFactory(new PropertyValueFactory<>("MealController"));
    }

        @FXML
        void initialize () throws SQLException, ClassNotFoundException {
            assert btnAdd != null : "fx:id=\"btnAdd\" was not injected: check your FXML file 'MealController.fxml'.";
            assert btnPrint != null : "fx:id=\"btnPrint\" was not injected: check your FXML file 'MealController.fxml'.";
            assert colmid != null : "fx:id=\"colmid\" was not injected: check your FXML file 'MealController.fxml'.";
            assert colname != null : "fx:id=\"colname\" was not injected: check your FXML file 'MealController.fxml'.";
            assert colprice != null : "fx:id=\"colprice\" was not injected: check your FXML file 'MealController.fxml'.";
            assert mealPane != null : "fx:id=\"mealPane\" was not injected: check your FXML file 'MealController.fxml'.";
            assert mealTable != null : "fx:id=\"mealTable\" was not injected: check your FXML file 'MealController.fxml'.";
            assert title != null : "fx:id=\"title\" was not injected: check your FXML file 'MealController.fxml'.";
            assert colimage != null:"fx:id=\"colimage\" was not injected: check your FXML file 'MealController.fxml'.";
            loadvalues();
            setValues();

        }
    }


