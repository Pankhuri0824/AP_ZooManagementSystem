package org.example;
import java.util.*;

public class Main {
    static Admin Adminone=new Admin();
    //static ArrayList<Visitor> visitors= new ArrayList<>(); //list of all visitors
    static HashMap<Integer,Attraction> AttHash=new HashMap<>(); //id and attraction
    static HashMap<String,Visitor> VisHash=new HashMap<>(); //email and visitor
    static HashMap<String,Animal> AniHash=new HashMap<>(); //name and animal
    static HashMap<String,Discount> DisHash=new HashMap<>(); //discount code and discount
    static HashMap<Visitor,String> FbHash=new HashMap<>(); //visitor and their feedback
    static HashMap<Integer,Deal> SpdHash=new HashMap<>(); // more than number of tickets and deal :subsequent discount


    static Scanner scan=new Scanner(System.in);

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
    public static void AdminM5SplDeals(){
        System.out.println("Set Special Deal:\n" +
                "1. Add Special Deal\n" +
                "2. Remove Special Deal\n" +
                "3. Exit\n");
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
                "7. Visit Attraction Events\n" +
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

    public static void RegisterVisitor() {
        System.out.println("Enter name:");
        String name = scan.nextLine();
        int age = 0;
        while (true) {
            System.out.println("Enter age:");
            try {
                age = Integer.parseInt(scan.nextLine());
                break; // Exit the loop if input valid
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid age. Please enter a valid number.");
            }
        }

        int num = 0;
        while (true) {
            System.out.println("Enter Phone Number:");
            try {
                num = Integer.parseInt(scan.nextLine());
                break; // Exit the loop if input valid
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid phone number. Please enter a valid number.");
            }
        }

        double bal = 0;
        while (true) {
            System.out.println("Enter Balance:");
            try {
                bal = Double.parseDouble(scan.nextLine());
                break; // Exit the loop if input valid
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid balance. Please enter a valid number.");
            }
        }

        System.out.println("Enter Email id:");
        String email = scan.nextLine();

        if (VisHash.containsKey(email)) {
            System.out.println("Email already in use. Please choose another email.");
            return; // Exit the function if email is already in use
        }

        System.out.println("Enter Password:");
        String pass = scan.nextLine();

        Visitor V1 = new Visitor(name, age, num, bal, email, pass);
        VisHash.put(email, V1);
        int n = (Adminone.getNumbervis()) + 1;
        Adminone.setNumbervis(n);
        System.out.println("Visitor Registered Successfully!");
    } //done and error handled

    public static Visitor LoginVisitor(){  //return visior //Scanner log=new Scanner(System.in)
        System.out.println("Enter Email:");
        String e=scan.nextLine();
        System.out.println("Enter Password:");
        String p=scan.nextLine();

        boolean flag=false;
        for(String i:VisHash.keySet()){
            if(Objects.equals(VisHash.get(i).getEmail(), e) && Objects.equals(VisHash.get(i).getPassword(), p)){
                flag = true;
                Visitor logged=VisHash.get(i);
                return logged;
            }
        }

        if(flag==false){
            System.out.println("Visitor does not exist, please register or enter correct details");
        }

        return null;
    } //done
    public static void ViewVisitors(){
        for(String i:VisHash.keySet()){
            System.out.println(VisHash.get(i).toString()+"\n");
        }
    } //done

    public static Attraction PopAtt(){
        int highest=0;
        for(int i:AttHash.keySet()){
            if(AttHash.get(i).getVisicount()>highest){
                highest=AttHash.get(i).getVisicount();
            }
        }

        for(int i:AttHash.keySet()){
            if(AttHash.get(i).getVisicount()==highest){
                Attraction a1=AttHash.get(i);
                return a1;
            }
        }

        return null;
    }
    public static void ViewVisiStats(){
        System.out.println("Total Visitors :"+ Adminone.getNumbervis());
        System.out.println("Total Revenue :"+ Adminone.getRevenue());
        System.out.println("Most Popular Attraction:"+ PopAtt().getName());
    } //done
    public static void BuyMembership(Visitor visit,int a1){
        if(a1==1){
            if(Objects.equals(visit.getMembership(), "basic")){
                System.out.println("You already have Basic membership");
            }
            else if(!Objects.equals(visit.getMembership(), "basic") && visit.getBalance()>=20){
                String str="basic";
                visit.setBalance(visit.getBalance()-20);
                visit.setMembership(str);
                double r=(Adminone.getRevenue())+20;
                Adminone.setRevenue(r);
                System.out.println("Congratulations on Basic membership ! ");
                System.out.println("Balance left: "+visit.getBalance());
            }
            else{
                System.out.println("Insufficient Balance");
            }
        }
        else if(a1==2){
            if(Objects.equals(visit.getMembership(), "premium")){
                System.out.println("You already have Premium membership");
            }
            else if(visit.getBalance()>=50 && !Objects.equals(visit.getMembership(), "premium")) {
                String str = "premium";
                visit.setBalance(visit.getBalance() - 50);
                visit.setMembership(str);
                double r=(Adminone.getRevenue())+50;
                Adminone.setRevenue(r);
                System.out.println("Congratulations on Premium membership !");
                System.out.println("Balance left: "+visit.getBalance());
            }
            else{
                System.out.println("Insufficient Balance");
            }
        }
    } //done
    //-------------------------------------------------------------------------------------------------------------------
    public static void ViewSpecialDeals(){
        for(Integer i:SpdHash.keySet()){
            System.out.println(SpdHash.get(i).toString()+"\n");
        }
    } //done
    public static void AddSpecialDeal(){
        System.out.println("Enter Minimum number of tickets for deal :");
        int num=scan.nextInt();
        scan.nextLine();
        System.out.println("Enter Discount percentage :");
        int val=scan.nextInt();
        scan.nextLine();
        System.out.println("Enter Deal Description");
        String str=scan.nextLine();
        Deal d1=new Deal(num,val,str);
        SpdHash.put(num,d1);
        System.out.println("Special Deal Successfully Added !");
    }
    public static void RemoveSpecialDeal(){
        System.out.println("Enter Minimum number of tickets for deal :");
        int num=scan.nextInt();
        scan.nextLine();
        SpdHash.remove(num);
        System.out.println("Special Deal Successfully Removed !");
    }

    public static int checkSplDeals(Visitor v1,int num){ //req is equal to or more than num
        int var;
        //int last=0;
        int req=0; //req key for checking spd
        for(int i:SpdHash.keySet()){
            var=i;
            if(num>=var && var>req){
                req=i;
            }
            //last=i; //last it num
        }

        if(req==0){
            return 0;
        }
        else{
            return SpdHash.get(req).getVal();
        }
    }

    //------------------------------------------------------------------------------------------------------------------------
    public static void AddAttraction(){
        System.out.println("Enter Attraction Name:");
        String name=scan.nextLine();
        System.out.println("Enter Attraction Description");
        String desc=scan.nextLine();
        Attraction a1=new Attraction(name,desc);
        //admin.attracts.add(a1);
        AttHash.put(a1.getId(),a1);
        System.out.println("Attraction Successfully Added !");
    } //done
    public static void RemoveAttraction(){
        System.out.println("Enter Attraction Name:");
        String name=scan.nextLine();
        System.out.println("Enter Attraction id");
        int id=scan.nextInt();
        scan.nextLine();
        AttHash.remove(id);
        System.out.println("Attraction Successfully Removed !");
    } //done
    public static void ViewAttractions(){
        for(int i:AttHash.keySet()){
            System.out.println("Attraction Name:"+ AttHash.get(i).getName()+"\nID:"+i+"\nAttraction Description:"+AttHash.get(i).getDescription()+"\n");
        }
    } //done
    public static void ModifyAttractions(){
        int id = 0;
        while (true) {
            System.out.println("ID of Attraction to be Modified:");
            try {
                id = Integer.parseInt(scan.nextLine());
                if (AttHash.containsKey(id)) {
                    break; // Exit the loop if the ID is valid and exists
                } else {
                    System.out.println("Attraction with the specified ID does not exist. Please enter a valid ID.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid ID. Please enter a valid number.");
            }
        }

        System.out.println("Enter new Name:");
        String name = scan.nextLine();

        System.out.println("Enter new Description:");
        String desc = scan.nextLine();

        AttHash.get(id).setName(name);
        AttHash.get(id).setDescription(desc);

    } //done
    public static void ScheduleEventsInterface() {
        // You're taking name and desc from user. You set price while scheduling an event; id is generated automatically.
        System.out.println("Enter name of Event Attraction:");
        String name = scan.nextLine();

        int id = 0;
        while (true) {
            try {
                System.out.println("Enter Attraction Id:");
                id = Integer.parseInt(scan.nextLine());
                if (!AttHash.containsKey(id)) {
                    System.out.println("Invalid Attraction Id. Please enter a valid Attraction Id.");
                } else if (AttHash.get(id).isEvent()) {
                    System.out.println("Attraction with the specified Id is already scheduled as an event.");
                } else {
                    break; // Exit the loop if input is valid and the attraction is not already an event.
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number for Attraction Id.");
            }
        }

        double price = 0;
        while (true) {
            try {
                System.out.println("Enter Event ticket price:");
                price = Double.parseDouble(scan.nextLine());
                if (price >= 0) {
                    break; // Exit the loop if input is valid and non-negative.
                } else {
                    System.out.println("Please enter a valid non-negative price for the event.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid numeric price for the event.");
            }
        }

        AttHash.get(id).setEvent(true); // Event scheduled
        AttHash.get(id).setPrice(price); // Price set
        System.out.println("Event Successfully added!");
    }// i hope done???
    //--------------------------------------------------------------------------------------------------------------
    public static void AddAnimal(){
        System.out.println("Enter Animal Name:");
        String name=scan.nextLine();
        System.out.println("Enter Animal Type (mammal / amphibian /reptile )");
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
        else{
            System.out.println("Creature type invalid "); //error handled
        }
        AniHash.put(name,ani);
        System.out.println("Animal Successfully Added !");
    } //done
    public static void RemoveAnimal(){
        System.out.println("Enter Animal Name:");
        String name=scan.nextLine();
        AniHash.remove(name);
        System.out.println("Animal Successfully Removed !");
    } //done
    public static void UpdateAnimal(){
        System.out.println("Name of Animal to be Modified:");
        String name = scan.nextLine();

        if (!AniHash.containsKey(name)) {
            System.out.println("Animal with the specified name does not exist. Please enter a valid animal name.");
            return; // Exit the function if the specified animal name does not exist
        }

        System.out.println("Enter Updated Animal Name:");
        String nme = scan.nextLine();

        System.out.println("Enter Updated Animal Type:");
        String type = scan.nextLine().toLowerCase();

        System.out.println("Enter Updated Animal Sound:");
        String sound = scan.nextLine();

        System.out.println("Enter Updated Animal Description:");
        String info = scan.nextLine();

        AniHash.get(name).setType(type);
        AniHash.get(name).setSound(sound);
        AniHash.get(name).setInfo(info);
        AniHash.get(name).setName(nme);
    } //done
    public static void ViewAnimal(){
        for(String i:AniHash.keySet()){
            System.out.println(AniHash.get(i).toString()+"\n");
        }
    } //done

    //--------------------------------------------------------------------------------------------------------------
    public static void AddDiscount(){
        int val = 0;
        while (true) {
            System.out.println("Enter Discount Value:");
            try {
                val = Integer.parseInt(scan.nextLine());
                break; // Exit the loop if input is valid
            } catch (NumberFormatException e) {
                System.out.println("Invalid discount value. Please enter a valid number.");
            }
        }

        System.out.println("Enter Discount code/category:");
        String cat = scan.nextLine();

        System.out.println("Enter Discount code:");
        String code = scan.nextLine();

        if (DisHash.containsKey(code)) {
            System.out.println("Discount code already in use. Please choose another code.");
            return; // Exit the function if the discount code is already in use
        }

        Discount d1 = new Discount(code, val, cat);
        DisHash.put(d1.getCode(), d1);
        System.out.println("Discount Successfully Added!");
    } //done
    public static void ModifyDiscount(){
        System.out.println("Code of Discount to be Modified:");
        String code = scan.nextLine();

        if (!DisHash.containsKey(code)) {
            System.out.println("Discount with the specified code does not exist. Please enter a valid discount code.");
            return; // Exit the function if the specified discount code does not exist
        }

        System.out.println("Enter new Category:");
        String cat = scan.nextLine();

        System.out.println("Enter new Code:");
        String cod = scan.nextLine();

        int val = 0;
        while (true) {
            System.out.println("Enter new Value:");
            try {
                val = Integer.parseInt(scan.nextLine());
                break; // Exit the loop if input is valid
            } catch (NumberFormatException e) {
                System.out.println("Invalid discount value. Please enter a valid number.");
            }
        }

        DisHash.get(code).setValue(val);
        DisHash.get(code).setCategory(cat);
        DisHash.get(code).setCode(cod);
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
            System.out.println(DisHash.get(d).toString()+"\n");
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
                            ManageAttractionsInterface(); //done
                            break;
                        case 2: //Manage Animals
                            ManageAnimalsInterface(); //done
                            break;
                        case 3: //Schedule Events
                            ScheduleEventsInterface(); //done
                            break;
                        case 4: //Set Discounts
                            SetDiscountsInterface(); //done
                            break;
                        case 5: //Set Special Deal
                            SetSpecialDealsInterface(); //done
                            break;
                        case 6: //View Visitor Stats
                            ViewVisiStats(); //done
                            break;
                        case 7: //View Feedback
                            ViewFeedback(); //done
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

    public static void SetSpecialDealsInterface(){
        Boolean spdbool=true;
        while(spdbool){
            AdminM5SplDeals();
            int adc2=scan.nextInt();
            scan.nextLine();
            switch(adc2){
                case 1://Add Discount
                    AddSpecialDeal();
                    break;
                case 2://Remove Discount
                    RemoveSpecialDeal();
                    break;
                case 3://Exit SET SPL DEALS
                    spdbool=false;
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
                    ExploreZooInterface(); //done
                    break;
                case 2://Buy Membership
                    BuyMembershipInterface(visit); //done
                    break;
                case 3://Buy Tickets
                    BuyTicketsInterface(visit); //done ig
                    break;
                case 4://View Discounts
                    ViewDiscount(); //done
                    break;
                case 5://View Special Deals
                    ViewSpecialDeals(); //done
                    break;
                case 6://Visit Animals
                    VisitAnimalInterface(visit); //done
                    break;
                case 7://Visit Attractions
                    VisitAttractionsInterface(visit); //done
                    break;
                case 8://Leave Feedback
                    GiveFeedback(visit); //done
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

//        System.out.println("Any Discount code:");
//        String dcode=scan.nextLine();

        switch(vc3){
            case 1://Basic Membership (₹20)\n"
            case 2://Premium Membership (₹50)\n
                BuyMembership(visit,vc3);
                break;

        }

    } //done

    public static void BuyTicketsInterface(Visitor v1) {
        if (Objects.equals(v1.getMembership(), "basic")) {
            if (v1.getBalance() < 0) {
                System.out.println("Pay last remaining dues before getting new tickets!");
            } else {
                System.out.println("How many tickets do you want? :");
                int n = 0;
                System.out.println("Enter Discount code if applicable:");
                String dcode=scan.nextLine();
                System.out.println("Discount Applied !");
                while (true) {
                    try {
                        n = Integer.parseInt(scan.nextLine());
                        if (n > 0) {
                            break; // Exit the loop if input is valid
                        }
                        else {
                            System.out.println("Please enter a valid positive number of tickets.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid number.");
                    }
                }

                int discount = checkSplDeals(v1, n);
                if (discount != 0) {
                    System.out.println("Special Deal Applied, Congratulations on a discount of " + discount + "%");
                }

                double cost = 0;
                for (int i = 0; i < n; i++) {
                    System.out.println("Select event for ticket " + (i + 1));
                    System.out.println("Available Events:");
                    for (int eid : AttHash.keySet()) {
                        if (AttHash.get(eid).isEvent() == true) {
                            System.out.println("Event Name:" + AttHash.get(eid).getName() +
                                    "\nID:" + eid + "\nEvent Description:" + AttHash.get(eid).getDescription() +
                                    "\nEvent Price:" + AttHash.get(eid).getPrice());
                        }
                    } // see number of events to choose from

                    int id = 0;
                    while (true) {
                        try {
                            System.out.println("Enter Id:");
                            id = Integer.parseInt(scan.nextLine());
                            if (AttHash.containsKey(id) && AttHash.get(id).isEvent()) {
                                break; // Exit the loop if input is valid and the attraction exists as an event
                            } else {
                                System.out.println("Invalid ID. Please enter a valid event ID.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid number.");
                        }
                    }

                    Ticket t1 = new Ticket(id, AttHash.get(id).getPrice());  // for this visitor, take the visitors array list, and put the attraction with that id
                    cost += AttHash.get(id).getPrice();
                    v1.getVisiTickets().add(t1);
                    AttHash.get(id).setVisicount(AttHash.get(id).getVisicount() + 1); // increase visitor count for this attraction
                }

                cost -= cost * (discount / 100);
                v1.setBalance(v1.getBalance() - cost);
                System.out.println("Remaining Balance:" + v1.getBalance());
                Adminone.setRevenue(Adminone.getRevenue() + cost); // increase revenue
                if (v1.getBalance() < 0) {
                    System.out.println("Tickets added but Balance exceeded. Pay remaining dues at the earliest");
                } else {
                    System.out.println("Tickets bought Successfully !");
                }
            }
        } else if (Objects.equals(v1.getMembership(), "premium")) {
            System.out.println("No tickets needed for premium members :) Enjoy ");
        } else {
            System.out.println("Cannot buy tickets without membership!");
        }
    }
    //DO THIS BIG TIME BT

    public static void VisitAnimalInterface(Visitor v1){
        if (Objects.equals(v1.getMembership(), "basic") || Objects.equals(v1.getMembership(), "premium")){
            System.out.println("Choose Animal to visit (name): ");
            String name=scan.nextLine();
            System.out.println("1.Feed Animal"+"\n2.Read about Animal");
            int choice=scan.nextInt();
            scan.nextLine();
            switch(choice){
                case 1:
                    AniHash.get(name).feed();
                    break;
                case 2:
                    AniHash.get(name).read();
                    break;
            }
        }
        else{
            System.out.println("You need to Buy Membership first !");
        }


    } //Done all members can do this

    public static void VisitAttractionsInterface(Visitor v1) {// DO THIS

        System.out.println("Enter Attraction id:");
        int id = 0;
        while (true) {
            try {
                id = Integer.parseInt(scan.nextLine());
                if (AttHash.containsKey(id)) {
                    break; // Exit the loop if the entered ID is valid and corresponds to an attraction.
                } else {
                    System.out.println("Invalid Attraction Id. Please enter a valid Attraction Id.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid numeric Attraction Id.");
            }
        }

        boolean tickbool = false;
        if (AttHash.get(id).isEvent()) {
            if (Objects.equals(v1.getMembership(), "premium")) {
                tickbool = true;
            }
            else if (Objects.equals(v1.getMembership(), "basic")) {
                for (Ticket i : v1.getVisiTickets()) {
                    if (i.getId() == id) {
                        tickbool = true;
                        v1.getVisiTickets().remove(i);
                        break;
                    }
                }
            }

            if (tickbool) {
                System.out.println("Thank you for visiting");
            }
            else {
                System.out.println("You don't have tickets for this event");
            }
            }
        else {
            System.out.println("Sorry, Attraction isn't open yet");
        }
    } //done




    //INTERFACES END---------------------------------------------------------------------------------------------------------------------

    //MAIN Function--------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        //standard animals
        Mammal dog =new Mammal("mammal","dog","BARK!","Modern wolf is the dog's nearest living relative.The dog was the first species to be domesticated by humans");
        AniHash.put("dog",dog);
        Mammal cat=new Mammal("mammal","cat","ME-A-OW!","The only domesticated species in the family Felidae. It is valued by humans for companionship and its ability to kill vermin.");
        AniHash.put("cat",cat);

        Amphibian frog=new Amphibian("amphibian","frog","CROAK!","Frogs are amphibians, which are cold-blooded vertebrates, meaning they have backbones, that don't have scales. Amphibians live both on land and in water.");
        AniHash.put("frog",frog);
        Amphibian toad=new Amphibian("amphibian","toad","QWARK!","Toad is a common name for certain frogs, especially of the family Bufonidae,");
        AniHash.put("toad",toad);

        Reptile crocodile=new Reptile("reptile","crocodile","GRUNT!","Crocodiles or true crocodiles are large semiaquatic reptiles that live throughout the tropics in Africa, Asia, the Americas and Australia.");
        AniHash.put("crocodile",crocodile);
        Reptile chameleon=new Reptile("reptile","chameleon","HISS!","Chameleons or chamaeleons are best known for their distinct range of colors, being capable of shifting to different hues and degrees of brightness.");
        AniHash.put("chameleon",chameleon);

        //standard discounts
        //below 18 get 10%
        Discount unidis1=new Discount("MIN1",10,"Minors (age<18) ");
        DisHash.put(unidis1.getCode(),unidis1);
        //above get 10%
        Discount unidis2=new Discount("SEN1",20,"Senior Citizens (age>60)");
        DisHash.put(unidis2.getCode(),unidis2);

        //standard deals
        Deal moretwo=new Deal(3,15,"Buy more than 2 tickets, get 15% discount");
        SpdHash.put(moretwo.getNum(),moretwo);
        Deal morethree=new Deal(4,30,"Buy more than 3 tickets, get 30% discount");
        SpdHash.put(morethree.getNum(),morethree);


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
                    ViewSpecialDeals();
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
