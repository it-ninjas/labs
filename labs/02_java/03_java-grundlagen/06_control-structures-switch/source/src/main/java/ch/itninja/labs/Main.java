package ch.itninja.labs;

import java.time.Month;

import ch.itninja.labs.basicexercises.MonthHelper;
import ch.itninja.labs.basicexercises.WeekHelper;

/**
 * Entry point for the It-Ninja basic exercises.
 */
public class Main {
    public static void main(String[] args) {

        WeekHelper.printWeekdayNumber("Donnerstag");
        MonthHelper.printMonthByNumber(3);
    }
}