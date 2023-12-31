package OOP;

import java.util.ArrayList;

public class CollectionFrameWork {

    public static void main(String[] args) {
        Operation add = (a, b) -> a + b;
        Operation subtract = (a, b) -> a - b;
        Operation multiply = (a, b) -> a * b;

        CollectionFrameWork myCal = new CollectionFrameWork();

        System.out.println(myCal.calculate(2, 3, add));
        System.out.println(myCal.calculate(2, 3, subtract));
        System.out.println(myCal.calculate(2, 3, multiply));
    }

    public int calculate(int a, int b, Operation ops){
        return ops.operation(a, b);
    }
}

interface Operation {
    int operation(int a, int b);
}
