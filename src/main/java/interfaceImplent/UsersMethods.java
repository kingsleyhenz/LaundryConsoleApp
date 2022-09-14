package interfaceImplent;

import dbconnections.LaundryConnection;
import interfaces.IUserMethods;
import model.ClotheType;
import model.Users;
import model.Clothes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UsersMethods implements IUserMethods {
    PreparedStatement prep;
    ResultSet res;

    LaundryConnection launder = new LaundryConnection();


    public boolean Register(Users users) {
        boolean status = false;
        int update;
        String USER_INFO = "INSERT INTO users (UserID, Fullname, Phone_No, Home_Address, UserEmail) VALUES (?,?,?,?)";
        if(launder.dbconnection()){
            try {
                prep = launder.getConnections().prepareStatement(USER_INFO);
                prep.setInt(1,users.getUserID());
                prep.setString(2, users.getFullname());
                prep.setString(3, users.getPhoneNumber());
                prep.setString(4, users.getHomeAddress());
                prep.setString(5, users.getUserEmail());
                update = prep.executeUpdate();

                if(update == 0){
                    System.out.println("(*) Your Details Were Not Uploaded (*)");
                } else{
                    System.out.println("(*) Your Details Have Successfully Been Uploaded (*)");
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return true;
    }

    @Override
    public boolean DropClothes(Clothes cloth, int Amount) {
        boolean status = false;
        int update = 0;
        String CLOTHE_DETS = "INSERT INTO clothes_type (UserId, Clothe_Id, Clothetype_ID, No_Of_Clothes, Date_Dropped, Time_Dropped) VALUES (?,?,?,?,?)";
        String GetPrice = "SELECT PRICE FROM clothe WHERE Clothetype_ID = ?";
        try {
            prep = launder.getConnections().prepareStatement(CLOTHE_DETS);
            prep.setInt(1,cloth.getUserId());
            prep.setInt(2,cloth.getClothe_Id());
            prep.setInt(3,cloth.getClothetype_Id());
            prep.setInt(4,cloth.getNo_Of_Clothes());
            prep.setString(5,cloth.getDate_Dropped());
            prep.setString(6,cloth.getTime_Dropped());
            prep.setInt(7,cloth.getAmount());
            res = prep.executeQuery();


            if(update == 0){
                System.out.println("(*) Your Laundry Was Not Uploaded (*)");
            } else{
                System.out.println("(*) Your Laundry Has Been Uploaded (*)");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public List<ClotheType> ViewPriceList() {
        List<ClotheType> clothes=new ArrayList<>();
        String DISPLAY = "SELECT * FROM clothes";
    if (launder.dbconnection()) {
        try {
            prep = launder.getConnections().prepareStatement(DISPLAY);
            res = prep.executeQuery();
            while (res.next()){
                ClotheType clothe = new ClotheType();
                clothe.setClothes_ID(res.getInt("Clothes_ID"));
                clothe.setClothe_Type(res.getString("Clothe_Type"));
                clothe.setPrice(res.getInt("Price"));
                clothes.add(clothe);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
        return clothes;
    }


    @Override
    public String UpdateDetails(Users users) {
        PreparedStatement ps;

        String UPDATE = "UPDATE users SET Phone_No = ?, Home_Address = ? WHERE UserID =?";
        String SEARCH = "SELECT * FROM users WHERE UserID = ?";
        String Notification = "";

        if (launder.dbconnection()){
            try {
                prep = launder.getConnections().prepareStatement(SEARCH);
                prep.setInt(1,users.getUserID());
                res = prep.executeQuery();
                if (res.next()){
                    ps = launder.getConnections().prepareStatement(UPDATE);
                    ps.setString(1,users.getPhoneNumber());
                    ps.setString(2, users.getHomeAddress());

                    int update = ps.executeUpdate();
                    if (update == 0){
                        Notification = "(*) Your Update Wasn't Successful (*)";
                        return Notification;
                    }else {
                        Notification = "(*) Your Update Was Successful (*)";
                        return Notification;
                    }
                }else {
                        Notification = "(*) Record Not Found (*)";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return Notification;
    }


    @Override
    public String CancelService(int UserID, String confirm) {
        String status ="";

        int upd =0;
        String Cancel = "DELETE FROM users WHERE UserEmail = ?";
        if(launder.dbconnection()){
            try{
                prep = launder.getConnections().prepareStatement(Cancel);
                prep.setInt(1,UserID);
                if(confirm.equalsIgnoreCase("y")){
                    upd = prep.executeUpdate();
                } else {
                    System.out.println("(*) Operation aborted (*)");
                }

                if(upd == 0){
                    status ="(*) Cancel Operation Not Successful (*)";
                    return status;
                } else {
                    status="(*) Laundry Has Successfully Been Cancelled (*)";
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return status;
    }
}



