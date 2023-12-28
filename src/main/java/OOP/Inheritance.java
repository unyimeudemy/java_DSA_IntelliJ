package OOP;

public class Inheritance {
    public static void main(String[] args) {
        BoxWeight boxWeight = new BoxWeight(2.9);
        BoxWeight box2 = new BoxWeight(2, 1, 3);
        BoxWeight box3 = new BoxWeight();
        Box myBox = new BoxWeight();
        System.out.println(boxWeight.weight + ", " + boxWeight.h + ", " + box3.weight+ ", " + box2.h);
        BoxWeight b = new BoxWeight();
        b.getBox();
    }

}

class Box {
    int l;
    int w;
    int h;

    Box() {
        super();
        this.l = -1;
        this.w = -1;
        this.h = -1;
    }

    Box(int side){
        this.l = side;
        this.w = side;
        this.h = side;
    }

    Box(int l, int w, int h) {
        this.l = l;
        this.w = w;
        this.h = h;
    }

    Box (Box oldBox){
        this.h = oldBox.h;
        this.w = oldBox.w;
        this.l = oldBox.l;
    }

    static void getBox(){
        System.out.println("this is from box ");
    }

}

class BoxWeight extends Box{
    double weight;

    public BoxWeight() {
        this.weight = -11;
        this.h = 0;
    }

    public BoxWeight(BoxWeight other) {
        super(other);
       weight = other.weight;
    }

    public BoxWeight(double weight){
        this.weight = weight;
    }

    public BoxWeight(int side, double weight) {
        super(side);
        this.weight = weight;
    }

    public BoxWeight(int l, int w, int h, double weight) {
        super(l, w, h);
        this.weight = weight;
    }

    public BoxWeight(int l, int w, int h){

    }

//     static void getBox(){
//        System.out.println("this is from box weight");
//    }

}