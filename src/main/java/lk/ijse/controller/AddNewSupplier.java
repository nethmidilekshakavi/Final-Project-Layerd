package lk.ijse.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
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
import lk.ijse.Model.CustomerModel;
import lk.ijse.Model.SupplierModel;
import lk.ijse.Repository.CustomerRepo;
import lk.ijse.Repository.SupplierRepo;
import lk.ijse.util.Regex;

public class AddNewSupplier {
    public static AnchorPane apane;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView AddNewSupplierPage;

    @FXML
    private TextField AmountDuetxt;

    @FXML
    private Text AmountPaid;

    @FXML
    private TextField AmountPaidtxt;

    @FXML
    private TextField PaymentTypetxt;

    @FXML
    private Text SID;

    @FXML
    private Text SupplierInfor;

    @FXML
    private Text address;

    @FXML
    private TextField addresstxt;

    @FXML
    private Text amountDue;

    @FXML
    private TextField sidtxt;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnSave;

    @FXML
    private TextField dataOfPaymenttxt;

    @FXML
    private Text dateOdPayment;

    @FXML
    private Text dateOdPayment1;

    @FXML
    private Text dateOdPurchase;

    @FXML
    private Text ingredient;

    @FXML
    private Text mobile;

    @FXML
    private TextField mobiletxt;

    @FXML
    private Text name;

    @FXML
    private TextField nametxt;

    @FXML
    private TextField purchasetxt;


    @FXML
    private TextField txtIngredient;



    @FXML
    void dontSaveSupplier(ActionEvent event) {
        Stage stage =(Stage)sidtxt.getScene().getWindow();
        stage.close();

        Stage stage1 =(Stage)sidtxt.getScene().getWindow();
        stage1.close();
    }


    @FXML
    void saveSupplier(ActionEvent event) throws SQLException, IOException {

        String sid = sidtxt.getText();
        String name = nametxt.getText();
        String address = addresstxt.getText();
        int mobile = Integer.parseInt(mobiletxt.getText());
        String ingredient = txtIngredient.getText();
        String dateOfPurchase = purchasetxt.getText();
        String AmountDue = AmountDuetxt.getText();
        String dateOfPayment= dataOfPaymenttxt.getText();
        String paymentType = PaymentTypetxt.getText();
        String amountPaid = AmountPaidtxt.getText();


       SupplierModel supplierModel = new SupplierModel(sid,name,address,mobile,ingredient,dateOfPurchase,AmountDue,dateOfPayment,paymentType,amountPaid);
        boolean a = SupplierRepo.saveSupplier(supplierModel);
        System.out.println(a);
        if (a){
            new Alert(Alert.AlertType.CONFIRMATION,"SupplierController saved successfully").show();
        }else {
            new Alert(Alert.AlertType.ERROR,"something went wrong").show();
        }
        Stage stage1 = (Stage) sidtxt.getScene().getWindow();
        stage1.close();
        apane.getChildren().clear();
        apane.getChildren().add(FXMLLoader.load(getClass().getResource("/view/Supplier.fxml")));
    }
    @FXML
    void clearOnAction(ActionEvent event) {
        clear();
    }
    public void clear(){
        sidtxt.clear();
        addresstxt.clear();
        mobiletxt.clear();
        nametxt.clear();
        txtIngredient.clear();
        purchasetxt.clear();
        dataOfPaymenttxt.clear();
        AmountDuetxt.clear();
        PaymentTypetxt.clear();
        AmountPaidtxt.clear();
    }

    @FXML
    void initialize() {

    }




    public void numKeyRelese(KeyEvent keyEvent) {
        Regex.setTextColor(lk.ijse.util.TextField.MOBILE,mobiletxt);

    }
    public void sidKeyRelese(KeyEvent keyEvent) {  Regex.setTextColor(lk.ijse.util.TextField.ID,sidtxt);}

}
