package lk.ijse.BO.Custom;

import lk.ijse.BO.SuperBo;
import lk.ijse.Entity.Meal;
import lk.ijse.Model.MealModel;

import java.sql.SQLException;
import java.util.ArrayList;

public interface MealBO extends SuperBo {
    ArrayList<MealModel> getAllMeal() throws SQLException, ClassNotFoundException;

    boolean saveMeal(MealModel mealModel) throws SQLException, ClassNotFoundException;

    boolean updateCustomer(MealModel mealModel) throws SQLException, ClassNotFoundException;

    boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;

    Meal serchbyIDS(String code) throws SQLException, ClassNotFoundException;
}
