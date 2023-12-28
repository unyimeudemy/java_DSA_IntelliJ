package OOP;

public class AbstractClass {
    public static void main(String[] args){
        Child mychild = new Child(22);
        mychild.career();
    }
}

abstract class Parent {
    int age;

    public Parent(int age) {
        this.age = age;
    }

    abstract void career();
    abstract  void partner();
}

class Child extends Parent{

    public Child(int age) {
        super(age);
    }

    @Override
    void career() {
        System.out.println("this is in career");
    }

    @Override
    void partner() {
        System.out.println("this is in partner");
    }

}
