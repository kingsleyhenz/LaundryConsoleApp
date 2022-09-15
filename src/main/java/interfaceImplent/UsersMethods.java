package interfaceImplent;

import dbconnections.LaundryConnection;
import interfaces.IUserMethods;
import model.ClotheType;
import model.LaundryItems;
import model.Users;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
    public boolean DropClothes(List<LaundryItems> clothes,Users users) {
        String LAUNDRY_INSERT = "Insert into laundry_table (User_Id,Date_Dropped) values(?,?) ";
     if (launder.dbconnection()){
         try {
            prep = launder.getConnections().prepareStatement(LAUNDRY_INSERT);
            prep.setInt(1,users.getUserID());
            prep.setString(2, String.valueOf(LocalDate.now()));
            res = prep.executeQuery();
            if (res.next()){
                int id = res.getInt("id");
                for (int i =0;i< clothes.size();i++){
                    String SECOND_INSERT = "INSERT INTO laundry_items (Laundry_Id, Clothetype, Quantity, Amount) values(?,?,?,?)";
                    prep.clearParameters();
                    LaundryItems cunt = clothes.get(i);
                    prep =  launder.getConnections().prepareStatement(SECOND_INSERT);
                    prep.setInt(1,id);
                    prep.setString(2,cunt.getClothetype());
                    prep.setInt(3,cunt.getQuantity());
                    prep.setInt(4,cunt.getAmount());
                    res = prep.executeQuery();
                }
                return true;
            }
         }catch (Exception e){
                e.printStackTrace();
         }
     }
      return false;
    }

    @Override
    public Users GetUserByEmail(String email) {
        String SELECT = "SELECT * FROM Laundry WHERE Email = ?";
        if (launder.dbconnection()){
            try {
                prep = launder.getConnections().prepareStatement(SELECT);
                prep.setString(1,email);
                res = prep.executeQuery();
                Users user = new Users();
                if (res.next()){
                    user.setUserID(res.getInt("UserID"));
                    user.setFullnamee(res.getString("Fullname"));
                    user.setPhoneNumber(res.getString("Phone_No"));
                    user.setHomeAddress(res.getString("Home_Address"));
                    user.setUserEmail(res.getString("UserEmail"));
            return user;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
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

        String PICKUP = "UPDATE users SET Phone_No = ?, Home_Address = ? WHERE UserID =?";
        String SEARCH = "SELECT * FROM users WHERE UserID = ?";
        String Notification = "";

        if (launder.dbconnection()){
            try {
                prep = launder.getConnections().prepareStatement(SEARCH);
                prep.setInt(1,users.getUserID());
                res = prep.executeQuery();
                if (res.next()){
                    ps = launder.getConnections().prepareStatement(PICKUP);
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
    public String PickUp(int UserID, String confirm) {
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
                    System.out.println("(*) PickUp Aborted (*)");
                }

                if(upd == 0){
                    status ="(*) PickUp Operation Not Successful (*)";
                    return status;
                } else {
                    status="(*) Laundry Has Successfully Been Picked Up (*)";
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return status;
    }
}



