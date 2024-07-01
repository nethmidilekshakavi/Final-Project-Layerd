package lk.ijse.BO.Impl;

import lk.ijse.BO.Custom.SupplierBO;
import lk.ijse.Dao.Custom.SupplierDao;
import lk.ijse.Dao.DaoFactory;
import lk.ijse.Entity.Supplier;
import lk.ijse.Model.SupplierModel;

import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierBOImpl implements SupplierBO {
    SupplierDao supplierDao = (SupplierDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DAOTypes.SUPPLIER);
    @Override
    public ArrayList<SupplierModel> getAllSupplier() throws SQLException, ClassNotFoundException {
        ArrayList<SupplierModel> allSupplier= new ArrayList<>();
        ArrayList<lk.ijse.Entity.Supplier> all = supplierDao.getAll();
        for (Supplier s : all) {
            allSupplier.add(new SupplierModel(s.getS_ID(),s.getName(),s.getAddress(),s.getPhone_Number(),s.getIngredient(),s.getDate_Of_Purchase(),s.getAmount_due(),s.getDate_of_Payment(),s.getPayment_Type(),s.getAmount_Paid()));
        }
        return allSupplier;
    }
    @Override
    public boolean saveSupplier(SupplierModel entity) throws SQLException, ClassNotFoundException {
        return supplierDao.Save(new Supplier(entity.getS_ID(),entity.getName(),entity.getAddress(),entity.getPhone_Number(),entity.getIngredient(),entity.getDate_Of_Purchase(),entity.getAmount_due(),entity.getDate_of_Payment(),entity.getPayment_Type(),entity.getAmount_Paid()));
    }

    @Override
    public boolean updateSupplier(SupplierModel entity) throws SQLException, ClassNotFoundException {
        return supplierDao.Update(new Supplier(entity.getS_ID(),entity.getName(),entity.getAddress(),entity.getPhone_Number(),entity.getIngredient(),entity.getDate_Of_Purchase(),entity.getAmount_due(),entity.getDate_of_Payment(),entity.getPayment_Type(),entity.getAmount_Paid()));
    }

    @Override
    public boolean deleteSuippler(String id) throws SQLException, ClassNotFoundException {
        return supplierDao.Delete(id);
    }
}
