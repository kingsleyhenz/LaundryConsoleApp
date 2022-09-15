package view;

import java.util.List;
import java.util.Scanner;

import interfaceImplent.AdminMethods;
import interfaceImplent.UsersMethods;
import model.DropOff;
import model.Laundry;
import model.Users;
import model.ClotheType;

public class AdminView {
    Scanner scan = new Scanner(System.in).useDelimiter("\n");
    int choice = 0;
    String redo;
    AdminMethods adminMethods = new AdminMethods();
    Users users = new Users();
    DropOff drop = new DropOff();
    Laundry laundry = new Laundry();
    ClotheType clothtype = new ClotheType();

    public void menu(){
        do {
            System.out.println("==================================================");
            System.out.println("               (*) Admin Port (*)                 ");
            System.out.println("==================================================");
            System.out.println();
            System.out.println(" >>  Enter an operation  <<   \n >> (1) View All Customers \n >> (2) View Price List" +
                    "\n >> (3) Update Clothes List\n >> (4) Add New Materials \n >> (5) Remove User \n");
            choice = scan.nextInt();
            switch (choice){
                case 1:
                    System.out.println(adminMethods.ViewAllCustomers());
                    break;
                case 2:
                    System.out.println("Fetching Price List Table ........");
                    System.out.println("Clothes_ID"+"\t"+"Clothe_Type"+"\t"+"\t"+"Price");
                    List<ClotheType>  clothes = adminMethods.ViewClotheList();
                    for (ClotheType cl: clothes){
                        System.out.println(cl.getClothes_ID()+"\t"+"\t"+"\t"+cl.getClothe_Type()+"\t"+"\t"+"\t"+cl.getPrice()+"\n");
                    }
                    break;
                case 3:
                    do{
                    System.out.println("<> Enter Clothe ID <>");
                    clothtype.setClothes_ID(scan.nextInt());
                    System.out.println("<> Enter Clothe Type <>");
                    clothtype.setClothe_Type(scan.next());
                    System.out.println("<> Enter New Price <>");
                    clothtype.setPrice(scan.nextInt());
                    System.out.println(adminMethods.UpdateClothesList(clothtype));
                    System.out.println("Do you Wish To Update Another Clothe On The List");
                    redo = scan.next();
                    }while (redo.equalsIgnoreCase("Yes"));
                    break;
                case 4:
                    System.out.println("Enter The New Clothe Id");
                    clothtype.setClothes_ID(scan.nextInt());
                    System.out.println("Enter The New Clothe Type");
                    clothtype.setClothe_Type(scan.next());
                    System.out.println("Enter The Price");
                    clothtype.setPrice(scan.nextInt());
                    System.out.println(adminMethods.AddNewMaterial(clothtype));
                    break;
                case 5:
                    System.out.println(" Removing Users Now........");
                    System.out.println(adminMethods.RemoveUser());
                    break;
                default:
                    System.out.println("  >>  Enter valid option");
            }
        } while(!(choice > 5));
    }
}
