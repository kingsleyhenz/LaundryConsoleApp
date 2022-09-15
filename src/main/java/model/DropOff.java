package model;

public class DropOff {
    private int DropOff_ID;
    private int UserId;
    private String Date_Dropped;
    private String Time_Dropped;
    private String PickUp_Date;
    private String PickUp_Time;
    private String PickUp_Status;

    public int getDropOff_ID() {
        return DropOff_ID;
    }

    public void setDropOff_ID(int dropOff_ID) {
        this.DropOff_ID = dropOff_ID;
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

    public String getTime_Dropped() {
        return Time_Dropped;
    }

    public void setTime_Dropped(String time_Dropped) {
        Time_Dropped = time_Dropped;
    }

    public String getPickUp_Date() {
        return PickUp_Date;
    }

    public void setPickUp_Date(String pickUp_Date) {
        PickUp_Date = pickUp_Date;
    }

    public String getPickUp_Time() {
        return PickUp_Time;
    }

    public void setPickUp_Time(String pickUp_Time) {
        PickUp_Time = pickUp_Time;
    }

    public String getPickUp_Status() {
        return PickUp_Status;
    }

    public void setPickUp_Status(String pickUp_Status) {
        PickUp_Status = pickUp_Status;
    }
}
