public class HeapSort extends Sort {
    @Override
    public int sort(int[] input) {
        int median= input[0];
        int i = input.length / 2 - 1;

        while (i >= 0) {
            heapify(input, input.length, i);
            i--;
        }

        i = input.length - 1;
        while (i > 0) {
            int temp = input[0];
            input[0] = input[i];
            input[i] = temp;

            heapify(input, i, 0);
            if (i == Math.floor(input.length / 2.0)) {
                median = input[i];
                break;
            }
            i--;
            increaseCount();
        }

        return median;
    }

    private void heapify(int[] input, int n, int i) {
        int j = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        if (left < n && input[left] > input[j])
            j = left;

        if (right < n && input[right] > input[j])
            j = right;

        if (j != i ) {
            int temp = input[i];
            input[i] = input[j];
            input[j] = temp;
            increaseExchange();
            heapify(input, input.length, j);
        }
    }
}
