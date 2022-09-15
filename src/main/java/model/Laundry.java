package model;

public class Laundry {
    private int ID;
    private int UserId;
    private String Date_Dropped;
    private String PickUp_Date;
    private String PickUp_Status;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getDate_Dropped() {
        return Date_Dropped;
    }

    public void setDate_Dropped(String date_Dropped) {
        Date_Dropped = date_Dropped;
    }

    public String getPickUp_Date() {
        return PickUp_Date;
    }

    public void setPickUp_Date(String pickUp_Date) {
        PickUp_Date = pickUp_Date;
    }

    public String getPickUp_Status() {
        return PickUp_Status;
    }

    public void setPickUp_Status(String pickUp_Status) {
        PickUp_Status = pickUp_Status;
    }
}
