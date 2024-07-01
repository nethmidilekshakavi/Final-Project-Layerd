package lk.ijse.BO.Impl;

import lk.ijse.BO.Custom.PurchaseOrderBO;
import lk.ijse.DB.DbConnection;
import lk.ijse.Dao.Custom.CustomerDao;
import lk.ijse.Dao.Custom.MealDao;
import lk.ijse.Dao.Custom.OrderDao;
import lk.ijse.Dao.DaoFactory;
import lk.ijse.Entity.Meal;
import lk.ijse.Entity.Reservation;
import lk.ijse.Model.MealModel;
import lk.ijse.Model.ReservationModel;

import java.sql.Connection;
import java.sql.SQLException;

public class PurchaseOrderBOImpl implements PurchaseOrderBO {

    CustomerDao customerDao = (CustomerDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DAOTypes.CUSTOMER);

    OrderDao orderDao = (OrderDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DAOTypes.ORDER);

    MealDao mealDao = (MealDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DAOTypes.MEAL);
    @Override
    public String generateOrderID() throws SQLException, ClassNotFoundException {
        return orderDao.generateNewID();
    }


}
