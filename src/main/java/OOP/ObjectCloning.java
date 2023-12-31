package OOP;

import java.util.ArrayList;
import java.util.Arrays;

public class ObjectCloning {

    public static void main(String[] args) throws CloneNotSupportedException{
        HumanA unyime = new HumanA(22, "uniyime");
        HumanA twin = (HumanA) unyime.clone();
        twin.arr[0] = 100;
        System.out.println(Arrays.toString(unyime.arr));
        System.out.println(Arrays.toString(twin.arr));

    }

}

class HumanA implements Cloneable{
    int age;
    String name;
    int[] arr;

    public HumanA(HumanA other) {
        this.name = other.name;
        this.age = other.age;
        this.arr = new int[]{1, 4, 5};
    }

    public HumanA(int age, String name) {
        this.age = age;
        this.name = name;
        this.arr = new int[]{1, 4, 5};

    }

    @Override
    protected  Object clone() throws  CloneNotSupportedException {
        HumanA twin = (HumanA) super.clone();
        twin.arr = new int[this.arr.length];
        for (int i = 0; i < this.arr.length; i++) {
            twin.arr[i] = this.arr[i];
        }
        return twin;
    }

    @Override
    public String toString() {
        return "HumanA{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

