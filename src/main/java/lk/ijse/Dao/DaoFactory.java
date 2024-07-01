package lk.ijse.Dao;

import lk.ijse.BO.Impl.EmployeeBOImpl;
import lk.ijse.BO.Impl.IngredientBOImpl;
import lk.ijse.Dao.Custom.IngredientsDao;
import lk.ijse.Dao.Impl.*;

public class DaoFactory {
    private static DaoFactory daoFactory;

    private DaoFactory() {
    }

    public static DaoFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DaoFactory() : daoFactory;
    }

    public enum DAOTypes {
        CUSTOMER,ITEM,ORDER,ORDER_DETAILS,QUERY_DAO,MEAL,EMPLOYEE,INGREDIENTS,SUPPLIER
    }

    public SuperDao getDAO(DAOTypes types){
        switch (types) {
            case CUSTOMER:
                return new CustomerDaoImpl();
            case MEAL:
                return new MealDaoImpl();
            case EMPLOYEE:
                return new EmployeeDaoImpl();
            case INGREDIENTS:
               return new IngredientDaoImpl();
            case SUPPLIER:
                return new SupplierDaoImpl();
            case ORDER:
                return new OrderDaoImpl();
        }
        return null;
    }
}
