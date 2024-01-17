
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class ProductWriter {
    public static void main(String[] args) {
        String ID;
        String Name;
        String Description;
        double Cost;
        boolean done = false;

        Scanner in = new Scanner(System.in);

        ArrayList<String> recs = new ArrayList<>();

        do {
            ID = SafeInput.getNonZeroLenString(in, "Enter the ID");
            Name = SafeInput.getNonZeroLenString(in, "Enter the Name");
            Description = SafeInput.getNonZeroLenString(in, "Enter item description");
            Cost = SafeInput.getRangedDouble(in, "Enter the price of item: ", 0, 999999999);

            // Create a CSV record
            String csvRec = ID + ", " + Name + ", " + Description + ", " + Cost;

            // Add the CSV record to the ArrayList
            recs.add(csvRec);

            done = SafeInput.getYNConfirm(in, "Are you done? ");
        } while (!done);

        // File path
        String filePath = "ProductTestData.txt";

        // Save data to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String record : recs) {
                writer.write(record);
                writer.newLine(); // Add a new line after each record
            }
            System.out.println("Data saved successfully to " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }
}

