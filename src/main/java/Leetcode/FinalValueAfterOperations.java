package Leetcode;

public class FinalValueAfterOperations {
    public static void main(String[] args) {
        String s = "G()()()()(al)";
        String sub = "(al)ooooooooooooooooooooo";
        int indexx = s.indexOf(sub);
        System.out.println(indexx);
        StringBuilder aa = new StringBuilder();

//        s.split()

        int[] arr = {2,4};
        int o = arr.length;


        System.out.println(o);



    }
        static int finalValueAfterOperations(String[] operations) {
            int X = 0;
            for(int i = 0; i < operations.length; i++){
                if(operations[i].equals("++X")){
                    X = X + 1;
                }else if(operations[i].equals("X++")){
                    X = X + 1;
                }else if(operations[i].equals("--X")){
                    X = X - 1;
                }else if(operations[i].equals("X--")){
                    X = X - 1;
                }
            }
            return X;

        }

        static void test(){
            int[] l = {1, 2, 4};


        }

}
