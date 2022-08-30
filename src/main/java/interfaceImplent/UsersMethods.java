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
    String INSERT = "INSERT INTO users (UserID, Fullname, Phone_No, Home_Address, Clothes_ID, Date_Dropped, Time_Dropped, PickUp_Date, PickUp_Time) VALUES (?,?,?,?,?,?,?,?,?)";
    if(launder.dbconnection()){
        try {
            prep = launder.getConnections().prepareStatement(INSERT);
            prep.setInt(1,users.getUserID());
            prep.setString(2, users.getFullname());
            prep.setLong(3, users.getPhoneNumber());
            prep.setString(4, users.getHomeAddress());
            prep.setInt(5,users.getClothes_ID());
            prep.setString(6, users.getDate_Dropped());
            prep.setString(7, users.getTime_Dropped());
            prep.setString(8, users.getPickUp_Date());
            prep.setString(9, users.getPickUp_Time());

            update = prep.executeUpdate();

            if(update == 0){
                System.out.println("  <<>>  Laundry Not Placed");
                return  false;
            } else{
                System.out.println("<<>> Customer Laundry Has Been Successfully Placed <<>>");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
        return true;
    }

    @Override
    public String cancelService(int UserID, String confirm) {
        return null;
    }


}
