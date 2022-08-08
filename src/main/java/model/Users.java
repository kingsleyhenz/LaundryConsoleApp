package model;

public class Users {
    private int UserID;
    private String fullname;
    private long phoneNumber;
    private String HomeAddress;
    private int NumberOfClothes;

    public Users(int userID, String fullname, long phoneNumber, String homeAddress, int numberOfClothes) {
        this.UserID = userID;
        this.fullname = fullname;
        this.phoneNumber = phoneNumber;
        this.HomeAddress = homeAddress;
        this.NumberOfClothes = numberOfClothes;
    }

    public int getUserID(){
        return UserID;
    }

    public void setUserID(int UserID){
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

    public int getNumberOfClothes() {
        return NumberOfClothes;
    }

    public void setNumberOfClothes(int numberOfClothes) {
        NumberOfClothes = numberOfClothes;
    }
}
