package mortgage.calculator;

import java.security.Principal;
import java.text.NumberFormat;
import java.util.Scanner;

public class mortgageCalculator {
    public static void main(String[] arg){

        //Initiate constants
        //Avoiding magic numbers
        final byte MONTH_IN_YEARS = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);

        //INPUTS
        // principal amount
        Float principal = 0F;
        while (true){
            System.out.print("Principal: ");
            principal = scanner.nextFloat();
            if (principal >= 1000 && principal <= 1000000)
                    break;
            else {
                System.out.println("Enter a value between 1000 and 1,000,000");
        }
        }

        //Annual Interest amount
        Float annualInterestRate = 0F;
        while (true) {
            System.out.print("Annual Interest Rate: ");
            annualInterestRate = scanner.nextFloat();
            if (annualInterestRate > 0F && annualInterestRate <= 30F) {
                break;
            } else {
                System.out.println("Enter a value greater than 0 or equal to 30");
            }
        }
        Float annualMonthlyRate = annualInterestRate / PERCENT / MONTH_IN_YEARS;

        // years in months
        byte years = 0;
        while (true) {
            System.out.print("Period(Years): ");
            years = scanner.nextByte();
            if (years > 0 && years <= 30) {
                break;
            } else{
                System.out.println("Enter a value between 1 and 30");
            }
        }
        int numberOfPayments = years * MONTH_IN_YEARS;

        //OUTPUT
        //Calculating Mortgage
        double mortgage = principal * ((annualMonthlyRate *
                Math.pow(1+annualMonthlyRate,numberOfPayments))
                /(Math.pow(1+annualMonthlyRate,numberOfPayments)-1));

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: "+ mortgageFormatted);

    }
}
