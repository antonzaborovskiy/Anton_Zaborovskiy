package homework1;

public class Task3 {
    public int sumAllDigits(int a) {
        int newValue = 200;
        System.out.println(a);
        while (newValue >= 10) {
            newValue = 0;
            while(a>0) {
                newValue += a%10;
                a = a / 10;
            }
            a = newValue;
            System.out.println(a);
        }

        return a;
    }
}
