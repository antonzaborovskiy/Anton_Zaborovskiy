package homework1;

import java.util.ArrayList;

public class Task1 {
    public ArrayList<Object> getIntegersFromList(ArrayList<Object> list) {
        var sortedList = new ArrayList<Object>();

        for (int i=0;i<list.size();i++) {
            var value = list.get(i);
            if (value instanceof Integer && (Integer)value >= 0 ) {
                sortedList.add(value);
            }
        }

        return sortedList;
    }
}
