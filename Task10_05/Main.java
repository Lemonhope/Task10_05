package Task10_05;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            File f = new File("file1.txt");
            Animal animal = new Animal(5, "Pes Patron", "white-brown");
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));

            // Серіалізуємо об'єкт Animal у байт-код
            oos.writeObject(animal);
            oos.flush();
            oos.close();

            // Десеріалізуємо
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            Animal newAnimal = (Animal) ois.readObject();
            ois.close();
            System.out.println(newAnimal.getAge() + "\t" + newAnimal.getName()+"\t"+newAnimal.getColor());
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
