import java.util.InputMismatchException; // Import the InputMismatchException class
import java.util.Scanner; // Import the Scanner class

public class Main {
    private static double memory = 0.0; // Declare a static variable for memory storage

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object for user input

        while (true) { // Enter an infinite loop for the calculator interface
            // Display the operation menu
            System.out.println("-----------------------------");
            System.out.println("|                           |");
            System.out.println("| WELCOME TO THE CALCULATOR |");
            System.out.println("|                           |");
            System.out.println("-----------------------------");

            // Display the calculator layout
            System.out.println(" _____________________");
            System.out.println("|  _________________  |");
            System.out.println("| |   CALCULATOR    | |");
            System.out.println("| |_________________| |");
            System.out.println("|  __ __ __ __ __ __  |");
            System.out.println("| |__|__|__|__|__|__| |");
            System.out.println("| |__|__|__|__|__|__| |");
            System.out.println("| |__|__|__|__|__|__| |");
            System.out.println("| |__|__|__|__|__|__| |");
            System.out.println("| |__|__|__|__|__|__| |");
            System.out.println("| |__|__|__|__|__|__| |");
            System.out.println("|  ___ ___ ___   ___  |");
            System.out.println("| | 7 | 8 | 9 | | + | |");
            System.out.println("| |___|___|___| |___| |");
            System.out.println("| | 4 | 5 | 6 | | - | |");
            System.out.println("| |___|___|___| |___| |");
            System.out.println("| | 1 | 2 | 3 | | x | |");
            System.out.println("| |___|___|___| |___| |");
            System.out.println("| | . | 0 | = | | / | |");
            System.out.println("| |___|___|___| |___| |");
            System.out.println("|_____________________|");

            // Display supported operations
            System.out.println("------------------------");
            System.out.println("| SUPPORTED OPERATIONS |");
            System.out.println("| DENOTED BY CATEGORY  |");
            System.out.println("------------------------");

            System.out.println("1. Memory+");
            System.out.println("2. Memory-");
            System.out.println("3. Memory Store");
            System.out.println("4. Memory Recall");
            System.out.println("5. Percentage");
            System.out.println("6. Division");
            System.out.println("7. Multiplication");
            System.out.println("8. Addition");
            System.out.println("9. Subtraction");
            System.out.println("10. Square Root");
            System.out.println("11. Raised to the Power");
            System.out.println("12. Quit");
            System.out.println("----------------------------");
            System.out.println("| TYPE to select OPERATION |");
            System.out.println("----------------------------");

            // Display a list of supported operations

            int choice;
            try {
                choice = scanner.nextInt(); // Read the user's choice
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the input buffer
                continue; // Skip to the next iteration of the loop
            }

            switch (choice) {
                case 1:
                    memory += getOperand(scanner); // Add the entered operand to memory
                    break;
                case 2:
                    memory -= getOperand(scanner); // Subtract the entered operand from memory
                    break;
                case 3:
                    memory = getOperand(scanner); // Store the entered operand in memory
                    break;
                case 4:
                    System.out.println("Memory Recall: " + memory); // Display the value in memory
                    break;
                case 5:
                    double base = getOperand(scanner);
                    double percentageValue = getPercentageValue(scanner);
                    double result = (base * percentageValue) / 100; // Calculate the percentage
                    System.out.println("Result: " + result);
                    break;
                case 6:
                    performOperation(scanner, '/', memory); // Perform division operation
                    break;
                case 7:
                    performOperation(scanner, '*', memory); // Perform multiplication operation
                    break;
                case 8:
                    performOperation(scanner, '+', memory); // Perform addition operation
                    break;
                case 9:
                    performOperation(scanner, '-', memory); // Perform subtraction operation
                    break;
                case 10:
                    double sqrtBase = getOperand(scanner);
                    if (sqrtBase < 0) {
                        System.out.println("Invalid input. Cannot calculate the square root of a negative number.");    //input validation
                    } else {
                        System.out.println("Square Root: " + Math.sqrt(sqrtBase)); // Calculate and display the square root
                    }
                    break;
                case 11:
                    double baseNumber = getOperand(scanner);
                    double exponent = getOperand(scanner);
                    System.out.println("Result: " + Math.pow(baseNumber, exponent)); // Calculate and display the result of raising to a power
                    break;
                case 12:
                    System.out.println("--------------------------------------------");
                    System.out.println("You are now exiting the calculator. Goodbye!");
                    System.out.println("--------------------------------------------");
                    System.exit(0); // Exit the program
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Helper method to get a valid operand (a number) from the user
    private static double getOperand(Scanner scanner) {
        System.out.println("Operand:");
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next(); // Clear the invalid input
        }
        return scanner.nextDouble(); // Return the valid operand
    }

    // Helper method to get a valid percentage value from the user
    private static double getPercentageValue(Scanner scanner) {
        System.out.print("Enter percentage value: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid number for the percentage value.");
            System.out.print("Enter percentage value: ");
            scanner.next(); // Clear the invalid input
        }
        return scanner.nextDouble(); // Return the valid percentage value
    }

    // Helper method to perform arithmetic operations (+, -, *, /)
    private static void performOperation(Scanner scanner, char operator, double initialValue) {
        System.out.print("Enter first number: ");
        double num1 = getOperand(scanner);

        // Clear the input buffer after reading the first operand
        scanner.nextLine();

        double num2 = 0.0; // Initialize num2 to 0.0

        switch (operator) {
            case '+':
            case '-':
            case '*':
            case '/':
            case '%':
                System.out.print("Enter second number: ");
                num2 = getOperand(scanner);
                break;
        }

        double result = 0.0;

        // Perform the selected operation and display the result
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Error: Division by zero!");
                }
                break;
            default:
                System.out.println("Invalid operator.");
        }

        System.out.println("Result: " + result);
    }
}
