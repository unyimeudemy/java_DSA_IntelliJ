package OOP;

public class DefaultMethods {
    public static void main(String[] args) {
        Obj2 oo = new Obj2();
//        oo.bb();
        One.staticMethod();

    }
}

class Obj2 implements One, Two{

}

interface One{
    static void staticMethod(){
        System.out.println("I am static");
    }
     default void aa(){
         System.out.println("this is a bb");
     }

}

interface Two {
    default void bb(){
        System.out.println("this is a bb");
    }
}

