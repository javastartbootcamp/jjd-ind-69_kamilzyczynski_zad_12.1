import java.io.*;

public class FileCalculator {

    public MathOperation[] getFileContain(String fileName) throws IOException {
        int lines = countLines(fileName);
        MathOperation[] mathOperation = new MathOperation[lines];
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        for (int i = 0; i < mathOperation.length; i++) {
            String line = reader.readLine();
            String[] numbers = line.split(" ");
            int firstNumber = Integer.parseInt(numbers[0]);
            int secondNumber = Integer.parseInt(numbers[2]);
            mathOperation[i] = new MathOperation(firstNumber, numbers[1], secondNumber);
        }
        return mathOperation;
    }

    private double getOperationResult(MathOperation mathOperation) {
        return switch (mathOperation.getOperator()) {
            case "+" -> mathOperation.getFirstNumber() + mathOperation.getSecondNumber();
            case "-" -> mathOperation.getFirstNumber() - mathOperation.getSecondNumber();
            case "*" -> mathOperation.getFirstNumber() * mathOperation.getSecondNumber();
            default -> (mathOperation.getFirstNumber() / mathOperation.getSecondNumber());
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

    public void printInfo(MathOperation[] mathOperation) {
        for (MathOperation operation : mathOperation) {
            System.out.println(operation + " = " + getOperationResult(operation));
        }
    }

    private String getInfo(MathOperation mathOperation) {
        return mathOperation.getFirstNumber() + " " + mathOperation.getOperator() + " " + mathOperation.getSecondNumber() +
                " = " + getOperationResult(mathOperation);
    }

    public void save(MathOperation[] mathOperations, String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for (MathOperation mathOperation : mathOperations) {
            writer.write(getInfo(mathOperation));
            writer.newLine();
        }
        writer.close();
    }
}
