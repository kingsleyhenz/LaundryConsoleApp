package model;

public class Users {
    private int UserID;
    private String fullname;
    private String phoneNumber;
    private String HomeAddress;
    private String UserEmail;


    public Users() {
        this.UserID = UserID;
        this.fullname = fullname;
        this.phoneNumber = phoneNumber;
        this.HomeAddress = HomeAddress;
        this.UserEmail = UserEmail;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getHomeAddress() {
        return HomeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        HomeAddress = homeAddress;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserEmail(String userEmail) {
        UserEmail = userEmail;
    }
}


