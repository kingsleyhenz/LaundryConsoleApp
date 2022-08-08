package interfaces;

import model.Users;

public interface IUserMethods {
    public boolean dropClothes(Users users);
    public String checkPrice(int UserID);
    public String addClothes(Users users);
    public String cancelService(int UserID, String confirm);
}
