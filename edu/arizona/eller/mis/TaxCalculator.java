package edu.arizona.eller.mis;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: tb189431e
 * Date: 8/26/13
 * Time: 7:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class TaxCalculator {
    private static final double TAXABLE_INCOME = 80000;
    private static final double TAX_RATE = 0.28;
    private static final double STATE_DEDUCTIBLE = 10000;
    private static final double STATE_TAX_RATE = 0.15;
    private static NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);

    public static void main(String args[]){
        String output = "The amount of state tax owed is: ";
        System.out.println(output + numberFormat.format(calculateStateTax()).toString());
    }

    private static double calcualteFederalTax(){
        return TAXABLE_INCOME * TAX_RATE;
    }

    private static double calculateStateTax(){
        double stateTaxBase = calcualteFederalTax() - STATE_DEDUCTIBLE;
        return stateTaxBase * STATE_TAX_RATE;
    }
}
