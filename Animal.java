package org.example;

public abstract class Animal implements Living{
    private String type;
    private String name;
    private String sound;
    private String info;

    public void makeSound() {
        System.out.println(sound);
    }

    public void feed() {
        makeSound();
    }

    public void read(){
        System.out.println(info);
    }

    public Animal(String type, String name, String sound, String info) {
        this.type = type;
        this.name = name;
        this.sound = sound;
        this.info = info;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Name:" + name +
                "\nType:" + type+
                "\nDescription:" + info ;
    }
}
