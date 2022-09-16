package interfaces;

import model.ClotheType;
import model.DropOff;
import model.Users;

import java.util.List;

public interface IAdminMethods {
    public List<Users> ViewAllCustomers();
    public List<ClotheType> ViewClotheList();
    public String UpdateClothesList(ClotheType clothetp);
    public boolean AddNewMaterial(ClotheType clothetp);
    public String RemoveUser(DropOff drop);
}
