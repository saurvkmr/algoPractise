package practise.misc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompareFiles {
    public static void main(String[] args) {
        try {
            List<String> us = Files.readAllLines(Path.of("/Users/s0k02c9/Downloads/limo-persistence-config-us.properties"));
            List<String> ca = Files.readAllLines(Path.of("/Users/s0k02c9/Downloads/limo-persistence-config-ca.properties"));
            compareFiles(us, ca);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void compareFiles(List<String> us, List<String> ca) {
        Map<String, String> usPropertyMap = new HashMap<>(us.size());
        Map<String, String> caPropertyMap = new HashMap<>(ca.size());

        us.forEach(prop -> {
            String[] keyValue = prop.split("=");
            usPropertyMap.put(keyValue[0], keyValue[1]);
        });

        ca.forEach(prop -> {
            String[] keyValue = prop.split("=");
            caPropertyMap.put(keyValue[0], keyValue[1]);
        });

        System.out.println(usPropertyMap.size() + " " + caPropertyMap.size());

        for (Map.Entry<String, String> entry : usPropertyMap.entrySet()) {
            /*if (!caPropertyMap.containsKey(entry.getKey())) {
                System.out.println(String.join(" - ", entry.getKey(), entry.getValue()));
            }*/

            if (diffNotDueToKeySpace(entry.getValue(), caPropertyMap.get(entry.getKey())) && !entry.getKey().contains("logistics_goldstandards")) {
                System.out.println(String.join(" - ", entry.getKey(), entry.getValue(), caPropertyMap.get(entry.getKey())));
            }
        }

        /*for (Map.Entry<String, String> entry : caPropertyMap.entrySet()) {
            if (!usPropertyMap.containsKey(entry.getKey())) {
                System.out.println(String.join(" - ", entry.getKey(), entry.getValue()));
            }
        }*/


    }

    private static boolean diffNotDueToKeySpace(String usValue, String caValue) {
        if (usValue.equals("limo") && caValue.equals("limo_ca"))
            return false;
        if (usValue.equals("limo_store_item") && caValue.equals("limo_store_item_ca"))
            return false;
        return !usValue.equals(caValue);
    }
}
