public class MergeSort extends Sort {


    @Override
    public int sort(int[] input) {
        int tempSize;
        int[] left;
        int[] right;
        if (input.length > 1) {
            tempSize = input.length / 2;
            left = new int[tempSize];
            right = new int[input.length - tempSize];
            for (int i = 0; i < tempSize; i++) {
                left[i] = input[i];
            }
            for (int i = tempSize; i < input.length; i++) {
                right[i-tempSize] = input[i];
            }
            sort(left);
            sort(right);
            merge(left, right, input);
        }
        return input[input.length / 2];
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
}
