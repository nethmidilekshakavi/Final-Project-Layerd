package lk.ijse.BO;

import lk.ijse.BO.Impl.*;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){
    }
    public static BOFactory getBoFactory(){
        return (boFactory==null)? boFactory=new BOFactory() : boFactory;
    }

    public enum BOTypes{
        CUSTOMER,ITEM,MEAL,EMPLOYEE,INGREDIENT,SUPPLIER,ORDER,PURCHASEORDER
    }

    //Object creation logic for BO objects
    public SuperBo getBO(BOTypes types){
        switch (types){
            case CUSTOMER:
                return new CustomerBOImpl();
            case MEAL:
                return  new MealBOImpl();
            case EMPLOYEE:
                return new EmployeeBOImpl();
            case INGREDIENT:
                return new IngredientBOImpl();
            case SUPPLIER:
                return new SupplierBOImpl();
            case  PURCHASEORDER:
                return new PurchaseOrderBOImpl();

        }
        return null;
    }
}
