package lk.ijse.Dao.Impl;

import lk.ijse.DB.DbConnection;
import lk.ijse.Dao.Custom.SupplierDao;
import lk.ijse.Dao.SQLUtil;
import lk.ijse.Entity.Supplier;
import lk.ijse.Model.SupplierModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierDaoImpl implements SupplierDao {
    @Override
    public ArrayList<Supplier> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Supplier> allsupplier = new ArrayList<>();
        ResultSet resultSet = SQLUtil.execute("select * from Supplier");
        while (resultSet.next()) {
            Supplier supplier = new Supplier(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8),resultSet.getString(9),resultSet.getString(10));
            allsupplier.add(supplier);
        }
        return allsupplier;
    }

    @Override
    public boolean save(Supplier entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Supplier entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Supplier search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }


    @Override
    public boolean Save(Supplier Entity) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("INSERT INTO Supplier VALUES(?,?,?,?,?,?,?,?,?,?)", Entity.getS_ID(),Entity.getName(),Entity.getAddress(),Entity.getPhone_Number(),Entity.getIngredient(),Entity.getDate_Of_Purchase(),Entity.getAmount_due(),Entity.getDate_of_Payment(),Entity.getPayment_Type(),Entity.getAmount_Paid());

    }

    @Override
    public boolean Update(Supplier Entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE Supplier SET Name = ?, Address = ?,Phone_Number =?, Ingredient =?,Date_Of_Purchase=?,Amount_due=?,Date_of_Payment =?,Payment_Type =?,Amount_Paid =? WHERE S_ID = ?",Entity.getName(),Entity.getAddress(),Entity.getPhone_Number(),Entity.getIngredient(),Entity.getDate_Of_Purchase(),Entity.getAmount_due(),Entity.getDate_of_Payment(),Entity.getPayment_Type(),Entity.getAmount_Paid(),Entity.getS_ID());
    }

    @Override
    public boolean Delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("delete from Supplier where S_ID=?", id);

    }
@Override
    public  ArrayList<SupplierModel> searchSID (String sid){
        ArrayList<SupplierModel> supplierModels = new ArrayList<>();
        try {
            Connection connection = DbConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Supplier WHERE S_ID = ?");
            preparedStatement.setString(1,sid);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                SupplierModel supplierModel = new SupplierModel(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8),resultSet.getString(9),resultSet.getString(10));
                supplierModels.add(supplierModel);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return supplierModels;
    }


}
