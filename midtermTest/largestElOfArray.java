// import java.lang.reflect.Array;

import java.io.Console;

public class largestElOfArray {
    public static int max;
    public static int curr;
    public static void main(String[] args) {
        int[] myArray= {1, 2, 3, 4, 13, 6, 7, 8, 9, 10};
        // O(n)
        for(int i=0; i<myArray.length; i++){
            System.out.println(myArray[i]);
            curr = myArray[i];
            if(curr > max){
                max = curr;
            }
        }
        System.out.println("max:" + max);
    }
}

// running time => O(n)