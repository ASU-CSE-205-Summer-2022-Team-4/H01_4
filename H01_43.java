import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * CLASS: H01_43 AUTHOR: David McConnell, dmcconn7, dmcconn7@asu.edu
 */

public class H01_43 {

    public static void main(String[] pArgs) {
        new H01_43().run();
    }

    private void run() {
        String fName = getFileName() + ".java";
        ArrayList<String> fileLines = getFileLines(fName); // Get lines from source code file
        String textName = fName + ".txt"; // Designate an output file with same name, .txt extension
        writeOutputFile(textName, fileLines); // Format lines from source code and write to txt file
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
        ArrayList<String> fileLines = new ArrayList<>();
        try (Scanner inScan = new Scanner(inFile)) {
            while (inScan.hasNextLine()) {
                fileLines.add(inScan.nextLine()); // populate ArrayList with lines from java file
            } // end while
        } catch (FileNotFoundException e) {
            System.out.println("Oops, file not found for reading. Closing the program...");
            System.exit(-100);
        } // end catch. try-with-resources automatically closes Scanner
        return fileLines;
    } // end getFileLines

    private void writeOutputFile(String fileName, ArrayList<String> lines) {
        File outFile = new File(fileName);
        try (PrintWriter out = new PrintWriter(outFile)) {
            int lineCounter = 1;
            while (lineCounter - 1 < lines.size()) { // line counter will be printed starting at 1, but indexing starts
                                                     // at 0
                out.printf("[%03d] ", lineCounter);
                out.println(" " + lines.get(lineCounter - 1)); // line counter will be printed starting at 1, but
                                                               // indexing starts at 0
                lineCounter++;
            } // end while
        } catch (FileNotFoundException e) {
            System.out.println("Oops, file not available for writing. Closing the program...");
            System.exit(-200);
        } // end catch. try-with-resources automatically closes PrintWriter

    } // end writeOutputFile
} // end H01_43