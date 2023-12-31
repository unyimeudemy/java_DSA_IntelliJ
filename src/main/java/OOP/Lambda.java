package OOP;

public class Lambda {
    public static void main(String[] args) {
//        Cat newCat = new Cat();
//        printThing(newCat);

        AnimalSound catSound = () -> System.out.println("Meow");
        printThing(catSound);
    }

    static void printThing(AnimalSound animal){
        animal.sound();
    }
}

//class Cat implements AnimalSound{
//    @Override
//    public void sound() {
//        System.out.println("Meow");
//    }
//}

@FunctionalInterface
interface AnimalSound {
    void sound();

    default void a (){
        System.out.println("This is default");
    }

    static void b (){
        System.out.println("this is static");
    }
}
