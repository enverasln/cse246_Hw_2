import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] input = new int[1], tempInput;
        int size, median;
        String str, fileName = "";
        InsertionSort insertionSort = new InsertionSort();
        MergeSort mergeSort = new MergeSort();
        HeapSort heapSort = new HeapSort();
        QuickSort quickSort = new QuickSort();
        QuickSortThreeMediain quickSortThreeMediain = new QuickSortThreeMediain();





        for (int j = 0; j < 5; j++) {

            size = 2;
            if(j == 0) {
                System.out.println("Input Random Generated");
                fileName = "_rnd.txt";
            } else if(j == 1) {
                System.out.println("Input Reverse Ordered");
                fileName = "_ro.txt";
            } else if( j == 2) {
                System.out.println("Input Ordered");
                fileName = "_o.txt";
            } else if(j == 3) {
                System.out.println("Input With At Least %50 Of Sorted Of The Beginning\n");
                fileName = "_sp.txt";
            } else if(j == 4) {
                System.out.println("Input With At Least %25 Of Unsorted Of The Ending\n");
                fileName = "_usp.txt";
            }
            for(int i = 2; i<=18; i++) {
                size = size << 1;
                if(j == 0) {
                    input = InputUtility.generateRandomInput(size);
                } else if(j == 1) {
                    input = InputUtility.generateReverseOrderedInput(size);
                } else if( j == 2) {
                    input = InputUtility.generateOrderedInput(size);
                } else if(j == 3) {
                    input = InputUtility.generatePercentageOrderedInput(size, 50);
                } else if(j == 4) {
                    input = InputUtility.generatePercentageOrderedInput(size, 75);
                }

                System.out.println("For " + size + " sizes input:");
                // Writing Insertion Sort
                insertionSort.resetCount();
                System.out.println("Insertion Sort");
                tempInput = Arrays.copyOf(input, size);
                median = insertionSort.sort(tempInput);
                // write file
                str = String.format("%d\t%d\n",size, insertionSort.getCount());
                insertionSort.write(fileName, str);
                System.out.println(String.format("Median: %d\t\tTime Complexity: %d",
                        median,insertionSort.getCount()));

                // Writing Merge Sort
                mergeSort.resetCount();
                System.out.println("Merge Sort");
                tempInput = Arrays.copyOf(input, size);
                median = mergeSort.sort(tempInput);
                // write file
                str = String.format("%d\t%d\n",size, mergeSort.getCount());
                mergeSort.write(fileName, str);
                System.out.println(String.format("Median: %d\t\tTime Complexity: %d",
                        median,mergeSort.getCount()));

                // Writing Max Heap Sort
                heapSort.resetCount();
                System.out.println("Max Heap Sort");
                tempInput = Arrays.copyOf(input, size);
                median = heapSort.sort(tempInput);
                // write file
                str = String.format("%d\t%d\n",size, heapSort.getCount());
                heapSort.write(fileName, str);
                System.out.println(String.format("Median: %d\t\tTime Complexity: %d",
                        median,heapSort.getCount()));


            }
        }


    }
}
