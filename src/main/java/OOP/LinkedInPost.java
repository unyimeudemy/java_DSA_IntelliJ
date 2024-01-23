package OOP;

import java.util.PriorityQueue;

public class LinkedInPost {

    public static void main(String[] args) {
        BoxWeightx box3 = new BoxWeightx();
        System.out.println(box3.w);

        Boxx b = new BoxWeightx();

        System.out.println(b.l);

//        BoxWeightx b2 = new Boxx();

    }

}

class Boxx {
    int l;
    int w;
    int h;

    Boxx(){
        this.h = -1;
        this.w = -1;
        this.l = -1;

    }


    Boxx(int side){
        this.l = side;
        this.w = side;
        this.h = side;
    }

    Boxx(int l, int w, int h) {
        this.l = l;
        this.w = w;
        this.h = h;
    }

    Boxx (Box oldBox){
        this.h = oldBox.h;
        this.w = oldBox.w;
        this.l = oldBox.l;
        PriorityQueue<Integer> qq = new PriorityQueue<>();

    }

}

class BoxWeightx extends Boxx{
    double weight;

    public BoxWeightx() { // this is used in creating boxWeight
        this.weight = 11;
    }

    public BoxWeightx(double weight){ // this is used in creating box2
        this.weight = weight;
    }

    public BoxWeightx(int l, int w, int h){ // this is used in creating box3
        this.h = h;
    }

}

