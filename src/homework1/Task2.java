package homework1;

public class Task2 {
    public String first_non_repeating_letter(String word) {
        int uni;

        for (int i = 0, n = word.length(); i < n; i++) {
            uni = 0;
            char first = word.charAt(i);
            for (int j=0; j<n; j++) {
                if (first == word.charAt(j)) {
                    uni++;
                }

                if (uni > 1) {
                    break;
                }
            }

            if (uni < 2) {
                return Character.toString(first);
            }
        }

        return "";
    }
}
