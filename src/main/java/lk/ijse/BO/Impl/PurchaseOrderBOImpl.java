package lk.ijse.BO.Impl;

import lk.ijse.BO.Custom.PurchaseOrderBO;
import lk.ijse.DB.DbConnection;
import lk.ijse.Dao.Custom.*;
import lk.ijse.Dao.DaoFactory;
import lk.ijse.Entity.*;
import lk.ijse.Model.*;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class PurchaseOrderBOImpl implements PurchaseOrderBO {
    IngredientsDao ingredientsDao = (IngredientsDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DAOTypes.INGREDIENTS);
    CustomerDao customerDao = (CustomerDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DAOTypes.CUSTOMER);
    SupplierDao supplierDao = (SupplierDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DAOTypes.SUPPLIER);
    OrderDao orderDao = (OrderDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DAOTypes.ORDER);
    OrderDetailDao orderDetailDao = (OrderDetailDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DAOTypes.ORDER_DETAILS);
    EmployeeDao employeeDao = (EmployeeDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DAOTypes.EMPLOYEE);
    MealDao mealDao = (MealDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DAOTypes.MEAL);

    @Override
    public String generateOrderID() throws SQLException, ClassNotFoundException {
        return orderDao.getCurrentId();
    }

    @Override
    public ArrayList<Reservation> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Reservation entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Reservation entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Reservation search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(Reservation entity) throws SQLException, ClassNotFoundException {
        return false;
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

    @Override
    public MealModel serachbyIDS(String mid) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<EmployeeModel> getAllEmployee() throws SQLException, ClassNotFoundException {
        ArrayList<EmployeeModel> allEmployee = new ArrayList<>();
        ArrayList<Employee> all = employeeDao.getAll();
        for (Employee e : all) {
            allEmployee.add(new EmployeeModel(e.getE_ID(), e.getNIC(), e.getFirst_Name(), e.getLast_Name(), e.getAddress(), e.getPhone_Number(), e.getEmail(), e.getSalary(), e.getPosition(), e.getYear(), e.getMonth(), e.getDay()));
        }
        return allEmployee;
    }

    @Override
    public boolean saveEmployee(EmployeeModel employeeModel) throws SQLException, ClassNotFoundException {
        return employeeDao.Save(new Employee(employeeModel.getE_ID(), employeeModel.getNIC(), employeeModel.getFirst_Name(), employeeModel.getLast_Name(), employeeModel.getAddress(), employeeModel.getPhone_Number(), employeeModel.getEmail(), employeeModel.getSalary(), employeeModel.getPosition(), employeeModel.getYear(), employeeModel.getMonth(), employeeModel.getDay()));
    }

    @Override
    public boolean updateEmployee(EmployeeModel employeeModel) throws SQLException, ClassNotFoundException {
        return employeeDao.Update(new Employee(employeeModel.getE_ID(), employeeModel.getNIC(), employeeModel.getFirst_Name(), employeeModel.getLast_Name(), employeeModel.getAddress(), employeeModel.getPhone_Number(), employeeModel.getEmail(), employeeModel.getSalary(), employeeModel.getPosition(), employeeModel.getYear(), employeeModel.getMonth(), employeeModel.getDay()));
    }

    @Override
    public boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException {
        return employeeDao.Delete(id);
    }

    @Override
    public ArrayList<EmployeeModel> searchEid() throws SQLException, ClassNotFoundException {
        return searchEid(null);
    }

    @Override
    public ArrayList<EmployeeModel> searchEid(String cid) throws SQLException, ClassNotFoundException {
        return employeeDao.searchEID(cid);
    }

    @Override
    public ArrayList<IngredientModel> getAllIngredients() throws SQLException, ClassNotFoundException {
        ArrayList<IngredientModel> allIngredient = new ArrayList<>();
        ArrayList<Ingredient> all = ingredientsDao.getAll();
        for (Ingredient i : all) {
            allIngredient.add(new IngredientModel(i.getI_ID(), i.getDescription(), i.getQty_On_Hand(), i.getSupplier()));
        }
        return allIngredient;
    }

    @Override
    public boolean saveIngredients(IngredientModel entity) throws SQLException, ClassNotFoundException {
        return ingredientsDao.Save(new Ingredient(entity.getI_ID(), entity.getDescription(), entity.getQty_On_Hand(), entity.getSupplier()));
    }

    @Override
    public boolean updateIngredients(IngredientModel entity) throws SQLException, ClassNotFoundException {
        return ingredientsDao.Update(new Ingredient(entity.getI_ID(), entity.getDescription(), entity.getQty_On_Hand(), entity.getSupplier()));
    }

    @Override
    public boolean deleteIngredients(String id) throws SQLException, ClassNotFoundException {
        return ingredientsDao.Delete(id);
    }

    @Override
    public ArrayList<IngredientModel> serachIID(String iid) throws SQLException, ClassNotFoundException {
        return ingredientsDao.searchIID(iid);
    }

    @Override
    public ArrayList<MealModel> getAllMeal() throws SQLException, ClassNotFoundException {
        ArrayList<MealModel> allmeal = new ArrayList<>();
        ArrayList<Meal> all = mealDao.getAll();
        for (Meal c : all) {
            allmeal.add(new MealModel(c.getMID(), c.getName(), c.getPrice()));
        }
        return allmeal;
    }

    @Override
    public boolean saveMeal(MealModel mealModel) throws SQLException, ClassNotFoundException {
        return mealDao.Save(new Meal(mealModel.getMID(), mealModel.getName(), mealModel.getPrice()));
    }

    @Override
    public boolean updateCustomer(MealModel mealModel) throws SQLException, ClassNotFoundException {
        return mealDao.Update(new Meal(mealModel.getMID(), mealModel.getName(), mealModel.getPrice()));
    }

    @Override
    public ArrayList<MealModel> serachMID(String mid) throws SQLException, ClassNotFoundException {
        return mealDao.searchMID(mid);
    }

    @Override
    public ArrayList<SupplierModel> getAllSupplier() throws SQLException, ClassNotFoundException {
        ArrayList<SupplierModel> allSupplier = new ArrayList<>();
        ArrayList<lk.ijse.Entity.Supplier> all = supplierDao.getAll();
        for (Supplier s : all) {
            allSupplier.add(new SupplierModel(s.getS_ID(), s.getName(), s.getAddress(), s.getPhone_Number(), s.getIngredient(), s.getDate_Of_Purchase(), s.getAmount_due(), s.getDate_of_Payment(), s.getPayment_Type(), s.getAmount_Paid()));
        }
        return allSupplier;
    }

    @Override
    public boolean saveSupplier(SupplierModel entity) throws SQLException, ClassNotFoundException {
        return supplierDao.Save(new Supplier(entity.getS_ID(), entity.getName(), entity.getAddress(), entity.getPhone_Number(), entity.getIngredient(), entity.getDate_Of_Purchase(), entity.getAmount_due(), entity.getDate_of_Payment(), entity.getPayment_Type(), entity.getAmount_Paid()));
    }

    @Override
    public boolean updateSupplier(SupplierModel entity) throws SQLException, ClassNotFoundException {
        return supplierDao.Update(new Supplier(entity.getS_ID(), entity.getName(), entity.getAddress(), entity.getPhone_Number(), entity.getIngredient(), entity.getDate_Of_Purchase(), entity.getAmount_due(), entity.getDate_of_Payment(), entity.getPayment_Type(), entity.getAmount_Paid()));
    }

    @Override
    public boolean deleteSuippler(String id) throws SQLException, ClassNotFoundException {
        return supplierDao.Delete(id);
    }

    @Override
    public ArrayList<SupplierModel> serachSID(String sid) throws SQLException, ClassNotFoundException {
        return supplierDao.searchSID(sid);
    }

    @Override
    @SneakyThrows
    public boolean setTransaction(ReservationModel reservationModel, ArrayList<ReservationDetailModel> arrayList) {
        Connection connection = DbConnection.getInstance().getConnection();
        connection.setAutoCommit(false);


        boolean b2 = orderDao.add(new Reservation(reservationModel.getRID(), reservationModel.getCID(), reservationModel.getDate(), reservationModel.getDescription(), reservationModel.getTime(), reservationModel.getTotal()));
        if (!b2) {
            connection.rollback();
            connection.setAutoCommit(true);
            return false;
        }

        PreparedStatement ptsm2;

        for (int j = 0; j < arrayList.size(); j++) {
            ptsm2= connection.prepareStatement("INSERT INTO Reservation_Details VALUES(?, ?, ?, ?)");
            ptsm2.setObject(1,arrayList.get(j).getQty());
            ptsm2.setObject(2,arrayList.get(j).getUnitPrice());
            ptsm2.setObject(3,arrayList.get(j).getRid());
            ptsm2.setObject(4,arrayList.get(j).getMid());

            int i1 = ptsm2.executeUpdate();
        }

            Meal meal = new Meal();
            boolean b = mealDao.update(new Meal(meal.getMID(), meal.getName(), meal.getPrice()));

            if (!b) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }

            connection.commit();
            connection.setAutoCommit(true);
            return true;

        }

    }


