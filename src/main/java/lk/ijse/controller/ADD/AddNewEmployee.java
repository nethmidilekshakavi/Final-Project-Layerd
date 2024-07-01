package lk.ijse.controller.ADD;

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
import javafx.scene.Parent;
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
import lk.ijse.BO.Custom.EmployeeBO;
import lk.ijse.Mail.mail;
import lk.ijse.Model.CustomerModel;
import lk.ijse.Model.EmployeeModel;
import lk.ijse.Repository.CustomerRepo;
import lk.ijse.Repository.EmployeeRepo;
import lk.ijse.util.Regex;

public class AddNewEmployee {
    public static AnchorPane apane;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text CID;

    @FXML
    private Text NIC;

    @FXML
    private ImageView addEmployeePane;

    @FXML
    private Text address;

    @FXML
    private TextField addresstxt;

    @FXML
    private Text birthday;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnSave;

    @FXML
    private TextField daytxt;

    @FXML
    private Text email;

    @FXML
    private TextField emailtxt;

    @FXML
    private TextField fnametxt;

    @FXML
    private TextField lnametxt;


    @FXML
    private TextField eidtxt;


    @FXML
    private Text mobile;

    @FXML
    private TextField mobiletxt;

    @FXML
    private TextField monthtxt;

    @FXML
    private Text name;

    @FXML
    private TextField nictxt;

    @FXML
    private Text personalInformation;

    @FXML
    private Text position;

    @FXML
    private TextField positiontxt;

    @FXML
    private Text salary;

    @FXML
    private TextField salarytxt;

    @FXML
    private TextField yeartxt;

    EmployeeBO employeeBO  = (EmployeeBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.EMPLOYEE);
    @FXML
    void dontSaveEmployee(ActionEvent event) {
        Stage stage =(Stage)eidtxt.getScene().getWindow();
        stage.close();
    }

    @FXML
    void saveEmployee(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        String id=eidtxt.getText();
        String nic= nictxt.getText();
        String finame=fnametxt.getText();
        String laname =lnametxt.getText();
        String address=addresstxt.getText();
        int mobile=Integer.parseInt(mobiletxt.getText());
        String email=emailtxt.getText();
        String salary = salarytxt.getText();
        String position = positiontxt.getText();
        int year = Integer.parseInt(yeartxt.getText());
        int month = Integer.parseInt(monthtxt.getText());
        int Day = Integer.parseInt(daytxt.getText());

       boolean a = employeeBO.saveEmployee(new EmployeeModel(id,nic,finame,laname,address,mobile,email,salary,position,year,month,Day));
        if (a){
          /*  mail mail =new mail();
            mail.setMsg("Hellow now you are a EmployeeController of FOOD COURT RESTURANT" +
                    "\nTime : "+ Time.valueOf(LocalTime.now()) +
                    "\nDate : " + Date.valueOf(LocalDate.now())
            );
            mail.setTo(emailtxt.getText());
            mail.setSubject("Alert");

            Thread thread =new Thread(mail);
            thread.start();*/
            new Alert(Alert.AlertType.CONFIRMATION,"EmployeeController saved successfully").show();
        }else {
            new Alert(Alert.AlertType.ERROR,"something went wrong").show();
        }
        Stage stage1 = (Stage) eidtxt.getScene().getWindow();
        stage1.close();
        apane.getChildren().clear();
        apane.getChildren().add(FXMLLoader.load(getClass().getResource("/view/Employee.fxml")));
    }
    @FXML
    void clearOnAction(ActionEvent event) {
        clear();
    }
    public void clear(){
      nictxt.clear();   emailtxt.clear();
      fnametxt.clear(); positiontxt.clear();
      lnametxt.clear(); salarytxt.clear();
      addresstxt.clear();   monthtxt.clear();
      yeartxt.clear();  daytxt.clear();
      monthtxt.clear(); mobiletxt.clear();
    }


    @FXML
    void initialize() {

    }
    public void eidKeyRelese(KeyEvent keyEvent) {
        Regex.setTextColor(lk.ijse.util.TextField.ID,eidtxt);
    }
    public void lnameKeyRelese(KeyEvent keyEvent) {
        Regex.setTextColor(lk.ijse.util.TextField.LNAME,lnametxt);
    }

    public void numnameKeyRelese(KeyEvent keyEvent) {
        Regex.setTextColor(lk.ijse.util.TextField.MOBILE,mobiletxt);
    }

    public void emailKeyRelese(KeyEvent keyEvent) {
        Regex.setTextColor(lk.ijse.util.TextField.EMAIL,emailtxt);
    }

    public void fnameKeyRelese(KeyEvent keyEvent) {
        Regex.setTextColor(lk.ijse.util.TextField.FNAME,fnametxt);
    }

}
