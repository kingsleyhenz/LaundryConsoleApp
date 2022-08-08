package interfaceImplent;

import dbconnections.LaundryConnection;
import interfaces.IUserMethods;
import model.Users;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersMethods implements IUserMethods {
    PreparedStatement prep;
    ResultSet res;

    LaundryConnection launder = new LaundryConnection();

    @Override
    public boolean dropClothes(Users users) {
    boolean status = false;
    int update;
    String INSERT = "INSERT INTO users (UserID, Fullname, Phone_No, Home_Address, No_Of_Clothes) VALUES (?,?,?,?,?)";
    if(launder.dbconnection()){
        try {
            prep = launder.getConnections().prepareStatement(INSERT);
            prep.setInt(1,users.getUserID());
            prep.setString(2, users.getFullname());
            prep.setLong(3, users.getPhoneNumber());
            prep.setString(4, users.getHomeAddress());
            prep.setInt(5, users.getNumberOfClothes());

            update = prep.executeUpdate();

            if(update == 0){
                System.out.println("  <<>>  Laundry Not Placed");
                return  false;
            } else{
                System.out.println("  <<>>  Customer Laundry Has Been Successfully Placed");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
        return true;
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
