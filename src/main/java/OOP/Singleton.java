package OOP;

public class Singleton {

        private static Singleton instance;

        private Singleton() {
            // Private constructor
        }

        public static Singleton getInstance() {
            if (instance == null) {
                instance = new Singleton();
            }
            return instance;
        }

        // Other methods...

        public static void main(String[] args) {
            // Accessing the singleton instance without creating an object
            Singleton singleton = Singleton.getInstance();
        }

}
