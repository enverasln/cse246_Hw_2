import java.util.*;

public class InputUtility {

    public static int[] generateRandomInput(int inputSize) {
        Random rnd = new Random();
        int[] input = new int[inputSize];
        for(int i = 0; i < inputSize; i++) {
            input[i] = rnd.nextInt(1000);
        }
        return input;
    }

    public static int[] generateReverseOrderedInput(int inputSize) {
        int[] input = generateOrderedInput(inputSize);
        int temp;
        for(int i = 0; i < Math.floor(inputSize/2.0); i++) {
            temp = input[i];
            input[i] = input[inputSize-i-1];
            input[inputSize-i-1] = temp;
        }
        return input;
    }

    public static int[] generateOrderedInput(int inputSize) {
        int[] input = generateRandomInput(inputSize);
        Arrays.sort(input);
        return input;
    }

    public static int[] generatePercentageOrderedInput(int inputSize, int percentage) {
        int[] input = generateOrderedInput(inputSize);
        int tempSize = inputSize * percentage/100;
        Random rnd = new Random();
        int j;
        for (int i = 0; i < tempSize; i++) {
            j = tempSize + rnd.nextInt(tempSize);
            input[tempSize+i]=input[j];
        }
        return input;
    }



}
