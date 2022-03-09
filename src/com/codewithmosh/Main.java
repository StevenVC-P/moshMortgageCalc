package com.codewithmosh;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

	    Scanner scanner = new Scanner(System.in);

        System.out.println("Principal: ");
        int principle = scanner.nextInt();

        System.out.println("Annual Interest Rate: ");
        float annualInterest = scanner.nextFloat();
        float monthlyInterest = annualInterest/PERCENT/MONTHS_IN_YEAR;
        System.out.println("Period (Years): ");
        byte years = scanner.nextByte();
        int numberOfPayments = years*MONTHS_IN_YEAR;

        float payments = (float) Math.pow(1+(monthlyInterest),numberOfPayments);

        float mortgage = principle*((monthlyInterest*payments)/(payments-1));
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println("Mortgage: " + mortgageFormatted);
    }
}
