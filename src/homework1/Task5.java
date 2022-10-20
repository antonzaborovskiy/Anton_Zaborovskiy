package homework1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Task5 {
    public String task5(String friends) {
        friends = friends.toUpperCase();
        ArrayList<String> friendsSurnames = new ArrayList<>();
        Map<String, ArrayList<String>> friendsMap = new HashMap<>();
        String[] pairs = friends.split(";");

        for (int i=0;i<pairs.length;i++) {
            String pair = pairs[i];
            String[] keyValue = pair.split(":");
            var firstName = keyValue[0];
            var lastName = keyValue[1];
            friendsSurnames.add(lastName);

            if (friendsMap.containsKey(lastName)) {
                var firstNames = friendsMap.get(lastName);
                firstNames.add(firstName);
            } else {
                ArrayList<String> firstNames = new ArrayList<>();
                firstNames.add(firstName);
                friendsMap.put(lastName, firstNames);
            }
        }

        friendsSurnames = uniSort(friendsSurnames);


        Map<String, ArrayList<String>> sorted = new HashMap<>();

        for (String key: friendsSurnames) {
            var value = friendsMap.get(key);
            value.sort((p1, p2) -> p1.compareTo(p2));
            sorted.put(key, value);
        }

        var res = "";
        for (String key: friendsSurnames) {
            for (String value: sorted.get(key)) {
                res += "(" + key + ":" + value + ")";
            }
        }
        System.out.println(res);
        return res;
    }

    private ArrayList<String> uniSort(ArrayList<String> data) {
        data.sort((p1, p2) -> p1.compareTo(p2));
        var set = new HashSet<String>(data);
        data.clear();
        data.addAll(set);
        return data;
    }
}
