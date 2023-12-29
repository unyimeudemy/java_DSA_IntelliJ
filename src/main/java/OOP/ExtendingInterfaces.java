package OOP;

public class ExtendingInterfaces {

}

class obj implements B{
    @Override
    public void aa(){

    }

    @Override
    public void bb(){

    }
}

interface A{
    void aa();
}

interface B extends A{
    void bb();
}
