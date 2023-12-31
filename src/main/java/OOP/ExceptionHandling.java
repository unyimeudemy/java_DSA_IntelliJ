package OOP;

public class ExceptionHandling {
    public static void main(String[] args) {
        int a = 2;
        int b = 0;

        try {
//            int c = a / b;
            System.out.println(divide(a, b));
        }catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    static int divide(int a, int b) throws ArithmeticException, MyException{
        if(b == 0){
            throw new ArithmeticException("Do not divide with zero");
        }
        if(b == 1){
            throw new MyException("Do not divide with zero");
        }
        return a/b;
    }
}

class MyException extends Exception{
    public MyException(String message){
        super(message);
    }
}
