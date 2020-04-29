import java.util.Arrays;
public class MedianOfMedians extends Sort{
    public static int comparisons = 0;
    public static int Icomparisons = 0;

    public int sort(int[] input){
        return select(input,(int)Math.ceil(input.length / 2) + 1);
    }
   /* public int select(int[] input, int left, int right, int n){
        if ( input.length < 11) {
            InsertionSort insertionSort = new InsertionSort();
            insertionSort.sort(input);
            return input.length / 2;
        }
        while(true){
            if (left == right){
                return left;
            }
            int pivotIndex = pivot(input, left, right);
            pivotIndex = partition(input, left, right, pivotIndex, n);
            if (n == pivotIndex) {
                return n;
            }
            else if (n < pivotIndex) {
                right = pivotIndex - 1;
            }
            else {
                left = pivotIndex + 1;
            }

        }
    }

    public int partition(int[] input, int left, int right, int pivotIndex, int n) {
        int pivotValue = input[pivotIndex];
        InputUtility.swap(input,pivotIndex, right);
        int storeIndex = left;

        for (int i = left; i <= right - 1; i++){
            if (input[i] < pivotValue) {
                InputUtility.swap(input, storeIndex, i);
                storeIndex++;
            }
        }
        int storeIndexEq = storeIndex;
        for (int i = storeIndex; i <= right - 1; i++) {
            if (input[i] == pivotValue) {
                InputUtility.swap(input, storeIndexEq, i);
                storeIndexEq++;
            }

        }
        InputUtility.swap(input,right,storeIndexEq);
        if (n < storeIndex) {
            return storeIndex;
        }
        if (n <= storeIndexEq) {
            return n;
        }
        return storeIndexEq;
    }

    public int pivot (int[] input, int left, int right) {
        if (right - left < 5) {
            return partition5(input, left,right);
        }
        for (int i = left; i <= right; i=i+5 ) {
            int subRight = i + 4;
            if (subRight > right) {
                subRight = right;
            }
            int median5 = partition5(input,i, subRight);
            InputUtility.swap(input, median5, left + ((i - left) / 5) );
        }

        int mid = (right - left) / 10 + left + 1;
        return select(input, left, left + (right - left) / 5, mid);
    }

    public int partition5 (int[] input, int left, int right){
        int i = left + 1;
        while (i <= right) {
            int j = i;
            while (j > left && input[j-1] > input[j] ) {
                InputUtility.swap(input, j-1,j);
                j = j - 1;
            }
            i = i + 1;
        }
        return ((left + right) / 2);
    }*/
   public int select(int[] input_array, int k){
       if(input_array.length < 11){

           InsertionSort insertionSort = new InsertionSort();
           insertionSort.sort(input_array);

           return input_array[k-1];
       }
       if(input_array.length%5!=0){
           int[] temp_array = new int[(input_array.length+5-(input_array.length%5))];
           int i = input_array.length;
           for(int a = 0; a < input_array.length; ++a){
               temp_array[a] = input_array[a];
           }
           for(int x = 0; x < 5-(input_array.length%5); ++x){
               temp_array[i] = Integer.MAX_VALUE;
               ++i;
           }
           input_array = temp_array;
       }
       int num_arrays = input_array.length/5;
       int[][] arrays_of_five = new int[num_arrays][5];
       int[] median_array = new int[num_arrays];
       int[] greater_than_median = new int[input_array.length];
       int gtm_index = 0; //greater than median index
       int[] less_than_median = new int[input_array.length];
       int ltm_index = 0; //less than median index
       int[] equal_to_median = new int[input_array.length];
       int etm_index = 0;
       int[] return_array;
       for(int i = 0; i < num_arrays; ++i){
           for(int j = 0; j < 5; ++j){
               arrays_of_five[i][j] = input_array[j+(5 * i)];
           }
       }
       for(int i = 0; i < num_arrays; ++i){
           median_array[i] = select(arrays_of_five[i], 2);
       }
       int median = select(median_array, median_array.length/2);
       for(int i = 0; i < input_array.length; ++i){
           comparisons+=2;
           if(input_array[i] > median){
               greater_than_median[gtm_index] = input_array[i];
               ++gtm_index;
               comparisons--;
           }
           else if(input_array[i] == median){
               equal_to_median[etm_index] = median;
               ++etm_index;
           }
           else{
               less_than_median[ltm_index] = input_array[i];
               ++ltm_index;
           }
       }
       if(k <= ltm_index){
           return_array = new int[ltm_index];
           for(int i = 0; i < ltm_index; ++i){
               return_array[i] = less_than_median[i];
           }
           return select(return_array, k);
       }
       if(k > (ltm_index + etm_index)){
           return_array = new int[gtm_index];
           for(int i = 0; i < gtm_index; ++i){
               return_array[i] = greater_than_median[i];
           }
           return select(return_array, (k - (ltm_index + etm_index)));
       }
       return median;
   }
}
