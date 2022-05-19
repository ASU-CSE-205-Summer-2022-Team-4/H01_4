import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * CLASS: H01_43 
 * AUTHOR: David McConnell, dmcconn7, dmcconn7@asu.edu
 */

public class H01_43 {

    public static void main(String[] pArgs) {
        new H01_43().run();
    }

    private void run() {
        // TODO Auto-generated method stub
        String fName = getFileName() + ".java"; // Prompt user for name of Java source code file with .java extension
        ArrayList<String> fileLines = getFileLines(fName); // Get lines from source code file
        String textName = fName + ".txt";
        writeOutputFile(textName, fileLines);
        // Output contents into new file named the same
        System.out.println("Printed");

    }

    private String getFileName() {
        System.out.print("Please enter the name of a Java source code file: ");
        Scanner userIn = new Scanner(System.in);
        String fName = userIn.next();
        userIn.close();
        return fName;

    }

    private ArrayList<String> getFileLines(String fName) {
        File inFile = new File(fName);
        Scanner inScan;
        try {
            inScan = new Scanner(inFile);
        } catch (FileNotFoundException e) {
            System.out.println("Oops, file not found for reading. Closing the program...");
            inScan = null;
            System.exit(-100);
        } // end catch
        ArrayList<String> fileLines = new ArrayList<>();
        while (inScan.hasNextLine()) {
            fileLines.add(inScan.nextLine());
        } // end while
        inScan.close();
        return fileLines;
    } // end getFileLines
    
    private void writeOutputFile(String fileName, ArrayList<String> lines) {
        File outFile = new File(fileName);
        PrintWriter out;
        try {
            out = new PrintWriter(outFile);
            int lineCounter = 1;
            while (lineCounter-1<lines.size()) {
                out.printf("[%03d] ", lineCounter);
                out.println(" " + lines.get(lineCounter-1));
                lineCounter++;
                }
            } catch (FileNotFoundException e) {
                System.out.println("Oops, file not available for writing. Closing the program...");
                out = null;
                System.exit(-200);
            } // end catch
        out.close();
    } // end writeOutputFile
} // end class