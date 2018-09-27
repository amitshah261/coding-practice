package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class countCutSticks {

    /* In each iteration you remove the min number of sticks from each element
     * Return the number of sticks remaining at the start of each iteration.
     * Complete the 'cutSticks' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY lengths as parameter.
     */

    private static List<Integer> cutSticks(List<Integer> lengths) {
        // Write your code here
        List<Integer> cuts = new ArrayList<>();
        int totalSticks = lengths.size();
        while(totalSticks > 0) {
            int minCut = findMinCut(lengths);
            cuts.add(totalSticks);
            for(int i = 0; i < lengths.size(); i++){
                int currentLength = lengths.get(i);
                if(lengths.get(i) > 0){
                    lengths.set(i, currentLength - minCut);
                    if(currentLength - minCut == 0){
                        totalSticks--;
                    }

                }
            }
        }
        return cuts;
    }

    private static int findMinCut(List<Integer> lengths){
        int min = Integer.MAX_VALUE;
        for(Integer element: lengths){
            if(element > 0 && element <= min){
                min = element;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(cutSticks(Arrays.asList(6,3,4,2,2,8)));
    }
}
