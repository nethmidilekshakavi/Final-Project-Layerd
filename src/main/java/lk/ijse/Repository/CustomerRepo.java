package lk.ijse.Repository;

import lk.ijse.DB.DbConnection;
import lk.ijse.Model.CustomerModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerRepo {

   // public static CustomerController searchByContact(String contact) throws SQLException {}


   /* public static boolean updateCustomer(CustomerController customerModel)  {}*/

  //  public static boolean delete(String id) throws SQLException {}


 /*  public static ArrayList<CustomerController> getAll() throws SQLException {}*/


   /* public static ArrayList<CustomerController> searchCID (String cid){
        ArrayList<CustomerController> customerModels = new ArrayList<>();
        try {
            Connection connection = DbConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM CustomerController WHERE C_ID = ?");
            preparedStatement.setString(1,cid);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                CustomerController customerModel = new CustomerController(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getInt(6),resultSet.getString(7));
                customerModels.add(customerModel);
            }

        } catch (SQLException e) {
           e.printStackTrace();
        }
        return customerModels;
    }*/


}








