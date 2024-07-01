package lk.ijse.BO.Custom;

import lk.ijse.BO.SuperBo;
import lk.ijse.Entity.Customer;
import lk.ijse.Model.CustomerModel;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO extends SuperBo {
    ArrayList<CustomerModel> getAllCustomers() throws SQLException, ClassNotFoundException;

    boolean saveCustomer(CustomerModel customerModel) throws SQLException, ClassNotFoundException;

    boolean updateCustomer(CustomerModel customerModel) throws SQLException, ClassNotFoundException;

    boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;


    ArrayList<Customer> serachCID(String cid) throws SQLException, ClassNotFoundException;

    ArrayList<CustomerModel>getAllNumber() throws SQLException, ClassNotFoundException;

}
