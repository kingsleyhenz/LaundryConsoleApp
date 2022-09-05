package model;

public class Users {
    private int UserID;
    private String fullname;
    private long phoneNumber;
    private String HomeAddress;
    private int Clothes_ID;
    private int No_of_Clothes;
    private String Date_Dropped;
    private String Time_Dropped;
    private String PickUp_Date;
    private String PickUp_Time;

    public Users() {
        this.UserID = userID;
        this.fullname = fullname;
        this.phoneNumber = phoneNumber;
        this.HomeAddress = homeAddress;
        Clothes_ID = clothes_id;
        No_of_Clothes = no_of_clothes;
        Date_Dropped = date_dropped;
        Time_Dropped = time_dropped;
        PickUp_Date = pickUp_date;
        PickUp_Time = pickUp_time;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullnamee(String fullname) {
        this.fullname = fullname;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getHomeAddress() {
        return HomeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        HomeAddress = homeAddress;
    }

    public int getClothes_ID() {
        return Clothes_ID;
    }

    public void setClothes_ID(int clothes_ID) {
        Clothes_ID = clothes_ID;
    }

    public int getNo_of_Clothes() {
        return No_of_Clothes;
    }

    public void setNo_of_Clothes(int no_of_Clothes) {
        No_of_Clothes = no_of_Clothes;
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
}


