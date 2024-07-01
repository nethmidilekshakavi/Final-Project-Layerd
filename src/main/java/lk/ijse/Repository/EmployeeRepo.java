package lk.ijse.Repository;

import lk.ijse.DB.DbConnection;
import lk.ijse.Model.CustomerModel;
import lk.ijse.Model.EmployeeModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepo {


  /*  public static boolean saveEmployee(EmployeeModel employeeModel) {
        try {
            Connection connection = DbConnection.getInstance().getConnection();
            PreparedStatement ptsm = connection.prepareStatement("INSERT INTO Employee VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");

            ptsm.setString(1, employeeModel.getE_ID());
            ptsm.setString(2, employeeModel.getNIC());
            ptsm.setString(3, employeeModel.getFirst_Name());
            ptsm.setString(4, employeeModel.getLast_Name());
            ptsm.setString(5, employeeModel.getAddress());
            ptsm.setInt(6, employeeModel.getPhone_Number());
            ptsm.setString(7, employeeModel.getEmail());
            ptsm.setString(8, employeeModel.getSalary());
            ptsm.setString(9, employeeModel.getPosition());
            ptsm.setInt(10,employeeModel.getYear());
            ptsm.setInt(11,employeeModel.getMonth());
            ptsm.setInt(12,employeeModel.getDay());


            int i;
            i = ptsm.executeUpdate();
            return i > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }*/


 /*   public static boolean updateEmployee(EmployeeModel employeeModel) throws SQLException {

        String sql = "UPDATE Employee SET NIC = ? ,First_Name = ?,Last_Name =?,Address = ?,Phone_Number = ?,Email = ?,Salary = ?,Position = ?, year = ?,Month = ?,Day = ? WHERE E_ID = ?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement ptsm = connection.prepareStatement(sql);
        ptsm.setString(1, employeeModel.getNIC());
        ptsm.setString(2, employeeModel.getFirst_Name());
        ptsm.setString(3, employeeModel.getLast_Name());
        ptsm.setString(4, employeeModel.getAddress());
        ptsm.setInt(5, employeeModel.getPhone_Number());
        ptsm.setString(6, employeeModel.getEmail());
        ptsm.setString(7, employeeModel.getSalary());
        ptsm.setString(8, employeeModel.getPosition());
        ptsm.setInt(9,employeeModel.getYear());
        ptsm.setInt(10,employeeModel.getMonth());
        ptsm.setInt(11,employeeModel.getDay());
        ptsm.setString(12, employeeModel.getE_ID());

        return ptsm.executeUpdate() > 0;
    }
*/
   /* public static boolean delete(String eid) throws SQLException {
        try {
            Connection connection = DbConnection.getInstance().getConnection();
            PreparedStatement ptsm = connection.prepareStatement("delete from Employee where E_ID=?");
            ptsm.setString(1, eid);
            int i;
            i = ptsm.executeUpdate();
            return i > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }*/

   /* public static ArrayList<EmployeeModel> searchEID (String eid){
        ArrayList<EmployeeModel> employeeModels = new ArrayList<>();
        try {
            Connection connection = DbConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Employee WHERE E_ID = ?");
            preparedStatement.setString(1,eid);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                EmployeeModel employeeModel = new EmployeeModel(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getInt(6),resultSet.getString(7),resultSet.getString(8),resultSet.getString(9),resultSet.getInt(10),resultSet.getInt(11),resultSet.getInt(12));
                employeeModels.add(employeeModel);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeModels;
    }*/

 /*   public static ArrayList<EmployeeModel> getAll() throws SQLException{
        ArrayList<EmployeeModel>employeeModels = new ArrayList<>();

        try {
            Connection connection = DbConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from Employee");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                EmployeeModel employeeModel = new EmployeeModel(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getInt(6),resultSet.getString(7),resultSet.getString(8),resultSet.getString(9),resultSet.getInt(10),resultSet.getInt(11),resultSet.getInt(12));
                employeeModels.add(employeeModel);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
            return employeeModels;
    }*/

    public static List<String> getIds() throws SQLException {
        String sql = "SELECT E_ID FROM Employee";
        PreparedStatement ptsm = DbConnection.getInstance().getConnection()
                .prepareStatement(sql);

        List<String> idList = new ArrayList<>();

        ResultSet resultSet = ptsm.executeQuery();
        while (resultSet.next()){
            String E_ID = resultSet.getString(1);
            idList.add(E_ID);
        }
        return idList;
    }

    }

















