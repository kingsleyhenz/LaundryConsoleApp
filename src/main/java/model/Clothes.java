package model;

public class Clothes {
    private int Clothes_ID;
    private String Clothe_Type;
    private int Price;

    public Clothes(int clothes_ID, String clothe_Type, int price) {
        Clothes_ID = clothes_ID;
        Clothe_Type = clothe_Type;
        Price = price;
    }

    public int getClothes_ID() {
        return Clothes_ID;
    }

    public void setClothes_ID(int clothes_ID) {
        Clothes_ID = clothes_ID;
    }

    public String getClothe_Type() {
        return Clothe_Type;
    }

    public void setClothe_Type(String clothe_Type) {
        Clothe_Type = clothe_Type;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }
}
