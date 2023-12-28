package OOP;

public class Polymorphism {

}

class Shapes{
    void area(){
        System.out.println("This is the  area");
    }
}

class Square extends Shapes{
    @Override
    void area (){
        System.out.println("square area");
    }

}

class Triangle extends Shapes{
    @Override
    void area(){
        System.out.println("triangle area");
    }
}
