package LearnJava;

import java.sql.SQLOutput;
import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
    public static void main(String[] args) {

/** Example:
 * Principal: 1_000_000
 * Annual Interest Rate: 3.92
 * Period (Years): 30
 * Monthly Payment: $472.81
 */
        // Mortgage Calculator //
        final byte MONTHS_IN_YEAR = 12; //removes "magic number"
        final byte PERCENT = 100;

        int principal = 0;
        float monthlyInterest = 0;
        int numberOfPayments = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Principal ($1K - $1M): ");
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1_000_000)
                break;
            System.out.println("Please Enter a Value Between 1K and 1M");
        }

        while (true) {
            System.out.print("Annual Interest Rate: ");
            float annualInterest = scanner.nextFloat();
            if (annualInterest >= 1 && annualInterest <= 30) {
                monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Please Enter a Value Between 1 and 30");

        }

        while (true) {
            System.out.print("Period (Years): ");
            byte years = scanner.nextByte();
            if (years >= 1 && years <= 30) {
                numberOfPayments = years * MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Please Enter a Value Between 1 and 30");
        }

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.print("Mortgage: " + mortgageFormatted);







    }
}
