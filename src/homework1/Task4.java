package homework1;

import java.util.stream.IntStream;

public class Task4 {
    public int countSumPairsForTarget(int target, int[] arr) {
        var counter = 0; 
        for (int i=0; i<arr.length; i++) {
            for (int j=i+1; j < arr.length; j++) {
                if (arr[i]+arr[j] == target) {
                    counter++;
                }
            }
        }

        if (counter == 0) {
            counter = -1;
        }

        System.out.println(counter);
        return counter;
    }

    public void countSumPairsForTargetStream(int target, int[] arr) {
        IntStream.range(0, arr.length).forEach(i -> {
            IntStream.range(i+1, arr.length).forEach(j -> {
                var sum = arr[i]+arr[j];
                if (sum == target) {
                    System.out.println(arr[i] + " + " + arr[j] + " = " + sum);
                }
            }); 
        });
    }
}
