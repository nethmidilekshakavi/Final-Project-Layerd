package lk.ijse.Repository;

import lk.ijse.DB.DbConnection;
import lk.ijse.Model.CustomerModel;
import lk.ijse.Model.MealModel;

import javax.swing.text.html.ImageView;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MealRepo {
  /*  public static boolean saveMeal(MealModel mealModel) throws SQLException {
        try {
            Connection connection = DbConnection.getInstance().getConnection();
            PreparedStatement ptsm = connection.prepareStatement("INSERT INTO Meal VALUES (?,?,?)");
            ptsm.setString(1, mealModel.getMID());
            ptsm.setString(2, mealModel.getName());
            ptsm.setString(3, mealModel.getPrice());

            int i;
            i = ptsm.executeUpdate();
            return i > 0;

        } catch (SQLException e) {
           e.printStackTrace();
        }
        return false;
    }*/

   /* public static boolean updateMeal(MealModel mealModel) throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement( "UPDATE Meal SET Name = ?, Meal_Price = ? WHERE M_ID = ?");

        pstm.setString(1,mealModel.getName());
        pstm.setString(2,mealModel.getPrice());
        pstm.setString(3,mealModel.getMID());

        return pstm.executeUpdate() > 0;
    }*/

  /*  public static boolean delete(String id) throws SQLException {
        try{
            Connection connection= DbConnection.getInstance().getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("delete from Meal where M_ID=?");
            preparedStatement.setString(1,id);
            int i;
            i=preparedStatement.executeUpdate();
            return i > 0;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }*/

   /* public static MealModel searchById(String id) throws SQLException {
        String sql = "SELECT * FROM Meal WHERE M_ID = ?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, id);

        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()) {
            String M_ID = resultSet.getString(1);
            String Name = resultSet.getString(2);
            String  Price = resultSet.getString(3);
         //   String image = String.valueOf((ImageView) resultSet.getBlob(4));
          MealModel mealModel = new MealModel(M_ID,Name,Price);

            return mealModel;
        }

        return null;
    }*/
    /*public static ArrayList<MealModel> getAll() throws SQLException {
        ArrayList<MealModel>mealModel =new ArrayList<>();
      try {
            Connection connection =DbConnection.getInstance().getConnection();
            PreparedStatement preparedStatement =connection.prepareStatement("select * from Meal");
            ResultSet resultSet =preparedStatement.executeQuery();

            while (resultSet.next()){
                MealModel mealModel1=new MealModel(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3));
                mealModel.add(mealModel1);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return mealModel;
    }*/
    public static List<String> getIds() throws SQLException {
        String sql = "SELECT M_ID FROM Meal";
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

    public static ArrayList<MealModel> searchMID (String mid){
        ArrayList<MealModel> mealModels = new ArrayList<>();
        try {
            Connection connection = DbConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Meal WHERE M_ID = ?");
            preparedStatement.setString(1,mid);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                MealModel mealModel = new MealModel(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3));
                mealModels.add(mealModel);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mealModels;
    }

}


