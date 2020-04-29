import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] input, tempInput;
        int size, median;
        String str, fileName;
        InsertionSort insertionSort = new InsertionSort();
        MergeSort mergeSort = new MergeSort();
        HeapSort heapSort = new HeapSort();
/*
        input = InputUtility.generateRandomInput(10);
        tempInput = Arrays.copyOf(input, input.length);
        InputUtility.printInput(tempInput);
        mergeSort.sort(tempInput);
        InputUtility.printInput(tempInput);

*/

        for (int j = 0; j < 5; j++) {

            size = 1;
            if(j == 0) {
                System.out.println("\nRandom Generated");
                fileName = "_rnd.txt";
            } else if(j == 1) {
                System.out.println("\nReverse Ordered");
                fileName = "_ro.txt";
            } else if( j == 2) {
                System.out.println("\nInput Ordered");
                fileName = "_o.txt";
            } else if(j == 3) {
                System.out.println("\nAt Least %50 Of Sorted Of The Beginning");
                fileName = "_sp.txt";
            } else {
                System.out.println("\nAt Least %25 Of Unsorted Of The Ending");
                fileName = "_usp.txt";
            }
            for(int i = 0; i<5; i++) {
                size = size << 1;
                if(j == 0) {
                    input = InputUtility.generateRandomInput(size);
                } else if(j == 1) {
                    input = InputUtility.generateReverseOrderedInput(size);
                } else if( j == 2) {
                    input = InputUtility.generateOrderedInput(size);
                } else if(j == 3) {
                    input = InputUtility.generatePercentageOrderedInput(size, 50);
                } else {
                    input = InputUtility.generatePercentageOrderedInput(size, 75);
                }

                System.out.println("For " + size + " sizes input:");

                for (int k = 0; k < 3; k ++ ) {
                    String prefix;
                    long timeComplexity;
                    tempInput = Arrays.copyOf(input, size);
                    // Writing Insertion Sort
                    if(k == 0) {
                        insertionSort.resetCount();
                        System.out.print("Insertion Sort:\t\t");
                        median = insertionSort.sort(tempInput);
                        timeComplexity = insertionSort.getCount();
                        str = String.format("%d\t%d\n",size, timeComplexity);
                        prefix = "is";

                    }
                    // Writing Insertion Sort
                    else if(k == 1) {
                        mergeSort.resetCount();
                        System.out.print("Merge Sort:\t\t\t");
                        median = mergeSort.sort(tempInput);
                        timeComplexity = mergeSort.getCount();
                        str = String.format("%d\t%d\n",size, timeComplexity);
                        prefix = "ms";
                    }
                    // Writing Max Heap Sort
                    else {
                        mergeSort.resetCount();
                        System.out.print("Max-Heap Sort:\t\t");
                        median = heapSort.sort(tempInput);
                        timeComplexity = heapSort.getCount();
                        str = String.format("%d\t%d\n",size, timeComplexity);
                        prefix = "hs";
                    }
                    System.out.println(String.format("Median: %d\t\tTime Complexity: %d", median, timeComplexity));
                    InputUtility.writeFile(prefix.concat(fileName), str);
                }
            }
        }


    }
}
