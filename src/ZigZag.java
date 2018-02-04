/**
 * This program takes a user determined string and prints it int
 * the order of a zigzag pattern with rows determined by user.
 * CPSC 224-02, Spring 2018
 * Programming Assignment #2
 *
 * @author Danielle Forrest
 * @version v1.0 2/1/18
 */
import java.util.Scanner;

public class ZigZag {
    /**
     * This method moves the letters of the string to different rows to create a zigzag pattern
     * @param string string input created from user in main method
     * @param rows number of rows created from user in main method
     */
    private static String ZigZag_Conversion(String string, int rows){
        StringBuilder builder = new StringBuilder();
        int traverse = (rows - 1) * 2;
        int columns = (string.length()/rows) + string.length()%rows;
        //if rows are only 1
        if(rows == 1){
            System.out.println(string);
        }
        //first row
        for (int i = 0; i < string.length(); i += traverse){
            builder.append(string.charAt(i));
        }
        //middle rows
        for (int x = 1 ; x < rows - 1; x++){
            boolean down = true;
            for (int y = x; y < string.length();){
                builder.append(string.charAt(y));

                //down
                if(down){
                    y = y + (rows - x - 1) * 2;
                }//up
                else {
                    y = y + traverse - (rows - x - 1) * 2;
                }
                down = false;
            }
        }
        //last row
        for (int j = rows - 1; j < string.length(); j += traverse){
            builder.append(string.charAt(j));
        }
        String zigzagStr = builder.toString();

        return zigzagStr;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ZigZag zigZagObj = new ZigZag();
        System.out.println("Please enter a string to zig zag.");
        String scanStr = scanner.nextLine();
        System.out.println("Please enter how many rows.");
        int scanInt = scanner.nextInt();

        //test if string is empty
        if (scanStr.equals("") || scanInt <= 0) {
            while (scanStr.equals("") || scanInt <= 0) {
                System.out.println("User must enter a string length greater than zero and a row greater than zero!");
                System.out.println("Please enter a string to zig zag.");
                scanStr = scanner.nextLine();
                System.out.println("Please enter how many rows.");
                scanInt = scanner.nextInt();
            }
        }

        //remove spaces in string
        scanStr = scanStr.replaceAll(" ", "");
        //make all letters lower case
        scanStr = scanStr.toLowerCase();
        //call method to zigzag string
        System.out.print(zigZagObj.ZigZag_Conversion(scanStr, scanInt));
    }
}
