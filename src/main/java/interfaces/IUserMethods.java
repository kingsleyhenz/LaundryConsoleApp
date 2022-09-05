package interfaces;

import model.Clothes;
import model.Users;

public interface IUserMethods {
    public boolean Register(Users users);
    public String ViewClothesTable(Clothes clothes);
    public String CheckPrice(Users users, Clothes clothes);
    public String UpdateYourLaundry(Users users);
    public String DaysAndTimeLeft(int UserId);
    public String CancelService(int UserID, String confirm);
}
