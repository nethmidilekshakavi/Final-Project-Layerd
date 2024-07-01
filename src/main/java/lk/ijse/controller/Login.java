package lk.ijse.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Login {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView FB;

    @FXML
    private Text ForgotPW;

    @FXML
    private ImageView GOOGLE;

    @FXML
    private ImageView Insterpic;

    @FXML
    private Text OR;

    @FXML
    private Circle c1;

    @FXML
    private Circle c2;

    @FXML
    private Circle c3;

    @FXML
    private Circle c4;

    @FXML
    private Button login;

    @FXML
    private ImageView loginphoto;

    @FXML
    private AnchorPane pane;

    @FXML
    private AnchorPane pane2;

    @FXML
    private Text password;

    @FXML
    private ImageView passwordpic;

    @FXML
    private PasswordField txtpw;

    @FXML
    private TextField txtun;

    @FXML
    private Text username;

    @FXML
    private ImageView usernamepic;

    @FXML
    private ImageView userpic;

    @FXML
    void loginOnAction(ActionEvent event) throws IOException {

            String username = "admin";
            String password = "1234";

            if (txtun.getText().equals(username) && txtpw.getText().equals(password)) {
                // Load the dashboard
                Parent parent = FXMLLoader.load(getClass().getResource("/view/dashboard.fxml"));
                Scene scene = new Scene(parent);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Dashboard");
                stage.show();
                Stage loginStage = (Stage) txtun.getScene().getWindow();
                loginStage.close();
            } else if (!txtun.getText().equals(username) && txtpw.getText().equals(password)) {
                new Alert(Alert.AlertType.INFORMATION, " ⚠\uFE0F Sorry! User ID not found.").show();
            } else if (!txtpw.getText().equals(password) && txtun.getText().equals(username)) {
                new Alert(Alert.AlertType.INFORMATION, "⚠\uFE0F Sorry! Incorrect password.").show();
            }
            else if(!txtun.getText().equals(username) && !txtpw.getText().equals(password)){
                new Alert(Alert.AlertType.INFORMATION, " ⚠\uFE0F Sorry! Incorrect User ID & Password try Again! ").show();
            }
        }



    @FXML
    void initialize() {
        assert FB != null : "fx:id=\"FB\" was not injected: check your FXML file 'Login.fxml'.";
        assert ForgotPW != null : "fx:id=\"ForgotPW\" was not injected: check your FXML file 'Login.fxml'.";
        assert GOOGLE != null : "fx:id=\"GOOGLE\" was not injected: check your FXML file 'Login.fxml'.";
        assert Insterpic != null : "fx:id=\"Insterpic\" was not injected: check your FXML file 'Login.fxml'.";
        assert OR != null : "fx:id=\"OR\" was not injected: check your FXML file 'Login.fxml'.";
        assert c1 != null : "fx:id=\"c1\" was not injected: check your FXML file 'Login.fxml'.";
        assert c2 != null : "fx:id=\"c2\" was not injected: check your FXML file 'Login.fxml'.";
        assert c3 != null : "fx:id=\"c3\" was not injected: check your FXML file 'Login.fxml'.";
        assert c4 != null : "fx:id=\"c4\" was not injected: check your FXML file 'Login.fxml'.";
        assert login != null : "fx:id=\"login\" was not injected: check your FXML file 'Login.fxml'.";
        assert loginphoto != null : "fx:id=\"loginphoto\" was not injected: check your FXML file 'Login.fxml'.";
        assert pane != null : "fx:id=\"pane\" was not injected: check your FXML file 'Login.fxml'.";
        assert pane2 != null : "fx:id=\"pane2\" was not injected: check your FXML file 'Login.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'Login.fxml'.";
        assert passwordpic != null : "fx:id=\"passwordpic\" was not injected: check your FXML file 'Login.fxml'.";
        assert txtpw != null : "fx:id=\"txtpw\" was not injected: check your FXML file 'Login.fxml'.";
        assert txtun != null : "fx:id=\"txtun\" was not injected: check your FXML file 'Login.fxml'.";
        assert username != null : "fx:id=\"username\" was not injected: check your FXML file 'Login.fxml'.";
        assert usernamepic != null : "fx:id=\"usernamepic\" was not injected: check your FXML file 'Login.fxml'.";
        assert userpic != null : "fx:id=\"userpic\" was not injected: check your FXML file 'Login.fxml'.";

    }

}
