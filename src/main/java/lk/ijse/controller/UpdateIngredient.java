package lk.ijse.controller;

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
import lk.ijse.BO.Custom.IngredientBO;
import lk.ijse.Model.CustomerModel;
import lk.ijse.Model.IngredientModel;
import lk.ijse.Repository.CustomerRepo;
import lk.ijse.Repository.IngredientRepo;

public class UpdateIngredient {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text IID;

    @FXML
    private Text NEWIID;
    @FXML
    private ImageView pic;
    @FXML
    private Text QOH;

    @FXML
    private TextField QOHtxt;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnUpdate;

    @FXML
    private Text desc;

    @FXML
    private TextField desctxt;

    @FXML
    private TextField iidtxt;

    @FXML
    private TextField newiddtxt;

    @FXML
    private Text supplier;

    @FXML
    private TextField suppliertxt;

    @FXML
    private ImageView updateIngredientPage;

    @FXML
    private Text updateIngreinfor;

    IngredientBO ingredientBO  = (IngredientBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.INGREDIENT);

    @FXML
    void dontSaveIngredient(ActionEvent event) {
        Stage stage =(Stage)iidtxt.getScene().getWindow();
        stage.close();
    }

    @FXML
    void updateIngredient(ActionEvent event) throws SQLException, ClassNotFoundException {
        String iidd = iidtxt.getText();
        String desc = desctxt.getText();
        String qtyOnHand = QOHtxt.getText();
        String supplier = suppliertxt.getText();

        boolean c = ingredientBO.updateIngredients(new IngredientModel(iidd,desc,qtyOnHand,supplier));

        if (c) {
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Success");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Ingredient details updated successfully.");
            successAlert.showAndWait();

            ((Node) (event.getSource())).getScene().getWindow().hide();
        } else {

            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Error");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Something went wrong.");
            errorAlert.show();
        }
        Stage stage1 = (Stage) iidtxt.getScene().getWindow();
        stage1.close();
    }

    @FXML
    void initialize() {
        assert IID != null : "fx:id=\"IID\" was not injected: check your FXML file 'UpdateIngredient.fxml'.";
        assert NEWIID != null : "fx:id=\"NEWIID\" was not injected: check your FXML file 'UpdateIngredient.fxml'.";
        assert QOH != null : "fx:id=\"QOH\" was not injected: check your FXML file 'UpdateIngredient.fxml'.";
        assert QOHtxt != null : "fx:id=\"QOHtxt\" was not injected: check your FXML file 'UpdateIngredient.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'UpdateIngredient.fxml'.";
        assert btnUpdate != null : "fx:id=\"btnUpdate\" was not injected: check your FXML file 'UpdateIngredient.fxml'.";
        assert desc != null : "fx:id=\"desc\" was not injected: check your FXML file 'UpdateIngredient.fxml'.";
        assert desctxt != null : "fx:id=\"desctxt\" was not injected: check your FXML file 'UpdateIngredient.fxml'.";
        assert iidtxt != null : "fx:id=\"iidtxt\" was not injected: check your FXML file 'UpdateIngredient.fxml'.";
        assert newiddtxt != null : "fx:id=\"newiddtxt\" was not injected: check your FXML file 'UpdateIngredient.fxml'.";
        assert supplier != null : "fx:id=\"supplier\" was not injected: check your FXML file 'UpdateIngredient.fxml'.";
        assert suppliertxt != null : "fx:id=\"suppliertxt\" was not injected: check your FXML file 'UpdateIngredient.fxml'.";
        assert updateIngredientPage != null : "fx:id=\"updateIngredientPage\" was not injected: check your FXML file 'UpdateIngredient.fxml'.";
        assert updateIngreinfor != null : "fx:id=\"updateIngreinfor\" was not injected: check your FXML file 'UpdateIngredient.fxml'.";

    }

    public void idEnter(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)){
            String id = String.valueOf(iidtxt.getText());
            ArrayList<IngredientModel> ingredientModels = IngredientRepo.searchIID(id);

            desctxt.setText(ingredientModels.get(0).getDescription());
            QOHtxt.setText(ingredientModels.get(0).getQty_On_Hand());
            suppliertxt.setText(ingredientModels.get(0).getSupplier());

        }
    }
}
