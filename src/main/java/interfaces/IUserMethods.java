package interfaces;

import model.ClotheType;
import model.DropOff;
import model.Laundry;
import model.Users;

import java.util.List;

public interface IUserMethods {
    public boolean Register(Users users);
    public boolean DropClothes(DropOff drop);
    public boolean CompleteReg(Laundry laundry);
    public List<ClotheType> ViewPriceList();
    public String UpdateDetails(Users users);
    public String UpdateYourDeliveryDateAndTime(DropOff drop);
    public String PickUp(DropOff drop);
}
