package lk.ijse.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lk.ijse.BO.BOFactory;
import lk.ijse.BO.Custom.CustomerBO;
import lk.ijse.Dao.Custom.CustomerDao;
import lk.ijse.Dao.Impl.CustomerDaoImpl;
import lk.ijse.Mail.mail;
import lk.ijse.Model.CustomerModel;
import lk.ijse.util.Regex;

public class AddNewCustomer {
    public static AnchorPane apane;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView AddNewCustomerPage;

    @FXML
    private TextField cidtxt;

    @FXML
    private Text CID;

    @FXML
    private TextField Emailtxt;

    @FXML
    private Text address;

    @FXML
    private TextField addresstxt;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnSave;

    @FXML
    private Text customerinfor;

    @FXML
    private Text email;

    @FXML
    private Text fname;

    @FXML
    private TextField fnametxt;

    @FXML
    private Text lname;

    @FXML
    private TextField lnametxt;

    @FXML
    private Text nic;

    @FXML
    private TextField nictxt;

    @FXML
    private Text num;

    @FXML
    private TextField numtxt;

    CustomerBO customerBO  = (CustomerBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CUSTOMER);

    @FXML
    void dontSaveCustomer(ActionEvent event) {
        Stage stage = (Stage) cidtxt.getScene().getWindow();
        stage.close();
    }

    @FXML
    void clearOnAction(ActionEvent event) {
        clear();
    }

    public void clear() {
        cidtxt.clear();
        nictxt.clear();
        fnametxt.clear();
        lnametxt.clear();
        addresstxt.clear();
        numtxt.clear();
        Emailtxt.clear();

    }

    @FXML
    void saveCustomer(ActionEvent event) throws SQLException, IOException, ClassNotFoundException {

        String cid = cidtxt.getText();
        String nic = nictxt.getText();
        String fname = fnametxt.getText();
        String lname = lnametxt.getText();
        String address = addresstxt.getText();
        int mobile = Integer.parseInt(numtxt.getText());
        String email = Emailtxt.getText();

      boolean b =   customerBO.saveCustomer(new CustomerModel(cid,nic,fname,lname,address,mobile,email));

        if (b) {
            new Alert(Alert.AlertType.CONFIRMATION, "customer saved successfully").show();
            mail mail = new mail();
            mail.setMsg("Hi " + fname + " " + lname +
                    "\nWelcome \uD83D\uDE4F you as a customer of the FOOD COURT RESTAURENT! \uD83C\uDF54 \uD83C\uDF7D\uFE0F  " +
                    "\nYour Nexus Card Number : " + mobile +
                    "\nTime : " + Time.valueOf(LocalTime.now()) +
                    "\nDate : " + Date.valueOf(LocalDate.now()) +
                    "\nThank You! \uD83D\uDE0A"
            );
            mail.setTo(Emailtxt.getText());
            mail.setSubject("Alert");

            Thread thread = new Thread(mail);
            thread.start();

            new Alert(Alert.AlertType.CONFIRMATION, "customer saved successfully").show();

        } else {
            new Alert(Alert.AlertType.ERROR, "something went wrong").show();
        }
        Stage stage1 = (Stage) cidtxt.getScene().getWindow();
        stage1.close();
        apane.getChildren().clear();
        apane.getChildren().add(FXMLLoader.load(getClass().getResource("/view/Customer.fxml")));
    }

    public void txtcustomerEmailKeyreleased(KeyEvent keyEvent) {
        Regex.setTextColor(lk.ijse.util.TextField.EMAIL, Emailtxt);
    }

    public void cidkeyRelese(KeyEvent keyEvent) {Regex.setTextColor(lk.ijse.util.TextField.ID, cidtxt);}

    @FXML
    void txtNumberKeyRelese(KeyEvent event) {
        Regex.setTextColor(lk.ijse.util.TextField.MOBILE, numtxt);
    }

    @FXML
    void FirstameOnkeyRelese(KeyEvent event) {
        Regex.setTextColor(lk.ijse.util.TextField.FNAME, fnametxt);
    }

    @FXML
    void LastnameOnkeyRelese(KeyEvent event) {
        Regex.setTextColor(lk.ijse.util.TextField.LNAME, lnametxt);
    }

    @FXML
    void initialize() throws SQLException {

    }
}


