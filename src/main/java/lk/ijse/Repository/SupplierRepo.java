package lk.ijse.Repository;

import lk.ijse.DB.DbConnection;
import lk.ijse.Model.CustomerModel;
import lk.ijse.Model.MealModel;
import lk.ijse.Model.SupplierModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierRepo {

  /*  public static boolean saveSupplier(SupplierModel supplierModel) throws SQLException {
        try {
            Connection connection = DbConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement("INSERT INTO Supplier VALUES (?,?,?,?,?,?,?,?,?,?)");
            pstm.setString(1, supplierModel.getS_ID());
            pstm.setString(2, supplierModel.getName());
            pstm.setString(3, supplierModel.getAddress());
            pstm.setInt(4, supplierModel.getPhone_Number());
            pstm.setString(5, supplierModel.getIngredient());
            pstm.setString(6, supplierModel.getDate_Of_Purchase());
            pstm.setString(7, supplierModel.getAmount_due());
            pstm.setString(8, supplierModel.getDate_of_Payment());
            pstm.setString(9, supplierModel.getPayment_Type());
            pstm.setString(10, supplierModel.getAmount_Paid());

            int i;
            i = pstm.executeUpdate();
            return i > 0;
        } catch (SQLException e) {
           e.printStackTrace();
        }
        return false;
    }*/

  /*  public static boolean updateSupplier(SupplierModel supplierModel) throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE Supplier SET Name = ?, Address = ?,Phone_Number =?, Ingredient =?,Date_Of_Purchase=?,Amount_due=?,Date_of_Payment =?,Payment_Type =?,Amount_Paid =? WHERE S_ID = ?");
        pstm.setString(1,supplierModel.getName());
        pstm.setString(2,supplierModel.getAddress());
        pstm.setInt(3,supplierModel.getPhone_Number());
        pstm.setString(4,supplierModel.getIngredient());
        pstm.setString(5,supplierModel.getDate_Of_Purchase());
        pstm.setString(6,supplierModel.getAmount_due());
        pstm.setString(7,supplierModel.getDate_of_Payment());
        pstm.setString(8,supplierModel.getPayment_Type());
        pstm.setString(9,supplierModel.getAmount_Paid());
        pstm.setString(10,supplierModel.getS_ID());

        return pstm.executeUpdate() > 0;
    }*/

 /*   public static boolean delete(String id) throws SQLException {
        try{
            Connection connection= DbConnection.getInstance().getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("delete from Supplier where S_ID=?");
            preparedStatement.setString(1,id);
            int i;
            i=preparedStatement.executeUpdate();
            return i > 0;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }*/

    public static SupplierModel searchById(String id) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Supplier WHERE S_ID = ?");
        pstm.setString(1, id);

        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()) {
            String S_ID = resultSet.getString(1);
            String name = resultSet.getString(2);
            String address = resultSet.getString(3);
            int mobile = resultSet.getInt(4);
            String ingredient = resultSet.getString(5);
            String DateOfPurchase = resultSet.getString(6);
            String amountDue = resultSet.getString(7);
            String dateOfPayment = resultSet.getString(8);
            String paymetType = resultSet.getString(9);
            String AmountPaid = resultSet.getString(10);

          SupplierModel supplierModel =  new SupplierModel(S_ID,name,address,mobile,ingredient,DateOfPurchase,amountDue,dateOfPayment,paymetType,AmountPaid);

          return supplierModel;
        }
        return null;
    }

 /*   public static ArrayList<SupplierModel> getAll() throws SQLException {
        ArrayList<SupplierModel>supplierModels =new ArrayList<>();
        try{
            Connection connection =DbConnection.getInstance().getConnection();
            PreparedStatement preparedStatement =connection.prepareStatement("select * from Supplier");
            ResultSet resultSet =preparedStatement.executeQuery();

            while (resultSet.next()){
                SupplierModel supplierModel =new SupplierModel(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8),resultSet.getString(9),resultSet.getString(10));
                supplierModels.add(supplierModel);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return supplierModels;
    }*/

    public static List<String> getIds() throws SQLException {
        String sql = "SELECT S_ID FROM Supplier";
        PreparedStatement pstm = DbConnection.getInstance().getConnection()
                .prepareStatement(sql);

        List<String> idList = new ArrayList<>();

        ResultSet resultSet = pstm.executeQuery();
        while (resultSet.next()) {
            String id = resultSet.getString(1);
            idList.add(id);
        }
        return idList;
    }
    public static ArrayList<SupplierModel> searchSID (String sid){
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
