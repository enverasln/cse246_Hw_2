public class Sort {

    public static int insertion_sort(int[] input) {
        for (int i = 1; i < input.length; i++) {
            int key = input[i];
            int j = i - 1;
            while (j >= 0 && input[j] > key) {
                input[j+1] = input[j];
                j--;
            }
            input[j+1] = key;
        }
        int medianPosition = input.length / 2;

        return input[medianPosition];
    }
}