package lk.ijse.BO.Custom;

import lk.ijse.BO.SuperBo;
import lk.ijse.Model.EmployeeModel;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeBO extends SuperBo {
    ArrayList<EmployeeModel> getAllEmployee() throws SQLException, ClassNotFoundException;

    boolean saveEmployee(EmployeeModel employeeModel) throws SQLException, ClassNotFoundException;

    boolean updateEmployee(EmployeeModel employeeModel) throws SQLException, ClassNotFoundException;

    boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException;

    ArrayList<EmployeeModel> searchEid(String cid) throws SQLException, ClassNotFoundException;
}
