package lk.ijse.controller;

import java.awt.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lk.ijse.BO.BOFactory;
import lk.ijse.BO.Custom.EmployeeBO;
import lk.ijse.Model.CustomerModel;
import lk.ijse.Model.EmployeeModel;
import lk.ijse.Repository.CustomerRepo;
import lk.ijse.Repository.EmployeeRepo;

public class UpdateEmployee {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text EID;

    @FXML
    private ImageView pic;

    @FXML
    private Text NIC;

    @FXML
    private Text address;

    @FXML
    private TextField addresstxt;

    @FXML
    private Text birthday;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnUpdate;

    @FXML
    private TextField daytxt;

    @FXML
    private TextField eidtxt;

    @FXML
    private Text email;

    @FXML
    private TextField emailtxt;

    @FXML
    private TextField fnametxt;

    @FXML
    private TextField lnametxt;

    @FXML
    private Text mobile;

    @FXML
    private TextField mobiletxt;

    @FXML
    private TextField monthtxt;

    @FXML
    private Text name;

    @FXML
    private Text neweid;

    @FXML
    private TextField neweidtxt;


    @FXML
    private TextField nictxt;

    @FXML
    private Text position;

    @FXML
    private TextField positiontxt;

    @FXML
    private Text salary;

    @FXML
    private TextField salarytxt;

    @FXML
    private Text updateEmployeeinfor;

    @FXML
    private ImageView updateEmployeerPage;

    @FXML
    private TextField yeartxt;

    EmployeeBO employeeBO  = (EmployeeBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.EMPLOYEE);

    @FXML
    void dontSaveEmployee(ActionEvent event) {
        Stage stage =(Stage)eidtxt.getScene().getWindow();
        stage.close();
    }

    @FXML
    void updateEmployee(ActionEvent event) throws SQLException, ClassNotFoundException {
        String eid = eidtxt.getText();
        String nic = nictxt.getText();
        String fname = fnametxt.getText();
        String lname = lnametxt.getText();
        String add = addresstxt.getText();
        int mobile = Integer.parseInt(mobiletxt.getText());
        String email = emailtxt.getText();
        String salary = salarytxt.getText();
        String position = positiontxt.getText();
        int year = Integer.parseInt(yeartxt.getText());
        int month = Integer.parseInt(monthtxt.getText());
        int day = Integer.parseInt(daytxt.getText());


        boolean a = employeeBO.updateEmployee( new EmployeeModel(eid,nic,fname,lname,add,mobile,email,salary,position,year,month,day));
        if (a) {

            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Success");
            successAlert.setHeaderText(null);
            successAlert.setContentText("EmployeeController details updated successfully.");
            successAlert.showAndWait();


            ((Node) (event.getSource())).getScene().getWindow().hide();
        } else {

            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Error");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Something went wrong.");
            errorAlert.show();
        }
        Stage stage1 = (Stage) eidtxt.getScene().getWindow();
        stage1.close();
    }

    @FXML
    void initialize() {
        assert EID != null : "fx:id=\"EID\" was not injected: check your FXML file 'UpdateEmployee.fxml'.";
        assert NIC != null : "fx:id=\"NIC\" was not injected: check your FXML file 'UpdateEmployee.fxml'.";
        assert address != null : "fx:id=\"address\" was not injected: check your FXML file 'UpdateEmployee.fxml'.";
        assert addresstxt != null : "fx:id=\"addresstxt\" was not injected: check your FXML file 'UpdateEmployee.fxml'.";
        assert birthday != null : "fx:id=\"birthday\" was not injected: check your FXML file 'UpdateEmployee.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'UpdateEmployee.fxml'.";
        assert btnUpdate != null : "fx:id=\"btnUpdate\" was not injected: check your FXML file 'UpdateEmployee.fxml'.";
        assert daytxt != null : "fx:id=\"daytxt\" was not injected: check your FXML file 'UpdateEmployee.fxml'.";
        assert eidtxt != null : "fx:id=\"eidtxt\" was not injected: check your FXML file 'UpdateEmployee.fxml'.";
        assert email != null : "fx:id=\"email\" was not injected: check your FXML file 'UpdateEmployee.fxml'.";
        assert emailtxt != null : "fx:id=\"emailtxt\" was not injected: check your FXML file 'UpdateEmployee.fxml'.";
        assert fnametxt != null : "fx:id=\"fnametxt\" was not injected: check your FXML file 'UpdateEmployee.fxml'.";
        assert lnametxt != null : "fx:id=\"lnametxt\" was not injected: check your FXML file 'UpdateEmployee.fxml'.";
        assert mobile != null : "fx:id=\"mobile\" was not injected: check your FXML file 'UpdateEmployee.fxml'.";
        assert mobiletxt != null : "fx:id=\"mobiletxt\" was not injected: check your FXML file 'UpdateEmployee.fxml'.";
        assert monthtxt != null : "fx:id=\"monthtxt\" was not injected: check your FXML file 'UpdateEmployee.fxml'.";
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'UpdateEmployee.fxml'.";
        assert neweid != null : "fx:id=\"neweid\" was not injected: check your FXML file 'UpdateEmployee.fxml'.";
        assert neweidtxt != null : "fx:id=\"neweidtxt\" was not injected: check your FXML file 'UpdateEmployee.fxml'.";
        assert nictxt != null : "fx:id=\"nictxt\" was not injected: check your FXML file 'UpdateEmployee.fxml'.";
        assert position != null : "fx:id=\"position\" was not injected: check your FXML file 'UpdateEmployee.fxml'.";
        assert positiontxt != null : "fx:id=\"positiontxt\" was not injected: check your FXML file 'UpdateEmployee.fxml'.";
        assert salary != null : "fx:id=\"salary\" was not injected: check your FXML file 'UpdateEmployee.fxml'.";
        assert salarytxt != null : "fx:id=\"salarytxt\" was not injected: check your FXML file 'UpdateEmployee.fxml'.";
        assert updateEmployeeinfor != null : "fx:id=\"updateEmployeeinfor\" was not injected: check your FXML file 'UpdateEmployee.fxml'.";
        assert updateEmployeerPage != null : "fx:id=\"updateEmployeerPage\" was not injected: check your FXML file 'UpdateEmployee.fxml'.";
        assert yeartxt != null : "fx:id=\"yeartxt\" was not injected: check your FXML file 'UpdateEmployee.fxml'.";

    }

    public void idEnter(KeyEvent keyEvent) throws SQLException, ClassNotFoundException {
        if (keyEvent.getCode().equals(KeyCode.ENTER)){
            String id = String.valueOf(eidtxt.getText());
            ArrayList<EmployeeModel> employeeModels = employeeBO.searchEid(id);

            nictxt.setText(employeeModels.get(0).getNIC());
           fnametxt.setText(employeeModels.get(0).getFirst_Name());
            lnametxt.setText(employeeModels.get(0).getLast_Name());
            addresstxt.setText(employeeModels.get(0).getAddress());
            daytxt.setText(String.valueOf(employeeModels.get(0).getDay()));
            monthtxt.setText(String.valueOf(employeeModels.get(0).getMonth()));
            yeartxt.setText(String.valueOf(employeeModels.get(0).getYear()));
            mobiletxt.setText(String.valueOf(employeeModels.get(0).getPhone_Number()));
            emailtxt.setText(employeeModels.get(0).getEmail());
            positiontxt.setText(employeeModels.get(0).getPosition());
            salarytxt.setText(employeeModels.get(0).getSalary());

        }
    }
}
