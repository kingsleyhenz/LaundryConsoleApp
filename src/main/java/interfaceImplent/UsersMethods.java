package interfaceImplent;

import dbconnections.LaundryConnection;
import interfaces.IUserMethods;
import model.Clothes;
import model.Users;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class UsersMethods implements IUserMethods {
    PreparedStatement prep;
    ResultSet res;

    LaundryConnection launder = new LaundryConnection();


    public boolean Register(Users users) {
        boolean status = false;
        int update;
        String INSERT = "INSERT INTO users (UserID, Fullname, Phone_No, Home_Address, Clothes_ID, No_Of_Clothes, Date_Dropped, Time_Dropped, PickUp_Date, PickUp_Time) VALUES (?,?,?,?,?,?,?,?,?)";
        if(launder.dbconnection()){
            try {
                prep = launder.getConnections().prepareStatement(INSERT);
                prep.setInt(1,users.getUserID());
                prep.setString(2, users.getFullname());
                prep.setLong(3, users.getPhoneNumber());
                prep.setString(4, users.getHomeAddress());
                prep.setInt(5,users.getClothes_ID());
                prep.setInt(6,users.getNo_of_Clothes());
                prep.setString(7, users.getDate_Dropped());
                prep.setString(8, users.getTime_Dropped());
                prep.setString(9, users.getPickUp_Date());
                prep.setString(10, users.getPickUp_Time());

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
    public String ViewClothesTable(Clothes clothes) {
        String DISPLAY = "SELECT * FROM clothes";
        String Message = "<*> The List And Prices Of All Clothing Material <*>";
    if (launder.dbconnection()) {
        try {
            prep = launder.getConnections().prepareStatement(DISPLAY);
            res = prep.executeQuery();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
        return Message;
    }

    @Override
    public String checkPrice(Users users, Clothes clothes) {
        return null;
    }

    @Override
    public String cancelService(int UserID, String confirm) {
        return null;
    }


}
