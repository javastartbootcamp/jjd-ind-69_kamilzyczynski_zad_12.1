import java.io.IOException;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        FileCalculator fileCalculator = new FileCalculator();
        MathOperations[] fileContain = fileCalculator.getFileContain("operations.txt");
        fileCalculator.save(fileContain, "results.txt");
    }
}