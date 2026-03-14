package mortgage.calculator;

import java.security.Principal;
import java.text.NumberFormat;
import java.util.Scanner;

public class mortgageCalculator {
    public static void main(String[] arg){
        Scanner scanner = new Scanner(System.in);

        //INPUTS
        // principal amount
        System.out.print("Principal: ");
        Float principal = scanner.nextFloat();

        //Annual Interest amount
        System.out.print("Annual Interest Rate: ");
        Double interestRate = (scanner.nextDouble()/100)/12;

        // years in months
        System.out.print("Period(Years): ");
        int period = scanner.nextInt() * 12;

        //OUTPUT
        //Calculating Mortgage
        NumberFormat mortgage = NumberFormat.getCurrencyInstance();
        String m = mortgage.format(principal * ((interestRate * Math.pow(1+interestRate,period))/(Math.pow(1+interestRate,period)-1)));
        System.out.println("Mortgage: "+ m);

    }
}
