package model;

public class Laundry {
    private int Laundry_ID;
    private int DropOff_Id;
    private String Clothetype;
    private int Quantity;
    private int Amount;


    public int getLaundry_ID() {
        return Laundry_ID;
    }

    public void setLaundry_ID(int laundry_ID) {
        Laundry_ID = laundry_ID;
    }

    public int getDropOff_Id() {
        return DropOff_Id;
    }

    public void setDropOff_Id(int dropOff_Id) {
        DropOff_Id = dropOff_Id;
    }
    public String getClothetype() {
        return Clothetype;
    }

    public void setClothetype(String clothetype) {
        Clothetype = clothetype;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }
}
