package interfaces;

import model.Clothes;
import model.Users;

public interface IUserMethods {
    public boolean Register(Users users);
    public String ViewClothesTable(Clothes clothes);
    public String checkPrice(Users users, Clothes clothes);
    public String TimeLeft(Users users);
    public String cancelService(int UserID, String confirm);
}
