package lk.ijse.BO.Custom;

import lk.ijse.BO.SuperBo;
import lk.ijse.Entity.Customer;
import lk.ijse.Entity.Reservation;
import lk.ijse.Model.*;
import lombok.SneakyThrows;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PurchaseOrderBO extends SuperBo {
    String generateOrderID() throws SQLException, ClassNotFoundException;

    ArrayList<Reservation> getAll() throws SQLException, ClassNotFoundException;

    boolean save(Reservation entity) throws SQLException, ClassNotFoundException;

    boolean update(Reservation entity) throws SQLException, ClassNotFoundException;

    boolean delete(String id) throws SQLException, ClassNotFoundException;

    Reservation search(String id) throws SQLException, ClassNotFoundException;

    boolean add(Reservation entity) throws SQLException, ClassNotFoundException;

    ArrayList<EmployeeModel> getAllEmployee() throws SQLException, ClassNotFoundException;

    boolean saveEmployee(EmployeeModel employeeModel) throws SQLException, ClassNotFoundException;

    boolean updateEmployee(EmployeeModel employeeModel) throws SQLException, ClassNotFoundException;

    boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException;

    ArrayList<EmployeeModel> searchEid() throws SQLException, ClassNotFoundException;

    ArrayList<EmployeeModel> searchEid(String cid) throws SQLException, ClassNotFoundException;

    ArrayList<IngredientModel> getAllIngredients() throws SQLException, ClassNotFoundException;

    boolean saveIngredients(IngredientModel entity) throws SQLException, ClassNotFoundException;

    boolean updateIngredients(IngredientModel entity) throws SQLException, ClassNotFoundException;

    boolean deleteIngredients(String id) throws SQLException, ClassNotFoundException;

    ArrayList<IngredientModel> serachIID(String iid) throws SQLException, ClassNotFoundException;

    ArrayList<MealModel> getAllMeal() throws SQLException, ClassNotFoundException;

    boolean saveMeal(MealModel mealModel) throws SQLException, ClassNotFoundException;

    boolean updateCustomer(MealModel mealModel) throws SQLException, ClassNotFoundException;

    ArrayList<CustomerModel> getAllCustomers() throws SQLException, ClassNotFoundException;

    boolean saveCustomer(CustomerModel customerModel) throws SQLException, ClassNotFoundException;

    boolean updateCustomer(CustomerModel customerModel) throws SQLException, ClassNotFoundException;

    boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;

    ArrayList<MealModel> serachMID(String mid) throws SQLException, ClassNotFoundException;

    ArrayList<Customer> serachCID(String cid) throws SQLException, ClassNotFoundException;

    //combo eke numbers listr eka
    ArrayList<CustomerModel> getAllNumber() throws SQLException, ClassNotFoundException;

    MealModel serachbyIDS(String mid) throws SQLException, ClassNotFoundException;

    ArrayList<SupplierModel> getAllSupplier() throws SQLException, ClassNotFoundException;

    boolean saveSupplier(SupplierModel entity) throws SQLException, ClassNotFoundException;

    boolean updateSupplier(SupplierModel entity) throws SQLException, ClassNotFoundException;

    boolean deleteSuippler(String id) throws SQLException, ClassNotFoundException;

    ArrayList<SupplierModel> serachSID(String sid) throws SQLException, ClassNotFoundException;


    @SneakyThrows
    boolean setTransaction(ReservationModel reservationModel, ArrayList<ReservationDetailModel> arrayList);
}
