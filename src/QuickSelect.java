import java.util.Arrays;
import java.util.Random;
public class QuickSelect extends Sort {
    public int sort(int[] input){
        quickSelect(input,0,input.length - 1,input.length/2);

        return input[input.length/2];
    }

    public int partition(int[] A, int left, int right, int pivotIndex)
    {

        int pivot = A[pivotIndex];


        InputUtility.swap(A, pivotIndex, right);

        int pIndex = left;
        int i;


        for (i = left; i < right; i++)
        {
            increaseCount();
            if (A[i] <= pivot)
            {
                InputUtility.swap(A, i, pIndex);
                pIndex++;
            }
        }


        InputUtility.swap(A, pIndex, right);


        return pIndex;
    }

    public int quickSelect(int[] A, int left, int right, int k)
    {
        increaseCount();
        if (left == right) {
            return A[left];
        }

        // select a pivotIndex as left
        int pivotIndex = left;

        pivotIndex = partition(A, left, right, pivotIndex);

        increaseCount();
        if (k == pivotIndex) {
            return A[k];
        }

        else if (k < pivotIndex) {
            return quickSelect(A, left, pivotIndex - 1, k);
        }


        else {
            return quickSelect(A, pivotIndex + 1, right, k);
        }
    }
}
