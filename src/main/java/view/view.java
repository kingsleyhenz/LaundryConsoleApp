package view;

import java.util.List;
import java.util.Scanner;
import interfaceImplent.UsersMethods;
import interfaceImplent.AdminMethods;
import model.Users;
import model.ClotheType;
import model.Clothes;
public class view {
    Scanner a = new Scanner(System.in).useDelimiter("\n");
    Scanner b = new Scanner(System.in).useDelimiter("\n");
    int choice =0;

    UsersMethods usersMethods = new UsersMethods();
    AdminMethods adminMethods = new AdminMethods();

    Users users = new Users();
    ClotheType clotheType = new ClotheType();
    Clothes cloth = new Clothes();


    public void menu(){
        do {
            System.out.println("==================================================");
            System.out.println("               (*) Users Port (*)                 ");
            System.out.println("==================================================");
            System.out.println();
            System.out.println("  >>  Enter an operation  <<   \n >> (1) Register\n >> (2) Drop Off Clothes" +
                    "\n >> (3) View Price List\n >> (4) Update Your Laundry \n >> (5) Check total Price \n >> (6) Cancel");
            choice = a.nextInt();
            switch (choice){
                case 1:
                    System.out.println("  >>  Enter UserID");
                    users.setUserID(b.nextInt());
                    System.out.println("  >>  Enter FullName");
                    users.setFullnamee(b.next());
                    System.out.println("  >>  Enter PhoneNumber");
                    users.setPhoneNumber(b.next());
                    System.out.println("  >>  Enter Home Address");
                    users.setHomeAddress(b.next());
                    System.out.println("  >>  Enter Your Email");
                    users.setUserEmail(b.next());
                    System.out.println(usersMethods.Register(users));
                    break;
                case 2:
                    System.out.println("  >> Enter UserId");
                    users.setUserEmail(b.next());
                    System.out.println("  >> Enter Clothe_Id");
                    cloth.setClothe_Id(b.nextInt());
                    System.out.println("  >> Enter Clothetype_Id");
                    cloth.setClothetype_Id(b.nextInt());
                    System.out.println("  >> Enter Number Of Clothes");
                    cloth.setNo_Of_Clothes(b.nextInt());
                    System.out.println("  >> Date Dropped dd-mm-yyyy");
                    cloth.setDate_Dropped(b.next());
                    System.out.println("  >> Time Dropped HH:MM 24hr Format");
                    cloth.setTime_Dropped(b.next());
                    System.out.println(usersMethods.DropClothes());
                    break;
                case 3:
                    System.out.println("Fetching Price List Table ........");
                    System.out.println("Clothes_ID"+"\t"+"Clothe_Type"+"\t"+"\t"+"Price");
                    List<ClotheType>  clothes = usersMethods.ViewPriceList();
                   for (ClotheType cl: clothes){
                       System.out.println(cl.getClothes_ID()+"\t"+"\t"+"\t"+"\t"+cl.getClothe_Type()+"\t"+"\t"+cl.getPrice()+"\n");
                   }
                    break;
                case 4:
                    System.out.println("  >>  Enter UserID");
                    users.setUserID(b.nextInt());
                    System.out.println("Enter Phone_No");
                    users.setPhoneNumber(a.next());
                    System.out.println("Enter Home Address");
                    users.setHomeAddress(a.next());
                    System.out.println(usersMethods.UpdateDetails(users));
                    break;
                case 5:
                    System.out.println("  >>  Enter the UserID");
                    users.setUserID(b.nextInt());
                    System.out.println(usersMethods.CheckTotalPrice(users.getUserEmail()));
//                    System.out.println("  >>  Do you wish to delete student with email " + student.getEmail()+" ?\n  >>  Y/N" );
//                    System.out.println(studentMethods.deleteStudent(student.getEmail(), b.next()));
                    break;
                case 6:
                    System.out.println("  >>  Enter the User email");
                    users.setUserEmail( b.next());
                    System.out.println("  >>  Do you wish to delete student with email " + users.getUserEmail()+" ?\n  >>  Y/N" );
                    System.out.println(usersMethods.CancelService(users.getUserEmail(), b.next()));
                    break;
                default:
                    System.out.println("  >>  Enter valid option");
            }
        } while(choice != 5);
    }
}
