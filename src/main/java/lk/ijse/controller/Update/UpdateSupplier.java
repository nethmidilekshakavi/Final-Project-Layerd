package lk.ijse.controller.Update;

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
import lk.ijse.BO.Custom.SupplierBO;
import lk.ijse.Model.SupplierModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UpdateSupplier {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField AmountDuetxt;

    @FXML
    private Text AmountPaid;

    @FXML
    private ImageView pic;

    @FXML
    private TextField sidtxt;

    @FXML
    private TextField AmountPaidtxt;

    @FXML
    private TextField PaymentTypetxt;

    @FXML
    private Text SID;

    @FXML
    private Text address;

    @FXML
    private TextField addresstxt;

    @FXML
    private Text amountDue;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnUpdate;

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
    private TextField newSnametxt;

    @FXML
    private TextField purchasetxt;

    @FXML
    private TextField txtIngredient;

    @FXML
    private Text updateEmployeeinfor;

    @FXML
    private ImageView updateSupplierPane;


    SupplierBO supplierBO  = (SupplierBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.SUPPLIER);

    @FXML
    void dontSaveSupplier(ActionEvent event) {
        Stage stage =(Stage)sidtxt.getScene().getWindow();
        stage.close();
    }



    @FXML
    void updateSupplier(ActionEvent event) throws SQLException {

       String sid = sidtxt.getText();
       String newname = newSnametxt.getText();
       String addr = addresstxt.getText();
       int num = Integer.parseInt(mobiletxt.getText());
       String igre = txtIngredient.getText();
       String dopur = purchasetxt.getText();
       String amountdue = AmountDuetxt.getText();
       String dopay = dataOfPaymenttxt.getText();
       String PT = PaymentTypetxt.getText();
       String AP = AmountPaidtxt.getText();


        boolean s = false;
        try {
            s = supplierBO.updateSupplier(new SupplierModel(sid,newname,addr,num,igre,dopur,amountdue,dopay,PT,AP));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        if (s) {

            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Success");
            successAlert.setHeaderText(null);
            successAlert.setContentText("SupplierController details updated successfully.");
            successAlert.showAndWait();

            ((Node) (event.getSource())).getScene().getWindow().hide();
        } else {

            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Error");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Something went wrong.");
            errorAlert.show();
        }
        Stage stage1 = (Stage) sidtxt.getScene().getWindow();
        stage1.close();
    }

    @FXML
    void initialize() {
        assert AmountDuetxt != null : "fx:id=\"AmountDuetxt\" was not injected: check your FXML file 'updateSupplier.fxml'.";
        assert AmountPaid != null : "fx:id=\"AmountPaid\" was not injected: check your FXML file 'updateSupplier.fxml'.";
        assert AmountPaidtxt != null : "fx:id=\"AmountPaidtxt\" was not injected: check your FXML file 'updateSupplier.fxml'.";
        assert PaymentTypetxt != null : "fx:id=\"PaymentTypetxt\" was not injected: check your FXML file 'updateSupplier.fxml'.";
        assert SID != null : "fx:id=\"SID\" was not injected: check your FXML file 'updateSupplier.fxml'.";
        assert address != null : "fx:id=\"address\" was not injected: check your FXML file 'updateSupplier.fxml'.";
        assert addresstxt != null : "fx:id=\"addresstxt\" was not injected: check your FXML file 'updateSupplier.fxml'.";
        assert amountDue != null : "fx:id=\"amountDue\" was not injected: check your FXML file 'updateSupplier.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'updateSupplier.fxml'.";
        assert btnUpdate != null : "fx:id=\"btnUpdate\" was not injected: check your FXML file 'updateSupplier.fxml'.";
        assert dataOfPaymenttxt != null : "fx:id=\"dataOfPaymenttxt\" was not injected: check your FXML file 'updateSupplier.fxml'.";
        assert dateOdPayment != null : "fx:id=\"dateOdPayment\" was not injected: check your FXML file 'updateSupplier.fxml'.";
        assert dateOdPayment1 != null : "fx:id=\"dateOdPayment1\" was not injected: check your FXML file 'updateSupplier.fxml'.";
        assert dateOdPurchase != null : "fx:id=\"dateOdPurchase\" was not injected: check your FXML file 'updateSupplier.fxml'.";
        assert ingredient != null : "fx:id=\"ingredient\" was not injected: check your FXML file 'updateSupplier.fxml'.";
        assert mobile != null : "fx:id=\"mobile\" was not injected: check your FXML file 'updateSupplier.fxml'.";
        assert mobiletxt != null : "fx:id=\"mobiletxt\" was not injected: check your FXML file 'updateSupplier.fxml'.";
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'updateSupplier.fxml'.";
        assert purchasetxt != null : "fx:id=\"purchasetxt\" was not injected: check your FXML file 'updateSupplier.fxml'.";
        assert sidtxt != null : "fx:id=\"sidtxt\" was not injected: check your FXML file 'updateSupplier.fxml'.";
        assert txtIngredient != null : "fx:id=\"txtIngredient\" was not injected: check your FXML file 'updateSupplier.fxml'.";
        assert updateEmployeeinfor != null : "fx:id=\"updateEmployeeinfor\" was not injected: check your FXML file 'updateSupplier.fxml'.";
        assert updateSupplierPane != null : "fx:id=\"updateSupplierPane\" was not injected: check your FXML file 'updateSupplier.fxml'.";

    }

    public void enterid(KeyEvent keyEvent) throws SQLException, ClassNotFoundException {
        if (keyEvent.getCode().equals(KeyCode.ENTER)){
            String id = String.valueOf(sidtxt.getText());
            ArrayList<SupplierModel> supplierModels = supplierBO.serachSID(id);

           newSnametxt.setText(supplierModels.get(0).getName());
           addresstxt.setText(supplierModels.get(0).getAddress());
           mobiletxt.setText(String.valueOf(supplierModels.get(0).getPhone_Number()));
           txtIngredient.setText(supplierModels.get(0).getIngredient());
           purchasetxt.setText(supplierModels.get(0).getDate_Of_Purchase());
           dataOfPaymenttxt.setText(supplierModels.get(0).getDate_of_Payment());
           AmountDuetxt.setText(supplierModels.get(0).getAmount_due());
           PaymentTypetxt.setText(supplierModels.get(0).getPayment_Type());
           AmountPaidtxt.setText(supplierModels.get(0).getAmount_Paid());

        }
    }
}
