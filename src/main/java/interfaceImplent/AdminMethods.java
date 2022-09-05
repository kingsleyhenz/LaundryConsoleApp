package interfaceImplent;

import dbconnections.LaundryConnection;
import interfaces.IAdminMethods;
import model.Clothes;
import model.Users;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AdminMethods implements IAdminMethods {
    @Override
    public String ViewAllCustomers(Users users, Clothes clothes) {
        return null;
    }

    @Override
    public String CalculateUsersPrice(Users users, Clothes clothes) {
        return null;
    }

    @Override
    public String SendReminder(Users user) {
        return null;
    }

    @Override
    public String RemoveUser(Users user, String Confirm) {
        return null;
    }
}
