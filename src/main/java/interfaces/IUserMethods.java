package interfaces;

import model.ClotheType;
import model.LaundryItems;
import model.Users;

import java.util.List;

public interface IUserMethods {
    public boolean Register(Users users);
    public boolean DropClothes(List<LaundryItems> clothes,Users users);
    public Users GetUserByEmail(String email);
    public List<ClotheType> ViewPriceList();
    public String UpdateDetails(Users users);
    public String PickUp(int UserID, String confirm);
}
