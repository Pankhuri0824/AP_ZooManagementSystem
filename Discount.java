package org.example;

public class Discount {
    private String code; //name of discount code
    private String category;
    private int value;

    //getter setters-----------------------------------------------------------------------------------------------
    public String getCode() {return code;}
    public void setCode(String code) {this.code = code;}

    public int getValue() {return value;}
    public void setValue(int value) {this.value = value;}

    public String getCategory() {return category;}
    public void setCategory(String category) { this.category = category;}

    //constructor-----------------------------------------------------------------------------------------------
    public Discount(String code, int value, String category) {
        this.code = code;
        this.value = value;
        this.category=category;
    }

    @Override
    public String toString() {
        return "Discount code:" + code +
                "\nCategory:" + category +
                "\nValue:" + value ;
    }
}
