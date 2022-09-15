package model;

public class LaundryItems {
    private int ID;
    private int Laundry_ID;
    private String Clothetype;
    private int Quantity;
    private int Amount;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getLaundry_ID() {
        return Laundry_ID;
    }

    public void setLaundry_ID(int laundry_ID) {
        Laundry_ID = laundry_ID;
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
