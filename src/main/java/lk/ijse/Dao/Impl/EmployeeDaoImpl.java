package lk.ijse.Dao.Impl;

import lk.ijse.DB.DbConnection;
import lk.ijse.Dao.Custom.EmployeeDao;
import lk.ijse.Dao.SQLUtil;
import lk.ijse.Entity.Employee;
import lk.ijse.Model.EmployeeModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDaoImpl implements EmployeeDao {
  @Override
    public ArrayList<Employee> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Employee> allemployee = new ArrayList<>();
        ResultSet resultSet = SQLUtil.execute("select * from Employee");
        while (resultSet.next()) {
            Employee employee = new Employee(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getInt(6),resultSet.getString(7),resultSet.getString(8),resultSet.getString(9),resultSet.getInt(10),resultSet.getInt(11),resultSet.getInt(12));
            allemployee.add(employee);
        }
        return allemployee;
    }

    @Override
    public boolean save(Employee entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Employee entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Employee search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean Save(Employee Entity) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("INSERT INTO Employee VALUES(?,?,?,?,?,?,?,?,?,?,?,?)", Entity.getE_ID(), Entity.getNIC(), Entity.getFirst_Name(), Entity.getLast_Name(), Entity.getAddress(), Entity.getPhone_Number(), Entity.getEmail(),Entity.getSalary(),Entity.getPosition(),Entity.getYear(),Entity.getMonth(),Entity.getDay());

    }

    @Override
    public boolean Update(Employee Entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE Employee SET NIC = ? ,First_Name = ?,Last_Name =?,Address = ?,Phone_Number = ?,Email = ?,Salary = ?,Position = ?, year = ?,Month = ?,Day = ? WHERE E_ID = ?", Entity.getNIC(), Entity.getFirst_Name(), Entity.getLast_Name(), Entity.getAddress(), Entity.getPhone_Number(), Entity.getEmail(), Entity.getSalary(),Entity.getPosition(),Entity.getYear(),Entity.getMonth(),Entity.getDay(),Entity.getE_ID());
    }

    @Override
    public boolean Delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("delete from Employee where E_ID=?", id);

    }

    @Override
    public  ArrayList<EmployeeModel> searchEID (String eid){
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
    }

}
