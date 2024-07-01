package lk.ijse.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class dashboard implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text Customertxt;

    @FXML
    private AnchorPane Emptypane;

    @FXML
    private Button btnReport;

    @FXML
    private Button btncustomer;

    @FXML
    private Button btndashboard;

    @FXML
    private Button btnemployee;

    @FXML
    private Button btningredients;

    @FXML
    private Button btnmeal;

    @FXML
    private Button btnreservation;

    @FXML
    private Button btnsupplier;

    @FXML
    private AnchorPane buttonSet;

    @FXML
    private ImageView customerpic;

    @FXML
    private ImageView dashboardpic;

    @FXML
    private Text dashboardtxt;

    @FXML
    private ImageView employeepic;

    @FXML
    private Text employeetxt;

    @FXML
    private Text ingredienttxt;

    @FXML
    private ImageView ingrepic;

    @FXML
    private Button llogoutbtn;

    @FXML
    private ImageView mealpic;

    @FXML
    private Text mealtxt;

    @FXML
    private ImageView orderpic;

    @FXML
    private ImageView reportpic;

    @FXML
    private Text reporttxt;

    @FXML
    private Text reservationtxt;

    @FXML
    private ImageView supplierpic;

    @FXML
    private Text supplierstxt;

    @FXML
    void EmployeeOnAction(ActionEvent event) throws IOException {
        Parent parent= FXMLLoader.load(getClass().getResource("/view/Employee.fxml"));
        Emptypane.getChildren().setAll(parent);
    }
    @FXML
    void IngredientOnAction(ActionEvent event) throws IOException {
        Parent parent= FXMLLoader.load(getClass().getResource("/view/Ingredients.fxml"));
        Emptypane.getChildren().setAll(parent);
    }
    @FXML
    void MealOnAction(ActionEvent event) throws IOException {
        Parent parent= FXMLLoader.load(getClass().getResource("/view/Meal.fxml"));
        Emptypane.getChildren().setAll(parent);
    }
    @FXML
    void ReportOnAction(ActionEvent event) {

    }
    @FXML
    void ReservationOnAction(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/view/Reservation.fxml"));
        Emptypane.getChildren().setAll(parent);
    }
    @FXML
    void SupplierOnAction(ActionEvent event) throws IOException {
        Parent parent= FXMLLoader.load(getClass().getResource("/view/Supplier.fxml"));
        Emptypane.getChildren().setAll(parent);

    }
    @FXML
    void customerOnAction(ActionEvent event) throws IOException {
        Parent parent= FXMLLoader.load(getClass().getResource("/view/Customer.fxml"));
        Emptypane.getChildren().setAll(parent);

    }
    @FXML
    void dashboardOnAction(ActionEvent event) throws IOException {
       Parent parent = FXMLLoader.load(getClass().getResource("/view/MainForm.fxml"));
       Emptypane.getChildren().setAll(parent);
    }
    @FXML
    void initialize() {
        assert Customertxt != null : "fx:id=\"Customertxt\" was not injected: check your FXML file 'dashboard.fxml'.";
        assert Emptypane != null : "fx:id=\"Emptypane\" was not injected: check your FXML file 'dashboard.fxml'.";
        assert btnReport != null : "fx:id=\"btnReport\" was not injected: check your FXML file 'dashboard.fxml'.";
        assert btncustomer != null : "fx:id=\"btncustomer\" was not injected: check your FXML file 'dashboard.fxml'.";
        assert btndashboard != null : "fx:id=\"btndashboard\" was not injected: check your FXML file 'dashboard.fxml'.";
        assert btnemployee != null : "fx:id=\"btnemployee\" was not injected: check your FXML file 'dashboard.fxml'.";
        assert btningredients != null : "fx:id=\"btningredients\" was not injected: check your FXML file 'dashboard.fxml'.";
        assert btnmeal != null : "fx:id=\"btnmeal\" was not injected: check your FXML file 'dashboard.fxml'.";
        assert btnreservation != null : "fx:id=\"btnreservation\" was not injected: check your FXML file 'dashboard.fxml'.";
        assert btnsupplier != null : "fx:id=\"btnsupplier\" was not injected: check your FXML file 'dashboard.fxml'.";
        assert buttonSet != null : "fx:id=\"buttonSet\" was not injected: check your FXML file 'dashboard.fxml'.";
        assert customerpic != null : "fx:id=\"customerpic\" was not injected: check your FXML file 'dashboard.fxml'.";
        assert dashboardpic != null : "fx:id=\"dashboardpic\" was not injected: check your FXML file 'dashboard.fxml'.";
        assert dashboardtxt != null : "fx:id=\"dashboardtxt\" was not injected: check your FXML file 'dashboard.fxml'.";
        assert employeepic != null : "fx:id=\"employeepic\" was not injected: check your FXML file 'dashboard.fxml'.";
        assert employeetxt != null : "fx:id=\"employeetxt\" was not injected: check your FXML file 'dashboard.fxml'.";
        assert ingredienttxt != null : "fx:id=\"ingredienttxt\" was not injected: check your FXML file 'dashboard.fxml'.";
        assert ingrepic != null : "fx:id=\"ingrepic\" was not injected: check your FXML file 'dashboard.fxml'.";
        assert llogoutbtn != null : "fx:id=\"llogoutbtn\" was not injected: check your FXML file 'dashboard.fxml'.";
        assert mealpic != null : "fx:id=\"mealpic\" was not injected: check your FXML file 'dashboard.fxml'.";
        assert mealtxt != null : "fx:id=\"mealtxt\" was not injected: check your FXML file 'dashboard.fxml'.";
        assert orderpic != null : "fx:id=\"orderpic\" was not injected: check your FXML file 'dashboard.fxml'.";
        assert reportpic != null : "fx:id=\"reportpic\" was not injected: check your FXML file 'dashboard.fxml'.";
        assert reporttxt != null : "fx:id=\"reporttxt\" was not injected: check your FXML file 'dashboard.fxml'.";
        assert reservationtxt != null : "fx:id=\"reservationtxt\" was not injected: check your FXML file 'dashboard.fxml'.";
        assert supplierpic != null : "fx:id=\"supplierpic\" was not injected: check your FXML file 'dashboard.fxml'.";
        assert supplierstxt != null : "fx:id=\"supplierstxt\" was not injected: check your FXML file 'dashboard.fxml'.";

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Parent root =null;
        try {
            root = FXMLLoader.load(getClass().getResource("/view/MainForm.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Emptypane.getChildren().clear();
        Emptypane.getChildren().add(root);
    }
    @FXML
    void logOutTheSystem(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
        Stage stage1 = (Stage)Emptypane.getScene().getWindow();
        stage1.close();

    }

}
