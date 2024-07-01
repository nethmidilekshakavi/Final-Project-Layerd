package lk.ijse.BO.Impl;

import lk.ijse.BO.Custom.EmployeeBO;
import lk.ijse.Dao.Custom.EmployeeDao;
import lk.ijse.Dao.DaoFactory;
import lk.ijse.Entity.Employee;
import lk.ijse.Model.EmployeeModel;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeBOImpl implements EmployeeBO {

    EmployeeDao employeeDao = (EmployeeDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DAOTypes.EMPLOYEE);
   @Override
    public ArrayList<EmployeeModel> getAllEmployee() throws SQLException, ClassNotFoundException {
        ArrayList<EmployeeModel> allEmployee= new ArrayList<>();
        ArrayList<Employee> all = employeeDao.getAll();
        for (Employee e : all) {
            allEmployee.add(new EmployeeModel(e.getE_ID(),e.getNIC(),e.getFirst_Name(),e.getLast_Name(),e.getAddress(),e.getPhone_Number(),e.getEmail(),e.getSalary(),e.getPosition(),e.getYear(),e.getMonth(),e.getDay()));
        }
        return allEmployee;
    }
    @Override
    public boolean saveEmployee(EmployeeModel employeeModel) throws SQLException, ClassNotFoundException {
        return employeeDao.Save(new Employee(employeeModel.getE_ID(),employeeModel.getNIC(),employeeModel.getFirst_Name(),employeeModel.getLast_Name(),employeeModel.getAddress(),employeeModel.getPhone_Number(),employeeModel.getEmail(),employeeModel.getSalary(),employeeModel.getPosition(),employeeModel.getYear(),employeeModel.getMonth(),employeeModel.getDay()));
    }

    @Override
    public boolean updateEmployee(EmployeeModel employeeModel) throws SQLException, ClassNotFoundException {
        return employeeDao.update(new Employee(employeeModel.getE_ID(),employeeModel.getNIC(),employeeModel.getFirst_Name(),employeeModel.getLast_Name(),employeeModel.getAddress(),employeeModel.getPhone_Number(),employeeModel.getEmail(),employeeModel.getSalary(),employeeModel.getPosition(),employeeModel.getYear(),employeeModel.getMonth(),employeeModel.getDay()));
    }

    @Override
    public boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException {
        return employeeDao.delete(id);
    }
@Override
    public ArrayList<EmployeeModel> searchEid(String cid) throws SQLException, ClassNotFoundException {
        return employeeDao.searchEID(cid);
    }

}
