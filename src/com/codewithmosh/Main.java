package com.codewithmosh;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int principal;
        float annualInterest;
        byte years;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Principal: ");
            principal = scanner.nextInt();
            if ((principal >= 1000) && (principal <= 1_000_000))
                break;
            System.out.println("Enter a value between 1,000 and 1,000,000.");
        }

        while (true) {
            System.out.println("Annual Interest Rate: ");
            annualInterest = scanner.nextFloat();
            if ((annualInterest > 0) && (annualInterest <= 30))
                break;
            System.out.println("Enter a value greater than 0 and less than or equal to 30.");
        }


        while (true) {
            System.out.println("Period (Years): ");
            years = scanner.nextByte();
            if ((years > 0) && (years <= 30))
                break;
            System.out.println("Enter a value greater than 0 and less than or equal to 30.");
        }

        double mortgage = calculateMortgage(principal,annualInterest, years);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println("Mortgage: " + mortgageFormatted);
    }

    public static double calculateMortgage(int principal, float annualInterest, byte years) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        short numberOfPayments = (short) (years * MONTHS_IN_YEAR);
        float payments = (float) Math.pow(1 + (monthlyInterest), numberOfPayments);

        return principal * ((monthlyInterest * payments) / (payments - 1));
    }

}
