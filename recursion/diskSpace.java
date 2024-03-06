package recursion;

import java.io.File;
import java.util.Scanner;

public class diskSpace {
    public static long diskUsage(File root) {
    long total = root.length();                          // start with direct disk usage
    System.err.println("total: " + total);
    System.out.println("root:" + root.isDirectory());

    if (root.isDirectory()) {                            // and if this is a directory,
      for (String childname : root.list()) {             // then for each child
        System.err.println("entered to for loop && childname: " + childname);
        File child = new File(root, childname);          // compose full path to child
        System.err.println("child: " + child);
        total += diskUsage(child);                       // add child's usage to total
      }
    }
    System.out.println(total + "\t" + root);             // descriptive output
    return total;                                        // return the grand total
  }

public static void findFile(File root, String filename) {
    System.err.println("root is a directory: " +root.isDirectory() );
    System.err.println("root is a file: " +root.isFile() );
    if (root.isDirectory()) {
        for (String childname : root.list()) {
            System.err.println("childname: " + childname);
            File child = new File(root, childname);      // compose full path to child
            findFile(child, filename);
        }
    } else if (root.isFile() && root.getName().equals(filename)) {
        System.out.println("Found: " + root.getAbsolutePath());
    }
}

  /**
   * Computes disk usage of the path given as a command line argument.
   * Sample usage:  java DiskSpace C:\Users\Michael
   */
  public static void main(String[] args) {
    String start = "/Users/azzaya/Documents/3409/semester4/comp254-Data Structure and algo/COMP254_W24/recursion/testForDiskSpace";
    // if (args.length > 0) {
    //   start = args[0];
    // } else {
    //   System.out.print("Enter the starting location: ");
    //   start = new Scanner(System.in).next();
    // }
    // diskUsage(new File(start));
    String filename = "hello.txt";
    findFile(new File(start), filename);
  }
}
