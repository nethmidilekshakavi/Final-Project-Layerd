package lk.ijse.Dao.Impl;

import lk.ijse.DB.DbConnection;
import lk.ijse.Dao.Custom.CustomerDao;
import lk.ijse.Dao.SQLUtil;
import lk.ijse.Entity.Customer;
import lk.ijse.Model.EmployeeModel;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Customer> allCustomers = new ArrayList<>();
        ResultSet resultSet = SQLUtil.execute("select * from Customer");
        while (resultSet.next()) {
            Customer customer = new Customer(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getInt(6), resultSet.getString(7));
            allCustomers.add(customer);
        }
        return allCustomers;
    }

    @Override
    public boolean save(Customer entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Customer entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Customer search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean Save(Customer Entity) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("INSERT INTO Customer VALUES(?, ?, ?, ?,?,?,?)", Entity.getC_ID(), Entity.getNIC(), Entity.getFirst_Name(), Entity.getLast_Name(), Entity.getAddress(), Entity.getPhone_Number(), Entity.getEmail());

    }

    @Override
    public boolean Update(Customer Entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE Customer SET NIC = ?, First_Name = ?, Last_Name = ?, Address = ?  , Email = ?, Phone_Number = ?  WHERE C_ID = ?",Entity.getC_ID(), Entity.getNIC(), Entity.getFirst_Name(), Entity.getLast_Name(), Entity.getAddress(), Entity.getPhone_Number(), Entity.getEmail());
    }

    @Override
    public boolean Delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("Delete from Customer where C_ID=?", id);

    }

    @Override
    public ArrayList<String> allcustomerNumber(Customer entity) throws SQLException, ClassNotFoundException {
        return null;
    }


    @Override
    public ArrayList<Customer> SearchCID(String cid) throws SQLException, ClassNotFoundException {
        ArrayList<Customer> customerModels = new ArrayList<>();
        try {
            Connection connection = DbConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Customer WHERE C_ID = ?");
            preparedStatement.setString(1, cid);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Customer customer = new Customer(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getInt(6), resultSet.getString(7));
                customerModels.add(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerModels;
    }

    @Override
    public ArrayList<Customer> loadAllCustomerNumber() throws SQLException, ClassNotFoundException {
        return null;
    }


    @Override
    public Customer searchByPhoneNumber(String num) throws SQLException, ClassNotFoundException {
        ResultSet rst  = SQLUtil.execute("SELECT * FROM Customer WHERE Phone_Number = ?",num+"");
        rst.next();
        return new Customer(num + "", rst.getString(3));
    }

}



