package interfaceImplent;

import dbconnections.LaundryConnection;
import interfaces.IAdminMethods;
import model.ClotheType;
import model.Users;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminMethods implements IAdminMethods {
    PreparedStatement prep;
    ResultSet res;

    LaundryConnection launder = new LaundryConnection();
    @Override
    public List<Users> ViewAllCustomers() {
        List<Users> users = new ArrayList<>();
        String VIEW_ALL = "SELECT * FROM users as u JOIN clothes as c ON u.Clothes_Type=c.Clothes_Type ";
        if (launder.dbconnection()){
            try {
                prep = launder.getConnections().prepareStatement(VIEW_ALL);
                res = prep.executeQuery();
                while (res.next()){
                    Users user = new Users();

                    users.add(user);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return users;
    }

    @Override
    public String CalculateUsersPrice() {
        return null;
    }

    @Override
    public String CustomerWithPrice() {
        return null;
    }

    @Override
    public String UpdateUsers() {
        return null;
    }

    @Override
    public String TimeReminder(Users user) {
        return null;
    }

    @Override
    public String RemoveUser(int UserID, String Confirm) {
        return null;
    }
}
