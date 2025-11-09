import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * BubbleSortFile
 * Reads lines of numbers from "input.txt",
 * sorts each line using Bubble Sort, and
 * writes sorted lines to "output.txt".
 *
 * Assumes valid input.
 *
 * Example:
 * Input:  5 2 8 1
 * Output: 1 2 5 8
 *
 * @author Beni Nkongolo
 * @version 1.0
 * @since 2025-11-08
 */
public final class BubbleSortFile {

    // Prevent instantiation
    private BubbleSortFile() { }
/**
     * Sorts input file and give an output file.
     * @param args Command-line arguments (not used).
     */
    public static void main(final String[] args) {
        File inputFile = new File("input.txt");
        File outputFile = new File("output.txt");

        try (
            Scanner fileScanner = new Scanner(inputFile);
            FileWriter writer = new FileWriter(outputFile)
        ) {
            // Read each line from input.txt
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();

                if (line.isEmpty()) {
                    continue; // Skip empty lines
                }

                // Split numbers by spaces
                String[] strNumbers = line.split(" ");
                int[] numbers = new int[strNumbers.length];

                // Convert to integers
                for (int i = 0; i < strNumbers.length; i++) {
                    numbers[i] = Integer.parseInt(strNumbers[i]);
                }

                // Sort the array
                bubbleSort(numbers);

                // Write sorted numbers to output.txt
                for (int i = 0; i < numbers.length; i++) {
                    writer.write(
                        numbers[i] + (i < numbers.length - 1 ? " " : ""));
                }
                writer.write("\n");
            }

            System.out.println(
                "Sorting complete! Check output.txt for results.");

        } catch (IOException e) {
            System.out.println(
                "Error reading or writing file: " + e.getMessage());
        }
    }

    /**
     * Sorts an integer array in ascending order using Bubble Sort.
     *
     * @param arr The array to sort.
     */
    public static void bubbleSort(final int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }
}
