package interfaceImplent;

import dbconnections.LaundryConnection;
import interfaces.IAdminMethods;
import model.ClotheType;
import model.DropOff;
import model.Laundry;
import model.Users;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdminMethods implements IAdminMethods {
    PreparedStatement prep;
    ResultSet res;

    LaundryConnection launder = new LaundryConnection();
    @Override
    public List<Users> ViewAllCustomers() {
        List<Users> users = new ArrayList<>();
        List<Laundry> laun = new ArrayList<>();
        String VIEW_ALL = "SELECT users.Fullname, users.Phone_No, users.UserEmail, laundry_table.Laundry_Id, laundry_table.DropOff_Id, laundry_table.Clothetype, laundry_table.Quantity, laundry_table.Amount FROM users INNER JOIN laundry_table ON users.UserID = laundry_table.UserID";
        if (launder.dbconnection()) {
            try {
                prep = launder.getConnections().prepareStatement(VIEW_ALL);
                res = prep.executeQuery();
                while (res.next()){
                    Users users1  = new Users();
                    Laundry laundry = new Laundry();
                    users1.setFullnamee(res.getString("Fullname"));
                    users1.setPhoneNumber(res.getString("Phone_No"));
                    users1.setUserEmail(res.getString("UserEmail"));
                    laundry.setLaundry_ID(res.getInt("Laundry_Id"));
                    laundry.setDropOff_Id(res.getInt("DropOff_Id"));
                    laundry.setClothetype(res.getString("Clothetype"));
                    laundry.setQuantity(res.getInt("Quantity"));
                    laundry.setAmount(res.getInt("Amount"));
                    users.add(users1);
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return users;
    }

    @Override
    public List<ClotheType> ViewClotheList() {
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
    public String UpdateClothesList(ClotheType clothetp) {
        PreparedStatement ps;
        String UPDATE =  "UPDATE clothes SET Clothes_Type = ?, Price = ? WHERE Clothetype_ID = ?";
        String SEARCH = "SELECT * FROM clothes WHERE Clothetype_ID = ?";
        String status = "";
        if (launder.dbconnection()){
            try{
                prep = launder.getConnections().prepareStatement(SEARCH);
                prep.setInt(1 ,clothetp.getClothetype_ID());
                res = prep.executeQuery();
                if(res.next()){
                    ps = launder.getConnections().prepareStatement(UPDATE);
                    ps.setString(1, clothetp.getClothes_Type());
                    ps.setInt(2, clothetp.getPrice());
                    ps.setInt(3, clothetp.getClothetype_ID());
                    int upd = ps.executeUpdate();
                    if(upd == 0){
                        status = "(*) Update Was Not Successful (*)";
                        return status;
                    } else {
                        status = "(*) Update Was Successful (*)";
                    }
                } else{
                    status = "(-) Record not found (-)";
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return status;
    }

    @Override
    public boolean AddNewMaterial(ClotheType clothetp) {
        boolean status = false;
        int update;
        String NEW_ADD = "INSERT INTO clothes (Clothetype_ID, Clothes_Type, Price) VALUES (?,?,?)";
        if(launder.dbconnection()){
            try {
                prep = launder.getConnections().prepareStatement(NEW_ADD);
                prep.setInt(1,clothetp.getClothetype_ID());
                prep.setString(2, clothetp.getClothes_Type());
                prep.setInt(3, clothetp.getPrice());
                update = prep.executeUpdate();

                if(update == 0){
                    System.out.println("(*) New Material Has Not Been Added (*)");
                } else{
                    System.out.println("(*) New Material Has Successfully Been Added (*)");
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return true;
    }


    @Override
    public String RemoveUser(DropOff drop) {
        String REMOVE = "DELETE FROM laundry_table WHERE PickUp_Status = ? ";
        if (launder.dbconnection()){
            try {
                prep = launder.getConnections().prepareStatement(REMOVE);
                prep.setString(1,drop.getPickUp_Status());
                res = prep.executeQuery();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return null;
    }
}
