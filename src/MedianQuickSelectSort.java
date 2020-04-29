public class MedianQuickSelectSort extends Sort {
    @Override
    public int sort(int[] input) {
        quickSelect(input, 0, input.length-1, input.length/2);

        return input[input.length/2];
    }

    private void quickSelect(int[] input, int left, int right, int k ) {
        if (left + 10 > right) {
            InsertionSort is = new InsertionSort();
            is.sort(input);
            increaseCount(is.getCount());
            return;
        }

        int pivot = findPivot(input, left, right);
        if (pivot == input[k]) return;
        int partionPoint = partition(input, left, right, pivot);
        increaseCount();
        if( k <= partionPoint )
            quickSelect( input, left, partionPoint - 1, k );
        else if( k > partionPoint + 1 )
            quickSelect( input, partionPoint + 1, right, k );
    }

    private int findPivot(int[] input, int left, int right) {
        int middle = (left + right) / 2;
        increaseCount();
        if( input[middle] < input[left] )
            InputUtility.swap( input, left, middle );
        increaseCount();
        if( input[right] < input[left] )
            InputUtility.swap( input, left, right );
        increaseCount();
        if( input[right] < input[middle])
            InputUtility.swap( input, middle, right );

        // Place pivot at position high - 1
        InputUtility.swap( input, middle, right - 1 );
        return input[right - 1];
    }

    private int partition(int[] input, int left, int right, int pivot) {
        int l, r;
        for(l = left, r = right - 1; ;) {
            while(input[++l] < pivot) increaseCount();

            while(pivot < input[--r])increaseCount();

            increaseCount();
            if(l >= r)
                break;
            InputUtility.swap(input, l, r);
        }

        // Restore pivot
        InputUtility.swap(input, l, right - 1);
        return l;
    }
}
