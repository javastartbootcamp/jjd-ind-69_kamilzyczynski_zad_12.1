import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
        FileCalculator fileCalculator = new FileCalculator();
        MathOperation[] fileContain = fileCalculator.getFileContain("operations.txt");
        fileCalculator.printInfo(fileContain);
        fileCalculator.save(fileContain, "results.txt");
    }
}