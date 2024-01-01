package Leetcode;

public class DefangIPaddr {
    public static void main(String[] args) {
        DefangIPaddr test = new DefangIPaddr();

//        System.out.println(test.defangIPaddr("255.100.50.0"));
//        System.out.println(test.defangIPaddr("1.1.1.1"));
        System.out.println(test.defangIPaddr2("1.1.1.1"));


    }
    public String defangIPaddr(String address){
        String result = "";
        for (int i = 0; i < address.length(); i++){
            if(address.charAt(i) == '.'){
                result += "[.]";
            }else{
                result += address.charAt(i);
            }
        }
        return result;
    }

    public String defangIPaddr2(String address) {
        StringBuilder str = new StringBuilder();
        for (char c : address.toCharArray()){
            str.append((c == '.')? "[.]" : c );
        }
        return str.toString();
    }
}
