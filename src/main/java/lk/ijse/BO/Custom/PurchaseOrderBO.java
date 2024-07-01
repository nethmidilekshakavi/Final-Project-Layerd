package lk.ijse.BO.Custom;

import lk.ijse.BO.SuperBo;
import lk.ijse.Entity.Customer;
import lk.ijse.Model.CustomerModel;
import lk.ijse.Model.MealModel;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PurchaseOrderBO extends SuperBo {
    String generateOrderID() throws SQLException, ClassNotFoundException;


    ArrayList<MealModel> getAllMeal() throws SQLException, ClassNotFoundException;

    boolean saveMeal(MealModel mealModel) throws SQLException, ClassNotFoundException;

    boolean updateCustomer(MealModel mealModel) throws SQLException, ClassNotFoundException;

    ArrayList<CustomerModel> getAllCustomers() throws SQLException, ClassNotFoundException;

    boolean saveCustomer(CustomerModel customerModel) throws SQLException, ClassNotFoundException;

    boolean updateCustomer(CustomerModel customerModel) throws SQLException, ClassNotFoundException;

    boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;

    ArrayList<MealModel> serachMID(String mid) throws SQLException, ClassNotFoundException;

    ArrayList<Customer> serachCID(String cid) throws SQLException, ClassNotFoundException;

    //combo eke numbers listr eka
    ArrayList<CustomerModel> getAllNumber() throws SQLException, ClassNotFoundException;
}
