package OOP;

public class NestedInterfaces {

}

class testClass implements OuterInterface.InnerInterface{
    @Override
    public void fun() {

    }

    // this will be needed if you only implement OuterInterface
//    @Override
//    public void all() {
//
//    }

}

interface OuterInterface {
    void all();
    interface InnerInterface{
        void fun();
    }
}
