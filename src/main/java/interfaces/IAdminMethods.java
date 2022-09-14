package interfaces;

import model.ClotheType;
import model.Users;

import java.util.List;

public interface IAdminMethods {
    public List<Users> ViewAllCustomers();
    public String CalculateUsersPrice();
    public String CustomerWithPrice();
    public String UpdateUsers();
    public String TimeReminder(Users user);
    public String RemoveUser(int UserID, String Confirm);
}
