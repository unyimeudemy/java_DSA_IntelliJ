package OOP;

public class Interfaces {

    public static void main(String[] args) {
        NewBenz myBenz = new NewBenz();
        myBenz.start();
    }
}



class NewBenz {
    Engine engine;
    Media media;
    Appearance appearance;

    public NewBenz(){
        media = new BenzMedia();
        appearance = new BenzAppearance();
        engine = new BenzEngine();
//        engine = new AudiEngine();
    }

    public void start(){
        engine.start();
    }
}


class BenzMedia implements Media {

    @Override
    public void play(){
        System.out.println("Benz media play");
    }

    @Override
    public void pause(){
        System.out.println("Benz media pause");
    }

    @Override
    public void stop(){
        System.out.println("Benz media stop");
    }

}

class BenzEngine implements Engine{
    @Override
    public void start() {
        System.out.println("Benz Engine start");
    }

    @Override
    public void stop(){
        System.out.println("Benz Engine stop");
    }

    @Override
    public void acc(){
        System.out.println("Benz Engine accelerate");
    }
}

class BenzAppearance implements Appearance{

    @Override
    public void color() {
        System.out.println("Benz Appearance color");
    }

    @Override
    public void tires() {
        System.out.println("Benz Appearance tires");
    }

    @Override
    public void doors() {
        System.out.println("Benz Appearance doors");
    }
}

class AudiEngine implements Engine{
    @Override
    public void start() {
        System.out.println("Audi Engine start");
    }

    @Override
    public void stop(){
        System.out.println("Audi Engine stop");
    }

    @Override
    public void acc(){
        System.out.println("Audi Engine accelerate");
    }
}

interface Engine{
    static  final int PRICE = 1000;
    void start();
    void stop();
    void acc();
}

interface Appearance{
    void color();
    void  tires();
    void doors();
}

interface Media{
    void play();
    void pause();
    void stop();
}


