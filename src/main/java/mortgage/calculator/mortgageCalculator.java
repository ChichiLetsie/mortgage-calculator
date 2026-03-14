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
        System.out.print("Principal: ");
        Float principal = scanner.nextFloat();

        //Annual Interest amount
        System.out.print("Annual Interest Rate: ");
        Float annualInterestRate = scanner.nextFloat();
        Float annualMonthlyRate = annualInterestRate / PERCENT /MONTH_IN_YEARS;

        // years in months
        System.out.print("Period(Years): ");
        byte years = scanner.nextByte() ;
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
