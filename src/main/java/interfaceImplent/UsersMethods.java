package interfaceImplent;

import dbconnections.LaundryConnection;
import interfaces.IUserMethods;
import model.Users;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsersMethods implements IUserMethods {
    PreparedStatement prep;
    ResultSet res;

    LaundryConnection launder = new LaundryConnection();


    @Override
    public boolean dropClothes(Users users) {
        return false;
    }

    @Override
    public String checkPrice(int UserID) {
        return null;
    }

    @Override
    public String addClothes(Users users) {
        return null;
    }

    @Override
    public String cancelService(int UserID, String confirm) {
        return null;
    }


}
