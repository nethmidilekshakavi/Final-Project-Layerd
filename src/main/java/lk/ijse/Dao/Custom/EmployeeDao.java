package lk.ijse.Dao.Custom;

import lk.ijse.Dao.CrudDao;
import lk.ijse.Entity.Employee;
import lk.ijse.Model.EmployeeModel;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeDao extends CrudDao<Employee>{

    boolean Save(Employee Entity) throws SQLException, ClassNotFoundException;

    boolean Update(Employee Entity) throws SQLException, ClassNotFoundException;

    boolean Delete(String id) throws SQLException, ClassNotFoundException;

    ArrayList<EmployeeModel> searchEID(String eid);
}
