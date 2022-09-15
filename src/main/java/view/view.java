package view;

import java.util.List;
import java.util.Scanner;
import interfaceImplent.UsersMethods;
import interfaceImplent.AdminMethods;
import model.Users;
import model.ClotheType;

public class view {
    Scanner scan = new Scanner(System.in).useDelimiter("\n");
    int choice =0;

    UsersMethods usersMethods = new UsersMethods();
    AdminMethods adminMethods = new AdminMethods();

    Users users = new Users();
    ClotheType clotheType = new ClotheType();

    public void RegisterNew(){
        System.out.println("Enter Email Address");
        String email = scan.next();
        Users user = usersMethods.GetUserByEmail(email);
        List <ClotheType> clotheTypes = usersMethods.ViewPriceList();
    }

    public void menu(){
        do {
            System.out.println("==================================================");
            System.out.println("               (*) Users Port (*)                 ");
            System.out.println("==================================================");
            System.out.println();
            System.out.println("  >>  Enter an operation  <<   \n >> (1) Register\n >> (2) Complete Drop Off" +
                    "\n >> (3) View Price List\n >> (4) Update Your Laundry \n >> (5) Check total Price \n >> (6) Cancel");
            choice = scan.nextInt();
            switch (choice){
                case 1:
                    System.out.println("  >>  Enter UserID");
                    users.setUserID(scan.nextInt());
                    System.out.println("  >>  Enter FullName");
                    users.setFullnamee(scan.next());
                    System.out.println("  >>  Enter PhoneNumber");
                    users.setPhoneNumber(scan.next());
                    System.out.println("  >>  Enter Home Address");
                    users.setHomeAddress(scan.next());
                    System.out.println("  >>  Enter Your Email");
                    users.setUserEmail(scan.next());
                    System.out.println(usersMethods.Register(users));
                    break;
                case 2:
                    RegisterNew();
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
                    users.setUserID(scan.nextInt());
                    System.out.println("Enter Phone_No");
                    users.setPhoneNumber(scan.next());
                    System.out.println("Enter Home Address");
                    users.setHomeAddress(scan.next());
                    System.out.println(usersMethods.UpdateDetails(users));
                    break;
                case 5:
                    System.out.println("  >>  Enter the UserID");
                    users.setUserID(scan.nextInt());
//                    System.out.println(usersMethods.CheckTotalPrice(users.getUserEmail()));
//                    System.out.println("  >>  Do you wish to delete student with email " + student.getEmail()+" ?\n  >>  Y/N" );
//                    System.out.println(studentMethods.deleteStudent(student.getEmail(), b.next()));
                    break;
                case 6:
                    System.out.println("  >>  Enter the User email");
                    users.setUserEmail( scan.next());
                    System.out.println("  >>  Do you wish to delete student with email " + users.getUserEmail()+" ?\n  >>  Y/N" );
//                    System.out.println(usersMethods.PickUp());
                    break;
                default:
                    System.out.println("  >>  Enter valid option");
            }
        } while(choice != 5);
    }
}
