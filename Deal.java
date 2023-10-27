package org.example;

public class Deal {
    private int num; //number of ticker combo
    private int val; //discount kitna hai
    private String str;

    public int getNum() {return num;}
    public void setNum(int num) {this.num = num;}

    public int getVal() {return val;}
    public void setVal(int val) {this.val = val;}

    public String getStr() {return str;}
    public void setStr(String str) {this.str = str;}

    public Deal(int num, int val, String str) {
        this.num = num;
        this.val = val;
        this.str = str;
    }

    @Override
    public String toString() {
        return "Deal value:" + val +
                "\nDescription:" + str;
    }
}
