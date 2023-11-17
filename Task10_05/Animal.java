package Task10_05;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Animal implements Serializable {
    private transient int age;
    private String name;
    private transient String color;

    public Animal(int age, String name, String color) {
        this.age = age;
        this.name = name;
        this.color = color;
    }

    public Animal() {
    }
    private void writeObject(ObjectOutputStream oos){
        try {
            oos.writeInt(this.age);
            oos.defaultWriteObject();
            oos.writeObject(this.color);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    private void readObject(ObjectInputStream ois) {
        try {
            this.age = ois.readInt();
            ois.defaultReadObject();
            this.color = (String) ois.readObject();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
