package com.anudip.Exception;

import java.util.Scanner;
import java.util.InputMismatchException;

public class LabException1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("ENTER FIRST NUMBER: ");
            double num1 = scanner.nextDouble();

            System.out.print("ENTER AN OPERATOR (+, -, *, /): ");
            char operator = scanner.next().charAt(0);

            System.out.print("ENTER SECOND NUMBER: ");
            double num2 = scanner.nextDouble();

            double result;
            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/':
                    if (num2 == 0) throw new ArithmeticException("CANNOT DIVIDE BY ZERO.");
                    result = num1 / num2;
                    break;
                default:
                    System.out.println("ERROR: INVALID OPERATOR INPUT.");
                    return;
            }
            System.out.println("THE RESULT IS: " + result);

        } catch (InputMismatchException e) {
            System.out.println("ERROR: PLEASE ENTER VALID NUMERIC VALUES.");
        } catch (ArithmeticException e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
