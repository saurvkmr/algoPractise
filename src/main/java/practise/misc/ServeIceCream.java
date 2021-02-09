package practise.misc;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class ServeIceCream {

    private Map<Integer, Integer> denominationCount;
    private int iceCreamCost;

    public ServeIceCream() {
        denominationCount = new TreeMap<>(Collections.reverseOrder());
        iceCreamCost = 5;
    }

    public boolean ableToServe(int[] money) {
        for (int amount : money) {
            if (amount == iceCreamCost) {
                int count = denominationCount.getOrDefault(amount, 0);
                denominationCount.put(amount, ++count);
            } else {
                if (denominationCount.isEmpty() || !ableToProvideChange(amount - iceCreamCost))
                    return false;
                else {
                    int newBillCount = denominationCount.getOrDefault(amount, 0);
                    denominationCount.put(amount, ++newBillCount);
                }
            }
        }
        return true;
    }

    private boolean ableToProvideChange(int change) {
        for (Map.Entry<Integer, Integer> bills : denominationCount.entrySet()) {
            int key = bills.getKey();
            int count = bills.getValue();
            while (change >= key && count > 0) {
                denominationCount.put(key, --count);
                change -= key;
            }
            if (change == 0)
                return true;
        }
        return false;
    }

    Object me() {
        return "Hello";
    }
}
