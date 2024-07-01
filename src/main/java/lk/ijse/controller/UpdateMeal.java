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
import lk.ijse.BO.Custom.CustomerBO;
import lk.ijse.BO.Custom.MealBO;
import lk.ijse.Model.MealModel;
import lk.ijse.Repository.MealRepo;

public class UpdateMeal extends MealController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnMeal;

    @FXML
    private Text mid;
    @FXML
    private ImageView pic;


    @FXML
    private TextField midtxt;

    @FXML
    private Text name;


    @FXML
    private Text price;

    @FXML
    private TextField newNametxt;

    @FXML
    private TextField newpricetxt;


    @FXML
    private Text updatemeal;

    @FXML
    private ImageView updatemealpane;

    MealBO mealBO  = (MealBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.MEAL);
    @FXML
    void dontSaveMeal(ActionEvent event) {
        Stage stage =(Stage)midtxt.getScene().getWindow();
        stage.close();
    }

    @FXML
    void updateMeal(ActionEvent event) throws SQLException, ClassNotFoundException {

        String mid = midtxt.getText();
        String name = newNametxt.getText();
        String price = newpricetxt.getText();


        boolean c = mealBO.updateCustomer(new MealModel(mid,name,price));

        if (c) {

            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Success");
            successAlert.setHeaderText(null);
            successAlert.setContentText("MealController details updated successfully.");
            successAlert.showAndWait();

            ((Node) (event.getSource())).getScene().getWindow().hide();
        } else {

            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Error");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Something went wrong.");
            errorAlert.show();
        }
        Stage stage1 = (Stage) midtxt.getScene().getWindow();
        stage1.close();
    }

    @FXML
    void initialize() {
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'updateMeal.fxml'.";
        assert btnMeal != null : "fx:id=\"btnMeal\" was not injected: check your FXML file 'updateMeal.fxml'.";
        assert mid != null : "fx:id=\"mid\" was not injected: check your FXML file 'updateMeal.fxml'.";
        assert midtxt != null : "fx:id=\"midtxt\" was not injected: check your FXML file 'updateMeal.fxml'.";
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'updateMeal.fxml'.";
        assert price != null : "fx:id=\"price\" was not injected: check your FXML file 'updateMeal.fxml'.";
        assert updatemeal != null : "fx:id=\"updatemeal\" was not injected: check your FXML file 'updateMeal.fxml'.";
        assert updatemealpane != null : "fx:id=\"updatemealpane\" was not injected: check your FXML file 'updateMeal.fxml'.";

    }

    public void enterID(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)){
            String id = String.valueOf(midtxt.getText());
            ArrayList<MealModel> mealModels = MealRepo.searchMID(id);

           newNametxt.setText(mealModels.get(0).getName());
           newpricetxt.setText(mealModels.get(0).getPrice());

        }
    }
}
