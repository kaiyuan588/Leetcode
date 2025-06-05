//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;
import string.*;

public class Main {
    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};

        List<List<Integer>> result = ThreeSum.threeSum(arr);
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }

    }
}