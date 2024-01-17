import javax.swing.*;
import java.io.*;
import java.nio.file.*;

public class ProductReader {

    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        File selectedFile;

        try {
            // Use the file chooser to get the selected file
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
            if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                selectedFile = fileChooser.getSelectedFile();
                displayFileContents(selectedFile);
            } else {
                System.out.println("No file selected. Exiting.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void displayFileContents(File file) throws IOException {
        System.out.println("ID#\tName\tDescription\tCost");
        System.out.println("=======================================");

        try (BufferedReader reader = Files.newBufferedReader(file.toPath())) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(", ");
                if (data.length >= 4) { // Ensure at least four elements in the array
                    String formattedLine = String.format("%s\t%s\t%s\t%s", data[0], data[1], data[2], data[3]);
                    System.out.println(formattedLine); // Print each formatted line
                }
            }
            System.out.println("\n\nData file read!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

