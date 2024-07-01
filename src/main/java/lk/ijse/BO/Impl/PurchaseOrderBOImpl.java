package lk.ijse.BO.Impl;

import lk.ijse.BO.Custom.PurchaseOrderBO;
import lk.ijse.Dao.Custom.CustomerDao;
import lk.ijse.Dao.Custom.MealDao;
import lk.ijse.Dao.Custom.OrderDao;
import lk.ijse.Dao.DaoFactory;
import lk.ijse.Entity.Customer;
import lk.ijse.Entity.Meal;
import lk.ijse.Model.CustomerModel;
import lk.ijse.Model.MealModel;

import java.sql.SQLException;
import java.util.ArrayList;

public class PurchaseOrderBOImpl implements PurchaseOrderBO {

    CustomerDao customerDao = (CustomerDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DAOTypes.CUSTOMER);

    OrderDao orderDao = (OrderDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DAOTypes.ORDER);

    MealDao mealDao = (MealDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DAOTypes.MEAL);
    @Override
    public String generateOrderID() throws SQLException, ClassNotFoundException {
        return orderDao.getCurrentId();
    }
    @Override
    public ArrayList<MealModel> getAllMeal() throws SQLException, ClassNotFoundException {
        ArrayList<MealModel> allmeal= new ArrayList<>();
        ArrayList<Meal> all = mealDao.getAll();
        for (Meal c : all) {
            allmeal.add(new MealModel(c.getMID(),c.getName(),c.getPrice()));
        }
        return allmeal;
    }
    @Override
    public boolean saveMeal(MealModel mealModel) throws SQLException, ClassNotFoundException {
        return mealDao.Save(new Meal(mealModel.getMID(),mealModel.getName(),mealModel.getPrice()));
    }

    @Override
    public boolean updateCustomer(MealModel mealModel) throws SQLException, ClassNotFoundException {
        return mealDao.Update(new Meal(mealModel.getMID(),mealModel.getName(),mealModel.getPrice()));
    }

    @Override
    public ArrayList<MealModel> serachMID(String mid) throws SQLException, ClassNotFoundException {
        return mealDao.searchMID(mid);
    }
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
