package OOP;

public class Enums {
    enum Week {
        Monday , Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday
    }

    public static void main(String[] args) {
        Week day;
        day = Week.Friday;

        System.out.println(day);
        System.out.println(day.ordinal());
        System.out.println(day.compareTo(Week.Monday));


        for (Week daysInAWeek : Week.values()){
            System.out.println(daysInAWeek);
        }
    }
}


