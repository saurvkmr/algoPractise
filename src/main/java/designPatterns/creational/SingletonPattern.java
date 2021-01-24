package designPatterns.creational;

import java.util.Collections;
import java.util.List;

public class SingletonPattern {
    public static void main(String[] args) {
        List<String> singletonList = Collections.singletonList("Saurav");
        singletonList.add("Rohan");
    }

}

class Connector {
    private static Connector connection;

    private Connector(){}
    private void init() {
        // complex initialisation
    }
    public static Connector getInstance() {
        if (connection != null) return connection;
        synchronized (connection) {
            connection = new Connector();
            connection.init();
            return connection;
        }
    }
}

// when no complex initialisation is required
class Connector2 {
    private static Connector2 connection = new Connector2();

    private Connector2(){}
    private void init() {
        // complex initialisation
    }
    public static Connector2 getInstance() {
        return connection;
    }
}