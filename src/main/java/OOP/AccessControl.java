package OOP;

import java.util.ArrayList;

public class AccessControl {
      int num;
    private Integer[] arr;
    private String name;

    public int getNum() {

        return num;
    }

    public Integer[] getArr() {
        return arr;
    }

    public String getName() {
        return name;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setArr(Integer[] arr) {
        this.arr = arr;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<>();

    }
}

class Client {

    public void test(){
        AccessControl a = new AccessControl();
        int b= a.num;
    }
}
