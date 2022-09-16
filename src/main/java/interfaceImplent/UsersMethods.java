package interfaceImplent;

import dbconnections.LaundryConnection;
import interfaces.IUserMethods;
import model.ClotheType;
import model.DropOff;
import model.Laundry;
import model.Users;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class UsersMethods implements IUserMethods {
    PreparedStatement prep;
    ResultSet res;

    LaundryConnection launder = new LaundryConnection();


    public boolean Register(Users users) {
        boolean status = false;
        int update;
        String USER_INFO = "INSERT INTO users (UserID, Fullname, Phone_No, Home_Address, UserEmail) VALUES (?,?,?,?,?)";
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
    public boolean DropClothes(DropOff drop) {
        int update;
        String Drop = "INSERT INTO dropoff (DropOff_Id, UserID, Date_Dropped, Time_Dropped, PickUp_Date, PickUp_Time) VALUES (?,?,?,?,?,?)";
        if (launder.dbconnection()){
            try {
                prep = launder.getConnections().prepareStatement(Drop);
                prep.setInt(1,drop.getDropOff_ID());
                prep.setInt(2,drop.getUserId());
                prep.setString(3, drop.getDate_Dropped());
                prep.setString(4,drop.getTime_Dropped());
                prep.setString(5, drop.getPickUp_Date());
                prep.setString(6,drop.getPickUp_Time());
                update = prep.executeUpdate();

                if(update == 0){
                    System.out.println("(*) Drop Off Was Not Successful (*)");
                } else{
                    System.out.println("(*) Success!! (*)");
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return true;
    }

    @Override
    public boolean CompleteReg(Laundry laundry) {
        int update;
        String Complete = "INSERT INTO laundry_table (Laundry_Id, UserID, DropOff_Id, Clothetype, Quantity, Amount) VALUES (?,?,?,?,?,?)";
        if (launder.dbconnection()){
            try {
                prep = launder.getConnections().prepareStatement(Complete);
                prep.setInt(1,laundry.getLaundry_ID());
                prep.setInt(2,laundry.getUser_Id());
                prep.setInt(3,laundry.getDropOff_Id());
                prep.setString(4, laundry.getClothetype());
                prep.setInt(5,laundry.getQuantity());
                prep.setInt(6,laundry.getAmount());
                update = prep.executeUpdate();

                if(update == 0){
                    System.out.println("(*) You've Not Been Successfully Registered (*)");
                } else{
                    System.out.println("(*) You Have Been Successfully Registered (*)");
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List<ClotheType> ViewPriceList() {
        List<ClotheType> clothes = new ArrayList<>();
        String DISPLAY = "SELECT * FROM clothes";
    if (launder.dbconnection()) {
        try {
            prep = launder.getConnections().prepareStatement(DISPLAY);
            res = prep.executeQuery();
            while (res.next()){
                ClotheType clothe = new ClotheType();
                clothe.setClothetype_ID(res.getInt("Clothetype_ID"));
                clothe.setClothes_Type(res.getString("Clothes_Type"));
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
        String PICKUP = "UPDATE users SET Phone_No = ?, Home_Address = ? WHERE UserID =?";
        String SEARCH = "SELECT * FROM users WHERE UserID = ?";
        String Notification = "";
        if (launder.dbconnection()){
            try {
                 prep.setInt(1,users.getUserID());
                res = prep.executeQuery();
                if (res.next()){
                    ps = launder.getConnections().prepareStatement(PICKUP);
                    ps.setString(1,users.getPhoneNumber());
                    ps.setString(2, users.getHomeAddress());
                    ps.setInt(3,users.getUserID());

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
    public String UpdateYourDeliveryDateAndTime(DropOff drop) {
        PreparedStatement ps;

        String DateAndTime = "UPDATE dropoff SET PickUp_Date = ?, PickUP_Time = ? WHERE DropOff_Id =?";
        String SEARCH = "SELECT * FROM users WHERE DropOff_Id = ?";
        String Notification = "";
        if (launder.dbconnection()){
            try {
                prep.setInt(1,drop.getDropOff_ID());
                res = prep.executeQuery();
                if (res.next()){
                    ps = launder.getConnections().prepareStatement(DateAndTime);
                    ps.setString(1,drop.getPickUp_Date());
                    ps.setString(2, drop.getPickUp_Time());

                    int update = ps.executeUpdate();
                    if (update == 0){
                        Notification = "(*) Your Laundry PickUp Date And Time Were Not Updated (*)";
                        return Notification;
                    }else {
                        Notification = "(*) Success!! (*)";
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
    public String PickUp(DropOff drop) {
        PreparedStatement ps;
        String status ="";
        String PickUp = "UPDATE dropoff SET Pickup_Status = ? WHERE DropOff_Id = ?";
        String SEARCH = "SELECT * FROM dropoff WHERE DropOff_Id = ?";
        if(launder.dbconnection()){
            try{
                prep = launder.getConnections().prepareStatement(SEARCH);
                prep.setInt(1,drop.getDropOff_ID());
                res = prep.executeQuery();
                if(res.next()){
                   ps = launder.getConnections().prepareStatement(PickUp);
                   ps.setString(1, drop.getPickUp_Status());
                   ps.setInt(2,drop.getDropOff_ID());
                    int upd = ps.executeUpdate();
                    if(upd == 0){
                        status = "): Unable To Process Request :(";
                        return status;
                    } else {
                        status = "(: Thank You For Choosing Us :)";
                    }
                } else{
                    status = "|: Record not found :|";
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return status;
    }
}



