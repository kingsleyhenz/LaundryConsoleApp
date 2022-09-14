package interfaces;

import model.ClotheType;
import model.Users;
import model.Clothes;

import java.util.List;

public interface IUserMethods {
    public boolean Register(Users users);
    public boolean DropClothes(Clothes cloth, int Amount);
    public List<ClotheType> ViewPriceList();
    public String UpdateDetails(Users users);
    public String CancelService(int UserID, String confirm);
}
