package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lk.ijse.BO.BOFactory;
import lk.ijse.BO.Custom.CustomerBO;
import lk.ijse.BO.Custom.MealBO;
import lk.ijse.BO.Custom.PurchaseOrderBO;
import lk.ijse.DB.DbConnection;
import lk.ijse.Entity.Customer;
import lk.ijse.Model.*;
import lk.ijse.Model.TM.ReservationTM;
import lk.ijse.Repository.*;
import lombok.SneakyThrows;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class ReservationController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text CNIC;

    @FXML
    private Text QOHtxt;

    @FXML
    private Text RCODE;

    @FXML
    private Text RID;

    @FXML
    private JFXButton btnAddToCart;

    @FXML
    private Button btnPlaceOrder;

    @FXML
    private Button btnnewCID;

    @FXML
    private TableColumn<ReservationTM, String> colcode;

    @FXML
    private TableColumn<ReservationTM, String> coldesc;

    @FXML
    private TableColumn<ReservationTM, String> colprice;

    @FXML
    private TableColumn<ReservationTM, String> colqty;

    @FXML
    private TableColumn<?,?> coltotal;

    @FXML
    private Text cusName;

    @FXML
    private Text date;

    @FXML
    private Text datetxt;

    @FXML
    private Text desc;

    @FXML
    private ImageView itemPic;

    @FXML
    private Text nametxt;

    @FXML
    private JFXComboBox<String> nicList;

    @FXML
    private TableView<ReservationTM> orderTable;

    @FXML
    private ImageView pane;

    @FXML
    private Text price;

    @FXML
    private Text ptxt;

    @FXML
    private Text qty;

    @FXML
    private Text qtyOnHand;

    @FXML
    private TextField qtytxt;

    @FXML
    private TableColumn<ReservationTM, JFXButton> remove;

    @FXML
    private Text reservationIDtxt;

    @FXML
    private JFXComboBox<String> reservationList;

    @FXML
    private Text title;

    @FXML
    private Text total;

    @FXML
    private Text totaltxt;

    @FXML
    private Text txtdesc;
    private ObservableList<ReservationTM> oblist = FXCollections.observableArrayList();

    double netTotal = 0;

    CustomerBO customerBO = (CustomerBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CUSTOMER);
    MealBO mealBO = (MealBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.MEAL);

    PurchaseOrderBO purchaseOrderBO = (PurchaseOrderBO)BOFactory.getBoFactory().getBO(BOFactory.BOTypes.PURCHASEORDER);
    public void initialize() {
        setDate();
        getCurrentOrderId();
        getCustomerIds();
        getItemCodes();
        setCellValueFactory();
    }

    private void setCellValueFactory() {
        colcode.setCellValueFactory(new PropertyValueFactory<>("code"));
        coldesc.setCellValueFactory(new PropertyValueFactory<>("description"));
        colqty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colprice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        coltotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        remove.setCellValueFactory(new PropertyValueFactory<>("Remove"));
    }


//getAllCustomerID
   private void getCustomerIds() {
       try {
           ArrayList<CustomerModel> allcus = purchaseOrderBO.getAllCustomers();
           for (CustomerModel c : allcus) {
               nicList.getItems().add(String.valueOf(c.getC_ID()));
           }

       } catch (SQLException e) {
           throw new RuntimeException(e);
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
   }
//item
    private void getItemCodes() {

        try {
             ArrayList<MealModel> allmeal= purchaseOrderBO.getAllMeal();
            for (MealModel m : allmeal) {
                reservationList.getItems().add(m.getMID());
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

//order
    private void getCurrentOrderId() {
        try {
            String currentId = purchaseOrderBO.generateOrderID();

            String nextOrderId = generateNextOrderId(currentId);
            reservationIDtxt.setText(nextOrderId);

        }  catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private String generateNextOrderId(String currentId) {
        if (currentId != null) {
            String[] split = currentId.split("");
            int idNum = Integer.parseInt(split[1]);
            return "O" + ++idNum;
        }
        return "O01";
    }

    private void setDate() {
        LocalDate now = LocalDate.now();
        date.setText(String.valueOf(now));
    }


    @FXML
    void btnAddToCartOnAction(ActionEvent event) {
        String itemcode = reservationList.getValue();
        String description = txtdesc.getText();
        String qty = qtytxt.getText();
        String unitPrice = ptxt.getText();
        double unit = Double.parseDouble(unitPrice);
        int qtyget = Integer.parseInt(qty);
        double total = unit * qtyget;

        netTotal += total;
        oblist.add(new ReservationTM(itemcode,description,qtyget,unit,total,new JFXButton("Delete")));
        loadTable();
        clearFields();
        setTblAction();
        setNetTotal();
    }

    private void loadTable() {
        orderTable.setItems(oblist);
    }

    private void setNetTotal() {
        totaltxt.setText(String.valueOf(netTotal));
    }

    private void setTblAction() {
        for (int i = 0; i < oblist.size(); i++) {
            int finalI = i;
            double total1 = oblist.get(i).getTotal();
            oblist.get(i).getRemove().setOnAction(event -> {
                oblist.remove(finalI);
                loadTable();
                setTblAction();
                netTotal -= total1;
                setNetTotal();
            });
            oblist.get(i).getRemove().setStyle("-fx-background-color: rgba(175, 108, 108, 1)");
            oblist.get(i).getRemove().setTextFill(Color.WHITE);


        }
    }

    private void clearFields() {
        reservationList.setValue("");
        txtdesc.setText("");
        qtytxt.setText("");
        ptxt.setText("");
    }


    @FXML
    void btnNewCustomerOnAction(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/view/addNewCustomer.fxml"));
        Scene scene =new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Add New CustomerController Form");
        stage.centerOnScreen();
        stage.show();
    }

    @SneakyThrows
    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) {
        String reId = reservationIDtxt.getText();
        String custId ="";
        ArrayList<CustomerModel> all =
        customerBO.getAllCustomers();
        for (int i = 0; i < all.size(); i++) {
            String cid = all.get(i).getC_ID();
            String value = (nicList.getValue());
            if (value == cid){
                custId = all.get(i).getC_ID();
            }
        }

        String date = this.date.getText();
        String des = txtdesc.getText(); // methana haduwa
        String time = String.valueOf(LocalTime.now());


        ReservationModel reservationModel = new ReservationModel(reId,custId,date,des,time,String.valueOf(netTotal));
        ArrayList<ReservationDetailModel> arrayList = new ArrayList<>();
        for (int i = 0; i < oblist.size(); i++) {
            String code = oblist.get(i).getCode();
            String desc = oblist.get(i).getDescription();
            String unitPrice = String.valueOf(oblist.get(i).getUnitPrice());
            String qty1 = String.valueOf(oblist.get(i).getQty());

            ReservationDetailModel reservationDetailModel = new ReservationDetailModel(reId,code,desc,unitPrice,qty1);
            System.out.println(reservationDetailModel);
            arrayList.add(reservationDetailModel);
        }
        boolean b = purchaseOrderBO.setTransaction(reservationModel,arrayList); //trancation
        if (b){
            new Alert(Alert.AlertType.INFORMATION,"Order Placed Successfully!!").show();
            clearAllFields();
        }

    }

    private void clearAllFields() {
        clearFields();
        nicList.setValue("");
        nametxt.setText("");
        String text = reservationIDtxt.getText();
        String[] split = text.split("");
        oblist.clear();
        loadTable();
        int x = Integer.parseInt(split[1]) + 1;
        reservationIDtxt.setText("0"+x);
        totaltxt.setText("");
    }
//customer
    @FXML
    void comboCustomerList(ActionEvent event) {
        String cid = nicList.getValue();
                try{
                    CustomerModel customerModel = customerBO.serachbyIDS(cid);
                    if(customerModel!= null){
                        nametxt.setText(customerModel.getFirst_Name());
                    }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

//meal
    @FXML
    void comboMealList(ActionEvent event) {
        String mid = reservationList.getValue();
        try{
            MealModel mealModel = mealBO.serachbyIDS(mid);
            if(mealModel != null){
                txtdesc.setText(mealModel.getName());
                ptxt.setText(mealModel.getPrice());
            }

            qtytxt.requestFocus();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }



    public void PrintOnAction(ActionEvent actionEvent) throws JRException, SQLException {
        InputStream resourceAsStream = getClass().getResourceAsStream("/Report/Reservation.jrxml");
        JasperDesign load = JRXmlLoader.load(resourceAsStream);
        JasperReport jasperReport = JasperCompileManager.compileReport(load);
        JasperPrint jasperPrint = JasperFillManager.fillReport(
                jasperReport,
                null,
                DbConnection.getInstance().getConnection()
        );

        JasperViewer.viewReport(jasperPrint,false);

}


}



