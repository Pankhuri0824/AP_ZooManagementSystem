package org.example;

public class Visitor {
    private String name;
    private int age;
    private int number;
    private double balance;
    private String email;
    private String password;
    private String membership=null; //defeault as null, otherwise basic or premium

    //constructor
    public Visitor(String name, int age, int number, double balance, String email, String password) {
        this.name = name;
        this.age = age;
        this.number = number;
        this.balance = balance;
        this.email = email;
        this.password = password;
    }

    //getters-------------------------------------------------------------------------------------------------------------
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public int getNumber() {
        return number;
    }
    public double getBalance() {
        return balance;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getMembership() {return membership;}

    //setters--------------------------------------------------------------------------------------------------------------
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setMembership(String membership) {this.membership = membership;}

    @Override
    public String toString() {
        return "Visitor name:"+ name +
                "\nAge=" + age +
                "\nNumber:" + number +
                "\nBalance:" + balance +
                "\nEmail:" + email +
                "\nPassword:" + password +
                "\nMembership:" + membership;
    }
}
