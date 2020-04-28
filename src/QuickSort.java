public class QuickSort extends Sort {
    @Override
    public int sort(int[] input) {
        quickSortFirstPivot(input, 0, input.length - 1);
        return input[input.length / 2];
    }

    public void quickSortFirstPivot(int[] input, int low, int high) {
        if(low < high) {
            // pi is partitioning index
            int pi = partition(input, low, high);
            quickSortFirstPivot(input, low, pi - 1); // Before pi
            quickSortFirstPivot(input, pi + 1, high); // After Pi
        }
    }

    public int partition(int[] input, int low, int high) {
        int pivot = input[low];
        int temp;
        int i  = low + 1; // index of smaller element
        for (int j = low + 1; j <= high; j++) {
            if (input[j] < pivot) {
                temp = input[i];
                input[i] = input[j];
                input[j] = temp;
                i++;
                increaseCount();
            }
        }
        temp = input[i-1];
        input[i-1] = input[low];
        input[low] = temp;
        return i-1;
    }

}
