package lk.ijse.Dao.Custom;

import lk.ijse.Dao.CrudDao;
import lk.ijse.Entity.Customer;
import lk.ijse.Model.CustomerModel;
import lk.ijse.Model.EmployeeModel;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDao extends CrudDao<Customer> {

    boolean Save(Customer Entity) throws SQLException, ClassNotFoundException;

    boolean Update(Customer Entity) throws SQLException, ClassNotFoundException;

    boolean Delete(String id) throws SQLException, ClassNotFoundException;


    ArrayList<String> allcustomerNumber(Customer entity) throws SQLException, ClassNotFoundException;


    ArrayList<Customer> SearchCID(String cid) throws SQLException, ClassNotFoundException;


    ArrayList<Customer> loadAllCustomerNumber() throws SQLException, ClassNotFoundException;


    Customer searchByPhoneNumber(String num) throws SQLException, ClassNotFoundException;

    CustomerModel searchById(String id) throws SQLException;
}

