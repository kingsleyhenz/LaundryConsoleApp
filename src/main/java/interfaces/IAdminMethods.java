package interfaces;

import model.Clothes;
import model.Users;

public interface IAdminMethods {
    public String ViewAllCustomers(Users users, Clothes clothes);
    public String CalculateUsersPrice(Users users, Clothes clothes);
    public String SendReminder(Users user);
    public String RemoveUser(Users user, String Confirm);
}
