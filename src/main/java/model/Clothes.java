package model;

public class Clothes {
   private int UserId;
   private int Clothe_Id;
    private int Clothetype_Id;
    private int No_Of_Clothes;
   private String Date_Dropped;
   private String Time_Dropped;
    private double Amount;

    public Clothes() {
        UserId = UserId;
        Clothe_Id = Clothe_Id;
        Clothetype_Id = Clothetype_Id;
        No_Of_Clothes = No_Of_Clothes;
        Date_Dropped = Date_Dropped;
        Time_Dropped = Time_Dropped;
        Amount = Amount;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public int getClothe_Id() {
        return Clothe_Id;
    }

    public void setClothe_Id(int clothe_Id) {
        Clothe_Id = clothe_Id;
    }

    public int getClothetype_Id() {
        return Clothetype_Id;
    }

    public void setClothetype_Id(int clothetype_Id) {
        Clothetype_Id = clothetype_Id;
    }

    public int getNo_Of_Clothes() {
        return No_Of_Clothes;
    }

    public void setNo_Of_Clothes(int no_Of_Clothes) {
        No_Of_Clothes = no_Of_Clothes;
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
    public int getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }
}
