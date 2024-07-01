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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lk.ijse.BO.BOFactory;
import lk.ijse.BO.Custom.EmployeeBO;
import lk.ijse.DB.DbConnection;
import lk.ijse.Model.EmployeeModel;
import lk.ijse.Model.TM.EmployeeTM;
import lk.ijse.controller.ADD.AddNewEmployee;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class EmployeeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView EmployeePane;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnPrint;

    @FXML
    private Text cidtxt;

    @FXML
    private TableColumn<EmployeeTM, String> colNIC;

    @FXML
    private TableColumn<EmployeeTM, String> colPosition;

    @FXML
    private TableColumn<EmployeeTM, String> colSalary;

    @FXML
    private TableColumn<EmployeeTM, JFXButton> colUpadte;

    @FXML
    private TableColumn<EmployeeTM, String> coladdress;

    @FXML
    private TableColumn<EmployeeTM, JFXButton> coldelete;

    @FXML
    private TableColumn<EmployeeTM, String> colemail;

    @FXML
    private TableColumn<EmployeeTM, String> colfName;

    @FXML
    private TableColumn<EmployeeTM, String> collname;

    @FXML
    private TableColumn<EmployeeTM, String> colnum;

    @FXML
    private TableView<EmployeeTM> employeeTable;

    @FXML
    private Text title;

    @FXML
    private AnchorPane pane;

    EmployeeBO employeeBO = (EmployeeBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.EMPLOYEE);

    @FXML
    void addNewEmployee(ActionEvent event) throws IOException {
        AddNewEmployee.apane = pane;
        Parent parent = FXMLLoader.load(getClass().getResource("/view/addNewEmployee.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Add New EmployeeController Form");
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    void getReport(ActionEvent event) throws JRException, SQLException {
        InputStream resourceAsStream = getClass().getResourceAsStream("/Report/Employee.jrxml");
        JasperDesign load = JRXmlLoader.load(resourceAsStream);
        JasperReport jasperReport = JasperCompileManager.compileReport(load);
        JasperPrint jasperPrint = JasperFillManager.fillReport(
                jasperReport,
                null,
                DbConnection.getInstance().getConnection()
        );

        JasperViewer.viewReport(jasperPrint, false);

    }

    public void loadvalues() throws SQLException {
        try {

            //gellAllEmployee
            ObservableList<EmployeeTM> observableList = FXCollections.observableArrayList();

            ArrayList<EmployeeModel> employeeModels = employeeBO.getAllEmployee();
            for (EmployeeModel employeeModel : employeeModels) {
                String mobile = String.valueOf(employeeModel.getPhone_Number());

                employeeTable.getItems().add(new EmployeeTM(employeeModel.getE_ID(), employeeModel.getNIC(), employeeModel.getFirst_Name(), employeeModel.getLast_Name(), employeeModel.getAddress(), mobile, employeeModel.getEmail(), employeeModel.getSalary(), employeeModel.getPosition(), new JFXButton("Update"), new JFXButton("Delete")));
                //  observableList.add(customerTM);
                employeeTable.setItems(observableList);
            }
            for (int i = 0; i < observableList.size(); i++) {
                observableList.get(i).getUpdate().setStyle("-fx-background-color: rgba(16, 176, 72)");
                observableList.get(i).getUpdate().setPrefWidth(100);
                observableList.get(i).getUpdate().setPrefHeight(30);
                observableList.get(i).getUpdate().setCursor(Cursor.HAND);
                observableList.get(i).getDelete().setStyle("-fx-background-color: rgba(166, 7, 33)");
                observableList.get(i).getDelete().setCursor(Cursor.HAND);
                observableList.get(i).getDelete().setPrefWidth(100);
                observableList.get(i).getDelete().setPrefHeight(30);
                observableList.get(i).getUpdate().setTextFill(Color.WHITE);
                observableList.get(i).getDelete().setTextFill(Color.WHITE);

            }
            for (int i = 0; i < observableList.size(); i++) {
                String id = observableList.get(i).getE_ID();
                observableList.get(i).getDelete().setOnAction(actionEvent -> {
                    Alert confirmDialog = new Alert(Alert.AlertType.CONFIRMATION);
                    confirmDialog.setTitle("Confirm Deletion");
                    confirmDialog.setHeaderText("Are you sure you want to delete this EmployeeController?");
                    confirmDialog.setContentText("Press OK to confirm or Cancel to abort.");

                    confirmDialog.showAndWait().ifPresent(response -> {
                        if (response == ButtonType.OK) {
                            try {
                                boolean deleted = employeeBO.deleteEmployee(id);
                                if (deleted) {
                                    Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                                    successAlert.setTitle("Success");
                                    successAlert.setHeaderText(null);
                                    successAlert.setContentText("EmployeeController Deleted Successfully");
                                    successAlert.showAndWait();
                                    // Reload values after successful deletion

                                } else {
                                    // Handle deletion failure
                                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                                    errorAlert.setTitle("Error");
                                    errorAlert.setHeaderText(null);
                                    errorAlert.setContentText("Failed to delete EmployeeController.");
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
                        parent = FXMLLoader.load(getClass().getResource("/view/UpdateEmployee.fxml"));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    Scene scene = new Scene(parent);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.setTitle("Update EmployeeController");
                    stage.centerOnScreen();
                    stage.show();
                });
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
        private void setValues () {
            colNIC.setCellValueFactory(new PropertyValueFactory<>("NIC"));
            colfName.setCellValueFactory(new PropertyValueFactory<>("First_Name"));
            collname.setCellValueFactory(new PropertyValueFactory<>("Last_Name"));
            coladdress.setCellValueFactory(new PropertyValueFactory<>("Address"));
            colnum.setCellValueFactory(new PropertyValueFactory<>("Phone_Number"));
            colemail.setCellValueFactory(new PropertyValueFactory<>("Email"));
            colSalary.setCellValueFactory(new PropertyValueFactory<>("Salary"));
            colPosition.setCellValueFactory(new PropertyValueFactory<>("Position"));
            colUpadte.setCellValueFactory(new PropertyValueFactory<EmployeeTM, JFXButton>("Update"));
            coldelete.setCellValueFactory(new PropertyValueFactory<EmployeeTM, JFXButton>("Delete"));
        }

        @FXML
        void initialize () throws SQLException {
            assert EmployeePane != null : "fx:id=\"EmployeePane\" was not injected: check your FXML file 'EmployeeController.fxml'.";
            assert btnAdd != null : "fx:id=\"btnAdd\" was not injected: check your FXML file 'EmployeeController.fxml'.";
            assert btnPrint != null : "fx:id=\"btnPrint\" was not injected: check your FXML file 'EmployeeController.fxml'.";
            assert cidtxt != null : "fx:id=\"cidtxt\" was not injected: check your FXML file 'EmployeeController.fxml'.";
            assert colNIC != null : "fx:id=\"colNIC\" was not injected: check your FXML file 'EmployeeController.fxml'.";
            assert colPosition != null : "fx:id=\"colPosition\" was not injected: check your FXML file 'EmployeeController.fxml'.";
            assert colSalary != null : "fx:id=\"colSalary\" was not injected: check your FXML file 'EmployeeController.fxml'.";
            assert colUpadte != null : "fx:id=\"colUpadte\" was not injected: check your FXML file 'EmployeeController.fxml'.";
            assert coladdress != null : "fx:id=\"coladdress\" was not injected: check your FXML file 'EmployeeController.fxml'.";
            assert coldelete != null : "fx:id=\"coldelete\" was not injected: check your FXML file 'EmployeeController.fxml'.";
            assert colemail != null : "fx:id=\"colemail\" was not injected: check your FXML file 'EmployeeController.fxml'.";
            assert colfName != null : "fx:id=\"colfName\" was not injected: check your FXML file 'EmployeeController.fxml'.";
            assert collname != null : "fx:id=\"collname\" was not injected: check your FXML file 'EmployeeController.fxml'.";
            assert colnum != null : "fx:id=\"colnum\" was not injected: check your FXML file 'EmployeeController.fxml'.";
            assert employeeTable != null : "fx:id=\"employeeTable\" was not injected: check your FXML file 'EmployeeController.fxml'.";
            assert title != null : "fx:id=\"title\" was not injected: check your FXML file 'EmployeeController.fxml'.";
            loadvalues();
            setValues();
        }
    }



