package OOP;

public class PackagesExample {
    public static void main(String[] args) {
        Human unyime = new Human("unyime", 20);
        System.out.println(Human.population); // outputs 1
        Human emma = new Human("emma", 21);
        System.out.println(Human.population); // outputs 2
    }

    static void greet(){
        System.out.println("yes");
        PackagesExample myPackage = new PackagesExample();
        myPackage.shout();
//        shout();
    }

    void hail(){
        shout();
    }

    void shout(){
        System.out.println("chai");
        greet();
    }
}

class Human {
    String name;
    int age;
    static int population;

    Human(String name, int age){
        this.name = name;
        this.age = age;
        Human.population++;
//        System.out.println(Human.population);

    }
}
