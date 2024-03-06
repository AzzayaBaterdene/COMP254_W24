package recursion;

import java.io.File;

public class recursion {
    public static int factorial(int n) throws IllegalArgumentException{

        if(n < 0){
            throw new IllegalArgumentException();
        }else if(n == 1){     // base case is 1 because it is an addition!
            return 1;
        } else{
            return n + factorial(n-1);   // recursion 
        }   
    }

    // Q1
    public static int twoPositiveNums(int a, int b ) throws IllegalArgumentException{

        if (a < 0 && b < 0){
            throw new IllegalArgumentException();
        } else{
            int a1 =  factorial(a);
            int b1 = factorial(b);
            int sum = a1 + b1;
            return sum;
        }
    }

    // Q2
    public static boolean palindrome(String str) {
        // System.err.println("length:" + str.length());
        // System.err.println("str:" + str);

        // base case
        if (str.length() == 0 || str.length() == 1)  // even or odd number of chars
            return true;
    
        // check first and last characters
        if (str.charAt(0) != str.charAt(str.length()-1))
            return false;
    
        // check the remaining string
        return palindrome(str.substring(1, str.length()-1));
    }

    // Q3
    public static void findFile(File root, String filename) {
    // System.err.println("root is a directory: " +root.isDirectory() );
    // System.err.println("root is a file: " +root.isFile() );
    if (root.isDirectory()) {
        for (String childname : root.list()) {
            // System.err.println("childname: " + childname);
            File child = new File(root, childname);      // compose full path to child
            findFile(child, filename);
        }
    } else if (root.isFile() && root.getName().equals(filename)) {
        System.out.println("The file is found: " + root.getAbsolutePath());
    }
}

    public static void main(String[] args){
        //Q1
        int n = factorial(3);
        int n1 = factorial(4);
        System.out.println(n);
        System.out.println(n1);
        // Q2
        System.out.println(twoPositiveNums(3, 4));
        System.out.println(palindrome("aazaa"));
        System.out.println(palindrome("aazuaa"));
        // Q3
        String start = "/Users/azzaya/Documents/3409/semester4/comp254-Data Structure and algo/COMP254_W24/recursion/testForDiskSpace";
        String filename = "hello.txt";
        findFile(new File(start), filename);
    }
}
