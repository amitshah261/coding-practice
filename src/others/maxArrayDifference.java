package others;

public class maxArrayDifference {

    // Find max difference between two elements in an array such that the smaller element lies on the left of the bigger
    // element. Return -1, if no such element exists.
    // Complete the maxDifference function below.
    static int maxDifference(int[] a) {
        if(a == null || a.length < 2){
            return -1;
        }
        int mins[] = new int[a.length];
        mins[0] = a[0];
        for(int i=1; i < a.length; i++){
            mins[i] = Math.min(a[i], mins[i-1]);
        }
        int maxDiff = -1;
        for(int i=1; i < a.length; i++){
            int currentDiff = a[i] - mins[i-1];
            if(currentDiff > maxDiff){
                maxDiff = currentDiff;
            }
        }
        return maxDiff;

    }

    public static void main(String[] args) {
        System.out.println(maxDifference(new int[]{2, 8, 3, 10, 2, 4, 8, 1})); // 8
        System.out.println(maxDifference(new int[]{10, 7, 6, 2, 1}));
    }

}
