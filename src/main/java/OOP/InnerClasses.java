package OOP;

public class InnerClasses {
    static class Test{
         static String name;
        public Test(String name){
            Test.name = name;
        }
    }
    public static void main(String[] args) {

        Test a = new  Test("unyime");
        Test b = new  Test("emma");

        System.out.println(a.name);
        System.out.println(b.name);

    }
}
