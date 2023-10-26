package org.example;

import java.util.HashMap;

public class Attraction {
    private static int i=0;
    private String name;
    private int id; //static so that every attraction gets unique id
    private String description;
    private double price;
    private boolean event=false; // default 0 is no event , 1 is event set
    private int visicount=0; //default 0, can increase



    //Constructor---------------------------------------------------------------------------------------------------------

    public Attraction(String name, String desc) {
        this.name = name;
        this.description = desc;
        this.id=++i;
        //AttHash.put(id,name);
    }

    //getters and setters-------------------------------------------------------------------------------------------------------------
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public  int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}

    public boolean isEvent() {return event;}
    public void setEvent(boolean event) {this.event = event;}

    public int getVisicount() {return visicount;}

    public void setVisicount(int visicount) {this.visicount = visicount;}

    //toString------------------------------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return "Attraction Name=:" + name + '\n' +
                "Description:=" + description + "\nID=" +this.getId();}
    }

