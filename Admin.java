package org.example;

import java.util.ArrayList;

public class Admin {

    private final String username= "admin";
    private final String password= "admin123";
    private static double revenue=0; //default 0, then increases
    private static int numbervis=0; //default 0, then increases

    public String getUsername() {return username;}
    public String getPassword() {return password;}

    public static double getRevenue() {return revenue;}
    public static void setRevenue(double revenue) {Admin.revenue = revenue;}

    public static int getNumbervis() {return numbervis;}
    public static void setNumbervis(int numbervis) {Admin.numbervis = numbervis;}
}
