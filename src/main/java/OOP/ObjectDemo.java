package OOP;

public class ObjectDemo {
    int num;
    public ObjectDemo(int num){
        this.num = num;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
//        return num;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) {
        ObjectDemo obj = new ObjectDemo(32);
        ObjectDemo obj2 = new ObjectDemo(32);
        System.out.println(obj.getClass().getName());

    }
}
