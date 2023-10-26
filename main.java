package org.example;

import java.util.*;

//add animals
//add standard discounts
//add to revenue both during membership AND tickets

//code for counting ticketed visitors :
//        int n=(AttHash.get(i).getVisicount())+1;
//        AttHash.get(i).setVisicount(n); //visitor count increased

public class Main {
    static Admin Adminone=new Admin();
    //static ArrayList<Visitor> visitors= new ArrayList<>(); //list of all visitors
    static HashMap<Integer,Attraction> AttHash=new HashMap<>(); //id and attraction
    static HashMap<String,Visitor> VisHash=new HashMap<>(); //email and visitor
    static HashMap<String,Animal> AniHash=new HashMap<>(); //name and animal
    static HashMap<String,Discount> DisHash=new HashMap<>(); //discount code and discount
    static HashMap<Visitor,String> FbHash=new HashMap<>(); //visitor and their feedback
    static Scanner scan=new Scanner(System.in);

    //standard lib--------------------------------------------------------------------------------------------------------
//    Discount unidis1=new Discount("STU1",10,"Students");
//    //DisHash.put(unidis.getCode(),unidis1);
//    Discount unidis2=new Discount("SEN1",20,"Senior Citizens");

    // ALL MENUS -----------------------------------------------------------------------------------------------------------
    public static void Menu() {
        System.out.println("1. Enter as Admin\n" +
                "2. Enter as a Visitor\n" +
                "3. View Special Deals\n"+
                "4. Exit");
    }
    public static void AdminMenu() {
        System.out.println("1. Manage Attractions\n" +
                "2. Manage Animals\n" +
                "3. Schedule Events\n" +
                "4. Set Discounts\n" +
                "5. Set Special Deal\n" +
                "6. View Visitor Stats\n" +
                "7. View Feedback\n" +
                "8. Exit\n");
    }

    public static void AdminM1Attactions() {
        System.out.println("Manage Attractions:\n" +
                "1. Add Attraction\n" +
                "2. View Attractions\n" +
                "3. Modify Attraction\n" +
                "4. Remove Attraction\n" +
                "5. Exit\n");
    }

    public static void AdminM2Animals(){
        System.out.println("Manage Animals:\n" +
                "1. Add Animal\n" +
                "2. Update Animal Details\n" +
                "3. Remove Animal\n" +
                "4. Exit\n");
    }

    public static void AdminM4Discounts() {
        System.out.println("Set Discounts:\n" +
                "1. Add Discount\n" +
                "2. Modify Discount\n" +
                "3. Remove Discount\n" +
                "4. Exit\n");
    }

    public static void VisitorLoginMenu(){
        System.out.println("1. Register\n" +
                "2. Login\n"+
                "3. Exit\n");
    }

    public static void VisitorMenu() {
        System.out.println("1. Explore the Zoo\n" +
                "2. Buy Membership\n" +
                "3. Buy Tickets\n" +
                "4. View Discounts\n" +
                "5. View Special Deals\n" +
                "6. Visit Animals\n" +
                "7. Visit Attractions\n" +
                "8. Leave Feedback\n" +
                "9. Log Out\n");
    }

    public static void VisitorM1Explore(){
        System.out.println("Explore the Zoo:\n" +
                "1. View Attractions\n" +
                "2. View Animals\n" +
                "3. Exit\n");
    }

    public static void VisitorM2Membership(){
        System.out.println("Buy Membership:\n" +
                "1. Basic Membership (₹20)\n" +
                "2. Premium Membership (₹50)\n");
    }

    // MENUS END-----------------------------------------------------------------------------------------------------------

    public static boolean loginAdmin(Admin ad,String user,String pass){ //CHECK IF ADMIN CORRECT OR NOT
        if(Objects.equals(ad.getUsername(), user) && Objects.equals(ad.getPassword(), pass)){
            return true;
        }
        else{
            return false;
        }
    } //done

    public static void RegisterVisitor(){
        //Scanner reg=new Scanner(System.in);
        System.out.println("Enter name;");
        String name=scan.nextLine();
        System.out.println("Enter age:");
        int age=scan.nextInt();
        scan.nextLine(); //extra line
        System.out.println("Enter Phone Number:");
        int num=scan.nextInt();
        scan.nextLine(); //extra line
        System.out.println("Enter Balance:");
        int bal=scan.nextInt();
        scan.nextLine(); //extra line
        System.out.println("Enter Email id");
        String email=scan.nextLine();
        System.out.println("Enter Password:");
        String pass=scan.nextLine();
        Visitor V1=new Visitor(name,age,num,bal,email,pass);
        //AddVisitor(V1);
        VisHash.put(email,V1);
        int n=(Adminone.getNumbervis())+1;
        Adminone.setNumbervis(n);
        System.out.println("Visitor Registered Succesfully!");
        //reg.close();
    } //done
    public static Visitor LoginVisitor(){  //return visior //Scanner log=new Scanner(System.in)
        System.out.println("Enter Email:");
        String e=scan.nextLine();
        System.out.println("Enter Password:");
        String p=scan.nextLine();

        boolean flag=false;
//        for (Visitor mem:visitors) {// MEMBER LOGGED IN IS mem
//            if (mem.getEmail().equals(e) && mem.getPassword().equals(p)) {
//                flag = true;
//                Visitor logged=mem;
//                return logged;
//            }
//        }
        for(String i:VisHash.keySet()){
            if(Objects.equals(VisHash.get(i).getEmail(), e) && Objects.equals(VisHash.get(i).getPassword(), p)){
                flag = true;
                Visitor logged=VisHash.get(i);
                return logged;
            }
        }

        if(flag==false){
            System.out.println("Visitor does not exist, please register");
        }

        return null;
    } //done
    public static void ViewVisitors(){
        for(String i:VisHash.keySet()){
            System.out.println(VisHash.get(i).toString()+"\n");
        }
    } //done
    public static void ViewVisiStats(){
        System.out.println("Total Visitors :"+ Adminone.getNumbervis());
        System.out.println("Total Revenue :"+ Adminone.getRevenue());
    } //done
    public static void BuyMembership(Visitor visit,int a1){
        if(a1==1){
            if(visit.getBalance()>=20){
                String str="basic";
                visit.setBalance(visit.getBalance()-20);
                visit.setMembership(str);
                double r=(Adminone.getRevenue())+20;
                Adminone.setRevenue(r);
                System.out.println("Congratulations on Basic membership");
            }
            else{
                System.out.println("Insufficient Balance");
            }
        }
        else if(a1==2){
            if(visit.getBalance()>=50) {
                String str = "premium";
                visit.setBalance(visit.getBalance() - 50);
                visit.setMembership(str);
                double r=(Adminone.getRevenue())+50;
                Adminone.setRevenue(r);
                System.out.println("Congratulations on Premium membership");
            }
            else{
                System.out.println("Insufficient Balance");
            }
        }
    } //done
    //-------------------------------------------------------------------------------------------------------------------
    public static void AddAttraction(){
        System.out.println("Enter Attraction Name:");
        String name=scan.nextLine();
        System.out.println("Enter Attraction Description");
        String desc=scan.nextLine();
        Attraction a1=new Attraction(name,desc);
        //admin.attracts.add(a1);
        AttHash.put(a1.getId(),a1);
        System.out.println("Attraction Sucessfully Added !");
    } //done
    public static void RemoveAttraction(){
        System.out.println("Enter Attraction Name:");
        String name=scan.nextLine();
        System.out.println("Enter Attraction id");
        int id=scan.nextInt();
        scan.nextLine();
        AttHash.remove(id);
        System.out.println("Attraction Sucessfully Removed !");
    } //done
    public static void ViewAttractions(){
        for(int i:AttHash.keySet()){
            System.out.println("Attraction Name:"+ AttHash.get(i).getName()+"\nID:"+i+"\nAttraction Description:"+AttHash.get(i).getDescription()+"\n");
        }
    } //done
    public static void ModifyAttractions(){
        System.out.println("ID of Attraction to be Modified:");
        int id=scan.nextInt();
        scan.nextLine();
        System.out.println("Enter new name:");
        String name=scan.nextLine();
        System.out.println("Enter new description:");
        String desc=scan.nextLine();
        AttHash.get(id).setName(name);
        AttHash.get(id).setDescription(desc);
//        for (int i:AttHash.keySet()){
//            if(AttHash.get(i).getId()==id){
//                System.out.println("Enter new name:");
//                String name=scan.nextLine();
//                System.out.println("Enter new description:");
//                String desc=scan.nextLine();
//                AttHash.get(i).setName(name);
//                AttHash.get(i).setDescription(desc);
//            }
//        }
    } //done
    public static void ScheduleEventsInterface(){
        //you're taking name and desc from user. you set price while scheduling event, id is made on its own
        System.out.println("Enter name of Event Attraction:");
        String name=scan.nextLine();
        System.out.println("Enter Attraction Id:");
        int id=scan.nextInt();
        scan.nextLine();
        System.out.println("Enter Event ticket price:");
        double price=scan.nextDouble();
        scan.nextLine();
        AttHash.get(id).setEvent(true); //event scheduled
        AttHash.get(id).setPrice(price); //price set
//        for (int i:AttHash.keySet()){ // i is id
//            if(AttHash.get(i).getId()==id){
//                AttHash.get(i).setEvent(true); //event scheduled
//                AttHash.get(i).setPrice(price); //price set
//            }
//        }

    } // i hope done???
    //--------------------------------------------------------------------------------------------------------------
    public static void AddAnimal(){
        System.out.println("Enter Animal Name:");
        String name=scan.nextLine();
        System.out.println("Enter Animal Type");
        String type=scan.nextLine().toLowerCase();
        System.out.println("Enter Animal Sound");
        String sound=scan.nextLine();
        System.out.println("Enter Animal Description");
        String info=scan.nextLine().toLowerCase();
        Animal ani = null;
        if (Objects.equals(type, "mammal")){
            ani=new Mammal(type,name,sound,info);
        }
        else if (Objects.equals(type, "reptile")){
            ani=new Reptile(type,name,sound,info);
        }
        else if (Objects.equals(type, "amphibian")){
            ani=new Amphibian(type,name,sound,info);
        }
        AniHash.put(name,ani);
        System.out.println("Animal Sucessfully Added !");
    } //done
    public static void RemoveAnimal(){
        System.out.println("Enter Animal Name:");
        String name=scan.nextLine();
        AniHash.remove(name);
        System.out.println("Animal Sucessfully Removed !");
    } //done
    public static void UpdateAnimal(){
        System.out.println("Name of Animal to be Modified:");
        String name=scan.nextLine();
        for (String i:AniHash.keySet()){
            if(Objects.equals(AniHash.get(i).getName(), name)){
                System.out.println("Enter Updated Animal Name:");
                String nme=scan.nextLine();
                System.out.println("Enter Updated Animal Type");
                String type=scan.nextLine().toLowerCase();
                System.out.println("Enter Updated Animal Sound");
                String sound=scan.nextLine();
                System.out.println("Enter Updated Animal Description");
                String info=scan.nextLine();

                AniHash.get(i).setName(nme);
                AniHash.get(i).setType(type);
                AniHash.get(i).setSound(sound);
                AniHash.get(i).setInfo(info);
            }
        }
    } //done
    public static void ViewAnimal(){
        for(String i:AniHash.keySet()){
            System.out.println(AniHash.get(i).toString());
        }
    } //done

    //--------------------------------------------------------------------------------------------------------------
    public static void AddDiscount(){
        System.out.println("Enter Discount Value:");
        int val=scan.nextInt();
        scan.nextLine();
        System.out.println("Enter Discount code/category");
        String cat=scan.nextLine();
        System.out.println("Enter Discount code");
        String code=scan.nextLine();
        Discount d1=new Discount(code,val,cat);
        DisHash.put(d1.getCode(),d1);
        System.out.println("Discount Sucessfully Added !");
    } //done
    public static void ModifyDiscount(){
        System.out.println("Code of Discount to be Modified:");
        String code=scan.nextLine();
        for (String c:DisHash.keySet()){
            if(DisHash.get(c).getCode()==code){
                System.out.println("Enter new Category:");
                String cat=scan.nextLine();
                System.out.println("Enter new Code:");
                String cod=scan.nextLine();
                System.out.println("Enter new val:");
                int val=scan.nextInt();
                scan.nextLine();
                DisHash.get(c).setCode(cod);
                DisHash.get(c).setValue(val);
                DisHash.get(c).setCategory(cat);
            }
        }
    } //done
    public static void RemoveDiscount(){
        System.out.println("Enter Discount Value:");
        int val=scan.nextInt();
        scan.nextLine();
        System.out.println("Enter Discount code/category");
        String cat=scan.nextLine();
        System.out.println("Enter Discount code");
        String code=scan.nextLine();
        DisHash.remove(code);
        System.out.println("Discount Sucessfully Removed !");
    } //done
    public static void ViewDiscount(){
        for(String d:DisHash.keySet()){
            System.out.println(DisHash.get(d).toString());
        }
    } //done
    //--------------------------------------------------------------------------------------------------------------
    public static void GiveFeedback(Visitor v1){
        System.out.println("Enter your Feedback:");
        String fb=scan.nextLine();
        FbHash.put(v1,fb);
        System.out.println("Feedback Noted Succesfully !");
    } //done
    public static void ViewFeedback(){
        for(Visitor v:FbHash.keySet()){
            System.out.println("User:"+ v.getName());
            System.out.println("Feedback:" +FbHash.get(v));
        }
    } //done


    //INTERFACES---------------------------------------------------------------------------------------------------------------------

    public static void ONEAdminInterface(){
        boolean t2=true; //admin- c1=1
        //Scanner ad=new Scanner(System.in);
        while(t2){
            System.out.println("Enter Username:");
            String user=scan.nextLine();
            System.out.println("Enter Password:");
            String pass=scan.nextLine();
            boolean check=loginAdmin(Adminone,user,pass);
            if (check==true){ //continue admin code
                System.out.println("Welcome Admin !");
                boolean adbool=true;
                while(adbool){
                    AdminMenu();
                    int adc1=scan.nextInt(); //admin choice one
                    scan.nextLine(); //extra line
                    switch(adc1){
                        case 1: //Manage Attractions
                            ManageAttractionsInterface();
                            break;
                        case 2: //Manage Animals
                            ManageAnimalsInterface();
                            break;
                        case 3: //Schedule Events
                            ScheduleEventsInterface();
                            break;
                        case 4: //Set Discounts
                            SetDiscountsInterface();
                            break;
                        case 5: //Set Special Deal

                            break;
                        case 6: //View Visitor Stats
                            ViewVisiStats();
                            //ADD MORE HERE THIS IS JUST FOR CHECKING
//                            Total Visitors: 1200 DONE
//                            Total Revenue: $15,000 DONE
//                            Most Popular Attraction: Jungle Safari
                            break;
                        case 7: //View Feedback
                            ViewFeedback();
                            break;
                        case 8: //exit ADMIN MENU
                            adbool=false;
                            t2=false;
                            break;
                    }

                }

            }
            else{
                System.out.println("Admin Username and Password not valid");
            }
        }
        //ad.close();
    }

    public static void ManageAttractionsInterface(){
        Boolean attractbool=true;
        while(attractbool){
            AdminM1Attactions();
            int adc2=scan.nextInt();
            scan.nextLine();
            switch(adc2){
                case 1://Add Attraction
                    AddAttraction();
                    break;
                case 2://View Attractions
                    ViewAttractions();
                    break;
                case 3://Modify Attraction
                    ModifyAttractions();
                    break;
                case 4://Remove Attraction
                    RemoveAttraction();
                    break;
                case 5://Exit MANAGEATTRACTIONS
                    attractbool=false;
                    break;
            }
        }
    } //done

    public static void ManageAnimalsInterface(){
        Boolean animbool=true;
        while(animbool){
            AdminM2Animals();
            int adc2=scan.nextInt();
            scan.nextLine();
            switch(adc2){
                case 1://Add Animal
                    AddAnimal();
                    break;
                case 2://Update Animal Details
                    UpdateAnimal();
                    break;
                case 3://Remove Animal
                    RemoveAnimal();
                    break;
                case 4://Exit MANAGEANIMALS
                    animbool=false;
                    break;
            }
        }
    } //done

    ////////////

    public static void SetDiscountsInterface(){ //done
        Boolean disbool=true;
        while(disbool){
            AdminM4Discounts();
            int adc2=scan.nextInt();
            scan.nextLine();
            switch(adc2){
                case 1://Add Discount
                    AddDiscount();
                    break;
                case 2://Modify Discount
                    ModifyDiscount();
                    break;
                case 3://Remove Discount
                    RemoveDiscount();
                    break;
                case 4://Exit SETDISCOUNTS
                    disbool=false;
                    break;
            }
        }
    } //done

    //----------------------------------------------------------------------------------------------------------------------------------

    public static void ONEVisitorInterface(){
        boolean t3=true; //visitor- c1=2
        //Scanner vis=new Scanner(System.in);
        while(t3==true){
            VisitorLoginMenu();
            String vc1=scan.nextLine();//visitor choice 1  PROBLEM
            //vis.nextLine();
            switch(vc1){
                case "1"://Register
                    RegisterVisitor();
                    break;
                case "2"://login
                    Visitor loggedIn=LoginVisitor();
                    //System.out.println(loggedIn);
                    if(loggedIn!=null) {
                        TWOLoggedInterface(loggedIn);
                    }
                    break;
                case "3"://exit from VISITOR INTERFACE
                    t3=false;
                    break;

            }
        }
        //vis.close();
    } //done

    public static void TWOLoggedInterface(Visitor visit){
        //Scanner log=new Scanner(System.in);
        System.out.println("Welcome "+visit.getName()+ "!");
        boolean logbool=true;
        while(logbool){
            VisitorMenu();
            int vc2=scan.nextInt();
            scan.nextLine();
            switch(vc2){
                case 1://Explore the Zoo
                    ExploreZooInterface();
                    break;
                case 2://Buy Membership
                    BuyMembershipInterface(visit);
                    break;
                case 3://Buy Tickets
                    break;
                case 4://View Discounts
                    ViewDiscount();
                    break;
                case 5://View Special Deals
                    break;
                case 6://Visit Animals
                    break;
                case 7://Visit Attractions
                    break;
                case 8://Leave Feedback
                    GiveFeedback(visit);
                    break;
                case 9://LogOut
                    logbool=false;
                    break;
            }

        }

    }

    public static void ExploreZooInterface(){
        boolean expbool=true;
        while(expbool){
            VisitorM1Explore();
            int vc3=scan.nextInt();
            scan.nextLine();
            switch(vc3){
                case 1://View Attractions
                    ViewAttractions();
                    break;
                case 2://View Animals
                    ViewAnimal();
                    break;
                case 3://exit EXPLORE ZOO INterface
                    expbool=false;
                    break;
            }

        }
    } //done

    public static void BuyMembershipInterface(Visitor visit){
        VisitorM2Membership();
        int vc3=scan.nextInt();
        scan.nextLine();
        switch(vc3){
            case 1://Basic Membership (₹20)\n"
            case 2://Premium Membership (₹50)\n
                BuyMembership(visit,vc3);
                break;

        }

    } //done


    //INTERFACES END---------------------------------------------------------------------------------------------------------------------

    //MAIN Function--------------------------------------------------------------------------------------------------------

    public static void main(String[] args)
    {
        System.out.println("Welcome to ZOOtopia!");
        //Scanner one = new Scanner(System.in);
        boolean t1 = true;
        while (t1) {
            Menu(); // Initial menu printed: enter as admin/visitor
            int c1 = scan.nextInt(); // Choice one PROBLEM
            scan.nextLine(); // Consume the newline character

            switch (c1) {
                case 1: // Enter as admin
                    ONEAdminInterface();
                    break;

                case 2: // Enter as visitor
                    ONEVisitorInterface();
                    break;

                case 3: // Special deals
                    // Implement special deals menu
                    break;

                case 4: // Exit entire code
                    System.out.println("--------------------------\n" +
                            "Thanks for visiting :) !\n" +
                            "--------------------------");
                    t1 = false;
                    break;

                default:
                    System.out.println("Please enter a valid number");
            }
        }

        //one.close();
    }
}
