import java.util.Arrays;

public class MergeSort extends Sort {


    @Override
    public int sort(int[] input) {
        int tempSize;
        int median = 0;
        int[] left;
        int[] right;
        if (input.length > 1) {
            tempSize = input.length / 2;
            left = Arrays.copyOf(input, tempSize);
            right = Arrays.copyOfRange(input, tempSize, input.length-1);
            sort(left);
            sort(right);
            merge(left, right, input);
        }
        if(input.length != 0) {
            median = input[input.length/2];
        }
        return median;
    }

    private void merge(int[] left, int[] right, int[] arr) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]){
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;

            }
            increaseCount();
            k++;
        }

        if(i == left.length) {
            for(int n = k; n < left.length + right.length; n++) {
                arr[n] = right[j];
                j++;
                increaseExchange();
            }
        } else {
            for(int n = k; n < left.length + right.length; n++) {
                arr[n] = left[i];
                i++;
                increaseExchange();
            }
        }
    }

    @Override
    public void write(String fileName, String str) {
        this.fileName = "ms" + fileName;
        super.write(this.fileName, str);
    }
}
