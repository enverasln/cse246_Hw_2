public class Main {

    public static void main(String[] args) {

        int[] input;
        int size, median;
        String str;
        InsertionSort insertionSort = new InsertionSort();
        MergeSort mergeSort = new MergeSort();
        size = 2;

        input = InputUtility.generateRandomInput(128);
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
        System.out.println();
        mergeSort.sort(input);

        System.out.println("\n" + mergeSort.getCount());

        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }

        /*
        for (int i = 2; i<= 18; i++) {
            size = size << 1;
            input = InputUtility.generateRandomInput(size);
            median = insertionSort.sort(input);
            str = String.format("%d\t%d\n",size, insertionSort.getCount());
            System.out.println(String.format("Median: %d\t\tInput Size:%d\t\tTime Complexity:%d\n", median, size,insertionSort.getCount()));
            insertionSort.write("is_rnd.txt", str);

        }

         */
    }
}
