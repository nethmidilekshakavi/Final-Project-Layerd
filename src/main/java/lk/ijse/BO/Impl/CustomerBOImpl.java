package lk.ijse.BO.Impl;

import lk.ijse.BO.Custom.CustomerBO;
import lk.ijse.Dao.Custom.CustomerDao;
import lk.ijse.Dao.DaoFactory;
import lk.ijse.Entity.Customer;
import lk.ijse.Model.CustomerModel;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {
    CustomerDao customerDao = (CustomerDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DAOTypes.CUSTOMER);

    @Override
    public ArrayList<CustomerModel> getAllCustomers() throws SQLException, ClassNotFoundException {
        ArrayList<CustomerModel> allCustomers = new ArrayList<>();
        ArrayList<Customer> all = customerDao.getAll();
        for (Customer c : all) {
            allCustomers.add(new CustomerModel(c.getC_ID(), c.getNIC(), c.getFirst_Name(), c.getLast_Name(), c.getAddress(), c.getPhone_Number(), c.getEmail()));
        }
        return allCustomers;
    }

    @Override
    public boolean saveCustomer(CustomerModel customerModel) throws SQLException, ClassNotFoundException {
        return customerDao.Save(new Customer(customerModel.getC_ID(), customerModel.getNIC(), customerModel.getFirst_Name(), customerModel.getLast_Name(), customerModel.getAddress(), customerModel.getPhone_Number(), customerModel.getEmail()));
    }

    @Override
    public boolean updateCustomer(CustomerModel customerModel) throws SQLException, ClassNotFoundException {
        return customerDao.Update(new Customer(customerModel.getC_ID(), customerModel.getNIC(), customerModel.getFirst_Name(), customerModel.getLast_Name(), customerModel.getAddress(), customerModel.getPhone_Number(), customerModel.getEmail()));
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDao.Delete(id);
    }

    @Override
    public ArrayList<Customer> serachCID(String cid) throws SQLException, ClassNotFoundException {
        return customerDao.SearchCID(cid);
    }

    //combo eke numbers listr eka
    @Override
    public ArrayList<CustomerModel> getAllNumber() throws SQLException, ClassNotFoundException {
        ArrayList<CustomerModel> allCustomers = new ArrayList<>();
        ArrayList<Customer> all = customerDao.loadAllCustomerNumber();

        for (Customer c : all) {
            allCustomers.add(new CustomerModel(c.getPhone_Number()));
        }
        return allCustomers;

    }




}
