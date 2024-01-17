import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {
    public static void main(String[] args) {
        String ID;
        String firstName;
        String lastName;
        String title;
        int YOB;
        boolean done = false;

        Scanner in = new Scanner(System.in);

        ArrayList<String> recs = new ArrayList<>();

        do {
            ID = SafeInput.getNonZeroLenString(in, "Enter the ID");
            firstName = SafeInput.getNonZeroLenString(in, "Enter the first name");
            lastName = SafeInput.getNonZeroLenString(in, "Enter the last name");
            title = SafeInput.getNonZeroLenString(in, "Enter the title");
            YOB = SafeInput.getRangedInt(in, "Enter the year of birth: ", 1000, 9999);

            // Create a CSV record
            String csvRec = ID + ", " + firstName + ", " + lastName + ", " + title + ", " + YOB;

            // Add the CSV record to the ArrayList
            recs.add(csvRec);

            done = SafeInput.getYNConfirm(in, "Are you done? ");
        } while (!done);

        // File path
        String filePath = "PersonTestData.txt";

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
