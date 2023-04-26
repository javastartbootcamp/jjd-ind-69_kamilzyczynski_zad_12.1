import java.io.*;
import java.util.Scanner;

public class FileCalculator {

    public MathOperations[] getFileContain(String fileName) throws IOException {
        int lines = countLines(fileName);
        MathOperations[] mathOperations = new MathOperations[lines];
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        for (int i = 0; i < mathOperations.length; i++) {
            String line = reader.readLine();
            line.split(" ");
            String[] numbers = line.split(" ");
            int firstNumber = Integer.parseInt(numbers[0]);
            int secondNumber = Integer.parseInt(numbers[2]);
            mathOperations[i] = new MathOperations(firstNumber, numbers[1], secondNumber);
        }
        return mathOperations;
    }

    public double getOperationResult(double firstNumber, String operator, double secondNumber) {
        return switch (operator) {
            case "+" -> firstNumber + secondNumber;
            case "-" -> firstNumber - secondNumber;
            case "*" -> firstNumber * secondNumber;
            default -> (firstNumber / secondNumber);
        };
    }

    private int countLines(String fileName) throws IOException {
        int counter = 0;
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        while (reader.readLine() != null) {
            counter++;
        }
        reader.close();
        return counter;
    }

    private String getInfo(MathOperations mathOperations) {
        return mathOperations.getFirstNumber() + " " + mathOperations.getOperator() + " " + mathOperations.getSecondNumber() +
                " = " + getOperationResult(mathOperations.getFirstNumber(), mathOperations.getOperator(),
                mathOperations.getSecondNumber());
    }

    public void save(MathOperations[] mathOperations, String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for (int i = 0; i < mathOperations.length; i++) {
            writer.write(getInfo(mathOperations[i]));
            writer.newLine();
        }
        writer.close();
    }
}
