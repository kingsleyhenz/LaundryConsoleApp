package view;

import java.util.List;
import java.util.Scanner;
import interfaceImplent.UsersMethods;
import model.DropOff;
import model.Laundry;
import model.Users;
import model.ClotheType;

public class UserView {
    Scanner scan = new Scanner(System.in).useDelimiter("\n");
    int choice =0;
    String redo;
    UsersMethods usersMethods = new UsersMethods();
    Users users = new Users();
    DropOff drop = new DropOff();
    Laundry laundry = new Laundry();

    public void menu(){
        do {
            System.out.println("==================================================");
            System.out.println("               (*) Users Port (*)                 ");
            System.out.println("==================================================");
            System.out.println();
            System.out.println(" Welcome To Our Laundry Service Before You Proceed We Kindly As Our \n Users To Take A Look At Our Price (option 4) List Before Registering Thank You \n >>  Enter an operation  <<   \n >> (1) Register\n >> (2) Drop Off" +
                    "\n >> (3) Complete Registration\n >> (4) View Price List \n >> (5) Update Your Personal Details \n >> (6) Update Your Delivery Date And Time \n >> (7) PickUp Your Laundry");
            choice = scan.nextInt();
            switch (choice){
                case 1:
                    System.out.println("  >>  Enter UserID (ie 1-1000)");
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
                            do {
                            System.out.println("  >> Please Enter Your DropOff ID (ie 100-300)");
                            drop.setDropOff_ID(scan.nextInt());
                            System.out.println("  >> Please Enter Your UserId");
                            drop.setUserId(scan.nextInt());
                            System.out.println("  >> Please Input Today's Date (dd-mm-yyyy)");
                            drop.setDate_Dropped(scan.next());
                            System.out.println("  >> Please Input Drop Off Time (HH:MM 24hr format)");
                            drop.setTime_Dropped(scan.next());
                            System.out.println("  >> Please Input PickUp Date (dd-mm-yyyy)");
                            drop.setPickUp_Date(scan.next());
                            System.out.println("  >> Please Input PickUp Time (HH:MM 24hr format)");
                            drop.setPickUp_Time(scan.next());
                            System.out.println(usersMethods.DropClothes(drop));
                            System.out.println("Do you wish Drop Off Another Item");
                            redo = scan.next();
                    }while (redo.equalsIgnoreCase("Yes"));
                    break;
                case 3:
                    System.out.println("  >> Kindly Input Laundry Id (ie 1000-3000)");
                    laundry.setLaundry_ID(scan.nextInt());
                    System.out.println("  >> Kindly Input Your DropOff ID Again");
                    laundry.setDropOff_Id(scan.nextInt());
                    System.out.println("  >> Kindly Put The Material As Listed In Our PriceList");
                    laundry.setClothetype(scan.next());
                    System.out.println("  >> Kindly Input The Quantity Of Said Material");
                    laundry.setQuantity(scan.nextInt());
                    System.out.println(usersMethods.CompleteReg(laundry));
                    break;
                case 4:
                    System.out.println("Fetching Price List Table ........");
                    System.out.println("Clothes_ID"+"\t"+"Clothe_Type"+"\t"+"\t"+"Price");
                    List<ClotheType>  clothes = usersMethods.ViewPriceList();
                   for (ClotheType cl: clothes){
                       System.out.println(cl.getClothes_ID()+"\t"+"\t"+"\t"+cl.getClothe_Type()+"\t"+"\t"+"\t"+cl.getPrice()+"\n");
                   }
                    break;
                case 5:
                    System.out.println("  >>  Enter UserID");
                    users.setUserID(scan.nextInt());
                    System.out.println("Enter Phone_No");
                    users.setPhoneNumber(scan.next());
                    System.out.println("Enter Home Address");
                    users.setHomeAddress(scan.next());
                    System.out.println(usersMethods.UpdateDetails(users));
                    break;
                case 6:
                    do {
                        System.out.println("  >>  Enter the DropOff ID");
                        drop.setDropOff_ID(scan.nextInt());
                        System.out.println("  >> Input Your New PickUp Date");
                        drop.setPickUp_Date(scan.next());
                        System.out.println("  >> Input Your New PickUp Time");
                        drop.setPickUp_Time(scan.next());
                        System.out.println(usersMethods.UpdateYourDeliveryDateAndTime(drop));
                        System.out.println("Do You Wish To Update For Your Other DropOffs");
                        redo = scan.next();
                    }while (redo.equalsIgnoreCase("Yes"));
                    break;
                case 7:
                    System.out.println(" Kindly Enter Your DropOff Id");
                    drop.setDropOff_ID(scan.nextInt());
                    System.out.println(" Thank You For Servicing With Us :)");
                    System.out.println(usersMethods.PickUp(drop));
                    break;
                default:
                    System.out.println("  >>  Enter valid option");
            }
        } while(!(choice > 7));
    }
}
