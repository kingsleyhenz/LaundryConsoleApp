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
    public String UpdateClothesList(ClotheType clothetp) {
        PreparedStatement ps;

        String UPDATE =  "UPDATE clothes Clothes_Type = ?, Price = ? WHERE Clothetype_ID = ?";
        String SEARCH = "SELECT * FROM clothes WHERE Clothetype_ID = ?";
        String status = "";
        if (launder.dbconnection()){
            try{
                prep = launder.getConnections().prepareStatement(SEARCH);
                prep.setInt(1 ,clothetp.getClothes_ID());
                res = prep.executeQuery();
                if(res.next()){
                    ps = launder.getConnections().prepareStatement(UPDATE);
                    ps.setString(1, clothetp.getClothe_Type());
                    ps.setInt(2, clothetp.getPrice());
                    ps.setInt(3, clothetp.getClothes_ID());

                    int upd = ps.executeUpdate();
                    if(upd == 0){
                        status = "(*) Update Was Not Successful (*)";
                        return status;
                    } else {
                        status = "(*) Update Was Successful (*) ";
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
                prep.setInt(1,clothetp.getClothes_ID());
                prep.setString(2, clothetp.getClothe_Type());
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
    public String RemoveUser(int UserID, String Confirm) {
        String REMOVE = "DELETE FROM Laundry WHERE PickUp_Status = ? ";
        return null;
    }
}
