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
            i--;
        }

        median = input[input.length/2];
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
            increaseCount();
        }


    }

    @Override
    public void write(String fileName, String str) {
        this.fileName = "hs" + fileName;
        super.write(this.fileName, str);
    }
}
