package OOP;

import java.util.ArrayList;
import java.util.Arrays;

public class ObjectCloning {

    public static void main(String[] args) throws CloneNotSupportedException{
        HumanA unyime = new HumanA(22, "uniyime");
//        unyime.test();
        String res = unyime.defangIPaddr("1.1.1.1");
        System.out.println(res);


//        HumanA twin = (HumanA) unyime.clone();
//        twin.arr[0] = 100;
//        System.out.println(Arrays.toString(unyime.arr));
//        System.out.println(Arrays.toString(twin.arr));

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
     void test(){
        ArrayList<String> aa = new ArrayList<>();
        String ss = "aassdfsd";
         System.out.println(ss.charAt(5));
        aa.add("sd");
         aa.add("aa");
         aa.add("gg");
         aa.add("hh");
//         System.out.println(aa.indexOf("hh"));

    }

    public String defangIPaddr(String address) {
        int start = 0;
        int end = 0;
        int k = 0;
        String defangedAddr = "";

        ArrayList<String> chunks = new ArrayList<>();
        for(int i = 0; i < address.length(); i++){
            if (address.charAt(i) == '.'){
                end = i;
                chunks.add(address.substring(start, end));
                start = end + 1;
            }
            if(i == address.length() - 1){
                chunks.add(address.substring(start));
            }
        }
        System.out.println(chunks);

        for (int i = 0; i < chunks.size(); i++){
            if(i == chunks.size() - 1 ){
                defangedAddr =  defangedAddr + chunks.get(i);
            }else{
                defangedAddr = defangedAddr + chunks.get(i) + "[.]";
            }
        }

        return defangedAddr;
    }
}

