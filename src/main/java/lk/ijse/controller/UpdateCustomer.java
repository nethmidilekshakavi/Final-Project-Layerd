package lk.ijse.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lk.ijse.BO.BOFactory;
import lk.ijse.BO.Custom.CustomerBO;
import lk.ijse.Dao.Custom.CustomerDao;
import lk.ijse.Dao.Impl.CustomerDaoImpl;
import lk.ijse.Entity.Customer;
import lk.ijse.Model.CustomerModel;
import lk.ijse.Repository.CustomerRepo;

public class UpdateCustomer {
    public static AnchorPane upane;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text CID;

    @FXML
    private Text address;

    @FXML
    private Button btnCancel;
    @FXML
    private ImageView pic;

    @FXML
    private Button btnUpdate;

    @FXML
    private AnchorPane pane;

    @FXML
    private TextField cidtxt;

    @FXML
    private Text email;

    @FXML
    private Text fname;

    @FXML
    private Text lname;

    @FXML
    private TextField newEmailtxt;

    @FXML
    private TextField newaddresstxt;


    @FXML
    private TextField newfnametxt;

    @FXML
    private TextField newlnametxt;

    @FXML
    private TextField newnictxt;

    @FXML
    private TextField newnumtxt;

    @FXML
    private Text nic;

    @FXML
    private Text num;

    @FXML
    private ImageView updateCustomerPage;

    @FXML
    private Text updatecustomerinfor;

    CustomerBO customerBO  = (CustomerBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CUSTOMER);

    @FXML
    void dontUpdateCustomer(ActionEvent event) {
        Stage stage = (Stage) cidtxt.getScene().getWindow();
        stage.close();
    }

    @FXML
    void updateCustomerOnAction(ActionEvent event) throws SQLException, IOException, ClassNotFoundException {
        UpdateCustomer.upane = pane;
        String cidd = cidtxt.getText();
        String nnic = newnictxt.getText();
        String finame = newfnametxt.getText();
        String laname = newlnametxt.getText();
        String add = newaddresstxt.getText();
        int phone = Integer.parseInt(newnumtxt.getText());
        String ema = newEmailtxt.getText();


     boolean c  = customerBO.updateCustomer(new CustomerModel(cidd,nnic,finame,laname,add,phone,ema));

        if (c) {
            // Show success message
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Success");
            successAlert.setHeaderText(null);
            successAlert.setContentText("CustomerController details updated successfully.");
            successAlert.showAndWait();

            ((Node) (event.getSource())).getScene().getWindow().hide();
        } else {

            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Error");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Something went wrong.");
            errorAlert.show();
        }
        Stage stage1 = (Stage) cidtxt.getScene().getWindow();
        stage1.close();
        upane.getChildren().clear();
        upane.getChildren().add(FXMLLoader.load(getClass().getResource("/view/Customer.fxml")));

    }
    @FXML
    void initialize() {
        assert CID != null : "fx:id=\"CID\" was not injected: check your FXML file 'UpdateCustomer.fxml'.";
        assert address != null : "fx:id=\"address\" was not injected: check your FXML file 'UpdateCustomer.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'UpdateCustomer.fxml'.";
        assert btnUpdate != null : "fx:id=\"btnUpdate\" was not injected: check your FXML file 'UpdateCustomer.fxml'.";
        assert cidtxt != null : "fx:id=\"cidtxt\" was not injected: check your FXML file 'UpdateCustomer.fxml'.";
        assert email != null : "fx:id=\"email\" was not injected: check your FXML file 'UpdateCustomer.fxml'.";
        assert fname != null : "fx:id=\"fname\" was not injected: check your FXML file 'UpdateCustomer.fxml'.";
        assert lname != null : "fx:id=\"lname\" was not injected: check your FXML file 'UpdateCustomer.fxml'.";
        assert newEmailtxt != null : "fx:id=\"newEmailtxt\" was not injected: check your FXML file 'UpdateCustomer.fxml'.";
        assert newaddresstxt != null : "fx:id=\"newaddresstxt\" was not injected: check your FXML file 'UpdateCustomer.fxml'.";
        assert newfnametxt != null : "fx:id=\"newfnametxt\" was not injected: check your FXML file 'UpdateCustomer.fxml'.";
        assert newlnametxt != null : "fx:id=\"newlnametxt\" was not injected: check your FXML file 'UpdateCustomer.fxml'.";
        assert newnictxt != null : "fx:id=\"newnictxt\" was not injected: check your FXML file 'UpdateCustomer.fxml'.";
        assert newnumtxt != null : "fx:id=\"newnumtxt\" was not injected: check your FXML file 'UpdateCustomer.fxml'.";
        assert nic != null : "fx:id=\"nic\" was not injected: check your FXML file 'UpdateCustomer.fxml'.";
        assert num != null : "fx:id=\"num\" was not injected: check your FXML file 'UpdateCustomer.fxml'.";
        assert updateCustomerPage != null : "fx:id=\"updateCustomerPage\" was not injected: check your FXML file 'UpdateCustomer.fxml'.";
        assert updatecustomerinfor != null : "fx:id=\"updatecustomerinfor\" was not injected: check your FXML file 'UpdateCustomer.fxml'.";
    }


    public void ideeenter(KeyEvent keyEvent) throws SQLException, ClassNotFoundException {
        if (keyEvent.getCode().equals(KeyCode.ENTER)){
            String id = String.valueOf(cidtxt.getText());
           ArrayList<Customer> customers = customerBO.serachCID(id);


            newnictxt.setText(String.valueOf(customers.get(0).getNIC()));
            newfnametxt.setText(String.valueOf(customers.get(0).getFirst_Name()));
            newlnametxt.setText(String.valueOf(customers.get(0).getLast_Name()));
            newaddresstxt.setText(String.valueOf(customers.get(0).getAddress()));
            newnumtxt.setText(String.valueOf(String.valueOf(customers.get(0).getPhone_Number())));
            newEmailtxt.setText(String.valueOf(customers.get(0).getEmail()));

        }
    }
}


