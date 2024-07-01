package lk.ijse.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lk.ijse.BO.BOFactory;
import lk.ijse.BO.Custom.IngredientBO;
import lk.ijse.BO.Custom.MealBO;
import lk.ijse.Model.CustomerModel;
import lk.ijse.Model.IngredientModel;
import lk.ijse.Model.SupplierModel;
import lk.ijse.Repository.CustomerRepo;
import lk.ijse.Repository.IngredientRepo;
import lk.ijse.util.Regex;

public class AddIngredient {
    public static AnchorPane apane;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView AddNewIngredientPage;

    @FXML
    private Text IID;

    @FXML
    private Button clear;

    @FXML
    private TextField iditxt;

    @FXML
    private Text QOH;

    @FXML
    private TextField QOHtxt;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnSave;

    @FXML
    private Text desc;

    @FXML
    private TextField desctxt;

    @FXML
    private Text igreinor;


    @FXML
    private Text supplier;

    @FXML
    private TextField suppliertxt;
    IngredientBO ingredientBO  = (IngredientBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.INGREDIENT);
    @FXML
    void dontSaveIngredient(ActionEvent event) {
        Stage stage =(Stage)iditxt.getScene().getWindow();
        stage.close();
    }

    @FXML
    void saveIngredinet(ActionEvent event) throws SQLException, IOException, ClassNotFoundException {

        String iid = iditxt.getText();
        String desc = desctxt.getText();
        String qoh = QOHtxt.getText();
        String supplier = suppliertxt.getText();


            boolean a = ingredientBO.saveIngredients(new IngredientModel(iid,desc,qoh,supplier));
            if (a) {
                new Alert(Alert.AlertType.CONFIRMATION, "Ingredient saved successfully").show();
                ((Node) (event.getSource())).getScene().getWindow().hide();

            } else {
                new Alert(Alert.AlertType.ERROR, "something went wrong").show();
            }
            Stage stage1 = (Stage) iditxt.getScene().getWindow();
            stage1.close();
        apane.getChildren().clear();
        apane.getChildren().add(FXMLLoader.load(getClass().getResource("/view/Ingredients.fxml")));
        }

    @FXML
    void clearOnAction(ActionEvent event) {
        clear();
    }
    public void clear(){
        iditxt.clear();
       desctxt.clear();
       QOHtxt.clear();
       suppliertxt.clear();
    }



    @FXML
    void initialize() {

    }

    public void iidKeyRelese(KeyEvent keyEvent) {
        Regex.setTextColor(lk.ijse.util.TextField.ID,iditxt);
    }
}
